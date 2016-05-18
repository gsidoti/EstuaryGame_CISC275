package Game1;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import util.*;
import javax.swing.*;

import OverallGame.gameObject;


public class Scoreboard extends gameObject{
	private int Lives;
	private int Score;
	private int HiScore;

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
