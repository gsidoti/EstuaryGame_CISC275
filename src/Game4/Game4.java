package Game4;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import OverallGame.Controller;
import OverallGame.STATE;
import OverallGame.Window;
import OverallGame.gameObject;

/**
 * Game4 is a game where the goal is to collect a correct water sample, using the movable water collection device.
 * The player clicks and holds to move the collection device down, and lets go to allow it to move up.
 * While the player is inside the green zone, the green score will go up.
 * If the player is outside the green zone, the red score will go up.
 * The score of the game is calculated when the water sample is finished, depending on how full both score bars are.
 * 
 * @author Team 7
 * @version 5/17
 */

public class Game4 extends MouseAdapter {
	public boolean running = false;
	ArrayList<gameObject> objects = new ArrayList<gameObject>();
	
	public Game4View view;
	boolean mousedown = false;
	int mx,my;
	public int greenScore = 1500;
	public int redScore = 1500;
	
	/**
	 * 
	 */
	public Game4(){
		objects.add( new G4Player("Player",(int)((Window.WIDTH/2)*Window.SCALE),(int)((Window.HEIGHT/2)*Window.SCALE),2,5));
		objects.add(new gameObject("greenScore",0,greenScore,0,-1));
		objects.add(new gameObject("redScore",0,redScore,0,-1));
		view = new Game4View();
	}
	
	/**
	 * 
	 */
	public void mousePressed(MouseEvent e){
		mousedown = true;
		mx = e.getX();
		my = e.getY();
		if(mouseOver(mx,my,scaleW(5),scaleH(5),scaleW(80),scaleH(44)))
			resetGame();
	}
	
	/**
	 * 
	 */
	public void mouseReleased(MouseEvent e){
		mousedown = false;
	}

	/**
	 * 
	 */
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
	
	/**
	 * 
	 */
	void resetGame(){
		gameObject player = objects.get(0);
		gameObject g = objects.get(1);
		gameObject r = objects.get(2);
		greenScore = 1500;
		redScore = 1500;
		g.setY(greenScore);
		r.setY(redScore);
		player.setY(Window.HEIGHT/2);
		running = false;
		Controller.gameState = STATE.Menu;
	}
	
	/**
	 * 
	 */
	void updateScore(){
		gameObject player = objects.get(0);
		gameObject g = objects.get(1);
		gameObject r = objects.get(2);
		if(scaleH(player.getY()+10)>scaleH(Window.HEIGHT/2-50) && scaleH(player.getY()+40)<scaleH(Window.HEIGHT/2+50)){
			g.setY(greenScore--);
			if(greenScore <= 0){
				Menu.Menu.ESCORE += 100;
				resetGame();
			}
		}else{
			r.setY(redScore--);
			if(redScore <= 0){
				resetGame();
			}
		}
	}
	
	/**
	 * 
	 */
	public void tick() {
		updatePlayer();
		updateScore();
		System.out.println("Green: "+greenScore+" Red: "+redScore);
	}
	
	/**
	 * 
	 * @param mx
	 * @param my
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return
	 */
    boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }
	
    /**
     * 
     * @param x
     * @return
     */
	public int scaleW(double x){
		return (int)(Window.SCALE*x);
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	public int scaleH(double x){
		return (int)(Window.SCALE*x);
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<gameObject> getObjects(){
		return this.objects;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * 
	 * @param running
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isMousedown() {
		return mousedown;
	}
	
	/**
	 * 
	 * @param mousedown
	 */
	public void setMousedown(boolean mousedown) {
		this.mousedown = mousedown;
	}

	/**
	 * 
	 * @return
	 */
	public int getGreenScore() {
		return greenScore;
	}

	/**
	 * 
	 * @param greenScore
	 */
	public void setGreenScore(int greenScore) {
		this.greenScore = greenScore;
	}

	/**
	 * 
	 * @return
	 */
	public int getRedScore() {
		return redScore;
	}

	/**
	 * 
	 * @param redScore
	 */
	public void setRedScore(int redScore) {
		this.redScore = redScore;
	}

	/**
	 * 
	 * @param objects
	 */
	public void setObjects(ArrayList<gameObject> objects) {
		this.objects = objects;
	}
	
	
}
