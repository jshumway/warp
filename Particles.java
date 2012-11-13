import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
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
    private boolean gravity=true;
    public Particles(int xVel,int yVel,Color c){
        color=c;
        xVelocity=xVel;
        yVelocity=yVel;
        image=new GreenfootImage(3,3);
        image.setColor(color);
        image.fillRect(0,0,3,3);
        setImage(image);
        
    }
    public Particles(int xVel,int yVel, Color c, boolean g){
        color=c;
        xVelocity=xVel;
        yVelocity=yVel;
        image=new GreenfootImage(3,3);
        image.setColor(color);
        image.fillRect(0,0,3,3);
        setImage(image);
        gravity =g;
    }
    /**
     * Act - do whatever the Particles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(xVelocity,yVelocity);
        if(gravity)
            yVelocity=yVelocity+1;
        transparentcy-=5;
        image.setTransparency(transparentcy);
        if(transparentcy==0){
            getWorld().removeObject(this);
        } 
        
        // Add your action code here.
    }    
}
