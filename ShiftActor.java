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
        int bound = 300;
        ShiftWorld sw = (ShiftWorld) getWorld();

        if (x < sw.worldWidth + bound && x > 0 - bound) {
            worldx = x;
        }

        if (y < sw.worldHeight + bound && y > 0 - bound) {
            worldy = y;
        }
    }

    // seeing as this is a sidescroller, this will probably change.
    public void move(int dx, int dy) {
        setWorldLocation(worldx + dx, worldy + dy);
    }

    /*
    public void saveWorldLocation() {
        ShiftWorld sw = (ShiftWorld) getWorld();
        worldx = sw.getScreenLeft() + getX();
        worldy = getY();
    }*/

    public void act() {}

    /* ACCESSORS */
    public int getWorldX() { return worldx; }
    public int getWorldY() { return worldy; }

    public int getLeft() { return worldx - getImage().getWidth() / 2; }
    public int getRight() { return worldx + getImage().getWidth() / 2; }
    public int getTop() { return worldy - getImage().getHeight() / 2; }
    public int getBottom() { return worldy + getImage().getHeight() / 2; }

    public int getHeight() { return getImage().getHeight(); }
    public int getWidth() { return getImage().getWidth(); }
}
