package game1;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import util.*;
import javax.swing.*;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private double x;
    private double y;
    private boolean ChangeDestination;
    private double xd;
    private double yd;
    private double vx;
    private double vy;
    private double velocity; // pixels per tick
    
    /**
     * Constructor for objects of class Player
     */
    public Player(int x0,int y0, double vel)
    {
        // initialise instance variables
        x = x0;
        y = y0;
        velocity=vel;
        ChangeDestination=false;
        xd=0.0;
        yd=0.0;
        vx=0.0;
        vy=0.0;
    }

    public void SetDest(int xn,int yn)
    {
        double StepsNeeded;
        xd=xn;
        yd=yn;
        vx=xd-x;
        vy=yd-y;
        StepsNeeded=Math.sqrt((vx*vx+vy*vy))/velocity;
        if(StepsNeeded<0.5)
        {
            vx=0.0;
            vy=0.0;
            return;
        }
        vx/=StepsNeeded;
        vy/=StepsNeeded;
    }
    
    public void Move()
    {
        if((Math.abs(vx)==0.0)&&(Math.abs(vy)==0.0))return;
        x+=vx;
        y+=vy;
        if((Math.abs(x-xd)+Math.abs(y-yd))<3.0)
        {
            vx=0.0;
            vy=0.0;
        }
        return;
    }
    
    public void Draw(Graphics g)
    {
        Color temp=g.getColor();
        int tx;
        int ty;
        
        tx=(int)x;
        ty=(int)y;
        g.setColor(Color.YELLOW);
        g.drawLine(tx-5,ty-5,tx+5,ty+5);
        g.drawLine(tx+5,ty-5,tx-5,ty+5);
        g.setColor(temp);
        return;
    }
    
    public int getx(){return (int)x;}
    public int gety(){return (int)y;}
    
}
