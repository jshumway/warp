import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class stationaryArcher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StationaryArcher extends StationaryEnemy
{
    /**
     * Act - do whatever the stationaryArcher wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public StationaryArcher(int dir){
        super (dir,300);
    }
    public void act(){
       if(look()){
           spoted();
        }
    }
    protected void spoted(){
        
        fireArrow();
    }
    private void fireArrow(){
        Arrow arrow=new Arrow(getFacing());
        getWorld().addObject(arrow,getX(),getY());
    }   
}
