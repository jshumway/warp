import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class stationaryArcher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StationaryArcher extends StationaryEnemy
{
    /* tweakable */
    private int fireCooldown = 60;

    /* internal */
    private int fireTick;
    private GreenfootSound sound_fire_arrow;
    private boolean shooting=false;
    private int shootingdelay=0;
    public StationaryArcher(int dir){
        super(dir, 500);
        fireTick = 0;
        setShot(true);
        if(dir==1)
            flipImage();

        sound_fire_arrow = new GreenfootSound("sounds/arrow-fired.wav");
    }
     private void flipImage(){
        GreenfootImage image=getImage();
        image.mirrorHorizontally();
        setImage(image);
    }
    public void act(){
        if (fireTick > 0)
            fireTick--;
        if(shooting){
            if(shootingdelay==3){
                setImage("Archer.png");
                if(getFacing()==1){
                    flipImage();
                }
                shootingdelay=0;
                shooting=false;
                fireArrow();
                
            }else{
                shootingdelay++;
            }
        }
        if(look())
            spoted();
    }
    protected void spoted() {
        if (fireTick == 0) {
           setImage("Archer Shooting.png");
           if(getFacing()==1){
                flipImage();
           }
           shooting=true;
        }
    }

    private void fireArrow(){
        Arrow arrow = new Arrow(getFacing());
        ShiftWorld sw = (ShiftWorld) getWorld();
         fireTick = fireCooldown;
        sw.addObject(arrow, getX(), getY());
        arrow.setWorldLocation(sw.getWorldX(getX()), getY());

        sound_fire_arrow.play();
    }   
}
