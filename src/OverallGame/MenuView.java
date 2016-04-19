package OverallGame;

import java.awt.*;
import javax.swing.JFrame;

public class MenuView{
	int WIDTH, HEIGHT;
	JFrame frame;
	
	public MenuView(int w, int h){
		this.WIDTH = w;
		this.HEIGHT = h;
	}
	
	public void render(Graphics g){
		g.setColor(Color.pink);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//first button
		g.setColor(Color.red);
		g.fillRect((WIDTH/100)*20,(HEIGHT/100)*20,200,200);
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Game1",(WIDTH/100)*20+30,(HEIGHT/100)*20+80);
		//second button
		g.setColor(Color.red);
		g.fillRect((WIDTH/100)*60,(HEIGHT/100)*20,200,200);
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Game2",(WIDTH/100)*60+30,(HEIGHT/100)*20+80);
		
		g.setColor(Color.red);
		g.fillRect((WIDTH/100)*20,(HEIGHT/100)*60,200,200);
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Game3",(WIDTH/100)*20+30,(HEIGHT/100)*60+80);
		
		g.setColor(Color.red);
		g.fillRect((WIDTH/100)*60,(HEIGHT/100)*60,200,200);
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Game4",(WIDTH/100)*60+30,(HEIGHT/100)*60+80);
		
		g.setColor(Color.green);
		g.fillRect((WIDTH/100)*50-250,(HEIGHT/100)*2,500,70);
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Score",(WIDTH/100)*50-30,(HEIGHT/100)*2+50);
	}
	
	
}
