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
    }
}
