package Game2;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import OverallGame.Window;
import OverallGame.gameView;

/**
 * Game2iView is the view of Game2i and it handles drawing all of the images and text on screen 
 * 
 * @author Team 7
 * @version 5/17
 */

public class Game2iView extends gameView{

	/**
	 * Constructor for Game2iView objects
	 */
	public Game2iView(){
		loadImages();

	}
	
	/**
	 * Handles drawing all of the objects on screen at every tick.
	 * 
	 * @param g The graphics for the instruction screen
	 */
	public void render(Graphics g){
		g.drawImage(images.get("game2background"), 0, 0, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, scaleW(30)));
		g.drawString("Clean The Boats!", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4);
		g.drawString("Shipping boats are coming to port, but some brought", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4+60);
		g.drawString("invasive species along with them", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4+90);
		g.drawString("Click on the dirty boats to clean them off before they dock", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4+150);
		g.drawString("If you let 3 dirty boats in, it's Game Over ", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4+210);
		g.drawString("-> Click to begin <-", (int)(Window.WIDTH*Window.SCALE)/2-150, (int)(Window.HEIGHT*Window.SCALE)-50);
	}

	/**
	 * Loads the needed images for the instruction screen
	 */
	@Override
	public void loadImages() {
		createImage("game2background");
	}
}