import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IntroLevel5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroLevel5 extends ShiftWorld
{

    /**
     * Constructor for objects of class IntroLevel5.
     * 
     */
    public IntroLevel5()
    {    
        super();
        
        Player p = new Player();
        registerPlayer(p, 100, 300);
        
        Background bg = new Background("background v2.png");
        addObject(bg);
        
        prepare();
    }
    public void prepare()
    {
        Block block3 = new Block();
        addObject(block3, 28, 590);
        block3.blockRow(24);
        Block block4 = new Block();
        addObject(block4, 21, 388);
        block4.blockRow(3);
        FallingPlatform fallingplatform = new FallingPlatform();
        addObject(fallingplatform, 245, 388);
        StationaryArcher stationaryarcher = new StationaryArcher(1);
        addObject(stationaryarcher, 20, 525);
        Wall wall2 = new Wall();
        addObject(wall2, 569, 410);
        wall2.wallStack(7);
        Platform platform = new Platform();
        addObject(platform, 658, 428);
        Platform platform2 = new Platform();
        addObject(platform2, 658, 315);
        Platform platform3 = new Platform();
        addObject(platform3, 658, 205);
        Block block5 = new Block();
        addObject(block5, 754, 428);
        Block block6 = new Block();
        addObject(block6, 754, 315);
        Block block7 = new Block();
        addObject(block7, 754, 205);
        Wall wall3 = new Wall();
        addObject(wall3, 811, 538);
        wall3.wallStack(6);
        Block block8 = new Block();
        addObject(block8, 818, 153);
        block8.blockRow(3);
        Block block9 = new Block();
        addObject(block9, 868, 252);
        block9.blockRow(2);
        FallingPlatform fallingplatform2 = new FallingPlatform();
        addObject(fallingplatform2, 1028, 253);
        Wall wall4 = new Wall();
        addObject(wall4, 1117, 236);
        wall4.wallStack(4);
        StationaryArcher stationaryarcher2 = new StationaryArcher(1);
        addObject(stationaryarcher2, 880, 528);
        Wall wall5 = new Wall();
        addObject(wall5, 1508, 539);
        wall5.wallStack(5);
        JumpPad jumppad = new JumpPad(30, 30);
        addObject(jumppad, 1440, 541);
        PlatformWaypoint platformwaypoint = new PlatformWaypoint();
        addObject(platformwaypoint, 1550, 241);
        FallingPlatform fallingplatform3 = new FallingPlatform();
        addObject(fallingplatform3, 2059, 589);
        Block block10 = new Block();
        addObject(block10, 2155, 591);
        block10.blockRow(17);
        Block block11 = new Block();
        addObject(block11, 2160, 242);
        Wall wall6 = new Wall();
        addObject(wall6, 2217, 225);
        wall6.wallStack(5);
        StationaryArcher stationaryarcher3 = new StationaryArcher(-1);
        addObject(stationaryarcher3, 2156, 178);
        PlatformWaypoint platformwaypoint2 = new PlatformWaypoint();
        addObject(platformwaypoint2, 2113, 242);
        MovingPlatform movingplatform = new MovingPlatform(true);
        addObject(movingplatform, 2037, 247);
        Wall wall7 = new Wall();
        addObject(wall7, 3096, 540);
        wall7.wallStack(4);
        Wall wall8 = new Wall();
        addObject(wall8, 3145, 540);
        wall8.wallStack(7);
        Block block12 = new Block();
        addObject(block12, 2897, 122);
        block12.blockRow(4);
        Exit exit = new Exit();
        addObject(exit, 3118, 21);
        JumpPad jumppad2 = new JumpPad(30, 30);
        addObject(jumppad2, 2719, 542);
        Wall wall9 = new Wall();
        addObject(wall9, 3049, 540);
        wall9.wallStack(4);
        Wall wall10 = new Wall();
        addObject(wall10, 3000, 540);
        wall10.wallStack(4);
        StationaryArcher stationaryarcher4 = new StationaryArcher(-1);
        addObject(stationaryarcher4, 3018, 260);
        Block block58 = new Block();
        addObject(block58, 344, 387);
        block58.setLocation(342, 388);
        block58.setWorldLocation(342, 388);
        block58.blockRow(4);
        stationaryarcher.setLocation(424, 525);
        stationaryarcher.setWorldLocation(424, 525);
        Shooting shooting = new Shooting();
        addObject(shooting, 266, 125);
    }
}
