import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Handles things like collisions, gravity, and acceleration, player
 * input
 * 
 * @author Jared Shumway
 */
public class Player extends Person
{
    /** Physical State **/
    /* tweakable */
    private int xSpeedMax = 10;
    private int terminalVelocity = 10;
    private int horizontalAccel = 3;
    private int gravityAccel = 1;
    private double friction = 0.35;
    private int jumpImpulse = 20;
    private int fireOffset = 120;
    private int laserCooldown = 75;
    private int stabRange = 65;
    private int fallTicksToSound = 17; // how many ticks should the player fall for there to be a sound

    /* internal */
    private double hp=1;
    private boolean invulnerable=false;
    private int invulntimer=0;
    private double yvel, xvel;
    private boolean accelerating;
    private boolean atRest;
    private boolean canJump;
    private int laserTick;
    private int animationTick;
    private boolean hittingBlockLeft=false;
    private boolean hittingBlockRight=false;
    private boolean hittingFloor=false;
    private boolean hittingCeiling=false;
    private boolean hittingMovingWallAbove=false;
    private boolean hittingMovingWallBelow=false;
    private boolean hittingMovingWallLeft=false;
    private boolean hittingMovingWallRight=false;
    private boolean controlsLocked=false;

    private boolean stabAnimationGoing=false;
    private boolean isJumping=false; // for the animation not sure where to put it yet no good spots
    private boolean isRunning=false; //for animation of movement
    private boolean isShooting=false; //for shooting animantion
    
    private int fallTickCounter = 0;

    /** CREATOR **/
    public Player() {
        // initialize physical state
        xvel = yvel = 0;
        atRest = false;
        accelerating = false;

        setFacing(1);
    }

    /** MANIPULATORS **/
    /* physics helpers */

    /**
     * y is 0 at the top of the screen applying a positive y impulse 
     * will lanch the player towards the bottom of the screen
     */
    public void impulse(int x, int y) {
        xvel += x; yvel += y;
    }

    public void jump() {
        GreenfootSound sound = new GreenfootSound("jumping-grunt.wav");
        impulse(0, -jumpImpulse);
        sound.setVolume(75);
        setImage("Main-Crouching.png");
        if(getFacing()==-1){
            flipImage();
        }
        isJumping=true;
        
        sound.play();
    }

    /**
     * Collision Functions. Collisions are detected before they happen
     * by these functions. Each function tests if the player will be 
     * inside a block by 1 pixel, and if they will be, set the player's
     * velocity to 0.
     */ 
    private Boolean lookForBlockRight() {
        // following the right edge of the actor, test every 5 points from bottom to top,
        // looking for a collision
        for (int i = -getHeight()/2; i < getHeight()/2; i+=5) {
            Actor block=getOneObjectAtOffset(-getWidth()/2 - 1, i, Block.class);
            if (block != null) 
                return true;
        }

        return false;
    }

    private boolean lookForBlockLeft(){
        for (int i = -getHeight()/2; i < getHeight()/2; i+=5) {
            Actor block=getOneObjectAtOffset(getWidth()/2 + 1, i, Block.class);
            if(block!=null)
                return true;
        }

        return false;
    }

    private boolean lookForFloor() {
        for (int i = -getWidth()/2; i < getWidth()/2; i+=5) {
            Actor block = getOneObjectAtOffset(i, getHeight()/2 + 1, Block.class);
            if (block != null) {
                return true;
            }
        }

        return false;
    }

    /* this is called by enemies that hit the player with an arrow or sword */
    public void hit(){
        GreenfootSound sound = new GreenfootSound("player-dying-1.wav");

        if(!invulnerable){
            hp=-1;
            if(hp<=0){
                sound.play();
                ShiftWorld sw = (ShiftWorld) getWorld();
                sw.resetLevel();
            }else{
                invulnerable= true;
                invulntimer = 10;
            }
        }

    }

    private boolean lookForCeiling() {
        for (int i = -getWidth()/2; i < getWidth()/2; i+=5) {
            Actor block = getOneObjectAtOffset(i, -getHeight()/2 - 1, Block.class);
            if (block != null) {
                return true;
            }
        }

        return false;
    }

    private boolean lookForMovingWallAbove(){
        for (int i = -getWidth()/2; i < getWidth()/2; i+=5) {
            Actor mw = getOneObjectAtOffset(i, -getHeight()/2 - 1, MovingWall.class);
            if (mw != null) {
                return true;
            }
        }

        return false;
    }

    private boolean lookForMovingWallBelow(){
        for (int i = -getWidth()/2; i < getWidth()/2; i+=5) {
            Actor mw = getOneObjectAtOffset(i, getHeight()/2 + 1, MovingWall.class);
            if (mw != null) {
                return true;
            }
        }

        return false;
    }

    private boolean lookForMovingWallLeft(){
        for (int i = -getHeight()/2; i < getHeight()/2; i+=5) {
            Actor mw=getOneObjectAtOffset(getWidth()/2 + 1, i, MovingWall.class);
            if(mw!=null)
                return true;
        }

        return false;
    }

