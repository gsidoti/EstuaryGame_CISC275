package Menu;

import java.awt.event.MouseEvent;
import java.util.Random;
import OverallGame.Controller;
import OverallGame.MiniGame;
import OverallGame.STATE;
import OverallGame.gameObject;

/**
 * Menu is the screen that is displayed when the game starts, giving the player the option of choosing one of the 
 * four games to play.
 * 
 * @author Team 7
 * @version 5/17
 */

public class Menu extends MiniGame {
	int counter= 0;
	int timer=0;
	boolean updatedScore = true;
	boolean ftInit = false;
	int ftTemp;
	public MenuView menuView;
	public static int SCORE = 0;
	Random rand = new Random();
	
	/**
	 * Constructor for Menu objects
	 */
	public Menu(){
		menuView = new MenuView();
	}
	
	/**
	 * When mouse is clicked, sets mx/my to mouse x- and y-positions.
	 * If the mouse was clicked over the button areas of any of the game buttons, set running to false, clear the ArrayList,
	 * and change the gameState to the corresponding game's instruction screen.
	 * If the mouse was clicked over the exit button, quit the game.
	 */
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		if(updatedScore && mouseOver(mx,my,scaleW(150), scaleH(150),scaleW(250),scaleH(275))){	
			Controller.gameState = STATE.Game1;
			resetMenu();
			System.out.println("game1");
		}else if(updatedScore && mouseOver(mx,my,scaleW(900), scaleH(250),scaleW(275),scaleH(250))){	
			Controller.gameState = STATE.Game2;
			resetMenu();
			System.out.println("game2");
		}else if(updatedScore && mouseOver(mx,my,scaleW(150), scaleH(480),scaleW(275),scaleH(250))){	
			Controller.gameState = STATE.Game3;
			resetMenu();
			System.out.println("game3");
		}else if(updatedScore && mouseOver(mx,my,scaleW(900), scaleH(480),scaleW(275),scaleH(250))){	
			Controller.gameState = STATE.Game4;
			resetMenu();
			System.out.println("game4");
		}
		if(mouseOver(mx,my,scaleW(5),scaleH(5),scaleW(80),scaleH(44))){
			System.exit(0);
		}
	}
	
	private void resetMenu(){
		running = false;
		objects.clear();
		updatedScore = false;
		ftInit = false;
	}

    /**
     * Creates 'trash' game objects that are used for the main menu
     * 
     * @param amount amount of new objects to make
     */
	private void createTrash(int amount){
		for(int i = 0;i < amount;i++){
			switch (rand.nextInt(4)){
				case 0:
					objects.add(new gameObject("apple",rand.nextInt(125)+515,rand.nextInt(30)+200,0,rand.nextInt(2)+1));
					break;
				case 1:
					objects.add(new gameObject("can",rand.nextInt(125)+515,rand.nextInt(30)+200,0,rand.nextInt(2)+1));
					break;
				case 2:
					objects.add(new gameObject("box",rand.nextInt(125)+515,rand.nextInt(30)+200,0,rand.nextInt(2)+1));
					break;
				case 3:
					objects.add(new gameObject("chipBag",rand.nextInt(125)+515,rand.nextInt(30)+200,0,rand.nextInt(2)+1));
					break;
			}
		}
	}
		
	/**
	 * Moves the 'trash' on the main screen to make them look like they are being thrown away
	 */
	private void moveTrash(){
		gameObject o;
		for(int i=0;i<objects.size();i++){
			o = objects.get(i);
			if(o.y>430){
				o.name = "";//sets it so view doesn't draw object if in can
			}else if(o.name != ""){
				o.y +=o.getVely();
			}
		}	
	}
	
    /**
     * Makes the amount of trash fall equal to the amount your score changed
     */
	public void fallingTrash(){
		if(!ftInit){
			ftTemp = SCORE-menuView.oldScore;
			ftInit = true;
		}
		if(objects.size() < ftTemp){
			if(counter++%10 == 0)
				createTrash(rand.nextInt(4));
		}
		if(objects.size()*4 >= ftTemp){ //shows new score after 1/4 trash falls
			if(!updatedScore){
				menuView.oldScore = SCORE;
				updatedScore = true;
			}
		}
	}
    

    /**
     * Handles the methods that are called every tick.
     */
	public void tick() {
		fallingTrash();
		moveTrash();
	}

	int getCounter() {
		return counter;
	}

	void setCounter(int counter) {
		this.counter = counter;
	}

	int getTimer() {
		return timer;
	}

	void setTimer(int timer) {
		this.timer = timer;
	}

	boolean isUpdatedScore() {
		return updatedScore;
	}

	void setUpdatedScore(boolean updatedScore) {
		this.updatedScore = updatedScore;
	}

	boolean isFtInit() {
		return ftInit;
	}

	void setFtInit(boolean ftInit) {
		this.ftInit = ftInit;
	}

	int getFtTemp() {
		return ftTemp;
	}

	void setFtTemp(int ftTemp) {
		this.ftTemp = ftTemp;
	}

	MenuView getMenuView() {
		return menuView;
	}

	void setMenuView(MenuView menuView) {
		this.menuView = menuView;
	}

	static int getSCORE() {
		return SCORE;
	}

	static void setSCORE(int score) {
		SCORE = score;
	}

	Random getRand() {
		return rand;
	}

	void setRand(Random rand) {
		this.rand = rand;
	}

}

