import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EndOfGameText extends World
{
    public EndOfGameText() {
        super(800, 600, 1); 
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            ShiftWorld.nextLevel();
        }
    }
}
