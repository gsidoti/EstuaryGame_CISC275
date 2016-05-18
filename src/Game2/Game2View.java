package Game2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import OverallGame.Controller;
import OverallGame.Window;
import OverallGame.gameObject;
import OverallGame.gameView;

/**
 * Game2View is the view of Game2 and it handles drawing all of the images and text on screen at every tick
 * 
 * @author Team 7
 * @version 5/17
 */

public class Game2View extends gameView{

    /**
     * Constructor for Game2View objects
     */
	public Game2View(){
		loadImages();
	}
	
	/**
	 * Handles drawing all of the objects on screen at every tick.
	 * 
	 * @param g The graphics for the game
	 * @param objects The ArrayList of gameObjects in the game
	 */
	public void render(Graphics g, ArrayList<gameObject> objects){
		
		//fill screen
		//g.setColor(Color.blue);
		//g.fillRect(0, 0, (int)(Window.WIDTH*Window.SCALE), (int)(Window.HEIGHT*Window.SCALE));
		
		//draw safe zone
		//g.setColor(Color.white);
		//g.fillRect(0,(int)(((Window.HEIGHT/2)-50)*Window.SCALE),(int) (Window.WIDTH*Window.SCALE),(int)(100*Window.SCALE) );
		//g.setColor(new Color(0f, .5f, 0f, .5f));//this would be the green zone
		//g.setColor(new Color(156, 93, 2));
		//g.fillRect(0,0,(int)(100*Window.SCALE),(int)(1000*Window.SCALE));
		//draw boats
		//g.setColor(Color.green);
		g.drawImage(images.get("game2background"), 0, 0, null);
		
		for (int i = 0; i < objects.size(); i++){
			Boat temp = (Boat)(objects.get(i));
			if (temp.getInfested()){
				if(temp.getActive()){
					g.drawImage(images.get("dirtyvessel"), scaleW(temp.getX()), scaleH(temp.getY()), null);
				}else{
					g.drawImage(images.get("dirtyvessel"), scaleW(50+(30*temp.getVely())), scaleH(temp.getY()), null);
				}
			}else if(!temp.getInfested()){
				if(temp.getActive()){
					g.drawImage(images.get("cleanvessel"), scaleW(temp.getX()), scaleH(temp.getY()), null);
				}else{
					g.drawImage(images.get("cleanvessel"), scaleW(50+(30*temp.getVely())), scaleH(temp.getY()), null);
				}
			}
					//g.setColor(Color.red);
			//if (temp.getActive()) {
			//	System.out.println(objects.get(i).name+"X: "+objects.get(i).getX()+" Y: "+ objects.get(i).getY()+objects.get(i).getVelx()+" "+ objects.get(i).getVely());
			//	g.fillRect(objects.get(i).getX(),objects.get(i).getY(),25,50);
			//}
		}
		
		g.setColor(Color.yellow);
		g.setFont(new Font("Verdana", Font.BOLD, scaleW(50)));
		g.drawString("Boats Left: "+ (Game2.boatsLeft-1),scaleW(Window.WIDTH-400), scaleH(50));
		
		g.drawImage(images.get("exit"), scaleW(5), scaleH(5), null);

		
		
		//g.setColor(Color.green);
		//g.drawRect((int)((Window.WIDTH-150)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE),(int) (150*Window.SCALE));
		//g.fillRect((int)((Window.WIDTH-150)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE),(int) (150*Window.SCALE));
		//g.setColor(Color.red);
		//g.drawRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE), (int)(150*Window.SCALE));
		//.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE), (int)(150*Window.SCALE));
		
		//draw score bar
		//g.setColor(Color.gray);
		//g.fillRect((int)((Window.WIDTH-150)*Window.SCALE),(int) (50*Window.SCALE),(int) (50*Window.SCALE),(int)((objects.get(1).getY()/10)*Window.SCALE));
		//g.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE),(int)(objects.get(2).getY()/10*Window.SCALE));
		//g.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE), (int)(150*Window.SCALE));
	}

	/**
	 * Loads the needed images for the game
	 */
	@Override
	public void loadImages() {
		createImage("cleanvessel");
		createImage("dirtyvessel");
		createImage("game2background");
		createImage("exit");
		BufferedImage temp = images.get("cleanvessel");
		//System.out.println(temp.getWidth()+" "+temp.getHeight());
		images.put("cleanvessel",resizeImg(temp,temp.getWidth()/2,temp.getHeight()/2));
		//System.out.println(temp.getWidth()+" "+temp.getHeight());
		temp = images.get("dirtyvessel");
		//System.out.println(temp.getWidth()+" "+temp.getHeight());
		images.put("dirtyvessel",resizeImg(temp,temp.getWidth()/2,temp.getHeight()/2));
		//System.out.println(temp.getWidth()+" "+temp.getHeight());
	}
}
