
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Swordsman extends PatrolingEnemy
{
    /* tweakable */
    private int killDistance = 75;
    private boolean stabbing=false;
    public Swordsman(int dir) {
        super(dir);
        if(dir==1)
            flipImage();
        setCanBeStabbed(true);
    }
     private void flipImage(){
        GreenfootImage image=getImage();
        image.mirrorHorizontally();
        setImage(image);
    }
    private int delay=0;
    public void act() {
        super.act();
        if(!stabbing){
            attemptKill();
        }else{
            if(delay==2){
                animate();
                delay=0;
            }
            else{
                delay++;
            }
        }
    }
    private int counter=0;
    public void animate(){
         setImage(animation[counter]);
        //will need to make it so it cheacks what direction its looking and changes the image to match
        counter++;
        if(counter==length){
            stabbing=false;
            kill();
            setImage("Swordsman.png");
     }
     if(getFacing()==1)
        flipImage();
     }
     private void kill(){
        Player player=rayTrace(killDistance, getFacing());
        if (player!=null) {
            player.hit();
        }
    }
    private void attemptKill() {
        Player player=rayTrace(killDistance, getFacing());
        if (player!=null) {
            //player.hit();
            setAnimation("Slash", ".png", 8);
            stabbing=true;
        }
    }
    
    private int length;
    private  GreenfootImage[] animation;
    
    public void setAnimation(String f,String ft,int animationLength)
    {
        animation = new GreenfootImage[animationLength];
        length=animationLength;
        for(int i=0;i<length;i++){
            String file=f+i+ft;
            animation[i]=new GreenfootImage(file);
            
        }
        counter=0;
        // Add your action code here.
    }    
    
}