    private boolean lookForMovingWallRight(){
        for (int i = -getHeight()/2; i < getHeight()/2; i+=5) {
            Actor mw=getOneObjectAtOffset(-getWidth()/2 - 1, i, MovingWall.class);
            if (mw != null) 
                return true;
        }

        return false;
    }

    // check if the palyer is standing on a wooden platform
    public boolean onPlatform() {
        if (yvel >= 0) {
            Platform platform;
            platform = (Platform) getOneIntersectingObject(Platform.class);

            if (platform != null) { /* && yvel >= 0) { */
                if (getBottom() - platform.getTop() <= Math.abs(yvel * 4)) {
                    onMovingPlatform();
                    setWorldLocation(getWorldX(), platform.getTop() - getHeight()/2);
                    canJump = true;
                    yvel = 0;
                    return true;
                }
            } /* else if (platform != null) {// && yvel < 0
            if (getBottom() - platform.getTop() <
            } */
        }

        return false;
    }
    private void onMovingPlatform(){
        MovingPlatform platform;
        platform=(MovingPlatform) getOneIntersectingObject(MovingPlatform.class);
        if(platform!=null){
            move(platform.getVel()*2,0);
        }
    }

    public boolean onMovingWall(){
        if (yvel >= 0) {
            MovingWall mw;
            mw = (MovingWall) getOneIntersectingObject(MovingWall.class);

            if (mw != null) {
                if (getBottom() - mw.getTop() <= Math.abs(yvel * 4)) {
                    setWorldLocation(getWorldX(), mw.getTop() - getHeight()/2);
                    canJump = true;
                    yvel = 0;
                    return true;
                }
            } /* else if (platform != null) {// && yvel < 0
            if (getBottom() - platform.getTop() <
            } */
        }

        return false;
    }

    public void collision() {
        hittingCeiling = lookForCeiling();
        hittingFloor = lookForFloor();
        hittingBlockLeft = lookForBlockLeft();
        hittingBlockRight = lookForBlockRight();
        hittingMovingWallAbove = lookForMovingWallAbove();
        hittingMovingWallBelow = lookForMovingWallBelow();
        hittingMovingWallLeft = lookForMovingWallLeft();
        hittingMovingWallRight = lookForMovingWallRight();

        // test vertical collision
        if (onPlatform() || onMovingWall() || hittingFloor|| hittingCeiling || hittingMovingWallBelow || hittingMovingWallAbove ) {
            if (fallTickCounter >= fallTicksToSound) {
                GreenfootSound sound = new GreenfootSound("player-landing.wav");
                sound.play();
                fallTickCounter = 0;
            }

            yvel = 0;
        }
        if (hittingFloor && !hittingMovingWallBelow) {
            canJump = true;
            move(0, -1);
        }

        if (hittingMovingWallAbove && hittingFloor) {
            addParticles(1);
        }
        if (hittingCeiling || hittingMovingWallAbove) {
            move(0, 1);
            if(hittingMovingWallAbove){
                move(0, 2);
                yvel = 2;
            }
        }

        if (hittingBlockRight || hittingBlockLeft || hittingMovingWallLeft || hittingMovingWallRight) {
            if (Math.abs(xvel) > 3.22) {
                GreenfootSound sound = new GreenfootSound("player-hits-wall.wav");
                sound.play();
            }
            xvel = 0;
        }
        if (hittingBlockRight || hittingMovingWallRight) {
            move(1, 0);
        }
        if (hittingBlockLeft || hittingMovingWallLeft) {
            move(-1, 0);
        }
    }

    /* physical update */
    private void accelerate() {
        // apply acceleration to velocity
        if (accelerating) {
            xvel += horizontalAccel * getFacing();
        }

        xvel -= xvel * friction;

        yvel += gravityAccel;

        // ensure max speeds are not surpassed
        if (xvel > xSpeedMax) {
            xvel = xSpeedMax;
        } else if (xvel < -xSpeedMax) {
            xvel = -xSpeedMax;
        }

        if (yvel > terminalVelocity) {
            yvel = terminalVelocity;
        }
    }

    public void physicsUpdate() {
        // keep track of how long the player has been falling
        if (yvel > 0) {
            fallTickCounter += 1;
        } else if (yvel == 0) {
            fallTickCounter = 0;
        }

        // apply acceleration to velocity
        accelerate();

        // check for collisions before they happen
        collision();

        // apply (modified) velocity
        move((int) xvel, (int) yvel);
    }

