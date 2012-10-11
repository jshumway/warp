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

    /* These four (ugly) function *should* return collisions that hit
     * the actor on the specific side */
    public ShiftActor collisionLeft(int dist) {
        List<ShiftActor> actors = getObjectsInRange(dist, ShiftActor.class);
        ShiftActor closest = actors.get(0);

        for (ShiftActor sa : actors) {
            if (sa.getWorldX() < worldx && sa.getWorldX() > closest.getX()) {
                closest = sa;
            }
        }
        return closest;
    }

    public ShiftActor collisionRight(int dist) {
        List<ShiftActor> actors = getObjectsInRange(dist, ShiftActor.class);
        ShiftActor closest = actors.get(0);

        for (ShiftActor sa : actors) {
            if (sa.getWorldX() > worldx && sa.getWorldX() < closest.getX()) {
                closest = sa;
            }
        }
        return closest;
    }

    public ShiftActor collisionTop(int dist) {
        List<ShiftActor> actors = getObjectsInRange(dist, ShiftActor.class);
        ShiftActor closest = actors.get(0);

        for (ShiftActor sa : actors) {
            if (sa.getWorldY() < worldy && sa.getWorldY() > closest.getY()) {
                closest = sa;
            }
        }
        return closest;
    }

    public ShiftActor collisionBottom(int dist) {
        List<ShiftActor> actors = getObjectsInRange(dist, ShiftActor.class);
        ShiftActor closest = actors.get(0);

        for (ShiftActor sa : actors) {
            if (sa.getWorldY() > worldy && sa.getWorldY() < closest.getY()) {
                closest = sa;
            }
        }
        return closest;
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
