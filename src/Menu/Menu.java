package Menu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

import OverallGame.Controller;
import OverallGame.STATE;
import OverallGame.Window;
import OverallGame.gameObject;

/**
 * Menu is the screen that is displayed when the game starts, giving the player the option of choosing one of the 
 * four games to play.
 * 
 * @author Team 7
 * @version 5/17
 */

public class Menu extends MouseAdapter {
	int counter= 0;
	int timer=0;
	public boolean updatedScore = true;
	public boolean returning = true;
	public long initTime;
	public MenuView menuView;
	public boolean running = false;
	boolean mlActive;
	public static int SCORE = 0;
	Random rand = new Random();
	ArrayList<gameObject> objects = new ArrayList<gameObject>();
	
	/**
	 * Constructor for Menu objects
	 */
	public Menu(){
		menuView = new MenuView();
	}
	
	/**
	 * Stops the mouse listener for the instruction screen
	 */
	public void stopMouseListener(){
		mlActive = false;
	}
	
	/**
	 * When mouse is clicked, sets mx/my to mouse x- and y-positions.
	 * If the mouse was clicked over the button areas of any of the game buttons, set running to false, clear the ArrayList,
	 * and change the gameState to the corresponding game's instruction screen.
	 * If the mosue was clicked over the exit button, quit the game.
	 */
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		if(updatedScore && mouseOver(mx,my,scaleW(150), scaleH(150),scaleW(250),scaleH(275))){	
			Controller.gameState = STATE.Game1i;
			running = false;
			returning = false;
			objects.clear();
			System.out.println("game1i");
		}else if(updatedScore && mouseOver(mx,my,scaleW(900), scaleH(250),scaleW(275),scaleH(250))){	
			Controller.gameState = STATE.Game2i;
			running = false;
			returning = false;
			objects.clear();
			System.out.println("game2i");
		}else if(updatedScore && mouseOver(mx,my,scaleW(150), scaleH(480),scaleW(275),scaleH(250))){	
			Controller.gameState = STATE.Game3i;
			running = false;
			returning = false;
			objects.clear();
			System.out.println("game3i");
		}else if(updatedScore && mouseOver(mx,my,scaleW(900), scaleH(480),scaleW(275),scaleH(250))){	
			Controller.gameState = STATE.Game4i;
			running = false;
			returning = false;
			objects.clear();
			System.out.println("game4i");
		}
		if(mouseOver(mx,my,scaleW(5),scaleH(5),scaleW(80),scaleH(44))){
			System.exit(0);
		}
	}
	
    /**
     * Takes the width of an image and scales it to the appropriate size for the current screen
     * 
     * @param x Width of image that needs to be scaled
     * @return Returns scaled width for image
     */
	public int scaleW(double x){
		return (int)(Window.SCALE*x);
	}
	
	/**
	 * Takes the height of an image and scales it to the appropriate size for the current screen
	 * 
	 * @param x Height of image that needs to be scaled
	 * @return Returns scaled height for image
	 */
	public int scaleH(double x){
		return (int)(Window.SCALE*x);
	}

	
	
    /**
     * Checks to see if the mouse is over given coordinates on the screen.
     * 
     * @param mx Mouse x-position
     * @param my Mouse y-position
     * @param x x-position of image being checked against mouse x-position
     * @param y y-position of image being checked against mouse y-position
     * @param width Width of image being checked for mouse over
     * @param height Height of image being checked for mouse over 
     * @return Returns true if mouse is over given image position, false if otherwise
     */
	//not being used
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
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
			if(o.y>400){
				o.name = "";
			}else if(o.name != ""){
				o.y +=o.getVely();
			}
		}	
	}
    

    /**
     * Handles the methods that are called every tick.
     */
	public void tick() {
		if(returning){
			if(System.currentTimeMillis()<initTime){
				updatedScore = false;
				if(counter++%10 ==0)
					createTrash(rand.nextInt(3));
			}else if(updatedScore == false){
				menuView.oldScore = SCORE;
				updatedScore = true;
			}
		}

		moveTrash();
	}
	
	
	public ArrayList<gameObject> getObjects(){
		return this.objects;
	}

}

