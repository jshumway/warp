import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Exit extends ShiftActor
{
    public void act() 
    {
        Player p = (Player) getOneIntersectingObject(Player.class);
        if (p != null) {
            ShiftWorld sw = (ShiftWorld) getWorld();

            sw.nextLevel();
        }
    }    
}
