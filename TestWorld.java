import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Use this world to test the setup in EditorWorld
 */
public class TestWorld extends EditorWorld
{
    public TestWorld()
    {    
        super(ShiftWorld.screenWidth, ShiftWorld.screenHeight);
        Player player = new Player();
        registerPlayer(player, 400, 400);
        super.prepare();

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    public void prepare()
    {
        FallingPlatform fallingplatform = new FallingPlatform();
        addObject(fallingplatform, 407, 465);
        Block block = new Block();
        addObject(block, 55, 571);
        Block block2 = new Block();
        addObject(block2, 134, 578);
        Block block3 = new Block();
        addObject(block3, 257, 574);
        Block block4 = new Block();
        addObject(block4, 369, 574);
        Block block5 = new Block();
        addObject(block5, 445, 565);
        Block block6 = new Block();
        addObject(block6, 509, 568);
        Block block7 = new Block();
        addObject(block7, 635, 574);
        Block block8 = new Block();
        addObject(block8, 678, 564);
        Block block9 = new Block();
        addObject(block9, 756, 597);
        FallingPlatform fallingplatform2 = new FallingPlatform();
        addObject(fallingplatform2, 718, 463);
        Platform platform = new Platform();
        addObject(platform, 174, 475);
        Platform platform2 = new Platform();
        addObject(platform2, 181, 358);
        Platform platform3 = new Platform();
        addObject(platform3, 193, 190);
        Platform platform4 = new Platform();
        addObject(platform4, 194, 91);
        Platform platform5 = new Platform();
        addObject(platform5, 178, 264);
        FallingPlatform fallingplatform3 = new FallingPlatform();
        addObject(fallingplatform3, 409, 84);
        MovingPlatform movingplatform = new MovingPlatform(true);
        addObject(movingplatform, 463, 281);
        PlatformWaypoint platformwaypoint = new PlatformWaypoint();
        addObject(platformwaypoint, 709, 288);
        PlatformWaypoint platformwaypoint2 = new PlatformWaypoint();
        addObject(platformwaypoint2, 290, 285);
    }
}
