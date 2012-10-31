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

    /** CREATOR **/
    public Player() {
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
    
    // test if the player is colliding with a wall
    public boolean inWall() {
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
    }

    // check if the player is standing on a block returns 
    // true if the player's location is changed to fix a collision
    public boolean onBlock() {
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
    }
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
        // test vertical collision
        if (onBlock() || onPlatform()) {
            yvel = 0;
        }
        
        if (inWall()) {
            xvel = 0;
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
        accelerate();

        // apply velocity
        move((int) xvel, (int) yvel);

        collision();
    }

    /* input */
    public void inputResponse() {
        // jumping
        if (Greenfoot.isKeyDown("space")){
            if (canJump){
                jump();
                canJump = false;
            }
        }

        // horizontal movement
        boolean left = Greenfoot.isKeyDown("left");
        boolean right = Greenfoot.isKeyDown("right");

        if (left) {
            if(getFacing()==1){
                flipImage();
            }    
            setFacing(-1);
            accelerating = true;
        }

        if (right) {
            if(getFacing()==-1){
                flipImage();
            }
            setFacing(1);
            accelerating = true;
        }

        if (!left && !right) {
            accelerating = false;
        }

        //shooting
        if ("t".equals(Greenfoot.getKey()))
        {
            fire();
        }
        if((Greenfoot.isKeyDown("f"))){
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

            getWorld().addObject(laser, getX() + fireOffset , getY());

            laser.setWorldLocation(getWorldX() + fireOffset, getY());
            laser.setRotation(getRotation());
            laserTick = laserCooldown;
        }

    }

    public void act(){ 
    
        if (laserTick > 0){
            laserTick--;
        }

        physicsUpdate();

        inputResponse();
    }    
}

