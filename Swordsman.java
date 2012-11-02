
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
        if (rayTrace(killDistance, getFacing())) {
            ShiftWorld sw = (ShiftWorld) getWorld();
            sw.killPlayer();
        }
    }
}

