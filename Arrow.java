import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends ShiftActor
{
    /**
     * Act - do whatever the Arrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     private int speed=3;
    private int direction;
    public Arrow(int dir){
        direction=dir;
    }
    public void act() 
    {
        move(direction*speed);
        collision();
        // Add your action code here.
    }    
     private void collision(){
         Actor hit= getOneIntersectingObject(Block.class);
         if(hit!=null){
           getWorld().removeObject(this);
            return;
        }
        hit=getOneIntersectingObject(Player.class);
        if(hit!=null){
            getWorld().removeObject(hit);
            getWorld().removeObject(this);
            return;
        }
            
    }   
}
