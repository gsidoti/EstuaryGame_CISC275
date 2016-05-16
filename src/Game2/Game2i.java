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

public class Game2i extends MouseAdapter {
	public Game2iView game2iView;
	public boolean running = false;
	boolean mlActive;
	ArrayList<gameObject> objects = new ArrayList<gameObject>();
	
	public Game2i(){
		game2iView = new Game2iView();
	}
	
	public void stopMouseListener(){
		mlActive = false;
	}
	

	public void mousePressed(MouseEvent e){
		Controller.gameState = STATE.Game2;
	}

	public void tick() {
		
	}

}