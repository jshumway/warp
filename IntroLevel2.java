import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IntroLevel2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroLevel2 extends ShiftWorld
{

    /**
     * Constructor for objects of class IntroLevel2.
     * 
     */
    public IntroLevel2()
    {    
        super();
        
        Player p = new Player();
        registerPlayer(p, 50, 200);
        
        Background bg = new Background("background.png");
        addObject(bg);
        
        prepare();
    }
    public void prepare()
    {
         
        Block block = new Block();
        addObject(block, 30, 584);
        block.blockRow(3);
        JumpPad jumppad = new JumpPad(30, 30);
        addObject(jumppad, 160, 536);
        Platform platform = new Platform();
        addObject(platform, 310, 179);
        PlatformWaypoint platformwaypoint = new PlatformWaypoint();
        addObject(platformwaypoint, 387, 181);
        PlatformWaypoint platformwaypoint2 = new PlatformWaypoint();
        addObject(platformwaypoint2, 691, 174);
        MovingPlatform movingplatform = new MovingPlatform(true);
        addObject(movingplatform, 462, 180);
        PlatformWaypoint platformwaypoint3 = new PlatformWaypoint();
        addObject(platformwaypoint3, 688, 432);
        MovingPlatform movingplatform2 = new MovingPlatform(false);
        addObject(movingplatform2, 693, 406);
        Platform platform3 = new Platform();
        addObject(platform3, 1028, 402);
        PlatformWaypoint platformwaypoint4 = new PlatformWaypoint();
        addObject(platformwaypoint4, 1233, 455);
        MovingPlatform movingplatform3 = new MovingPlatform(false);
        addObject(movingplatform3, 1237, 423);
        PlatformWaypoint platformwaypoint5 = new PlatformWaypoint();
        addObject(platformwaypoint5, 1224, 87);
        PlatformWaypoint platformwaypoint6 = new PlatformWaypoint();
        addObject(platformwaypoint6, 1439, 81);
        PlatformWaypoint platformwaypoint7 = new PlatformWaypoint();
        addObject(platformwaypoint7, 1433, 451);
        MovingPlatform movingplatform4 = new MovingPlatform(false);
        addObject(movingplatform4, 1449, 111);
        Block block2 = new Block();
        addObject(block2, 1546, 110);
        block2.blockRow(3);
        Wall wall = new Wall();
        addObject(wall, 1731, 595);
        wall.wallStack(8);
        Wall wall2 = new Wall();
        addObject(wall2, 1945, 125);
        wall2.wallStack(4);
        Wall wall12 = new Wall();
        addObject(wall12, 2045, 125);
        wall12.wallStack(4);
        Wall wall13 = new Wall();
        addObject(wall13, 1995, 125);
        wall13.wallStack(4);
        PlatformWaypoint platformwaypoint8 = new PlatformWaypoint();
        addObject(platformwaypoint8, 1780, 565);
        PlatformWaypoint platformwaypoint9 = new PlatformWaypoint();
        addObject(platformwaypoint9, 2217, 568);
        MovingPlatform movingplatform5 = new MovingPlatform(true);
        addObject(movingplatform5, 1856, 568);
        PlatformWaypoint platformwaypoint10 = new PlatformWaypoint();
        addObject(platformwaypoint10, 2203, 190);
        MovingPlatform movingplatform6 = new MovingPlatform(false);
        addObject(movingplatform6, 2213, 220);
        Wall wall5 = new Wall();
        addObject(wall5, 2332, 580);
        wall5.wallStack(6);
        Wall wall14 = new Wall();
        addObject(wall14, 2382, 580);
        wall14.wallStack(6);
        Wall wall7 = new Wall();
        addObject(wall7, 2569, 210);
        wall7.wallStack(4);
        Wall wall15 = new Wall();
        addObject(wall15, 2619, 210);
        wall15.wallStack(4);
        Wall wall16 = new Wall();
        addObject (wall16, 2669, 210);
        wall16.wallStack(4);
        Wall wall17 = new Wall();
        addObject (wall17, 2719, 210);
        wall17.wallStack(4);
        Wall wall18 = new Wall();
        addObject (wall18, 2769, 210);
        wall18.wallStack(4);
        PlatformWaypoint platformwaypoint11 = new PlatformWaypoint();
        addObject(platformwaypoint11, 2413, 571);
        PlatformWaypoint platformwaypoint12 = new PlatformWaypoint();
        addObject(platformwaypoint12, 2692, 571);
        PlatformWaypoint platformwaypoint13 = new PlatformWaypoint();
        addObject(platformwaypoint13, 2949, 573);
        PlatformWaypoint platformwaypoint14 = new PlatformWaypoint();
        addObject(platformwaypoint14, 2942, 171);
        MovingPlatform movingplatform7 = new MovingPlatform(true);
        addObject(movingplatform7, 2486, 570);
        MovingPlatform movingplatform8 = new MovingPlatform(true);
        addObject(movingplatform8, 2878, 571);
        MovingPlatform movingplatform9 = new MovingPlatform(false);
        addObject(movingplatform9, 2951, 537);
        Wall wall11 = new Wall();
        addObject(wall11, 3065, 575);
        wall11.wallStack(6);
        Wall wall19 = new Wall();
        addObject(wall19, 3115, 575);
        wall19.wallStack(6);
        Wall wall20 = new Wall();
        addObject(wall20, 3165, 575);
        wall20.wallStack(6);
        Wall wall21 = new Wall();
        addObject(wall21, 3215, 575);
        wall21.wallStack(6);
        Exit exit = new Exit();
        addObject(exit, 3153, 122);

    }
}
