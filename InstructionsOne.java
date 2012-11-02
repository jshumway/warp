import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class InstructionsOne extends World
{
    public InstructionsOne() {
        super(800, 600, 1); 
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            LevelOne l = new LevelOne();
            Greenfoot.setWorld(l);
        }
    }
}
