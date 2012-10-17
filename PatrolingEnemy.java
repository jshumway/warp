import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PatrolingEnemy extends Enemy
{
    private int count=6;

    public PatrolingEnemy(int dir, int sight) {
        super(dir, sight);
    }

    public PatrolingEnemy(int dir) {
        super(dir);
    }

    public void act() 
    {
        moveToPoint();
        super.act();

    }

    protected void moveToPoint() {
        move((2*getFacing()),0);

        Actor wayPoint=getOneIntersectingObject(WayPoint.class);

        if (wayPoint != null && count > 5) {
            setFacing(getFacing()*-1);
            count=0;
        }

        count++;
    }    
}
