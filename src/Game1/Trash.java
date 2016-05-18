package Game1;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import util.*;
import javax.swing.*;

import OverallGame.gameObject;

/**
 * Trash are the objects that move from left to right on the screen, that the player needs to collect before they
 * reach the right side.
 * 
 * @author Team 7
 * @version 5/17
 */

public class Trash extends gameObject
{
	boolean isActive = false;
    // instance variables - replace the example below with your own
 // pixels per tick

	/**
     * Constructor for Trash objects
     * 
     * @param name name of the object
	 * @param x x-position of the object
	 * @param y y-position of the object
	 * @param velx x velocity of the object
	 * @param vely y velocity of the object
	 */
    public Trash(String name,int x, int y, int velx, int vely)
    {
    	super(name,0,y,velx,0);
        // initialize instance variables
    }

    /**
     * Checks to see if a Trash object has made it to a given x-position
     * 
     * @param to the x-position being checked for whether the trash made it
     * @return Returns true if the trash made it, false otherwise
     */
    public boolean MadeIt(int to)
    {
        if(x>=to)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Checks to see if a Trash object has been caught by the player
     * 
     * @param px Player's x-position
     * @param py Player's y-position
     * @return Returns true if the trash is caught, false otherwise
     */
    public boolean IsCaught(int px,int py)
    {
        if((Math.abs(px-x)+Math.abs(py-y))<20)return true;
        return false;
    }

    /**
     * Moves the trash object from the left side to the right side of the screen
     */
    public void Move()
    {
        x+=velx;
        return;
    }

    public boolean getActive() {
    	return isActive;
    }

    public void setActive(boolean value) {
    	isActive = value;
    }
//
//    public void Draw(Graphics g)
//    {
//        Color temp=g.getColor();
//        int tx;
//        int ty;
//
//        tx=x;
//        ty=y;
//        g.setColor(Color.RED);
//        g.drawLine(tx-3,ty-3,tx+4,ty+4);
//        g.drawLine(tx+4,ty-3,tx-3,ty+4);
//        g.setColor(temp);
//        return;
//    }
}
