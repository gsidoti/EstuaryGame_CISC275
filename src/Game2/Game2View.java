package Game2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
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
		g.drawImage(images.get("game2background"), 0, 0, null);
		if(!Game2.inst)
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
			}
		else
			g.drawImage(images.get("game2i"), 0, 0, null);
		
		g.setColor(Color.yellow);
		g.setFont(new Font("Verdana", Font.BOLD, scaleW(50)));
		g.drawString("Boats Left: "+ (Game2.boatsLeft),scaleW(Window.WIDTH-400), scaleH(50));
		
		g.drawImage(images.get("exit"), scaleW(5), scaleH(5), null);
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
		try{
			BufferedImage temp = images.get("cleanvessel");
			images.put("cleanvessel",resizeImg(temp,temp.getWidth()/2,temp.getHeight()/2));
			temp = images.get("dirtyvessel");
			images.put("dirtyvessel",resizeImg(temp,temp.getWidth()/2,temp.getHeight()/2));
			createImage("game2i");
		}catch(NullPointerException e){
			System.out.println("ERROR: Can't find images in Game2.");
			e.printStackTrace();
			System.exit(0);
		}
	}
}
