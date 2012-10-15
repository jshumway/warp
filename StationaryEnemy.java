import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StationaryEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StationaryEnemy extends Enemy
{
    /**
     * Act - do whatever the StationaryEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public StationaryEnemy(int dir,int sight){
        super(dir, sight);
    }
     public StationaryEnemy(int dir){
        super(dir);
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
