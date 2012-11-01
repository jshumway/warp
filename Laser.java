import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends ShiftActor
{
    /* tweakable */
    private int speed = 30;

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
        collision();
        
        // bounds checking
        if (getWorldX() >= ShiftWorld.worldWidth) {
            getWorld().removeObject(this);
        } else if (getWorldX() <= 0) {
            getWorld().removeObject(this);
        }
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
