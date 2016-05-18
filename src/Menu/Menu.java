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
	public boolean updatedScore = false;
	public boolean returning = true;
	public long initTime;
	public MenuView menuView;
	public boolean running = false;
	boolean mlActive;
	public static int SCORE = 0;
	Random rand = new Random();
	ArrayList<gameObject> objects = new ArrayList<gameObject>();
	
	/**
	 * 
	 * @param W
	 */
	public Menu(){
		menuView = new MenuView();
	}
	
	/**
	 * 
	 */
	public void stopMouseListener(){
		mlActive = false;
	}
	
	/**
	 * 
	 */
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		if(mouseOver(mx,my,scaleW(150), scaleH(150),scaleW(250),scaleH(275))){	
			Controller.gameState = STATE.Game1i;
			running = false;
			returning = false;
			objects.clear();
			System.out.println("game1i");
		}else if(mouseOver(mx,my,scaleW(900), scaleH(250),scaleW(275),scaleH(275))){	
			Controller.gameState = STATE.Game2i;
			running = false;
			returning = false;
			objects.clear();
			System.out.println("game2i");
		}else if(mouseOver(mx,my,scaleW(150), scaleH(480),scaleW(275),scaleH(275))){	
			Controller.gameState = STATE.Game3i;
			running = false;
			returning = false;
			objects.clear();
			System.out.println("game3i");
		}else if(mouseOver(mx,my,scaleW(900), scaleH(480),scaleW(275),scaleH(275))){	
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
	 * @param mx
	 * @param my
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return
	 */
	//not being used
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }
    
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
     * 
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

