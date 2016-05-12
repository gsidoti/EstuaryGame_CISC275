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
	
	public Game4(){
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


	void updatePlayer(){
		G4Player p = (G4Player) (objects.get(0));
		if(mousedown){
			if(scaleH(p.getY())>scaleH(150.0))
				p.moveUp();
		}else{
			if(scaleH(objects.get(0).getY())<scaleH(Window.HEIGHT-100))
				p.moveDown();
		}
	}
	void resetGame(gameObject player, gameObject g, gameObject r){
		greenScore = 1500;
		redScore = 1500;
		g.setY(greenScore);
		r.setY(redScore);
		player.setY(Window.HEIGHT/2);
		running = false;
		Controller.gameState = STATE.Menu;
	}
	
	void updateScore(){
		gameObject player = objects.get(0);
		gameObject g = objects.get(1);
		gameObject r = objects.get(2);
		if(scaleH(player.getY()+15)>scaleH(Window.HEIGHT/2-50) && scaleH(player.getY()+50-15)<scaleH(Window.HEIGHT/2+50)){
			g.setY(greenScore--);
			if(greenScore <= 0){
				Menu.Menu.ESCORE += 100;
				resetGame(player,g,r);
			}
		}else{
			r.setY(redScore--);
			if(redScore <= 0){
				resetGame(player,g,r);
			}
		}
	}
	

	public void tick() {
		updatePlayer();
		updateScore();
		System.out.println("Green: "+greenScore+" Red: "+redScore);
	}
	
	public int scaleW(double x){
		return (int)(Window.SCALE*x);
	}
	
	public int scaleH(double x){
		return (int)(Window.SCALE*x);
	}

	public ArrayList<gameObject> getObjects(){
		return this.objects;
	}


	public boolean isRunning() {
		return running;
	}


	public void setRunning(boolean running) {
		this.running = running;
	}


	public boolean isMousedown() {
		return mousedown;
	}


	public void setMousedown(boolean mousedown) {
		this.mousedown = mousedown;
	}


	public int getGreenScore() {
		return greenScore;
	}


	public void setGreenScore(int greenScore) {
		this.greenScore = greenScore;
	}


	public int getRedScore() {
		return redScore;
	}


	public void setRedScore(int redScore) {
		this.redScore = redScore;
	}


	public void setObjects(ArrayList<gameObject> objects) {
		this.objects = objects;
	}
	
	
}
