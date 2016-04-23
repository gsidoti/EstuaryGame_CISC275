package Game4;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import OverallGame.Window;
import OverallGame.gameObject;

public class Game4 extends MouseAdapter {
	public boolean running = false;
	ArrayList<gameObject> objects = new ArrayList<gameObject>();
	
	//G4Player player;
	public Game4View view;
	boolean mousedown = false;
	public int greenScore;
	public int redScore;
	public Game4(int w, int h){
		objects.add( new G4Player("Player",(int)((Window.WIDTH/2)*Window.SCALE),(int)((Window.HEIGHT/2)*Window.SCALE),2,5));
		//objects.add(new gameObject("greenScore",(int)((Window.WIDTH-150)*Window.SCALE),(int)(50*Window.SCALE),0,0));
		//objects.add(new gameObject("redScore",(int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),0,0));
		view = new Game4View();
	}
	
	public void mousePressed(MouseEvent e){
		mousedown = true;
	}
	public void mouseReleased(MouseEvent e){
		mousedown = false;
	}


	private void updatePlayer(){
		G4Player p = (G4Player) objects.get(0);
		if(mousedown){
			if(p.getY()>100.0*Window.SCALE)
				p.moveUp();
		}else{
			if(objects.get(0).getY()<(Window.HEIGHT-100)*Window.SCALE)
				p.moveDown();
		}
	}
	
	private void updateScore(){
		G4Player player = (G4Player) objects.get(0);
		if(player.getY()>Window.HEIGHT/2-100 && player.getY()<Window.HEIGHT/2+100){
			greenScore++;
		}else{
			redScore++;
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
