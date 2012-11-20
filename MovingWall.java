import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MovingWall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovingWall extends ShiftActor
{
    /* tweakable */
    private int moveSpeed = 2;

    /* interanl */
    private int count = 5;
    private int dx = 0;
    private int dy = 0;

    /**
     * Determine which direction(s) the wall should move in
     */
    public MovingWall(boolean moveInX) {
        // convert booleans to ints
        if (moveInX)
            dx = 1;
        else
            dy = 1;
    }

    public void act() 
    {
        // Add your action code here.
        moveToWaypoint();
    }    

    public void moveToWaypoint()
    {
        move(moveSpeed * dx, moveSpeed * dy);
        PlatformWaypoint platformwaypoint;
        platformwaypoint = (PlatformWaypoint) getOneIntersectingObject(PlatformWaypoint.class);
        if (platformwaypoint != null && count > 5)
        {
            moveSpeed *= -1;
            count = 0;
        }
        count++;
    }
}

