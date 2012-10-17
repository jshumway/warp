import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Person
{
    protected int sightRange=50;
    private Boolean canShot=false;
    private Boolean canStabed=false;
     
    public Enemy(int dir, int sight){
        setFacing(dir);
        sightRange = sight;
    }
    public void setShot(Boolean s){
        canShot=s;
    }
    public Boolean beShot(){
        return canShot;
    }

    public Enemy(int dir){
        setFacing(dir);
    }
  
    public boolean look(){
        int distToWall=sightRange;

        for (int i=0;i<sightRange;i++) {
            Actor wall = getOneObjectAtOffset(i*getFacing(),0,Block.class);
            Actor player = getOneObjectAtOffset(i*getFacing(),0,Player.class);
            if(wall!=null) {
                return false;
            }             
            
            if(player!=null) {
                return true;
            }
        }

        return false;
    } 
}
