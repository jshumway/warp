import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends ShiftActor
{
    /* tweakable */
    private int speed = 17;

    /* internal */
    private int direction;

    public Laser(int dir){
        if (dir == 0){
            dir = 1;
        }
        direction=dir;
    }
    public void act() 
    {
        move(speed * direction,0);
        addParticles();
        collision();
        
        // bounds checking
        if (getWorldX() >= ShiftWorld.worldWidth) {
            getWorld().removeObject(this);
        } else if (getWorldX() <= 0) {
            getWorld().removeObject(this);
        }
    } 
    private void addParticles(){
        int y=getY()+getHeight();
        int x=getX();
        if(direction==-1){
            x=x+getWidth();
        }
        Particles particle=new Particles(0,0,Color.yellow);
        getWorld().addObject(particle,x,y);
        particle.setWorldLocation(x,y);
    }
    private void collision() {
        Actor hit=getOneIntersectingObject(Block.class);

        if (hit != null) {
            getWorld().removeObject(this);
            return;
        }

        Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);

        if (enemy != null && enemy.beShot()) {
            getWorld().removeObject(enemy);
            getWorld().removeObject(this);
            return;
        } else if (enemy != null) {
            getWorld().removeObject(this);
        }
    }
}
