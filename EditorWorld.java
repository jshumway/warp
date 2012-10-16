import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EditorWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EditorWorld extends ShiftWorld
{

    /**
     * Constructor for objects of class EditorWorld.
     * 
     */
    public EditorWorld()
    {    
        super(ShiftWorld.worldWidth, ShiftWorld.worldHeight);

        prepare();
    }

    /**
     * copy this method to your level
     */
    private void prepare()
    {
        fillBottom();
        Platform platform = new Platform();
        addObject(platform, 797, 415);
        Platform platform2 = new Platform();
        addObject(platform2, 204, 425);
        StationaryArcher stationaryarcher = new StationaryArcher(1);
        addObject(stationaryarcher, 549, 485);
    }
}