    /* input */
    public void inputResponse() {
        if (controlsLocked) return;
        // jumping
        if(isJumping){
            setImage("Main.png");
            isJumping=false;
            if(getFacing()==-1)
                flipImage();
        }
        if (Greenfoot.isKeyDown("space")){
            if (canJump) {
                jump();
                canJump = false;
            }
        }

        // horizontal movement
        boolean left = Greenfoot.isKeyDown("left");
        boolean right = Greenfoot.isKeyDown("right");

        // animation stuff
        if (left && !hittingBlockLeft) {
            if(getFacing() == 1) {
                flipImage();
            } 
            isRunning=true;
            setFacing(-1);
            accelerating = true;
        }

        if (right && !hittingBlockRight) {
            isRunning=true;
            if(getFacing() == -1) {
                flipImage();
            }

            setFacing(1);
            accelerating = true;
        }

        if (!left && !right) {
            isRunning=false;
            accelerating = false;
        }

        //shooting
        if (Greenfoot.isKeyDown("t")) {
            if(laserTick==0){
                isShooting=true;
                fire(); // will need to be replaced with the start of the animation
            }
        }

        //stabbing
        if (Greenfoot.isKeyDown("f")) {
            stabAnimation("Stab",".png",6);
            stabAnimationGoing=true;

        }
    }

    private void flipImage(){
        GreenfootImage image=getImage();
        image.mirrorHorizontally();
        setImage(image);
    }
    private int length;
    private GreenfootImage[] animation;

    public void stabAnimation(String f, String ft, int animationLength) {
        animation = new GreenfootImage[animationLength];
        length=animationLength;
        for(int i=0;i<length;i++){
            String file=f+i+ft;
            animation[i]=new GreenfootImage(file);
        }
        
        counter=0;
        // Add your action code here.
    } 

    private int counter=0;
    public void stabAnimate(){
        setImage(animation[counter]);
        if(getFacing()==-1)
            flipImage();
        //will need to make it so it cheacks what direction its looking and changes the image to match
        counter++;
        if (counter == length - 2) {
            GreenfootSound sound = new GreenfootSound("player-stab-2.wav");
            sound.play();
        } else if(counter==length){
            stabAnimationGoing=false;
            stab();
            setImage("Main.png");
            if(getFacing()==-1)
                flipImage();
        }
    }

    private void stab(){
        GreenfootSound guardDying = new GreenfootSound("guard-alert-2.wav");

        for (int i = 0; i < stabRange; i++) {
            Enemy enemy = (Enemy) getOneObjectAtOffset(i*getFacing(),0,Enemy.class);

            if (enemy != null && enemy.beStabbed()) {
                if (getFacing() == enemy.getFacing()) {
                    getWorld().removeObject(enemy);
                    addParticles(i);
                    guardDying.play();
                }
            }
        }

    }

    private void addParticles(int i){
        int x=(getWorldX()+i)*getFacing();
        int numParticles=Greenfoot.getRandomNumber(40)+15;
        for(int j=0;j<numParticles;j++){
            int xVel=(Greenfoot.getRandomNumber(10)+1)*getFacing();
            int yVel=Greenfoot.getRandomNumber(10)-5;
            Particles particle=new Particles(xVel,yVel,Color.red);
            getWorld().addObject(particle,x,getY());
            particle.setWorldLocation(x,getY()+getWidth()/2);
        } 
    }

    private void fire(){
        Laser laser = new Laser(getFacing());
        GreenfootSound sound = new GreenfootSound("laser-fire-2.wav");
        //ShiftWorld sw = (ShiftWorld) getWorld();

        getWorld().addObject(laser, getX() + fireOffset * getFacing() , getY());

        laser.setWorldLocation(getWorldX() + fireOffset * getFacing() , getY());
        laser.setRotation(getRotation());
        laserTick = laserCooldown;
        isShooting=false;

        sound.play();
    }

    private void killZone(){
        if (getY() > ShiftWorld.worldHeight + 50)
        {
            GreenfootSound sound = new GreenfootSound("player-falling.wav");
            sound.play();

            Greenfoot.delay(150);

            ShiftWorld sw = (ShiftWorld) getWorld();
            sw.resetLevel();
        }
    }

    public void act(){
        if(invulntimer==0){
            invulnerable=false;
        } 
        invulntimer=-1;

        if (laserTick > 0){
            laserTick--;
        }
        if(stabAnimationGoing&&animationTick==1){
            stabAnimate();
            animationTick=0;
        }else if(stabAnimationGoing)
            animationTick++;

        physicsUpdate();

        inputResponse();

        // stuff to do
        killZone();
        checkJumpPad();
    } 

    /**
     * Special stuff.
     */
    public void checkJumpPad() {
        GreenfootSound sound = new GreenfootSound("jump-pad-lanch.wav");

        JumpPad jp = (JumpPad) getOneIntersectingObject(JumpPad.class);
        if (jp != null) {
            if (jp.dy > 0) {
                yvel = 0; canJump = false;
                jp.particals();
            }

            impulse(jp.dx, -jp.dy);
            sound.play();
        }
    }

    private void addJumpParticles(){

        
    }
    public void lockControls() { controlsLocked = true; accelerating = false; }
    public void unlockControls() { controlsLocked = false; }
    
}