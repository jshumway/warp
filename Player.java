import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Handles things like collisions, gravity, and acceleration, player
 * input
 * 
 * @author Jared Shumway
 */
public class Player extends Person
{
    /** Physical State **/
    /* tweakable */
    private int xSpeedMax = 10;
    private int terminalVelocity = 10;
    private int horizontalAccel = 3;
    private int gravityAccel = 1;
    private double friction = 0.35;
    private int jumpImpulse = 20;
    private int fireOffset = 120;
    private int laserCooldown = 200;
    private int stabRange = 90;

    /* internal */
    private double yvel, xvel;
    private boolean accelerating;
    private boolean atRest;
    private boolean canJump;
    private int laserTick;
    private boolean hittingBlockLeft=false;
    private boolean hittingBlockRight=false;
    private boolean hittingFloor=false;
    private boolean hittingCeiling=false;

    /** CREATOR **/
    public Player() {
        // initialize physical state
        xvel = yvel = 0;
        atRest = false;
        accelerating = false;
    }

    /** MANIPULATORS **/
    /* physics helpers */
    /**
     * y is 0 at the top of the screen applying a positive y impulse 
     * will lanch the player towards the bottom of the screen
     */
    public void impulse(int x, int y) {
        xvel += x; yvel += y;
    }

    public void jump() {
        impulse(0, -jumpImpulse);
    }
    
    // UNUSED
    /* public boolean inWall() {
        Wall wall = (Wall) getOneIntersectingObject (Wall.class);
        if (wall != null) {
            if (getRight() < wall.getRight() && getRight() > wall.getLeft()) {
                setWorldLocation(wall.getLeft() - getWidth()/2, getY());
                return true;
            }
            
            if (getLeft() > wall.getLeft() && getLeft() < wall.getRight()) {
                setWorldLocation(wall.getRight() + getHeight()/2, getY());
                return true;
            }
        }
        return false;
    } */

    // see if the player is going to hit a block to the right
    private Boolean lookForBlockRight() {
        // following the right edge of the actor, test every 5 points from bottom to top,
        // looking for a collision
        for (int i = -getHeight()/2; i < getHeight()/2; i+=5) {
            Actor block=getOneObjectAtOffset(-getWidth()/2 - 1, i, Block.class);
            if (block != null) 
                return true;
        }

        return false;
    }

    // see if the player is going to hit a block to the left
    private boolean lookForBlockLeft(){
        for (int i = -getHeight()/2; i < getHeight()/2; i+=5) {
            Actor block=getOneObjectAtOffset(getWidth()/2 + 1, i, Block.class);
            if(block!=null)
                return true;
        }

        return false;
    }

    private boolean lookForFloor() {
        for (int i = -getWidth()/2; i < getWidth()/2; i+=5) {
            Actor block = getOneObjectAtOffset(i, getHeight()/2 + 1, Block.class);
            if (block != null) {
                return true;
            }
        }

        return false;
    }

    private boolean lookForCeiling() {
        for (int i = -getWidth()/2; i < getWidth()/2; i+=5) {
            Actor block = getOneObjectAtOffset(i, -getHeight()/2 - 1, Block.class);
            if (block != null) {
                return true;
            }
        }

        return false;
    }
    
    // check if the player is standing on a block returns 
    // true if the player's location is changed to fix a collision
    /* public boolean onBlock() {
        Block block = (Block) getOneIntersectingObject(Block.class);
        // make sure there is an actual block
        if (block != null) { // see if the player is above it
            if (getBottom() < block.getBottom() &&
                    getBottom() > block.getTop()) {
                setWorldLocation(getWorldX(), block.getTop() - getHeight()/2);
                canJump = true;
                return true;
            } else if (getTop() > block.getTop() &&
                    getTop() < block.getBottom()) {
                setWorldLocation(getWorldX(), block.getBottom() + getHeight()/2);
                System.out.println("Hit your head lol!");
                return true;
            }
        }
        return false;
    } */
    /* old collision check
        Block block = (Block) getOneIntersectingObject(Block.class);
        if (block != null) {
            setLocation(getX(), getY() - (getBottom() - block.getTop()));
            return true;
        }

        return false;
    }*/

