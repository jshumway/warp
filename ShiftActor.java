import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * ShiftActor is an actor that exists in a 2D plane that is not
 * (forced to be) the same size as the screen
 * 
 * @author Jared Shumway
 */
public class ShiftActor extends Actor
{
    /* world coords. start at the top right of the world */
    private int worldx;
    private int worldy;

    /* MANIPULATORS */
    public void setWorldLocation(int x, int y) {
        worldx = x;
        worldy = y;
    }

    // seeing as this is a sidescroller, this will probably change.
    public void move(int dx, int dy) {
        setWorldLocation(worldx + dx, worldy + dy);
    }

    public void act() {}

    /* ACCESSORS */
    public int getWorldX() { return worldx; }
    public int getWorldY() { return worldy; }
}
