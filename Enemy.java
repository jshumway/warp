import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Enemy extends Person
{
    protected int sightRange=450;
    private Boolean canShot=false;
    private Boolean canStabed=false;
     
    public Enemy(int dir, int sight){
        setFacing(dir);
        sightRange = sight;
    }
    public void setShot(Boolean s){
        canShot=s;
    }
    public boolean beShot(){
        return canShot;
    }

    public void setCanBeStabbed(boolean b) {
        canStabed = b;
    }
    public boolean beStabbed() {
        return canStabed;
    }
    
    public Enemy(int dir){
        setFacing(dir);
    }
  
    // generalized to work without reliance on this objects state
    // at least in regards to range and facing
    public Player rayTrace(int range, int facing) {
        int distToWall = range;

        for (int i = 0; i < range; i+=7) {
            Actor wall = getOneObjectAtOffset(i*facing,0,Block.class);
            Player player =(Player) getOneObjectAtOffset(i*facing,0,Player.class);

            if(wall != null) {
                return null;
            }             
            
            if(player != null) {
                return player;
            }
        }

        return null;
    }

    // don't break public interfaces!
    public boolean look() {
        return rayTrace(sightRange, getFacing())!=null;
    }
}