    // check if the palyer is standing on a wooden platform
    public boolean onPlatform() {
        if (yvel >= 0) {
            Platform platform;
            platform = (Platform) getOneIntersectingObject(Platform.class);

            if (platform != null) { /* && yvel >= 0) { */
                if (getBottom() - platform.getTop() <= Math.abs(yvel * 4)) {
                    setWorldLocation(getWorldX(), platform.getTop() - getHeight()/2);
                    canJump = true;
                    yvel = 0;
                    return true;
                }
            } /* else if (platform != null) {// && yvel < 0
                if (getBottom() - platform.getTop() <
            } */
        }

        return false;
    }

    public void collision() {
        hittingCeiling = lookForCeiling();
        hittingFloor = lookForFloor();
        hittingBlockLeft = lookForBlockLeft();
        hittingBlockRight = lookForBlockRight();

        // test vertical collision
        if (onPlatform() || hittingFloor || hittingCeiling) {
            yvel = 0;
        }
        if (hittingFloor) {
            canJump = true;
            move(0, -1);
        }
        if (hittingCeiling) {
            move(0, 1);
        }

        if (hittingBlockRight || hittingBlockLeft) {
            xvel = 0;
        }
        if (hittingBlockRight) {
            move(1, 0);
        }
        if (hittingBlockLeft) {
            move(-1, 0);
        }
    }

    /* physical update */
    private void accelerate() {
        /* is any of this even nessecary?
           if (yvel == 0 && xvel == 0) {
           atRest = true;
           } else {
           atRest = false;
           } */

        // apply acceleration to velocity
        if (accelerating) {
            xvel += horizontalAccel * getFacing();
        }

        xvel -= xvel * friction;

        yvel += gravityAccel;

        // ensure max speeds are not surpassed
        if (xvel > xSpeedMax) {
            xvel = xSpeedMax;
        } else if (xvel < -xSpeedMax) {
            xvel = -xSpeedMax;
        }

        if (yvel > terminalVelocity) {
            yvel = terminalVelocity;
        }
    }

    public void physicsUpdate() {
        // apply acceleration to velocity
        accelerate();

        // check for collisions before they happen
        collision();

        // apply (modified) velocity
        move((int) xvel, (int) yvel);
    }

    /* input */
    public void inputResponse() {
        // jumping
        if (Greenfoot.isKeyDown("space")){
            if (canJump) {
                jump();
                canJump = false;
            }
        }

        // horizontal movement
        boolean left = Greenfoot.isKeyDown("left");
        boolean right = Greenfoot.isKeyDown("right");

        // animation stuff
        if (left && !hittingBlockLeft) {
            if(getFacing() == 1) {
                flipImage();
            }    

            setFacing(-1);
            accelerating = true;
        }

        if (right && !hittingBlockRight) {
            if(getFacing() == -1) {
                flipImage();
            }

            setFacing(1);
            accelerating = true;
        }

        if (!left && !right) {
            accelerating = false;
        }

        //shooting
        if (Greenfoot.isKeyDown("t")) {
            fire();
        }

        //stabbing
        if (Greenfoot.isKeyDown("f")) {
            stab();
        }
    }

    private void flipImage(){
        GreenfootImage image=getImage();
        image.mirrorHorizontally();
        setImage(image);
    }

    private void stab(){
        for (int i = 0; i < stabRange; i++) {
            Enemy enemy = (Enemy) getOneObjectAtOffset(i*getFacing(),0,Enemy.class);            

            if(enemy != null && enemy.beStabbed()) {
                if (getFacing() == enemy.getFacing()) {
                    getWorld().removeObject(enemy);
                }
            }
        }
    }

    private void fire(){
        if (laserTick == 0){
            Laser laser = new Laser(getFacing());
            //ShiftWorld sw = (ShiftWorld) getWorld();

            getWorld().addObject(laser, getX() + fireOffset * getFacing() , getY());

            laser.setWorldLocation(getWorldX() + fireOffset * getFacing() , getY());
            laser.setRotation(getRotation());
            laserTick = laserCooldown;
        }

    }

    private void killZone(){
        if (getY() > ShiftWorld.worldHeight + 50)
        {
            ShiftWorld sw = (ShiftWorld) getWorld();
            sw.killPlayer();
        }
    }


    public void act(){ 

        if (laserTick > 0){
            laserTick--;
        }

        physicsUpdate();

        inputResponse();
        
        killZone();
    } 
}

