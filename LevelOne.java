import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Use this world to test the setup in EditorWorld
 */
public class LevelOne extends ShiftWorld
{
    public LevelOne()
    {    
        super();
        Background bg = new Background("background.png");
        addObject(bg);
        Player p = new Player();
        registerPlayer(p, 150, 475);
        prepare();
    }
    
    public void nextLevel() {
        World w = new JamesWorld();
        Greenfoot.setWorld(w);
    }
    
    public void resetLevel() {
        World w = new LevelOne();
        Greenfoot.setWorld(w);
    }
    
    public void prepare()
    {
        Block block = new Block();
        addObject(block, 122, 540);
        block.blockRow(25);
        Wall wall = new Wall();
        addObject(wall, 768, 488);
        wall.wallStack(4);
        MovingPlatform movingplatform = new MovingPlatform(true);
        addObject(movingplatform, 657, 231);
        Platform platform = new Platform();
        addObject(platform, 164, 311);
        Wall wall2 = new Wall();
        addObject(wall2, 326, 338);
        Block block2 = new Block();
        addObject(block2, 333, 389);
        block2.blockRow(3);
        Block block3 = new Block();
        addObject(block3, 526, 388);
        removeObject(block3);
        PlatformWaypoint platformwaypoint = new PlatformWaypoint();
        addObject(platformwaypoint, 477, 235);
        Swordsman swordsman = new Swordsman(1);
        addObject(swordsman, 587, 474);
        WayPoint waypoint = new WayPoint();
        addObject(waypoint, 704, 507);
        WayPoint waypoint2 = new WayPoint();
        addObject(waypoint2, 280, 508);
        JumpPad jumppad2 = new JumpPad(10, 30);
        addObject(jumppad2, 55, 519);
        Block block30 = new Block();
        addObject(block30, 825, 312);
        block30.blockRow(9);
        Exit exit = new Exit();
        addObject(exit, 864, 438);
        Wall wall6 = new Wall();
        addObject(wall6, 960, 361);
        Swordsman swordsman2 = new Swordsman(1);
        addObject(swordsman2, 1088, 473);
        MakeWayPoint makewaypoint = new MakeWayPoint();
        addObject(makewaypoint, 1268, 510);
        MakeWayPoint makewaypoint2 = new MakeWayPoint();
        addObject(makewaypoint2, 1016, 508);
        Wall wall7 = new Wall();
        addObject(wall7, 1665, 489);
        wall7.wallStack(8);
        PlatformWaypoint platformwaypoint2 = new PlatformWaypoint();
        addObject(platformwaypoint2, 759, 230);
        Swordsman swordsman3 = new Swordsman(-1);
        addObject(swordsman3, 1433, 472);
        MakeWayPoint makewaypoint3 = new MakeWayPoint();
        addObject(makewaypoint3, 1627, 507);
        MakeWayPoint makewaypoint4 = new MakeWayPoint();
        addObject(makewaypoint4, 1288, 512);
    }
}