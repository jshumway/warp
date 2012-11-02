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
        // this is ugly, but it makes the swordsman move
        // by 1 pixle, then 2 pixels, then 1 again, etc
        move(1 * (count % 2 + 1) * getFacing(),0);

        Actor wayPoint=getOneIntersectingObject(WayPoint.class);

        if (wayPoint != null && count > 5) {
            setFacing(getFacing()*-1);
            count=0;
            flipImage();
        }

        count++;
    } 
     private void flipImage(){
        GreenfootImage image=getImage();
        image.mirrorHorizontally();
        setImage(image);
    }
}
