package Menu;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import OverallGame.Window;
import OverallGame.gameView;

public class MenuView extends gameView{
	int w;
	int h;
	double wS;
	double hS;
	JFrame frame;
	Image background;
	
	public MenuView(Window W){
		loadImages();
		this.frame = W.frame;
		this.w = Window.WIDTH;
		this.h= Window.HEIGHT;
		this.wS = Window.SCALE;
		this.hS = Window.SCALE;
	}
	
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
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Game1",((int)(w*wS)/100)*20+30,((int)(h*hS)/100)*20+80);
		//second button
		//g.setColor(Color.red);
		//g.fillRect(((int)(w*wS)/100)*60,((int)(h*hS)/100)*20,this.scaleW(200),this.scaleH(200));
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Game2",((int)(w*wS)/100)*60+30,((int)(h*hS)/100)*20+80);
		
		//g.setColor(Color.red);
		//g.fillRect(((int)(w*wS)/100)*20,((int)(h*hS)/100)*60,this.scaleW(200),this.scaleH(200));
		//g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Game3",((int)(w*wS)/100)*20+30,((int)(h*hS)/100)*60+80);
		
		//g.setColor(Color.red);
		//g.fillRect(((int)(w*wS)/100)*60,((int)(h*hS)/100)*60,this.scaleW(200),this.scaleH(200));
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Game4",((int)(w*wS)/100)*60+30,((int)(h*hS)/100)*60+80);
		
		//g.setColor(Color.green);
		//g.fillRect(((int)(w*wS)/100)*50-250,((int)(h*hS)/100)*2,500,70);
		//g.setColor(Color.black);
		//g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		//g.drawString("Score",((int)(w*wS)/100)*50-30,((int)(h*hS)/100)*2+50);
	}

	@Override
	public void loadImages() {
		createImage("smallButton");
		createImage("menuBG");
		images.put("menuBG",resizeImg(images.get("menuBG"),scaleW(Window.WIDTH),scaleH(Window.HEIGHT)));
	}
	
	
}
