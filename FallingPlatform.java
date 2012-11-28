import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FallingPlatform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FallingPlatform extends Platform
{
    private int yVel=0;
    private boolean isFalling=false;
    private int delay=0;
    /**
     * Act - do whatever the FallingPlatform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        if(isFalling){
            for(int i=-((getWidth()-60)/2);i<getWidth()-60;i++){
                Actor block=getOneObjectAtOffset(i,getHeight()/2,Block.class);
                if(block!=null){
                    isFalling=false;
                    return;
                }
            }
            if(yVel!=10&&delay==0){
                yVel++;
            } else {
                delay--;
            }

            move(0,yVel);
        } else {
            for(int i=-(getWidth()/2);i<getWidth();i++){
                Actor player=getOneObjectAtOffset(i,-getHeight()/2,Player.class);
                if(player!=null){
                    GreenfootSound sound = new GreenfootSound("platform-falling.wav");
                    isFalling=true;
                    delay=10;
                    sound.play();
                }
            }
        }
    }
}
