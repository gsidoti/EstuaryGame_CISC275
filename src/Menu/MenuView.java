package Menu;

import java.awt.*;
import java.util.ArrayList;

import OverallGame.Window;
import OverallGame.gameObject;
import OverallGame.gameView;

/**
 * MenuView is the view of Menu and it handles drawing all of the images and text on screen at every tick
 * 
 * @author Team 7
 * @version 5/17
 */

public class MenuView extends gameView{
	int count=0;
	int wait = 20;
	public int oldScore = 0;
	boolean flip = false;
	
	/**
	 * 
	 */
	public MenuView(){
		loadImages();
	}
	
	/**
	 * 
	 * @param g
	 */
	public void render(Graphics g, ArrayList<gameObject> objects){
		if(count++%wait == 0){
			if(flip==true){
				flip = false;
				wait = 10;
			}else{
				flip = true;
				wait = 50;
			}
		}
			
		g.setColor(Color.black);
		g.fillRect(0, 0,scaleW(Window.WIDTH+5),scaleH(Window.HEIGHT+5));
		
		g.drawImage(images.get("menubg2"), 0, 0, null);
		
		if(flip==true){
			g.drawImage(images.get("game1_NS"), scaleW(150), scaleH(250), null);
			g.drawImage(images.get("game2_NS"), scaleW(900), scaleH(250), null);
			g.drawImage(images.get("game3_NS"), scaleW(150), scaleH(480), null);
			g.drawImage(images.get("game4_NS"), scaleW(900), scaleH(480), null);
		}else{
			g.drawImage(images.get("game1_S"), scaleW(150), scaleH(250), null);
			g.drawImage(images.get("game2_S"), scaleW(900), scaleH(250), null);
			g.drawImage(images.get("game3_S"), scaleW(150), scaleH(480), null);
			g.drawImage(images.get("game4_S"), scaleW(900), scaleH(480), null);
		}
		gameObject o;
		for(int i=0;i<objects.size();i++){
			o = objects.get(i);
			if(o.name == "apple"){
				g.drawImage(images.get("apple"), scaleW(o.getX()), scaleH(o.getY()), null);
			}else if(o.name == "can"){
				g.drawImage(images.get("can"), scaleW(o.getX()), scaleH(o.getY()), null);
			}else if(o.name == "box"){
				g.drawImage(images.get("box"), scaleW(o.getX()), scaleH(o.getY()), null);
			}else if(o.name == "chipBag"){
				g.drawImage(images.get("chipBag"), scaleW(o.getX()), scaleH(o.getY()), null);
				
			}
		}
		
		g.drawImage(images.get("trash-43"), scaleW(500), scaleH(400), null);
		g.setFont(new Font("Verdana", Font.BOLD, scaleW(30)));
		g.setColor(Color.cyan);
		g.drawString("Garbage",scaleW(565),scaleH(500));
		g.drawString("Collected:",scaleW(555),scaleH(550));
		g.setFont(new Font("Verdana", Font.BOLD, scaleW(70)));
		g.drawString(String.valueOf(oldScore),scaleW(550),scaleH(620));
		g.drawImage(images.get("exit"), scaleW(5), scaleH(5), null);
	}
	
	/**
	 * 
	 */
	@Override
	public void loadImages() {
		createImage("exit");
		createImage("game1_NS");
		createImage("game2_NS");
		createImage("game3_NS");
		createImage("game4_NS");
		images.put("game1_NS",resizeImg(images.get("game1_NS"),scaleW(images.get("game1_NS").getWidth()*1.1),scaleW(images.get("game1_NS").getHeight()*1.1)));
		images.put("game2_NS",resizeImg(images.get("game2_NS"),scaleW(images.get("game2_NS").getWidth()*1.35),scaleW(images.get("game2_NS").getHeight()*1.35)));
		images.put("game3_NS",resizeImg(images.get("game3_NS"),scaleW(images.get("game3_NS").getWidth()*1.35),scaleW(images.get("game3_NS").getHeight()*1.35)));
		images.put("game4_NS",resizeImg(images.get("game4_NS"),scaleW(images.get("game4_NS").getWidth()*1.35),scaleW(images.get("game4_NS").getHeight()*1.35)));
		
		createImage("game1_S");
		createImage("game2_S");
		createImage("game3_S");
		createImage("game4_S");
		images.put("game1_S",resizeImg(images.get("game1_S"),scaleW(images.get("game1_S").getWidth()*1.1),scaleW(images.get("game1_S").getHeight()*1.1)));
		images.put("game2_S",resizeImg(images.get("game2_S"),scaleW(images.get("game2_S").getWidth()*1.35),scaleW(images.get("game2_S").getHeight()*1.35)));
		images.put("game3_S",resizeImg(images.get("game3_S"),scaleW(images.get("game3_S").getWidth()*1.35),scaleW(images.get("game3_S").getHeight()*1.35)));
		images.put("game4_S",resizeImg(images.get("game4_S"),scaleW(images.get("game4_S").getWidth()*1.35),scaleW(images.get("game4_S").getHeight()*1.35)));
		
		createImage("apple");
		createImage("can");
		createImage("box");
		createImage("chipBag");
		images.put("apple",resizeImg(images.get("apple"),scaleW(images.get("apple").getWidth()*0.4),scaleW(images.get("game1_S").getHeight()*0.4)));
		images.put("can",resizeImg(images.get("can"),scaleW(images.get("can").getWidth()*0.4),scaleW(images.get("game2_S").getHeight()*0.4)));
		images.put("box",resizeImg(images.get("box"),scaleW(images.get("box").getWidth()*0.4),scaleW(images.get("game3_S").getHeight()*0.4)));
		images.put("chipBag",resizeImg(images.get("chipBag"),scaleW(images.get("chipBag").getWidth()*0.3),scaleW(images.get("game4_S").getHeight()*0.3)));
		
		createImage("trash-43");
		images.put("trash-43",resizeImg(images.get("trash-43"),scaleW(images.get("trash-43").getWidth()*1.3),scaleW(images.get("trash-43").getHeight()*1.3)));
		createImage("menubg2");
		//images.put("menuBG",resizeImg(images.get("menuBG"),scaleW(Window.WIDTH),scaleH(Window.HEIGHT)));
	}
	
	
}
