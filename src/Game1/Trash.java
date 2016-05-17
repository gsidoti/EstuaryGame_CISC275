package Game1;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import util.*;
import javax.swing.*;

import OverallGame.gameObject;

/**
 * Trash is the object that the player is trying to pick up before it gets to the right side of the screen.
 * Trash is collected by the player boat colliding with it.
 * Each piece of trash causes the player to lose a life.
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
     * 
     * @param name
     * @param x
     * @param y
     * @param velx
     * @param vely
     */
    public Trash(String name,int x, int y, int velx, int vely)
    {
    	super(name,0,y,velx,0);
        // initialize instance variables
    }

    /**
     * 
     * @param to
     * @return
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
     * 
     * @param px
     * @param py
     * @return
     */
    public boolean IsCaught(int px,int py)
    {
        if((Math.abs(px-x)+Math.abs(py-y))<20)return true;
        return false;
    }

    /**
     * 
     */
    public void Move()
    {
        x+=velx;
        return;
    }

    /**
     * 
     * @return
     */
    public boolean getActive() {
    	return isActive;
    }

    /**
     * 
     * @param value
     */
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
