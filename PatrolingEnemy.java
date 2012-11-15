import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PatrolingEnemy extends Enemy
{
    private int count=6;
    private boolean turning=false;
    private int turnTime=0;

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
        if(!turning){
            move(1 * (count % 2 + 1) * getFacing(),0);

            Actor wayPoint=getOneIntersectingObject(WayPoint.class);

            if (wayPoint != null && count > 5) {
                
                count=0;
                
                turning=true;
            }

            count++;
        }else{
            if(turnTime==10){
                turning=false;
                flipImage();
                setFacing(getFacing()*-1);
                turnTime=0;
            }else
                turnTime++;
           
            
        }
    } 
     private void flipImage(){
        GreenfootImage image=getImage();
        image.mirrorHorizontally();
        setImage(image);
    }
}
