package Game4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import OverallGame.Window;
import OverallGame.gameObject;
import OverallGame.gameView;

/**
 * Game4View is the view of Game4 and it handles drawing all of the images and text on screen at every tick
 * 
 * @author Team 7
 * @version 5/17
 */

public class Game4View extends gameView{
	int []waterTop;
	
	/**
	 * Constructor for Game4View objects
	 */
	public Game4View(){
		loadImages();
	}
	
	/**
	 * Loads the needed images for the game
	 * Calculates the top of the water based on the alpha value
	 */
	public void loadImages(){
		createImage("vessel");
		createImage("sky");
		createImage("watertester");
		createImage("game4_bgTile");
		createImage("g4_sand");
		createImage("game4i");
		createImage("exit");
		try{
			BufferedImage img = images.get("game4_bgTile");
			waterTop = new int[images.get("game4_bgTile").getWidth()];
			for(int i = 0; i<waterTop.length;i++){
				int y = 0;
				while((img.getRGB(i,y)>>24) == 0x00){
					y++;
				}
				waterTop[i] = y;
			}
		}catch(NullPointerException e){
			System.out.println("ERROR: Can't find images in Game2.");
			System.exit(0);
		}
	}
	
	/**
	 * Handles drawing all of the objects on screen at every tick.
	 * 
	 * @param g The graphics for the game
	 * @param objects The ArrayList of gameObjects in the game
	 */
	public void render(Graphics g, ArrayList<gameObject> objects){
		g.drawImage(images.get("sky"), scaleW(0), scaleH(0), null);
		//draws moving water
		for(int i=-1;i<10;i++){
			g.drawImage(images.get("game4_bgTile"), scaleW(Game4.tick%288+(i*288)), scaleH(0), null);
		}
		g.drawImage(images.get("g4_sand"), scaleW(0), scaleH(Window.HEIGHT-82), null);
		//draw vessel based on wave height
		g.drawImage(images.get("vessel"), scaleW(398), waterTop[scaleW(287-((Game4.tick+30)%288))]-scaleH(110), null);
		//draw rope
		g.setColor(Color.black);
		g.fillRect(scaleW(Window.WIDTH/2-1),waterTop[scaleW(287-((Game4.tick+30)%288))]-scaleH(68),(int)(Math.ceil(2*Window.SCALE)),scaleH(68)+scaleH(objects.get(0).y)-waterTop[scaleW(287-((Game4.tick+30)%288))]);
		//draw watertester
		g.drawImage(images.get("watertester"), scaleW(Window.WIDTH/2-10), scaleH(objects.get(0).y-30), null);
		//draws instructions
		if(Game4.inst)
			g.drawImage(images.get("game4i"), 0, 0, null);
		//draw score bars
		g.setColor(Color.green);
		g.fillRect((int)((Window.WIDTH-150)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE),(int) (150*Window.SCALE));
		g.setColor(Color.red);
		g.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE), (int)(150*Window.SCALE));
		g.setColor(Color.gray);
		g.fillRect((int)((Window.WIDTH-150)*Window.SCALE),(int) (50*Window.SCALE),(int) (50*Window.SCALE),(int)((objects.get(1).getY()/10)*Window.SCALE));
		g.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE),(int)(objects.get(2).getY()/10*Window.SCALE));
		g.drawImage(images.get("exit"), scaleW(5), scaleH(5), null);
	}
}