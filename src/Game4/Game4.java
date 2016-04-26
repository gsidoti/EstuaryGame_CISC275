package Game4;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import OverallGame.Controller;
import OverallGame.STATE;
import OverallGame.Window;
import OverallGame.gameObject;

public class Game4 extends MouseAdapter {
	public boolean running = false;
	ArrayList<gameObject> objects = new ArrayList<gameObject>();
	
	public Game4View view;
	boolean mousedown = false;
	public int greenScore = 1500;
	public int redScore = 1500;
	
	public Game4(int w, int h){
		objects.add( new G4Player("Player",(int)((Window.WIDTH/2)*Window.SCALE),(int)((Window.HEIGHT/2)*Window.SCALE),2,5));
		objects.add(new gameObject("greenScore",0,greenScore,0,-1));
		objects.add(new gameObject("redScore",0,redScore,0,-1));
		view = new Game4View();
	}
	
	
	public void mousePressed(MouseEvent e){
		mousedown = true;
	}
	public void mouseReleased(MouseEvent e){
		mousedown = false;
	}


	private void updatePlayer(){
		G4Player p = (G4Player) (objects.get(0));
		if(mousedown){
			if(p.getY()>100.0*Window.SCALE)
				p.moveUp();
		}else{
			if(objects.get(0).getY()<(Window.HEIGHT-100)*Window.SCALE)
				p.moveDown();
		}
	}
	
	private void updateScore(){
		gameObject player = objects.get(0);
		gameObject g = objects.get(1);
		gameObject r = objects.get(2);
		if(player.getY()>Window.HEIGHT/2-100 && player.getY()<Window.HEIGHT/2+100){
			g.setY(greenScore--);
			if(greenScore <= 0){
				Menu.Menu.ESCORE += 100;
				greenScore = 1500;
				redScore = 1500;
				g.setY(greenScore);
				r.setY(redScore);
				running = false;
				Controller.gameState = STATE.Menu;
			}
		}else{
			r.setY(redScore--);
			if(redScore <= 0){
				greenScore = 1500;
				redScore = 1500;
				g.setY(greenScore);
				r.setY(redScore);
				running = false;
				Controller.gameState = STATE.Menu;
			}
		}
	}
	

	public void tick() {
		updatePlayer();
		updateScore();
		System.out.println("Green: "+greenScore+" Red: "+redScore);
	}

	public ArrayList<gameObject> getObjects(){
		return this.objects;
	}
}
