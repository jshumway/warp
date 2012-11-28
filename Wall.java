import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Block
{
    /**
     * Create a larger wall from a single wall. The final wall will be a
     * stack of "height" walls, including the first wall. Creats the stack
     * upwards.
     */
    public void wallStack(int height) {
        ShiftWorld sw = (ShiftWorld) getWorld();

        sw.wallStack(this, height);
    }
    public void wallRow(int length) {
        ShiftWorld sw = (ShiftWorld) getWorld();

        sw.wallRow(this, length);
    }
}
