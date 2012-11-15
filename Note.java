import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Note extends Actor
{
    private boolean inited = false;

    public Note(String filename) 
    {
        super();
        
        setImage(filename);
    }    

    public void act() {
        if (inited==false) {
            ShiftWorld sw = (ShiftWorld) getWorld();
            sw.lockControls();
            inited = true;
        }
        
        if (Greenfoot.mouseClicked(this)) {
            ShiftWorld sw = (ShiftWorld) getWorld();
            sw.removeObject(this);
            sw.unlockControls();
        }
    }
}
