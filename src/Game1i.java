package Game1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import OverallGame.Controller;
import OverallGame.STATE;
import OverallGame.Window;
import OverallGame.gameObject;

public class Game1i extends MouseAdapter {
	public Game1iView game1iView;
	public boolean running = false;
	boolean mlActive;
	ArrayList<gameObject> objects = new ArrayList<gameObject>();
	
	public Game1i(){
		game1iView = new Game1iView();
	}
	
	public void stopMouseListener(){
		mlActive = false;
	}
	

	public void mousePressed(MouseEvent e){
		Controller.gameState = STATE.Game1;
		running=false;
	}

	public void tick() {
		
	}

}