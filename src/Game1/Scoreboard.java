package Game1;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import util.*;
import javax.swing.*;

import OverallGame.gameObject;

/**
 * Scoreboard is the object that holds everything pertaining to the score of Game1, including Lives, Score, and HiScore
 * 
 * @author Team 7
 * @version 5/17
 */

public class Scoreboard extends gameObject{
	private int Lives;
	private int Score;
	private int HiScore;

	/**
	 * 
	 * @param name
	 * @param x
	 * @param y
	 * @param velx
	 * @param vely
	 */
	public Scoreboard(String name,int x, int y, int velx, int vely)
	{
		super(name,x,y,0,0);
		Score=0;
		HiScore=0;
		Lives=10;
		// initialize instance variables
	}
	
	/**
	 * 
	 * @return
	 */
	public int getScore(){return Score;}
	
	/**
	 * 
	 * @return
	 */
	public int getLives(){return Lives;}
	
	/**
	 * 
	 * @return
	 */
	public int getHi(){return HiScore;}
	
	/**
	 * 
	 * @param s
	 */
	public void setScore(int s){Score=s;}
	
	/**
	 * 
	 * @param l
	 */
	public void setLives(int l){Lives=l;}
	
	/**
	 * 
	 * @param l
	 */
	public void setHi(int l){HiScore=l;}

}
