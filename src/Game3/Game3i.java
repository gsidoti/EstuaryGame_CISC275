package Game3;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import OverallGame.Controller;
import OverallGame.STATE;
import OverallGame.Window;
import OverallGame.gameObject;

public class Game3i extends MouseAdapter {
	public Game3iView game3iView;
	public boolean running = false;
	boolean mlActive;
	ArrayList<gameObject> objects = new ArrayList<gameObject>();
	
	public Game3i(){
		game3iView = new Game3iView();
	}
	
	public void stopMouseListener(){
		mlActive = false;
	}
	

	public void mousePressed(MouseEvent e){
		Controller.gameState = STATE.Game3;
	}

	public void tick() {
		
	}

}