package OverallGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game4 extends MouseAdapter {
	boolean running = false;
	G4Player player;
	Game4View view;
	boolean mousedown = false;
	public Game4(int w, int h){
		player = new G4Player((int)((Window.WIDTH/2)*Window.scaleW),(int)((Window.HEIGHT/2)*Window.scaleH),2,5);
		view = new Game4View(player);
	}
	
	public void mousePressed(MouseEvent e){
		mousedown = true;
	}
	public void mouseReleased(MouseEvent e){
		mousedown = false;
	}


	private void updatePlayer(){
		if(mousedown)
			player.setY(player.getY() - player.getVyUp());
		else
			player.setY(player.getY() + player.getVyDown());
	}
	

	public void tick() {
		updatePlayer();
		view.update(player);
	}

}
