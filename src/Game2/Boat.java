package Game2;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import util.*;
import javax.swing.*;
import OverallGame.gameObject;

/**
 * Boats are either clean or dirty
 * If a clean boat makes it to the end of the screen, you earn points
 * If a dirty boat makes it to the end of the screen, you lose a life
 * 
 * @author Team 7 
 * @version 5/17
 */

public class Boat extends gameObject
{
    /* 
     * Instance variables - isInfested holds whether the boat object is clean or dirty
     * 					  - isActive holds whether the boat object is active in the game
     */
    private boolean isInfested;
    private boolean isActive = true;
    
    /**
     * 
     * @param name
     * @param x
     * @param y
     * @param velx
     * @param vely
     * @param infested
     */
    public Boat(String name, int x, int y, int velx, int vely, boolean infested) {
		super(name, x, y, velx, vely);
		this.isInfested = infested;
	}

    /**
     * 
     * @param to
     * @return
     */
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
    
    /**
     * 
     * @param px
     * @param py
     * @return
     */
    public boolean IsClicked(int px,int py)
    {
        if((Math.abs(px-getX())+Math.abs(py-getY()))<10)return true;
        return false;
    }
    
    /**
     * 
     * @return
     */
    public boolean getInfested() {
    	return isInfested;
    }
    
    /**
     * 
     * @param value
     */
    public void setInfested(boolean value) {
    	isInfested = value;
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
    
    /**
     * 
     */
    void Move(){
		this.setX(this.getX()-this.getVelx());
	//	System.out.println("left "+ x + " " + velx);
	}
    
    /**
     * 
     */
    public String toString() {
    	return "Name: " + name + " X " + x + " Y " + y + " velX " + velx + " velY " + vely + " Active " + isActive + " Infested " + isInfested;
    }
}

