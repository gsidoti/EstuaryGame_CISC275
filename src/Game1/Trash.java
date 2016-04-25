package Game1;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import util.*;
import javax.swing.*;

import OverallGame.gameObject;

/**
 * Write a description of class Trash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trash extends gameObject
{
    // instance variables - replace the example below with your own
 // pixels per tick
    
    /**
     * Constructor for objects of class Player
     */
    public Trash(String name,int x, int y, int velx, int vely)
    {
    	super(name,x,y,velx,vely);
        // initialise instance variables
        this.x = 0;
        this.y = (int)Math.round(Math.floor(y*Math.random()));
        this.velx=1+(int)Math.round(Math.floor(velx*Math.random()));
    }

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
    
    public boolean IsCaught(int px,int py)
    {
        if((Math.abs(px-x)+Math.abs(py-y))<10)return true;
        return false;
    }
    
    public void Move()
    {
        x+=velx;
        return;
    }
    
    public void Draw(Graphics g)
    {
        Color temp=g.getColor();
        int tx;
        int ty;
        
        tx=x;
        ty=y;
        g.setColor(Color.RED);
        g.drawLine(tx-3,ty-3,tx+4,ty+4);
        g.drawLine(tx+4,ty-3,tx-3,ty+4);
        g.setColor(temp);
        return;
    }
}
