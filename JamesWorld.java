import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class JamesWorld extends ShiftWorld
{
    public JamesWorld()
    {    
        super(); 
        Background bg = new Background("background.png");
        addObject(bg);
        Player p = new Player();
        registerPlayer(p, 175, 460);
        prepare();

    }
    
    public void prepare()
    {
        Block block = new Block();
        addObject(block, 71, 589);
        block.blockRow(29);
        Wall wall = new Wall();
        addObject(wall, 911, 537);
        wall.wallStack(7);
        JumpPad jumppad = new JumpPad(20, 40);
        addObject(jumppad, 822, 547);
        Platform platform2 = new Platform();
        addObject(platform2, 552, 306);
        Platform platform3 = new Platform();
        addObject(platform3, 822, 230);
        //Wall wall15 = new Wall();
        // addObject(wall15, 1382, 317);
        // wall15.wallStack(8);
        Platform platform4 = new Platform();
        addObject(platform4, 1183, 119);
        platform4.platformRow(2);
        // Platform platform5 = new Platform();
        // addObject(platform5, 1304, 202);
        Block block31 = new Block();
        addObject(block31, 967, 287);
        block31.blockRow(4);
        Block block32 = new Block();
        addObject(block32, 1137, 424);
        block32.blockRow(5);
        Block block33 = new Block();
        Wall wall16 = new Wall();
        addObject(wall16, 1400, 407);
        wall16.wallStack(8);
        MovingPlatform movingplatform = new MovingPlatform(false);
        addObject(movingplatform, 1621, 523);
        WayPoint waypoint = new WayPoint();
        addObject(waypoint, 1627, 570);
        WayPoint waypoint2 = new WayPoint();
        addObject(waypoint2, 1620, 233);
        MovingPlatform platform6 = new MovingPlatform(true);
        addObject(platform6, 1715, 237);
        PlatformWaypoint platformwaypoint = new PlatformWaypoint();
        addObject(platformwaypoint, 1624, 239);
        PlatformWaypoint platformwaypoint2 = new PlatformWaypoint();
        addObject(platformwaypoint2, 1630, 571);
        PlatformWaypoint platformwaypoint3 = new PlatformWaypoint();
        addObject(platformwaypoint3, 2132, 228);
        // StationaryArcher stationaryarcher = new StationaryArcher(-1);
        // addObject(stationaryarcher, 1856, 530);
        WayPoint waypoint3 = new WayPoint();
        addObject(waypoint3, 1109, 415);
        WayPoint waypoint4 = new WayPoint();
        addObject(waypoint4, 1345, 417);
        Block block34 = new Block();
        addObject(block34, 2145, 592);
        block34.blockRow(6);
        Wall wall17 = new Wall();
        addObject(wall17, 2232, 417);
        wall17.wallStack(12);
        Wall wall18 = new Wall();
        addObject(wall18, 2088, 577);
        wall18.wallStack(4);
        // StationaryArcher stationaryarcher2 = new StationaryArcher(-1);
        // addObject(stationaryarcher2, 2474, 528);
        StationaryArcher stationaryarcher3 = new StationaryArcher(1);
        addObject(stationaryarcher3, 562, 244);
        Wall wall19 = new Wall();
        addObject(wall19, 2522, 576);
        wall19.wallStack(6);
        JumpPad jumppad3 = new JumpPad(0, 35);
        addObject(jumppad3, 2463, 549);
        StationaryArcher stationaryarcher4 = new StationaryArcher(-1);
        addObject(stationaryarcher4, 2087, 297);
        Wall wall81 = new Wall();
        addObject(wall81, 2764, 393);
        wall81.wallStack(12);
        Block block91 = new Block();
        addObject(block91, 2579, 561);
        block91.blockRow(8);
        Exit exit = new Exit();
        addObject(exit, 3126, 125);
        Wall wall82 = new Wall();
        addObject(wall82, 3034, 510);
        wall82.wallStack(5);
        WayPoint waypoint9 = new WayPoint();
        addObject(waypoint9, 2568, 532);
        WayPoint waypoint10 = new WayPoint();
        addObject(waypoint10, 2982, 534);
        Swordsman swordsman = new Swordsman(1);
        addObject(swordsman, 2789, 493);

        Platform platform15 = new Platform();
        addObject(platform15, 2945, 411);
        Platform platform16 = new Platform();
        addObject(platform16, 2853, 315);
        Platform platform17 = new Platform();
        addObject(platform17, 2945, 225);

        Wall wall83 = new Wall();
        addObject(wall83, 64, 538);
        wall83.wallStack(12);
        Block block53 = new Block();
        addObject(block53, 3091, 227);
        block53.blockRow(3);
        NotePickup notepickup = new NotePickup("notes/note-3.png");
        addObject(notepickup, 3029, 176);
    }
}
