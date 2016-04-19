package OverallGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game4 extends MouseAdapter {
	G4Player player;
	STATE gameState = STATE.Game4;
	Game4View view;
	boolean mousedown = false;
	
	public Game4(int w, int h){
		player = new G4Player(w/2,h/2,0,0);
		view = new Game4View(w,h);
	}
	
	public void mousePressed(MouseEvent e){
		mousedown = true;
	}
	public void mouseReleased(MouseEvent e){
		mousedown = false;
	}


	private void updatePlayer(){
		if(mousedown)
			player.moveUp();
		else
			player.moveDown();
			
	}
	
	public void updateView(){
		view.py = player.gety();
		view.px = player.getx();
	}
	
	public STATE tick() {
		updatePlayer();
		updateView();
		return gameState;
	}

}
