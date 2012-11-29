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
    /** tweakable **/
    // enable god mode here!
    private boolean godMode = false;

    /* world geometry */
    public static final int worldWidth = 3200;
    public static final int worldHeight = 600;

    /* screen geometry */
    public static final int screenWidth = 800;
    public static final int screenHeight = 600;

    /** internal **/
    // the player controlled actor
    private Player player;
    
    // the independent timer
    private Timer timer;

    // the actor that the screen should center on
    private ShiftActor viewTarget;

    /* static methods for level trasitions */
    private static int levelIndex = 0;

    public static void advanceLevel(int by) {
        switch (levelIndex += by) {
            case 0: Greenfoot.setWorld(new IntroScreen()); break;
            case 1: Greenfoot.setWorld(new InstructionsOne()); break;
            case 2: Greenfoot.setWorld(new IntroLevel1()); break;
            case 3: Greenfoot.setWorld(new IntroLevel3()); break;
            case 4: Greenfoot.setWorld(new IntroLevel2()); break;
            case 5: Greenfoot.setWorld(new IntroLevel4()); break;
            case 6: Greenfoot.setWorld(new IntroLevel5()); break;
            case 7: Greenfoot.setWorld(new LevelOne()); break;
            case 8: Greenfoot.setWorld(new LevelGeddy()); break;
            case 9: Greenfoot.setWorld(new JamesWorld()); break;
            case 10: Greenfoot.setWorld(new VictoryScreen()); break;
        }
    }

    public static void resetLevel() {
        advanceLevel(0);
    }

    public static void nextLevel() {
        advanceLevel(1);
    }

    /* CONSTRUCTOR */
    public ShiftWorld()
    {    
        // create the screen
        super(screenWidth, screenHeight, 1, false);
        paintOrder();
        // adds a timer
        timer = new Timer();
        addObject(timer, 74, 60);
        timer.setLocation(79,19);
        // adds the player
    }
    
    // used by editor world
    public ShiftWorld(int width, int height) {
        super(width, height, 1, false);
        paintOrder();
    }

    // register a Player object with the world
    public void registerPlayer(Player p, int x, int y) {
        p.setWorldLocation(x, y);
        this.player = p;
        this.viewTarget = p;
        addObject(p);
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

    public void paintOrder() {
        // sets the order in which things appear on the world
        setPaintOrder(Note.class, Timer.class, NotePickup.class, Particles.class, Player.class, Exit.class,
            Laser.class, Arrow.class, MovingPlatform.class, JumpPad.class,
            Platform.class, Enemy.class, Block.class, Background.class, 
            WayPoint.class, PlatformWaypoint.class, MakeWayPoint.class);
    }

    /* create a row of platforms that is count long (including the
     * head) starting from the platform head
     *
     * Only works in EditorWorld!
     */
    public void platformRow(Platform head, int length) {
        for (int i = 1; i < length; i++) {
            Platform p = new Platform();
            int w = p.getWidth();

            p.setWorldLocation(head.getX() + w * i, head.getY());
            addObject(p);
        }
    }

    /* create a row of blocks that is count long (including the
     * head) starting from the platform head
     *
     * Only works in EditorWorld!
     */
    public void blockRow (Block head, int length) {
        for (int i = 1; i < length; i++) {
            Block p = new Block();
            int w = p.getWidth();

            p.setWorldLocation(head.getX() + w * i, head.getY());
            addObject(p);
        }
    }

    public void wallStack(Wall head, int height) {
        for (int i = -1; i > -height; i--) {
            Wall w = new Wall();
            int h = w.getHeight();

            w.setWorldLocation(head.getX(), head.getY() + i*h);
            addObject(w);
        }
    }

    public void wallRow(Wall head, int length) {
        for (int i = 1; i < length; i++){
            Wall r = new Wall();
            int q = r.getWidth();
            
            r.setWorldLocation(head.getX() + i * q, head.getY());
            addObject(r);
        }
    }

    // pass the absolute world location
    public void addObject(ShiftActor object, int x, int y) {
        addObject((Actor) object, x, y);
        object.setWorldLocation(x, y);
    }
    
    public void addObject(ShiftActor object) {
        addObject((Actor) object, object.getWorldX(), object.getWorldY()); 
    }

    /* IMPORTANT: Use this method when killing the player in a
     * standard way
     */
    public void killPlayer() {
        GreenfootSound sound = new GreenfootSound("player-dying.wav");

        if (player != null) {
            // do shit to kill the player
            if (!godMode)
                sound.play();
                resetLevel();
            // removeObject(player);
        }
    }

    /* ACCESSORS */
    // get the top left corner of the camera
    // used for saveWorldLocation
    public int getScreenLeft() {
        int x = viewTarget.getWorldX() - screenWidth / 2;

        if (x < 0) {
            return 0;
        }
        else if (x + screenWidth > worldWidth) {
            return worldWidth - screenWidth;
        }

        return x;
    }

    // using the (screen)x coord of an object, return the absolute
    // world x that corrisponds
    public int getWorldX(int x) {
        if (viewTarget != null) {
            return x + getScreenLeft();
        }
        return x;
    }

    // getWorldY always returns y

    public Player getPlayer() { return player; }

    public void lockControls() {
        getPlayer().lockControls();
    }

    public void unlockControls() {
        getPlayer().unlockControls();
    }
}