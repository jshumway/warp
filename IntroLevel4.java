import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IntroLevel4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroLevel4 extends ShiftWorld
{

    /**
     * Constructor for objects of class IntroLevel4.
     * 
     */
    public IntroLevel4()
    {    
        super();
        
        Player p = new Player();
        registerPlayer(p, 100, 750);
        
        Background bg = new Background("background v2.png");
        addObject(bg);
        
        prepare();
    }
    public void prepare()
    {
        Block block11 = new Block();
        addObject(block11, 23, 590);
        block11.blockRow(35);
        Wall wall109 = new Wall();
        addObject(wall109, 14, 538);
        Wall wall110 = new Wall();
        addObject(wall110, 352, 538);
        StationarySwordsman stationaryswordsman = new StationarySwordsman(-1);
        addObject(stationaryswordsman, 163, 525);
        Block block12 = new Block();
        addObject(block12, 16, 181);
        block12.blockRow(6);
        FallingPlatform fallingplatform4 = new FallingPlatform();
        addObject(fallingplatform4, 432, 182);
        Wall wall111 = new Wall();
        addObject(wall111, 521, 164);
        wall111.wallStack(3);
        wall109.wallStack(3);
        Wall wall112 = new Wall();
        addObject(wall112, 846, 538);
        wall112.wallStack(6);
        JumpPad jumppad4 = new JumpPad(15, 30);
        addObject(jumppad4, 777, 542);
        Platform platform = new Platform();
        addObject(platform, 756, 185);
        Block block14 = new Block();
        addObject(block14, 903, 188);
        block14.blockRow(4);
        Block block15 = new Block();
        addObject(block15, 1037, 411);
        block15.blockRow(12);
        Wall wall113 = new Wall();
        addObject(wall113, 1365, 359);
        wall113.wallStack(6);
        Wall wall20 = new Wall();
        addObject(wall20, 1415, 359);
        wall20.wallStack(6);
        Wall wall21 = new Wall();
        addObject(wall21, 1465, 359);
        wall21.wallStack(6);
        Wall wall22 = new Wall();
        addObject(wall22, 1515, 359);
        wall22.wallStack(6);
        Wall wall23 = new Wall();
        addObject(wall23, 1565, 359);
        wall23.wallStack(6);
        Wall wall24 = new Wall();
        addObject(wall24, 1615, 359);
        wall24.wallStack(6);
        Wall wall25 = new Wall();
        addObject(wall25, 1665, 359);
        wall25.wallStack(6);
        Wall wall26 = new Wall();
        addObject(wall26, 1715, 359);
        wall26.wallStack(6);
        MakeWayPoint makewaypoint3 = new MakeWayPoint();
        addObject(makewaypoint3, 993, 351);
        MakeWayPoint makewaypoint4 = new MakeWayPoint();
        addObject(makewaypoint4, 1331, 352);
        Swordsman swordsman = new Swordsman(-1);
        addObject(swordsman, 1268, 345);
        MakeWayPoint makewaypoint5 = new MakeWayPoint();
        addObject(makewaypoint5, 887, 536);
        MakeWayPoint makewaypoint6 = new MakeWayPoint();
        addObject(makewaypoint6, 1355, 539);
        Wall wall114 = new Wall();
        addObject(wall114, 2082, 538);
        wall114.wallStack(5);
        MakeWayPoint makewaypoint7 = new MakeWayPoint();
        addObject(makewaypoint7, 2026, 537);
        Swordsman swordsman2 = new Swordsman(-1);
        addObject(swordsman2, 1412, 524);
        Swordsman swordsman3 = new Swordsman(1);
        addObject(swordsman3, 1295, 524);
        Platform platform2 = new Platform();
        addObject(platform2, 1993, 440);
        Platform platform3 = new Platform();
        addObject(platform3, 1804, 340);
        Block block16 = new Block();
        addObject(block16, 2025, 255);
        Block block18 = new Block();
        addObject(block18, 2139, 255);
        block18.blockRow(2);
        FallingPlatform fallingplatform5 = new FallingPlatform();
        addObject(fallingplatform5, 2302, 254);
        Wall wall116 = new Wall();
        addObject(wall116, 2395, 580);
        wall116.wallStack(6);
        Block block19 = new Block();
        addObject(block19, 2451, 583);
        block19.blockRow(14);
        Wall wall117 = new Wall();
        addObject(wall117, 2650, 365);
        wall117.wallStack(8);
        MakeWayPoint makewaypoint8 = new MakeWayPoint();
        addObject(makewaypoint8, 2450, 521);
        MakeWayPoint makewaypoint9 = new MakeWayPoint();
        addObject(makewaypoint9, 2806, 524);
        Swordsman swordsman4 = new Swordsman(-1);
        addObject(swordsman4, 2712, 518);
        Exit exit2 = new Exit();
        addObject(exit2, 2940, 480);
    }
}
