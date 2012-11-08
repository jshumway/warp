
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Swordsman extends PatrolingEnemy
{
    /* tweakable */
    private int killDistance = 75;

    public Swordsman(int dir) {
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

