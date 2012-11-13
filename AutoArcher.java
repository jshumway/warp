import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AutoArcher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AutoArcher extends StationaryEnemy
{
    private int fireCooldown = 60;

    private int fireTick;
    public AutoArcher(int dir){
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

    public void act() 
    {
        if (fireTick > 0)
            fireTick--;

        autoFire();

    }    

    public void autoFire(){
        if (fireTick == 0){
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