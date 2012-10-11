import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Handles things like collisions, gravity, and acceleration
 * 
 * @author Jared Shumway
 */
public class Player extends ShiftActor
{
    // x and y velocities
    private double yvel = 0, xvel = 0;

    // maximum speeds
    private int xSpeedMax = 10;
    private int terminalVelocity = 25;

    // acceleration in the x direction
    private double accel = 0;

    public Player() {}

    // increase the x, y velocity
    public void impulse(int x, int y) {
        xvel += x; yvel += y;
    }

    public void jump() {
        impulse(0, 10);
    }

    /**
     * Checks collisions for this object, applies acceleration to
     * velocity, then applies velocity to the world coords of the
     * object.
     */
    public void physicsUpdate() {
        // apply acceleration
        xvel += accel;
        yvel += 1;

        if (xvel > xSpeedMax) xvel = xSpeedMax;
        else if (xvel < -xSpeedMax) xvel = -xSpeedMax;

        if (yvel > terminalVelocity) yvel = terminalVelocity;

        // collisions
        /* if the player is hitting a block under it's feet, move it
         * so that the bottom of the image touches the top of the
         * block, yvel is 0.
         *
         * if the player is hitting a wall on the left, same
         * thing. wall on the right, same thing. ceiling, same
         * thing. What about platforms?
         */

        // apply velocity
        move((int) xvel, (int) yvel);
    }

    /**
     */
    public void act() 
    {
        physicsUpdate();
        if (Greenfoot.isKeyDown("space")) {
            jump();
        }
    }    
}
