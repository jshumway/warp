import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
public class JumpPad extends ShiftActor
{
    public int dx, dy;

    public JumpPad(int impulseX, int impulseY) {
        dx = impulseX;
        dy = impulseY;
    }
    public void particals(){
        int numParticles=Greenfoot.getRandomNumber(40)+15;
        int y=getY()+getHeight();
        for(int i=1;i<4;i++){
            for(int j=0;j<getWidth();j+=4){
                int xMod;
                int yMod=0;
                if(j>getWidth()/2){
                    xMod=getWidth()-j;
                }else if(j==getWidth()/2){
                    xMod=0; 
                }else
                    xMod=-j;
                if(Math.abs(getWidth()/2-j)<15){
                    yMod=-Math.abs(getWidth()/2-j);
                }
                int xVel=(int)((double)1/(double)xMod*10.0);
                int yVel=(-30+Math.abs(xVel)+yMod)/i;
                int grayScale=255-(Math.abs(xVel));
                if(grayScale<0)
                    grayScale=0;
                Color color=new Color(Greenfoot.getRandomNumber(255),Greenfoot.getRandomNumber(255),Greenfoot.getRandomNumber(255));
                Particles particle=new Particles(xVel,yVel,color,false);
                getWorld().addObject(particle,getWorldX()+j,y);
                particle.setWorldLocation(getWorldX()+j,y);
            }
        }
    }
}
