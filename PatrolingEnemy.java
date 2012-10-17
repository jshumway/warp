import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PatrolingEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PatrolingEnemy extends Enemy
{
    /**
     * Act - do whatever the PatrolingEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PatrolingEnemy(int dir,int sight){
        super(dir, sight);
    }
   public PatrolingEnemy(int dir){
        super(dir);
    }
    public void act() 
    {
        moveToPoint();
        super.act();
        // Add your action code here.
    }
    private int count=6;
    protected void moveToPoint(){
        move((2*getFacing()),0);
        Actor wayPoint=getOneIntersectingObject(WayPoint.class);
        if(wayPoint!=null&&count>5){
            setFacing(getFacing()*-1);
            count=0;
        }
        count++;
    }    
}
