import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Handles things like collisions, gravity, and acceleration, player
 * input
 * 
 * @author Jared Shumway
 */
public class Player extends ShiftActor
{
    /** Physical State **/
    /* tweakable */
    private int xSpeedMax = 10;
    private int terminalVelocity = 20;
    private int horizontalAccel = 2;
    private int gravityAccel = 1;

    /* internal */
    private double yvel, xvel;
    private boolean accelerating;
    private boolean atRest;

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
        impulse(0, 10);
    }

    // check if the player is standing on a block
    public boolean onBlock() {
        Block block = (Block) getOneIntersectingObject(Block.class);
        return block != null;
    }

    /* physical update */
    private void accelerate() {
        // apply acceleration to velocity
        if (accelerating)
            xvel += horizontalAccel;

        yvel += gravityAccel;

        // ensure max speeds are not surpassed
        if (xvel > xSpeedMax)
            xvel = xSpeedMax;
        else if (xvel < -xSpeedMax) 
            xvel = -xSpeedMax;

        if (yvel > terminalVelocity)
            yvel = terminalVelocity;
    }

    public void physicsUpdate() {
        accelerate();

        // apply velocity
        move((int) 1, (int) yvel);

        if (onBlock()) {
            move(0, (int) -yvel);
            yvel = 0;
        }
    }

    public void act() 
    {
        physicsUpdate();
        if (Greenfoot.isKeyDown("space")) {
            jump();
        }
    }    
}
