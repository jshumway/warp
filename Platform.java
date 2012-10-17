import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends ShiftActor
{
    public void act() {}

    public void platformRow(int length) {
        ShiftWorld sw = (ShiftWorld) getWorld();

        sw.platformRow(this, length);
    }
}
