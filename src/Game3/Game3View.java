package Game3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import OverallGame.Window;
import OverallGame.gameObject;
import OverallGame.gameView;

/**
 * Game3View is the view of Game3 and it handles drawing all of the images and text on screen at every tick
 * 
 * @author Team 7
 * @version 5/17
 */

public class Game3View extends gameView{
	int count;
	
	/**
	 * Constructor for Game3View objects
	 */
	public Game3View(){
		loadImages();
	}
	
	/**
	 * Loads the needed images for the game
	 */
	public void loadImages(){
		createImage("bluecrab_0");
		for(Direction d :Direction.values())//create every horseshoe crab image
			createImage("horseshoe_crab_"+d);
		createImage("mittencrab_1");
		createImage("bluecrab_0");
		createImage("dialogue2");
		createImage("game3sand");
		createImage("game3wood");
		createImage("exit");
		}
	
	/**
	 * Handles drawing all of the objects on screen at every tick.
	 * 
	 * @param g The graphics for the game
	 * @param objects The ArrayList of gameObjects in the game
	 */
	public void render(Graphics g, ArrayList<gameObject> objects){
		
		g.drawImage(images.get("game3sand"), 0, 0, null);
		
		for(gameObject o: objects){
			Animal a = (Animal)(o);
			if(a.name == "HorseShoe"){
				g.drawImage(images.get("horseshoe_crab_"+a.getDir().toString()), scaleW(a.getX()-50), scaleH(a.getY()-50), null);
			}else if(a.name == "mittencrab_1"){
				g.drawImage(images.get("mittencrab_1"), scaleW(a.getX()), scaleH(a.getY()), null);
			}else if(a.name == "bluecrab_0"){
				g.drawImage(images.get("bluecrab_0"), scaleW(a.getX()), scaleH(a.getY()), null);
			}else if(a.name == "EndGame"){
				//g.setColor(Color.gray);
				//g.fillRect((int)((Window.WIDTH/2-200)*Window.SCALE), (int) (((Window.HEIGHT/2)-200)*Window.SCALE), (int)(400*Window.SCALE), (int)(200*Window.SCALE));
				g.drawImage(images.get("dialogue2"), scaleW((Window.WIDTH/2)-200), scaleH((Window.HEIGHT/2)-200), null);
				g.setFont(new Font("TimesRoman", Font.PLAIN, scaleW(50)));
				g.setColor(Color.black);
				g.drawString("You Counted: "+ o.y ,(int)((Window.WIDTH/2-200+20)*Window.SCALE), (int) (((Window.HEIGHT/2)-200+60)*Window.SCALE));
				g.drawString("Actual: "+ o.x ,(int)((Window.WIDTH/2-200+75)*Window.SCALE), (int) (((Window.HEIGHT/2)-200+120)*Window.SCALE));
			}else if(a.name == "Count"){
				count = a.getX();
			}
		}
		g.drawImage(images.get("game3wood"), 0, 0, null);
		g.setColor(Color.yellow);
		g.setFont(new Font("Verdana", Font.PLAIN, scaleW(55)));
		g.drawString("Count: "+ count,scaleW(Window.WIDTH-275), scaleH(60));
		
		g.drawImage(images.get("exit"), scaleW(5), scaleH(5), null);

		
		
		//draw score bar
		//g.setColor(Color.gray);
		//g.fillRect((int)((Window.WIDTH-150)*Window.SCALE),(int) (50*Window.SCALE),(int) (50*Window.SCALE),(int)((objects.get(1).getY()/10)*Window.SCALE));
		//g.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE),(int)(objects.get(2).getY()/10*Window.SCALE));
		//g.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE), (int)(150*Window.SCALE));
	}

}