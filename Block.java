import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends ShiftActor
{
    /**
     * The primary class for collidable objects.
     */
    public void blockRow(int length) {
        ShiftWorld sw = (ShiftWorld) getWorld();

        sw.blockRow(this, length);
    }
}
