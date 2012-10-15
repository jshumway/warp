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

    /* internal */
    private double yvel, xvel;
    private boolean accelerating;
    private boolean atRest;
    private boolean canJump;

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
    public int onBlock() {
        Block block = (Block) getOneIntersectingObject(Block.class);
        if (block != null)
            return block.getTop();

        return -1;
    }

    // check if the palyer is standing on a wooden platform
    public int onPlatform() {
        if (yvel >= 0) {
            Platform platform;
            platform = (Platform) getOneIntersectingObject(Platform.class);
            if (platform != null && yvel >= 0) {
                // if (getBottom() - platform.getTop() <= yvel) {
                if (getBottom() - platform.getTop() <= yvel * 2) {
                    return platform.getTop();
                }
            }
        }

        return -1;
    }

    public int collision() {
        int block = onBlock();
        int plat = onPlatform();

        if (block > -1) return block;
        if (plat  > -1) return plat;

        return 0;
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

        int move = collision();

        if (yvel > 0 && move > 0) {
            move(0, -(getWorldY() + getImage().getHeight()/2 - move));
            yvel = 0;
            canJump = true;
        }
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
            setFacing(-1);
            accelerating = true;
        }

        if (right) {
            setFacing(1);
            accelerating = true;
        }

        if (!left && !right) {
            accelerating = false;
        }
    }

    public void act() 
    {
        physicsUpdate();

        inputResponse();
    }    
}
