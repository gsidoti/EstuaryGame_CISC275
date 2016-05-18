package Game1;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import OverallGame.Window;
import OverallGame.gameView;

/**
 * Game1iView is the view of Game1i and it handles drawing all of the images and text on screen 
 * 
 * @author Team 7
 * @version 5/17
 */

public class Game1iView extends gameView{

	private int BkgOffset=0;
	private int dBkgOffset=1;
    //private int pos=0;
    private int i;
	
    /**
     * Constructor for Game1iView objects
     */
	public Game1iView(){
		loadImages();
	}
	
	/**
	 * Handles drawing all of the objects on screen at every tick.
	 * 
	 * @param g The graphics for the instruction screen
	 */
	public void render(Graphics g) {
		//g.setColor(new Color(0,32,64));
		//g.fillRect(0, 0, (int)(Window.WIDTH*Window.SCALE)-20, (int)(Window.HEIGHT*Window.SCALE));
		//g.setColor(new Color(192,192,0));
		//g.fillRect((int)(Window.WIDTH*Window.SCALE)-20, 0, 20, (int)(Window.HEIGHT*Window.SCALE));

		//g.setColor(new Color(32,64,128));
		//for(i=pos-(int)(Window.WIDTH*Window.SCALE);i<(int)(Window.WIDTH*Window.SCALE)-20;i+=100)
		//{
			//g.drawLine(i, 0, i, (int)(Window.HEIGHT*Window.SCALE) );
		//}
		//g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		//pos++;
		
		BkgOffset+=dBkgOffset;
		if(BkgOffset>10)
		{
			BkgOffset=10;
			dBkgOffset=-1;
		}
		if(BkgOffset<0)
		{
			BkgOffset=0;
			dBkgOffset=1;
		}
		g.drawImage(images.get("sea3"),0,0,(int)(Window.WIDTH*Window.SCALE),
				(int)(Window.HEIGHT*Window.SCALE),(int)(BkgOffset*Window.SCALE),
				0,(int)((1260.0+BkgOffset)*Window.SCALE),
				(int)(720*Window.SCALE),null); 
		

		//if(pos>(int)(Window.WIDTH*Window.SCALE)-20)pos=0;
		g.setColor(new Color(255,255,128));
		g.drawString("Collect The Trash!", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4);
		g.drawString("Click where you want your boat to go", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4+60);
		g.drawString("Run into the trash to collect it before it reaches the beach", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4+120);
		g.drawString("If you let 10 pieces of trash by, it's Game Over ", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4+180);
		g.drawString("-> Click to begin <-", (int)(Window.WIDTH*Window.SCALE)/2-150, (int)(Window.HEIGHT*Window.SCALE)-50);
		//Check to see if this bottom text is centered on someone else's screen, it is on mine but I'm not sure
		//if it will work out with the scaling -Cody
	}

	/**
	 * Loads the needed images for the instruction screen
	 */
	@Override
	public void loadImages() {
		createImage("sea3");

		//createImage("smallButton");
		//createImage("menuBG");
		//images.put("menuBG",resizeImg(images.get("menuBG"),scaleW(Window.WIDTH),scaleH(Window.HEIGHT)));
	}
	
	
}
