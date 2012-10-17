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
        MakeWayPoint makewaypoint = new MakeWayPoint();
        addObject(makewaypoint, 800, 483);
        PatrolingEnemy patrolingenemy = new PatrolingEnemy(1);
        addObject(patrolingenemy, 680, 492);
        Player player = new Player();
        addObject(player, 91, 483);
        patrolingenemy.setLocation(439, 485);
        MakeWayPoint makewaypoint2 = new MakeWayPoint();
        addObject(makewaypoint2, 217, 511);
    }
}
