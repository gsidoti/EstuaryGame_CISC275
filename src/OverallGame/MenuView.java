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
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.red);
		g.fillRect((WIDTH/10)*2,(HEIGHT/10)*2,200,200);
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("START!",(WIDTH/10)*2+30,(HEIGHT/10)*2+80);
		//g.fillRect(15, 15, 200, 200);
		//g.drawString("Game 1", 16, 16);
	}
	
	
}
