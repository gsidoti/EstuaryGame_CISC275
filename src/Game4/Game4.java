package Game4;

import java.awt.event.MouseEvent;
import OverallGame.Controller;
import OverallGame.MiniGame;
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

public class Game4 extends MiniGame {
	public Game4View view;
    static boolean inst = true;
	static int tick=0;
	boolean mousedown = false;
	int mx,my;
	int greenScore = 1500;
	int redScore = 1500;
	
	/**
	 * Constructor for Game4 objects
	 */
	public Game4(){
		objects.add( new G4Player("Player",Window.WIDTH/2,Window.HEIGHT/2,2,3));
		objects.add(new gameObject("greenScore",0,greenScore,0,-1));
		objects.add(new gameObject("redScore",0,redScore,0,-1));
		view = new Game4View();
	}
	
    /**
     * When the mouse button is pressed, sets mousedown to true and sets mx/my to the mouse's x and y position.
     * If the mouse was over the quit button when pressed, reset the game.
     */
	public void mousePressed(MouseEvent e){
		mousedown = true;
		mx = e.getX();
		my = e.getY();
		if(inst && mouseOver(mx,my,scaleW(570),scaleH(520),scaleW(111),scaleH(52)))
			inst = false;
		if(mouseOver(mx,my,scaleW(5),scaleH(5),scaleW(80),scaleH(44)))
			resetGame();
	}
	
	/**
	 * When the mouse button is released, sets mousedown to false.
	 */
	public void mouseReleased(MouseEvent e){
		mousedown = false;
	}

	/**
	 * Updates the player by checking the value of mousedown. If true, the player moves up, else the player moves down
	 */
	void updatePlayer(){
		G4Player p = (G4Player) (objects.get(0));
		if(mousedown){
			if(scaleH(p.getY())>scaleH(150.0))
				p.moveUp();
		}else{
			if(scaleH(objects.get(0).getY())<scaleH(Window.HEIGHT-65))
				p.moveDown();
		}
	}
	
	/**
	 * Resets Game4 by setting game values back to starting values, clearing the ArrayList, and setting gameState back to Menu.
	 */
	void resetGame(){
		gameObject player = objects.get(0);
		gameObject g = objects.get(1);
		gameObject r = objects.get(2);
		greenScore = 1500;
		redScore = 1500;
		tick = 0;
		inst = true;
		g.setY(greenScore);
		r.setY(redScore);
		player.setY(Window.HEIGHT/2);
		running = false;
		Controller.gameState = STATE.Menu;
	}
	
	/**
	 * Updates the score of the game by checking whether the player is inside the green zone or not.
	 * If yes, green score goes up, otherwise red score goes up.
	 * If green score is full, reset game and add score, otherwise just reset game.
	 */
	void updateScore(){
		gameObject player = objects.get(0);
		gameObject g = objects.get(1);
		gameObject r = objects.get(2);
		int top = view.waterTop[scaleW(287-((Game4.tick+220)%288))]+scaleH(220);
		int bot = view.waterTop[scaleW(287-((Game4.tick+220)%288))]+scaleH(348);
		if(scaleH(player.getY()+27)<bot && scaleH(player.getY()-27)>top){
			g.setY(greenScore--);
			if(greenScore <= 0){
				Menu.Menu.SCORE += 100;
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
	 * Handles the methods called every tick of the game.
	 * Updates player and score, then prints out score values.
	 */
	public void tick() {
		if(!inst){
			updatePlayer();
			updateScore();
		}
		tick++;	
	}

	Game4View getView() {
		return view;
	}

	void setView(Game4View view) {
		this.view = view;
	}

	static boolean isInst() {
		return inst;
	}

	static void setInst(boolean inst) {
		Game4.inst = inst;
	}

	static int getTick() {
		return tick;
	}

	static void setTick(int tick) {
		Game4.tick = tick;
	}

	boolean isMousedown() {
		return mousedown;
	}

	void setMousedown(boolean mousedown) {
		this.mousedown = mousedown;
	}

	int getMx() {
		return mx;
	}

	void setMx(int mx) {
		this.mx = mx;
	}

	int getMy() {
		return my;
	}

	void setMy(int my) {
		this.my = my;
	}

	int getGreenScore() {
		return greenScore;
	}

	void setGreenScore(int greenScore) {
		this.greenScore = greenScore;
	}

	int getRedScore() {
		return redScore;
	}

	void setRedScore(int redScore) {
		this.redScore = redScore;
	}
}
