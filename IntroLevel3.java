import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IntroLevel3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroLevel3 extends ShiftWorld
{

    /**
     * Constructor for objects of class IntroLevel3.
     * 
     */
    public IntroLevel3()
    {    
        super();
        
        Player p = new Player();
        registerPlayer(p, 100, 200);
        
        Background bg = new Background("background.png");
        addObject(bg);
        
        prepare();
    }
    public void prepare()
    {
        
        Wall wall = new Wall();
        addObject(wall, 165, 571);
        wall.wallStack(5);
        Wall wall8 = new Wall();
        addObject(wall8, 115, 571);
        wall8.wallStack(5);
        Wall wall9 = new Wall();
        addObject(wall9, 65, 571);
        wall9.wallStack(5);
        Wall wall10 = new Wall();
        addObject(wall10, 15, 571);
        wall10.wallStack(5);
        FallingPlatform fallingplatform = new FallingPlatform();
        addObject(fallingplatform, 254, 285);
        Wall wall2 = new Wall();
        addObject(wall2, 343, 268);
        wall2.wallStack(5);
        Wall wall11 = new Wall();
        addObject(wall11, 393, 268);
        wall11.wallStack(5);
        Wall wall12 = new Wall();
        addObject(wall12, 443, 268);
        wall12.wallStack(5);
        Wall wall13 = new Wall();
        addObject(wall13, 493, 268);
        wall13.wallStack(5);
        Block block = new Block();
        addObject(block, 222, 587);
        block.blockRow(3);
        Wall wall3 = new Wall();
        addObject(wall3, 407, 569);
        wall3.wallRow(6);
        Wall wall4 = new Wall();
        addObject(wall4, 708, 571);
        wall4.wallStack(4);
        JumpPad jumppad = new JumpPad(30, 30);
        addObject(jumppad, 642, 506);
        Wall wall5 = new Wall();
        addObject(wall5, 1065, 276);
        wall5.wallStack(6);
        Wall wall14 = new Wall();
        addObject(wall14, 1115, 276);
        wall14.wallStack(6);
        Wall wall15 = new Wall();
        addObject(wall15, 1165, 276);
        wall15.wallStack(6);
        Wall wall16 = new Wall();
        addObject(wall16, 1215, 276);
        wall16.wallStack(6);
        Wall wall17 = new Wall();
        addObject(wall17, 1265, 276);
        wall17.wallStack(6);
        Wall wall18 = new Wall();
        addObject(wall18, 1315, 276);
        wall18.wallStack(6);
        Wall wall19 = new Wall();
        addObject(wall19, 1365, 276);
        wall19.wallStack(6);
        Wall wall20 = new Wall();
        addObject(wall20, 1415, 276);
        wall20.wallStack(6);
        Wall wall21 = new Wall();
        addObject(wall21, 1465, 276);
        wall21.wallStack(6);
        PlatformWaypoint platformwaypoint = new PlatformWaypoint();
        addObject(platformwaypoint, 882, 251);
        MovingPlatform movingplatform = new MovingPlatform(false);
        addObject(movingplatform, 881, 290);
        PlatformWaypoint platformwaypoint2 = new PlatformWaypoint();
        addObject(platformwaypoint2, 866, 571);
        PlatformWaypoint platformwaypoint3 = new PlatformWaypoint();
        addObject(platformwaypoint3, 950, 569);
        PlatformWaypoint platformwaypoint4 = new PlatformWaypoint();
        addObject(platformwaypoint4, 1283, 567);
        PlatformWaypoint platformwaypoint5 = new PlatformWaypoint();
        addObject(platformwaypoint5, 1644, 572);
        Wall wall6 = new Wall();
        addObject(wall6, 1703, 568);
        JumpPad jumppad2 = new JumpPad(30, 30);
        addObject(jumppad2, 1704, 506);
        MovingPlatform movingplatform2 = new MovingPlatform(true);
        addObject(movingplatform2, 1210, 569);
        MovingPlatform movingplatform3 = new MovingPlatform(true);
        addObject(movingplatform3, 1359, 572);
        FallingPlatform fallingplatform2 = new FallingPlatform();
        addObject(fallingplatform2, 1901, 163);
        Wall wall7 = new Wall();
        addObject(wall7, 2117, 568);
        JumpPad jumppad3 = new JumpPad(30, 30);
        addObject(jumppad3, 2119, 506);
        PlatformWaypoint platformwaypoint6 = new PlatformWaypoint();
        addObject(platformwaypoint6, 2222, 154);
        PlatformWaypoint platformwaypoint7 = new PlatformWaypoint();
        addObject(platformwaypoint7, 2514, 151);
        MovingPlatform movingplatform4 = new MovingPlatform(true);
        addObject(movingplatform4, 2443, 153);
        FallingPlatform fallingplatform3 = new FallingPlatform();
        addObject(fallingplatform3, 2609, 155);
        PlatformWaypoint platformwaypoint8 = new PlatformWaypoint();
        addObject(platformwaypoint8, 2697, 158);
        PlatformWaypoint platformwaypoint9 = new PlatformWaypoint();
        addObject(platformwaypoint9, 3028, 157);
        MovingPlatform movingplatform5 = new MovingPlatform(true);
        addObject(movingplatform5, 2863, 157);
        Block block2 = new Block();
        addObject(block2, 3064, 582);
        block2.blockRow(3);
        Exit exit = new Exit();
        addObject(exit, 3153, 480);
    }
}
