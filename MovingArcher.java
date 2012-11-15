import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MovingArcher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovingArcher extends PatrolingEnemy
{
    private int fireCooldown = 60;

    private int fireTick;

    public MovingArcher(int dir) {
        super(dir);
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
        super.act();
        if (fireTick > 0)
            fireTick--;

        if(look())
            spotted();
    }
    protected void spotted() {
        if (fireTick == 0) {
            fireArrow();
            fireTick = fireCooldown;
        }
    }
    
    private void fireArrow(){
        Arrow a = new Arrow(getFacing());
        ShiftWorld sw = (ShiftWorld) getWorld();
        
        sw.addObject(a, getX(), getY());
        a.setWorldLocation(sw.getWorldX(getX()), getY());
    }
}

 