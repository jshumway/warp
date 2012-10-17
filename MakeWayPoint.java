import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MakeWayPoint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MakeWayPoint extends WayPoint
{
    /**
     * Act - do whatever the MakeWayPoint wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int moveTick;
    
       
    public void act() 
    {
        if (moveTick > 0)
        {
            moveTick--;
        }        
        MakeWayPoint waypoint = new MakeWayPoint ();
        PatrolingEnemy p = (PatrolingEnemy) getOneIntersectingObject(PatrolingEnemy.class);   
        if (moveTick == 0)
        {
            if (p != null)
            {
                p.setFacing(-1*p.getFacing());
            }
            moveTick = 30;
        }
        
        
        // Add your action code here.
    } 
    
    
}
