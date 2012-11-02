import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class InstructionsOne extends World
{
    public InstructionsOne() {
        super(600, 400, 1); 
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            LevelOne l = new LevelOne();
            Greenfoot.setWorld(l);
        }
    }
}
