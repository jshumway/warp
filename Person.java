import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Everything that the player and enemies share
 * 
 * @author Jared Shumway
 */
public class Person extends ShiftActor
{
    /* internal */
    private int facing;  /* <- (-1) | (0) | (1) -> */

    /* MANIPULATORS */
    public void setFacing(int f) {
        if (f >= -1 && f <= 1)
            facing = f;
    }

    /* ACCESSORS */
    public int getFacing() { return facing; }
}
