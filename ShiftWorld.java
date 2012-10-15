import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * ShiftWorld handles things that are global to shift.
 *
 * This class enables sidescrolling.
 *
 * @author Jared Shumway
 */
public class ShiftWorld extends World
{
    /* world geometry */
    public static final int worldWidth = 1600;
    public static final int worldHeight = 600;
    
    /* screen geometry */
    public static final int screenWidth = 800;
    public static final int screenHeight = 600;    
    
    /** internal **/
    // the player controlled actor
    private Player player;

    // the actor that the screen should center on
    private ShiftActor viewTarget;

    /* CONSTRUCTOR */
    public ShiftWorld()
    {    
        // create the screen
        super(screenWidth, screenHeight, 1, false);

        Player player = new Player();
        player.setWorldLocation(400, 400);
        this.player = player;
        viewTarget = player;
        addObject(player, 400, 400);

        fillBottom();
    }

    /* MANIPULATORS */
    public void act() {
        /* all of this stuff does sidescrolling */
        /* could probably be a subroutine */
        /* only does left-right side scrolling */
        int screenx = 0;

        if (viewTarget != null) {
            screenx = viewTarget.getWorldX() - screenWidth / 2;

            // bounds checking
            if (screenx < 0)
                screenx = 0;
            if (screenx + screenWidth > worldWidth) 
                screenx = worldWidth - screenWidth;
        }
        
        List<ShiftActor> sActors = getObjects(ShiftActor.class);

        for (ShiftActor sactor : sActors) {
            // Actor World Coords
            int awx = sactor.getWorldX();
            int awy = sactor.getWorldY();

            sactor.setLocation(awx - screenx, awy);
        }
    }

    /* fills the bottom of the screen with blocks */
    public void fillBottom() {
        for (int i = 0; i <= worldWidth; i+=48) {
            Block b = new Block();
            b.setWorldLocation(i, worldHeight - 24);
            addObject(b, i, worldHeight - 24);
        }
    }

    public int getTopLeftX() {
        return viewTarget.getWorldX() - screenWidth / 2;
    }
}
