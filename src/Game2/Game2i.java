package Game2;

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
 * Game2i is the instruction screen for Game2. It just presents the game instructions to the player,
 * and waits for a mouse click to clear the instructions and start the game
 * 
 * @author Team 7
 * @version 5/17
 */

public class Game2i extends MouseAdapter {
	
	/*
	 * Instance Variables - running is used to check whether the instruction screen is currently running or not
	 * 					  - mlActive is used to check whether there are active mouse listeners for the instruction screen
	 */
	public Game2iView game2iView;
	public boolean running = false;
	boolean mlActive;
	ArrayList<gameObject> objects = new ArrayList<gameObject>();
	
	/**
	 * 
	 */
	public Game2i(){
		game2iView = new Game2iView();
	}
	
	/**
	 * 
	 */
	public void stopMouseListener(){
		mlActive = false;
	}
	
	/**
	 * 
	 */
	public void mousePressed(MouseEvent e){
		Controller.gameState = STATE.Game2;
	}
	
	/**
	 * 
	 */
	public void tick() {
		
	}

}