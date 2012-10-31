import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class Timer extends Actor
{
    private GreenfootImage board;
    private GreenfootImage sb;
    private int score = 0;
    private String label = "Score: ";
    private int scoreCounter;
    private int scoreCooldown = 30;

    /**
     * Act - do whatever the Scoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (scoreCounter > 0){
            scoreCounter--;
        }
        
        if (scoreCounter == 0){
            addScore(1);
            scoreCounter = scoreCooldown;
        }
    }  

    public Timer()
    {
        super();

        int boardWidth = 150;
        int boardHeight = 30;
        int boardTransparency = 125;

        board = new GreenfootImage(boardWidth, boardHeight);
        board.setColor(Color.green);
        board.setTransparency(boardTransparency);
        board.fillRect(0, 0, boardWidth, boardHeight);
        this.setImage(board);

        update();
    }

    public int getScore()
    {
        return score;
    }

    public void addScore(int pts)
    {
        score += pts;
        update();
    }

    private void update()
    {
        sb = new GreenfootImage(board);
        sb.drawImage(new GreenfootImage(label + score, 18, Color.WHITE, new Color(0,0,0,0)),25,5);
        this.setImage(sb);
    }


}
