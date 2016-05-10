package Game2;

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
public class Boat extends gameObject
{
    // instance variables - replace the example below with your own
    private boolean isInfested;
    private boolean isActive = true;
    
    /**
     * Constructor for objects of class Player
     */
    public Boat(String name, int x, int y, int velx, int vely, boolean infested) {
		super(name, x, y, velx, vely);
		this.isInfested = infested;
	}

    public boolean MadeIt(int to)
    {
        if(x<=to)
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
        if((Math.abs(px-getX())+Math.abs(py-getY()))<10)return true;
        return false;
    }
    
    public boolean getInfested() {
    	return isInfested;
    }
    
    public void setInfested(boolean value) {
    	isInfested = value;
    }
    
    public boolean getActive() {
    	return isActive;
    }
    
    public void setActive(boolean value) {
    	isActive = value;
    }
    
    void Move(){
		this.setX(this.getX()-this.getVelx());
	//	System.out.println("left "+ x + " " + velx);
	}
    
    public String toString() {
    	return "Name: " + name + " X " + x + " Y " + y + " velX " + velx + " velY " + vely + " Active " + isActive + " Infested " + isInfested;
    }
}

