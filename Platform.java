import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Platform extends ShiftActor
{
    public void platformRow(int length) {
        ShiftWorld sw = (ShiftWorld) getWorld();

        sw.platformRow(this, length);
    }
}
