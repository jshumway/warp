import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StationarySwordsman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StationarySwordsman extends StationaryEnemy
{
    /* tweakable */
    private int killDistance = 75;

    public StationarySwordsman(int dir) {
        super(dir);
        if(dir==1)
            flipImage();
        setCanBeStabbed(true);
    }
     private void flipImage(){
        GreenfootImage image=getImage();
        image.mirrorHorizontally();
        setImage(image);
    }
    
    public void act() {
        super.act();
        attemptKill();
    }

    private void attemptKill() {
        Player player=rayTrace(killDistance, getFacing());
        if (player!=null) {
            player.hit();
        }
    }
}
