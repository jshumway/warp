import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelGeddy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelGeddy extends ShiftWorld
{

    /**
     * Constructor for objects of class LevelGeddy.
     * 
     */
    public LevelGeddy()
    {    
        super();
        
        Background bg = new Background("background.png");
        addObject(bg);
        
        prepare();
    }
    
          public void prepare()
    {
            Player p = new Player();
            registerPlayer(p, 100, 100);
        
       Block block6 = new Block();
        addObject(block6, 25, 579);
        block6.blockRow(30);
        Block block7 = new Block();
        addObject(block7, 28, 422);
        block7.blockRow(40);
        Wall wall5 = new Wall();
        addObject(wall5, 393, 372);
        wall5.wallStack(4);
        Wall wall6 = new Wall();
        addObject(wall6, 2, 372);
        wall6.wallStack(7);
        Platform platform4 = new Platform();
        addObject(platform4, 305, 154);
        JumpPad jumppad2 = new JumpPad(0, 20);
        addObject(jumppad2, 339, 384);
        Block block8 = new Block();
        addObject(block8, 644, 10);
        block8.blockRow(50);
        Wall wall7 = new Wall();
        addObject(wall7, 647, 245);
        wall7.wallStack(4);
        Block block9 = new Block();
        addObject(block9, 702, 261);
        block9.blockRow(3);
        Wall wall8 = new Wall();
        addObject(wall8, 1108, 272);
        wall8.wallStack(2);
        Block block10 = new Block();
        addObject(block10, 1163, 187);
        block10.blockRow(10);
        Wall wall9 = new Wall();
        addObject(wall9, 1755, 372);
        wall9.wallStack(4);
        Platform platform5 = new Platform();
        addObject(platform5, 1053, 322);
        Platform platform6 = new Platform();
        addObject(platform6, 1023, 225);
        MovingPlatform movingplatform = new MovingPlatform(true);
        addObject(movingplatform, 2773, 564);
        Wall wall10 = new Wall();
        addObject(wall10, 2219, 255);
        wall10.wallStack(5);
        PlatformWaypoint platformwaypoint = new PlatformWaypoint();
        addObject(platformwaypoint, 3189, 574);
        PlatformWaypoint platformwaypoint2 = new PlatformWaypoint();
        addObject(platformwaypoint2, 1954, 571);
        MakeWayPoint makewaypoint = new MakeWayPoint();
        addObject(makewaypoint, 1884, 543);
        MakeWayPoint makewaypoint2 = new MakeWayPoint();
        addObject(makewaypoint2, 816, 542);
        MakeWayPoint makewaypoint3 = new MakeWayPoint();
        addObject(makewaypoint3, 1714, 153);
        MakeWayPoint makewaypoint4 = new MakeWayPoint();
        addObject(makewaypoint4, 1139, 152);
        MakeWayPoint makewaypoint5 = new MakeWayPoint();
        addObject(makewaypoint5, 2540, 383);
        MakeWayPoint makewaypoint6 = new MakeWayPoint();
        addObject(makewaypoint6, 1807, 382);
        StationaryArcher stationaryarcher = new StationaryArcher(1);
        addObject(stationaryarcher, 730, 197);
        StationaryArcher stationaryarcher2 = new StationaryArcher(1);
        addObject(stationaryarcher2, 477, 515);
        Swordsman swordsman = new Swordsman(-1);
        addObject(swordsman, 1578, 122);
        Swordsman swordsman2 = new Swordsman(-1);
        addObject(swordsman2, 2457, 358);
        Swordsman swordsman3 = new Swordsman(1);
        addObject(swordsman3, 1221, 514);
        Wall wall11 = new Wall();
        addObject(wall11, 3192, 530);
        wall11.wallStack(10);
        removeObject(platformwaypoint);
        Wall wall12 = new Wall();
        addObject(wall12, 3198, 572);
        removeObject(wall12);
        Wall wall13 = new Wall();
        addObject(wall13, 3198, 574);
        removeObject(wall13);
        Wall wall14 = new Wall();
        addObject(wall14, 3194, 578);
        PlatformWaypoint platformwaypoint3 = new PlatformWaypoint();
        addObject(platformwaypoint3, 3150, 571);

        addObject(platform4, 306, 225);
        Platform platform7 = new Platform();
        addObject(platform7, 306, 226);
        platform7.act();
    }
    }