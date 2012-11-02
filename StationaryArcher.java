import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class stationaryArcher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StationaryArcher extends StationaryEnemy
{
    /* tweakable */
    private int fireCooldown = 60;

    /* internal */
    private int fireTick;

    public StationaryArcher(int dir){
        super(dir, 500);
        fireTick = 0;
        setShot(true);
        if(dir==1)
            flipImage();
    }
     private void flipImage(){
        GreenfootImage image=getImage();
        image.mirrorHorizontally();
        setImage(image);
    }
    public void act(){
        if (fireTick > 0)
            fireTick--;
        
        if(look())
            spoted();
    }
    protected void spoted() {
        if (fireTick == 0) {
            fireArrow();
            fireTick = fireCooldown;
        }
    }

    private void fireArrow(){
        Arrow arrow = new Arrow(getFacing());
        ShiftWorld sw = (ShiftWorld) getWorld();

        sw.addObject(arrow, getX(), getY());
        arrow.setWorldLocation(sw.getWorldX(getX()), getY());
    }   
}
