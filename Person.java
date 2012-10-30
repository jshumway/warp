import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Everything that the player and enemies share
 * 
 * @author Jared Shumway
 */
public class Person extends ShiftActor
{
    /* internal */
    private int facing = 1;  /* <- (-1) | (0) | (1) -> */

    /* MANIPULATORS */
    public void setFacing(int dir) {
        if (dir <= -1)
            facing = -1;
        else if (dir >= 0) 
            facing = 1;
    }

    /* ACCESSORS */
    public int getFacing() { return facing; }
}
