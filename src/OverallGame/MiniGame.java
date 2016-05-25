package OverallGame;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;

/**
 * MiniGame is an abstract class used as a mold for all of the games
 * 
 * @author Team 7
 * @version 5/17
 */

public abstract class MiniGame extends MouseAdapter{
	protected ArrayList<gameObject> objects = new ArrayList<gameObject>();
	protected boolean running = false;
	
	
	public abstract void tick();
	
    /**
     * Takes the width of an image and scales it to the appropriate size for the current screen
     * 
     * @param x Width of image that needs to be scaled
     * @return Returns scaled width for image
     */
	protected int scaleW(double x){
		return (int)(Window.SCALE*x);
	}
	
	/**
	 * Takes the height of an image and scales it to the appropriate size for the current screen
	 * 
	 * @param x Height of image that needs to be scaled
	 * @return Returns scaled height for image
	 */
	protected int scaleH(double x){
		return (int)(Window.SCALE*x);
	}
	
    /**
     * Checks to see if the mouse is over given coordinates on the screen.
     * 
     * @param mx Mouse x-position
     * @param my Mouse y-position
     * @param x x-position of image being checked against mouse x-position
     * @param y y-position of image being checked against mouse y-position
     * @param width Width of image being checked for mouse over
     * @param height Height of image being checked for mouse over 
     * @return Returns true if mouse is over given image position, false if otherwise
     */
    protected boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }
    
	/**
	 * Returns ArrayList of gameObjects
	 * 
	 * @return Returns ArrayList of gameObjects
	 */
	public ArrayList<gameObject> getObjects(){
		return this.objects;
	}
	
	/**
	 * Sets the ArrayList of gameObjects
	 * 
	 * @return Returns ArrayList of gameObjects
	 */
	public void setObjects(ArrayList<gameObject> g){
		this.objects = g;
	}
	
	/**
	 * Checks to see whether the game is running or not
	 * 
	 * @return Returns boolean value of running
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * Sets running variable to given value
	 * 
	 * @param running New value for running
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

}
