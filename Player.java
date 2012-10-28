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
    public void impulse(int x, int y) {
        xvel += x; yvel += y;
    }

    public void jump() {
        impulse(0, -jumpImpulse);
    }

    // check if the player is standing on a block
    public boolean onBlock() {
        Block block = (Block) getOneIntersectingObject(Block.class);
        if (block != null) {
            setLocation(getX(), getY() - (getBottom() - block.getTop()));
            return true;
        }

        return false;
    }

    // check if the palyer is standing on a wooden platform
    public boolean onPlatform() {
        if (yvel >= 0) {
            Platform platform;
            platform = (Platform) getOneIntersectingObject(Platform.class);
            if (platform != null && yvel >= 0) {
                // if (getBottom() - platform.getTop() <= yvel) {
                if (getBottom() - platform.getTop() <= yvel * 2) {
                    setLocation(getX(), getY() - (getBottom() - platform.getTop()));
                    return true;
                }
            }
        }

        return false;
    }

    public void collision() {
        // test vertical collision
        if (onBlock() || onPlatform()) {
            yvel = 0; canJump = true;
        }
    }

    /* physical update */
    private void accelerate() {
        if (yvel == 0 && xvel == 0) {
            atRest = true;
        } else {
            atRest = false;
        }

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

