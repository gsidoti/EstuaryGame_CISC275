package Game4;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import OverallGame.Window;
import OverallGame.gameView;

/**
 * Game4iView is the view of Game4i and it handles drawing all of the images and text on screen 
 * 
 * @author Team 7
 * @version 5/17
 */

public class Game4iView extends gameView{
	
	/**
	 * 
	 */
	public Game4iView(){
		loadImages();
	}
	
	/**
	 * 
	 * @param g
	 */
	public void render(Graphics g){
		//g.setColor(Color.pink);
		//g.fillRect(0, 0,(int)(w*wS), (int)(h*hS));
		g.drawImage(images.get("underwater2"), scaleW(0), scaleH(0), null);

		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, scaleW(30)));
		g.drawString("Collect the Sample", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4);
		g.drawString("The reserve needs your help to test the water around the estuary", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4+60);
		g.drawString("Click and hold to make your water collection device move up", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4+120);
		g.drawString("Let go of the mouse to let your water collection device move down", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4+150);
		g.drawString("Keep your water collection device in the green area of the water to ", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4+210);
		g.drawString("collect a correct water sample", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4+240);
		g.drawString("-> Click to begin <-", (int)(Window.WIDTH*Window.SCALE)/2-150, (int)(Window.HEIGHT*Window.SCALE)-50);
	}

	/**
	 * 
	 */
	@Override
	public void loadImages() {
		createImage("underwater2");
		images.put("underwater2",resizeImg(images.get("underwater2"),scaleW(Window.WIDTH),scaleH(Window.HEIGHT)));

	}
	
	
}