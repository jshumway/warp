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
        addObject(makewaypoint, 732, 483);
        Enemy enemy = new Enemy(1);
        addObject(enemy, 579, 484);
        removeObject(enemy);
        Enemy enemy2 = new Enemy(1);
        addObject(enemy2, 822, 490);
        makewaypoint.setLocation(502, 460);
        makewaypoint.setLocation(1049, 476);
        removeObject(enemy2);
        PatrolingEnemy patrolingenemy = new PatrolingEnemy(1);
        addObject(patrolingenemy, 740, 492);
        patrolingenemy.setLocation(743, 484);
        patrolingenemy.setLocation(358, 483);
    }
}
