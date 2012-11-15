import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class NotePickup extends ShiftActor
{
    private String filename;

    public NotePickup(String filename) {
        super();
        this.filename = filename;
    }

    public void act() 
    {
        if (getOneIntersectingObject(Player.class) != null) {
            ShiftWorld sw = (ShiftWorld) getWorld();
            sw.addObject(new Note(filename), 400, 300);
            
            sw.removeObject(this);
        }
    }    
}
