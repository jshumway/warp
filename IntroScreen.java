import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class IntroScreen extends World
{
    public IntroScreen() {
        super(600, 400, 1);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            InstructionsOne i = new InstructionsOne();
            Greenfoot.setWorld(i);
        }
    }
}
