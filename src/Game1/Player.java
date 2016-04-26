package Game1;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import util.*;
import javax.swing.*;

import OverallGame.gameObject;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends gameObject
{
    // instance variables - replace the example below with your own
    private boolean ChangeDestination = false;
    private int xd;
    private int yd;
    private double velocity; // pixels per tick
    
    /**
     * Constructor for objects of class Player
     */
    public Player(String name, int x, int y, int velx, int vely)
    {
        // initialize instance variables
        super(name, x, y, velx, vely);        
    }

    public void SetDest(int xn,int yn)
    {
        double StepsNeeded;
        xd=xn;
        yd=yn;
        setVelx(xd-x);
        setVely(yd-y);
        StepsNeeded=Math.sqrt((getVelx()*getVelx()+getVely()*getVely()))/velocity;
        if(StepsNeeded<0.5)
        {
            setVelx(0);
            setVely(0);
            return;
        }
        setVelx((int)(getVelx()/StepsNeeded));
        setVely((int)(getVely()/StepsNeeded));
    }
    
    public void Move()
    {
        if((Math.abs(getVelx())==0.0)&&(Math.abs(getVely())==0.0))return;
        x+=getVelx();
        y+=getVely();
        if((Math.abs(x-xd)+Math.abs(y-yd))<3.0)
        {
            setVelx(0);
            setVely(0);
        }
        return;
    }
    
//    public void Draw(Graphics g)
//    {
//        Color temp=g.getColor();
//        int tx;
//        int ty;
//        
//        tx=(int)x;
//        ty=(int)y;
//        g.setColor(Color.YELLOW);
//        g.drawLine(tx-5,ty-5,tx+5,ty+5);
//        g.drawLine(tx+5,ty-5,tx-5,ty+5);
//        g.setColor(temp);
//        return;
//    }
    
    public boolean getChangeDestination() {
    	return ChangeDestination;
    }
    
    public void setChangeDestination(boolean value) {
    	ChangeDestination = value;
    }
    
    public int getxd() {
    	return xd;
    }
    
    public void setxd(int value) {
    	xd = value;
    }
    
    public int getyd() {
    	return yd;
    }
    
    public void setyd(int value) {
    	yd = value;
    }
}