package Game3;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import OverallGame.Window;
import OverallGame.gameView;

/**
 * Game3iView is the view of Game3i and it handles drawing all of the images and text on screen 
 * 
 * @author Team 7
 * @version 5/17
 */

public class Game3iView extends gameView{
	
	/**
	 * 
	 */
	public Game3iView(){
		loadImages();
	}
	
	/**
	 * 
	 * @param g
	 */
	public void render(Graphics g){
		//g.setColor(Color.pink);
		//g.fillRect(0, 0,(int)(w*wS), (int)(h*hS));
		g.drawImage(images.get("game3sand"), 0, 0, null);
		g.drawImage(images.get("game3wood"), 0, 0, null);
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Horseshoe Crab Spawning Survey", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4);
		g.drawString("There is marine wildlife everywhere, but the reserve needs", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4+60);
		g.drawString("you to count how many Horseshoe Crabs there are", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4+90);
		g.drawString("Click to count each Horseshoe Crab you see go by", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4+150);
		g.drawString("If you count them all, you win!", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4+210);
		g.drawString("-> Click to begin <-", (int)(Window.WIDTH*Window.SCALE)/2-150, (int)(Window.HEIGHT*Window.SCALE)-50);
	}

	/**
	 * 
	 */
	@Override
	public void loadImages() {
		createImage("game3sand");
		createImage("game3wood");
	}
}