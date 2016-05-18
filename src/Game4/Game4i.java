package Game4;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import OverallGame.Controller;
import OverallGame.STATE;
import OverallGame.Window;
import OverallGame.gameObject;

/**
 * Game4i is the instruction screen for Game4. It displays the game background with overlaid text providing instructions for
 * the game. Once the mouse is clicked, the instructions disappear and the game starts.
 * 
 * @author Team 7
 * @version 5/17
 */

public class Game4i extends MouseAdapter {
	public Game4iView game4iView;
	public boolean running = false;
	boolean mlActive;
	ArrayList<gameObject> objects = new ArrayList<gameObject>();
	
	/**
	 * Constructor for Game4i objects
	 */
	public Game4i(){
		game4iView = new Game4iView();
	}
	
	/**
	 * Stops the mouse listener for the instruction screen
	 */
	public void stopMouseListener(){
		mlActive = false;
	}
	
	/**
	 * When mouse button is clicked, changes gameState to Game2, and sets running to false
	 */

	public void mousePressed(MouseEvent e){
		Controller.gameState = STATE.Game4;
		running=false;
	}

	/**
	 * method that is called every tick
	 */
	public void tick() {
		
	}

}