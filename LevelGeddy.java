import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelGeddy extends ShiftWorld
{
    public LevelGeddy()
    {    
        super();
        
        Player p = new Player();
        registerPlayer(p, 142, 279);
        
        Background bg = new Background("background.png");
        addObject(bg);
        
        prepare();
    }
    
    public void prepare() {
        Block block6 = new Block();
        addObject(block6, 25, 579);
        block6.blockRow(30);
        Block block7 = new Block();
        addObject(block7, 81, 344);
        block7.blockRow(5); // was 40

        Wall wall5 = new Wall();
        addObject(wall5, 393, 372);
        wall5.wallStack(4);
        Wall wall6 = new Wall();
        addObject(wall6, 25, 527);
        wall6.wallStack(10);
        // Platform platform4 = new Platform();
        // addObject(platform4, 305, 154);
        // JumpPad jumppad2 = new JumpPad(0, 20);
        // addObject(jumppad2, 339, 384);
        Block block8 = new Block();
        addObject(block8, 644, 10);
        block8.blockRow(50);
        Wall wall7 = new Wall();
        addObject(wall7, 637, 260);
        wall7.wallStack(4);
        Block block9 = new Block();
        addObject(block9, 694, 276);
        block9.blockRow(3);
        Wall wall8 = new Wall();
        addObject(wall8, 1107, 202);

        Block block10 = new Block();
        addObject(block10, 1163, 187);
        block10.blockRow(10);
        Wall wall9 = new Wall();
        addObject(wall9, 1746, 372);
        wall9.wallStack(3);
        Platform platform5 = new Platform();
        addObject(platform5, 1018, 185);
        Platform platform6 = new Platform();
        addObject(platform6, 918, 274);
        MovingPlatform movingplatform = new MovingPlatform(true);
        addObject(movingplatform, 2773, 564);
        Wall wall10 = new Wall();
        addObject(wall10, 2219, 255);
        wall10.wallStack(5);
        // PlatformWaypoint platformwaypoint = new PlatformWaypoint();
        // addObject(platformwaypoint, 3189, 574);
        PlatformWaypoint platformwaypoint2 = new PlatformWaypoint();
        addObject(platformwaypoint2, 1954, 571);
        
        MakeWayPoint makewaypoint = new MakeWayPoint();
        addObject(makewaypoint, 1679, 542);
        MakeWayPoint makewaypoint2 = new MakeWayPoint();
        addObject(makewaypoint2, 1046, 542);
        
        MakeWayPoint makewaypoint3 = new MakeWayPoint();
        addObject(makewaypoint3, 1714, 153);
        MakeWayPoint makewaypoint4 = new MakeWayPoint();
        addObject(makewaypoint4, 1139, 152);
        MakeWayPoint makewaypoint5 = new MakeWayPoint();
        addObject(makewaypoint5, 2540, 383);
        MakeWayPoint makewaypoint6 = new MakeWayPoint();
        addObject(makewaypoint6, 1807, 382);
        StationaryArcher stationaryarcher = new StationaryArcher(1);
        addObject(stationaryarcher, 753, 212);
        // StationaryArcher stationaryarcher2 = new StationaryArcher(1);
        // addObject(stationaryarcher2, 477, 515);
        Swordsman swordsman = new Swordsman(-1);
        addObject(swordsman, 1578, 122);
        Swordsman swordsman2 = new Swordsman(-1);
        addObject(swordsman2, 2457, 358);
        Swordsman swordsman3 = new Swordsman(1);
        addObject(swordsman3, 1221, 514);
        Wall wall11 = new Wall();
        addObject(wall11, 3175, 566);
        wall11.wallStack(10);
        
        PlatformWaypoint platformwaypoint3 = new PlatformWaypoint();
        addObject(platformwaypoint3, 2858, 571);

        // addObject(platform4, 306, 226);
        Platform platform7 = new Platform();
        addObject(platform7, 304, 220);
        platform7.act();
        Exit exit = new Exit();
        addObject(exit, 123, 478);
        Block block99 = new Block();
        addObject(block99, 400, 424);
        block99.blockRow(35);
        Block block134 = new Block();
        addObject(block134, 1114, 254);
    }
}
