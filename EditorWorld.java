import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EditorWorld extends ShiftWorld
{
    public EditorWorld()
    {    
        super(ShiftWorld.worldWidth, ShiftWorld.worldHeight);

        prepare();
    }
    
    public EditorWorld(int x, int y) {
        super(x, y); 
    }

    /**
     * copy this method to your level
     */
    public void prepare()
    {

        Block block = new Block();
        addObject(block, 40, 567);
        block.blockRow(50);
        Player player = new Player();
        addObject(player, 635, 515);
    }
}
