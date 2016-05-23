package Game1;

import OverallGame.gameObject;

/**
 * Scoreboard is the object that holds the score, lives, and hiscore of the game
 * 
 * @author Team 7
 * @version 5/17
 */

public class Scoreboard extends gameObject{
	private int Lives;
	private int Score;
	private int HiScore;

	/**
     * Constructor for Scoreboard objects
     * 
     * @param name name of the object
	 * @param x x-position of the object
	 * @param y y-position of the object
	 * @param velx x velocity of the object
	 * @param vely y velocity of the object
	 */
	public Scoreboard(String name,int x, int y, int velx, int vely)
	{
		super(name,x,y,0,0);
		Score=0;
		HiScore=0;
		Lives=10;
		// initialize instance variables
	}
	
	public int getScore(){return Score;}
	public int getLives(){return Lives;}
	public int getHi(){return HiScore;}
	public void setScore(int s){Score=s;}
	public void setLives(int l){Lives=l;}
	public void setHi(int l){HiScore=l;}

}
