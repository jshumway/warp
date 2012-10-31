import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Animation_Meathod here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Animation_Meathod
{
    /**
     * Act - do whatever the Animation_Meathod wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //not really a class
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
    private int counter=0;
    //animate goes in act it should go every tick or what ever timer we put animations on
    /*public void animate(){
        setImage(animation[counter]);
        //will need to make it so it cheacks what direction its looking and changes the image to match
        counter++;
        if(counter==length){
            counter=0;
        }
    }*/
}

