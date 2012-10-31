import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 ***** Must use an image that is the same size as the world.****
 */
public class Background extends ShiftActor
{
    private GreenfootImage background;
    /**
     * Act - do whatever the Background wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Background(String image) 
    {
        background = new GreenfootImage("images/" + image);
        setImage(background);
        setWorldLocation(ShiftWorld.worldWidth / 2, ShiftWorld.worldHeight / 2);
    }    
}
