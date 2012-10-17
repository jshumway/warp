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
        Enemy enemy=(Enemy)getOneIntersectingObject(Enemy.class);
         if(enemy!=null&&enemy.beShot()){
            getWorld().removeObject(enemy);
            getWorld().removeObject(this);
         }else if(enemy!=null){
            getWorld().removeObject(this);   
         }
        

    }



}
