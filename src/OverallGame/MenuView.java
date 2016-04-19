package OverallGame;

import java.awt.*;
import javax.swing.JFrame;

public class MenuView{
	JFrame frame;
	
	public MenuView(JFrame frame){
		this.frame = frame;
	}
	
	public void render(Graphics g){
		g.setColor(Color.red);
		g.fillRect((frame.getWidth()/10)*2,(frame.getHeight()/10)*2,200,200);
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("START!",(frame.getWidth()/10)*2+30,(frame.getHeight()/10)*2+80);
		//g.fillRect(15, 15, 200, 200);
		//g.drawString("Game 1", 16, 16);
	}
	
	
}
