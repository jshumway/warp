import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends ShiftActor
{
    /**
     * Act - do whatever the Laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(30,0);
        collision();
    } 
    private void collision(){
        Actor hit=getOneIntersectingObject(Block.class);
        if(hit!=null){
            getWorld().removeObject(this);
        }
        hit=getOneIntersectingObject(StationaryArcher.class);
         if(hit!=null){
            getWorld().removeObject(hit);
            getWorld().removeObject(this);
         }
        hit=getOneIntersectingObject(Enemy.class);
        if(hit!=null){
            getWorld().removeObject(this);
        }

    }



}
