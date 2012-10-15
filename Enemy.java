import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Person
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     protected int sightRange=50;
     
     public Enemy(int dir, int sight){
        setFacing(dir);
        sightRange=sight;
    }
    public Enemy(int dir){
        setFacing(dir);
    }
   
    public void act() 
    {
        
    }    
    public boolean look(){
        int distToWall=sightRange;
        for (int i=0;i<sightRange;i++){
               Actor wall = getOneObjectAtOffset(i*getFacing(),0,Block.class);
               Actor player = getOneObjectAtOffset(i*getFacing(),0,Player.class);
                if(wall!=null){
                    return false;
                }             
                if(player!=null){
                   
                    return true;
                }
        }
        return false;
    } 
}
