import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IntroLevel1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroLevel1 extends ShiftWorld
{

    /**
     * Constructor for objects of class IntroLevel1.
     * 
     */
    public IntroLevel1()
    {    
        super();
        
        Player p = new Player();
        registerPlayer(p, 100, 200);
        
        Background bg = new Background("background v2.png");
        addObject(bg);
        
        prepare();
    }
    public void prepare()
    {
         Block block = new Block();
        addObject(block, 29, 585);
        block.blockRow(15);
        Wall wall = new Wall();
        addObject(wall, 805, 535);
        wall.wallStack(5);
        Platform platform = new Platform();
        addObject(platform, 717, 251);
        Platform platform2 = new Platform();
        addObject(platform2, 513, 359);
        Platform platform3 = new Platform();
        addObject(platform3, 268, 469);
        JumpPad jumppad = new JumpPad(30, 30);
        addObject(jumppad, 877, 537);
        Platform platform4 = new Platform();
        addObject(platform4, 1118, 248);
        Platform platform5 = new Platform();
        addObject(platform5, 1402, 186);
        Platform platform6 = new Platform();
        addObject(platform6, 1654, 247);
        Wall wall2 = new Wall();
        addObject(wall2, 1826, 568);
        JumpPad jumppad2 = new JumpPad(30, 30);
        addObject(jumppad2, 1826, 505);
        Platform platform7 = new Platform();
        addObject(platform7, 2089, 249);
        Wall wall3 = new Wall();
        addObject(wall3, 2181, 567);
        wall3.wallStack(6);
        Block block2 = new Block();
        addObject(block2, 2239, 217);
        block2.blockRow(3);
        Platform platform8 = new Platform();
        addObject(platform8, 2464, 220);
        Wall wall5 = new Wall();
        addObject(wall5, 2553, 203);
        wall5.wallStack(4);
        removeObject(platform8);
        FallingPlatform fallingplatform = new FallingPlatform();
        addObject(fallingplatform, 2464, 221);
        Wall wall6 = new Wall();
        addObject(wall6, 2560, 567);
        JumpPad jumppad3 = new JumpPad(60, 30);
        addObject(jumppad3, 2561, 504);
        Platform platform9 = new Platform();
        addObject(platform9, 2641, 222);
        Block block3 = new Block();
        addObject(block3, 2768, 218);
        block3.blockRow(3);
        Wall wall7 = new Wall();
        addObject(wall7, 2731, 567);
        wall7.wallStack(6);
        Block block4 = new Block();
        addObject(block4, 2789, 586);
        block4.blockRow(7);
        Exit exit = new Exit();
        addObject(exit, 2806, 484);
    }
}
