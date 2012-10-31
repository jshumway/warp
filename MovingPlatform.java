import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MovingPlatform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovingPlatform extends ShiftActor
{
    private int moveSpeed = 3;
    private int count = 5;
    /**
     * Act - do whatever the MovingPlatform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        moveToWaypoint();
    }    
        public void moveToWaypoint()
    {
        setWorldLocation ( getX() + moveSpeed, getY());
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
