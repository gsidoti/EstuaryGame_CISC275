package Menu;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import OverallGame.Window;
import OverallGame.gameView;

/**
 * MenuView is the view of Menu and it handles drawing all of the images and text on screen at every tick
 * 
 * @author Team 7
 * @version 5/17
 */

public class MenuView extends gameView{
	int w;
	int h;
	double wS;
	double hS;
	JFrame frame;
	Image background;
	
	/**
	 * 
	 * @param W
	 */
	public MenuView(Window W){
		loadImages();
		this.frame = W.frame;
		this.w = Window.WIDTH;
		this.h= Window.HEIGHT;
		this.wS = Window.SCALE;
		this.hS = Window.SCALE;
	}
	
	/**
	 * 
	 * @param g
	 */
	public void render(Graphics g){
		//g.setColor(Color.pink);
		//g.fillRect(0, 0,(int)(w*wS), (int)(h*hS));
		
		g.drawImage(images.get("menuBG"), 0, 0, null);
		
		

		g.drawImage(images.get("smallButton"), scaleW(770), scaleH(145), null);
		g.drawImage(images.get("smallButton"), scaleW(270), scaleH(145), null);
		g.drawImage(images.get("smallButton"), scaleW(270), scaleH(392), null);
		g.drawImage(images.get("smallButton"), scaleW(770), scaleH(392), null);
		
		
		//first button
		//g.setColor(Color.red);		
		//g.fillRect(((int)(w*wS)/100)*20,((int)(h*hS)/100)*20,this.scaleW(200),this.scaleH(200));
		g.setColor(Color.black);
		g.setFont(new Font("verdana", Font.PLAIN, scaleW(28)));
		g.drawString("Game1",((int)(w*wS)/100)*20+30,((int)(h*hS)/100)*20+80);
		//second button
		//g.setColor(Color.red);
		//g.fillRect(((int)(w*wS)/100)*60,((int)(h*hS)/100)*20,this.scaleW(200),this.scaleH(200));
		//g.setColor(Color.black);
		//g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Game2",scaleW(770+15),((int)(h*hS)/100)*20+80);
		
		//g.setColor(Color.red);
		//g.fillRect(((int)(w*wS)/100)*20,((int)(h*hS)/100)*60,this.scaleW(200),this.scaleH(200));
		//g.setColor(Color.black);
		//g.setFont(new Font("TimesRoman", Font.PLAIN, scaleW(30)));
		g.drawString("Game3",((int)(w*wS)/100)*20+30,((int)(h*hS)/100)*60+80);
		
		//g.setColor(Color.red);
		//g.fillRect(((int)(w*wS)/100)*60,((int)(h*hS)/100)*60,this.scaleW(200),this.scaleH(200));
		//g.setColor(Color.black);
		//g.setFont(new Font("TimesRoman", Font.PLAIN, scaleW(30)));
		g.drawString("Game4",scaleW(770+15),((int)(h*hS)/100)*60+80);
		
		//g.setColor(Color.green);
		//g.fillRect(((int)(w*wS)/100)*50-250,((int)(h*hS)/100)*2,500,70);
		//g.setColor(Color.black);
		//g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		//g.drawString("Score",((int)(w*wS)/100)*50-30,((int)(h*hS)/100)*2+50);
		g.drawImage(images.get("exit"), scaleW(5), scaleH(5), null);
	}

	/**
	 * 
	 */
	@Override
	public void loadImages() {
		createImage("exit");
		createImage("smallButton");
		createImage("menuBG");
		images.put("menuBG",resizeImg(images.get("menuBG"),scaleW(Window.WIDTH),scaleH(Window.HEIGHT)));
	}
	
	
}
