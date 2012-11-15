import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends ShiftActor
{
    /* tweakable */
    private int speed = 7;

    /* internal */
    private int direction;
    
    public Arrow(int dir) {
        direction = dir;
        if (dir == 1) {
            GreenfootImage image = getImage();
            image.mirrorHorizontally();
            setImage(image);
        }
    }
    
    public void act() {
        move(direction*speed, 0);
        
        collision();
    }    

    private void collision(){
        Actor hit = getOneIntersectingObject(Block.class);

        if (hit != null) {
            getWorld().removeObject(this); return;
        }

        hit = getOneIntersectingObject(Player.class);

        // this && false is so that arrows don't kill the player. For
        // testing purposes only -- removed
        if (hit != null) {
            Player player=(Player)hit;
            player.hit();
        }
    }
}
