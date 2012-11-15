import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Particles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Particles extends ShiftActor
{
    private Color color;
    private int xVelocity;
    private int yVelocity;
    private int transparentcy=255;
    private GreenfootImage image;
    public Particles(int xVel,int yVel){
        color=Color.red;
        xVelocity=xVel;
        yVelocity=yVel;
        image=new GreenfootImage(3,3);
        image.setColor(color);
        image.fillRect(0,0,3,3);
        setImage(image);
        
    }
    /**
     * Act - do whatever the Particles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(xVelocity,yVelocity);
        yVelocity=yVelocity+1;
        transparentcy-=5;
        image.setTransparency(transparentcy);
        if(transparentcy==0){
            getWorld().removeObject(this);
        } 
        
        // Add your action code here.
    }    
}