package Game1;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import util.*;
import javax.swing.*;

import OverallGame.gameObject;

/**
 * Player is the object that the user controls. The player can move to anywhere on the screen by clicking there with the mouse
 * and the goal is to collide the player with the moving trash before they reach the beach.
 * 
 * @author Team 7
 * @version 5/17
 */
public class Player extends gameObject
{
    // instance variables - replace the example below with your own
    private boolean ChangeDestination = false;
    private int xd;
    private int yd;
    private double velocity; // pixels per tick
    private double Angle;

    /**
     * 
     * @param name
     * @param x
     * @param y
     * @param velx
     * @param vely
     */
    public Player(String name, int x, int y, int velx, int vely)
    {
        // initialize instance variables
        super(name, x, y, 0, 0);
        velocity=Math.sqrt(velx*velx+vely*vely);
        Angle=0.0;
    }

    /**
     * 
     * @param xn
     * @param yn
     */
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
        Angle=Math.atan2(getVely(),getVelx());
    }

    /**
     * 
     */
    public void Move()
    {
    	double dnow;

        if((Math.abs(getVelx())==0.0)&&(Math.abs(getVely())==0.0))return;
        dnow=Math.abs(x-xd)+Math.abs(y-yd);
        if((Math.abs(x+getVelx()-xd)+Math.abs(y+getVely()-yd))>dnow)
        {
            setVelx(0);
            setVely(0);
        }
        else
        {
            x+=getVelx();
            y+=getVely();
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

    /**
     * 
     * @return
     */
    public boolean getChangeDestination() {
    	return ChangeDestination;
    }

    /**
     * 
     * @param value
     */
    public void setChangeDestination(boolean value) {
    	ChangeDestination = value;
    }

    /**
     * 
     * @return
     */
    public int getxd() {
    	return xd;
    }

    /**
     * 
     * @param value
     */
    public void setxd(int value) {
    	xd = value;
    }

    /**
     * 
     * @return
     */
    public int getyd() {
    	return yd;
    }

    /**
     * 
     * @param value
     */
    public void setyd(int value) {
    	yd = value;
    }
    
    /**
     * 
     * @return
     */
    public double getAngle(){return Angle;}

    /**
     * 
     * @return
     */
	public double getVelocity() {
		return velocity;
	}

	/**
	 * 
	 * @param velocity
	 */
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
    
    
}
