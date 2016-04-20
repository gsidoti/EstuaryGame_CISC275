package OverallGame;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuView{
	int w;
	int h;
	double wS;
	double hS;
	JFrame frame;
	
	public MenuView(Window W){
		this.frame = W.frame;
		this.w = W.WIDTH;
		this.h= W.HEIGHT;
		this.wS = W.scaleW;
		this.hS = W.scaleH;
	}
	
	public void render(Graphics g){
		g.setColor(Color.pink);
		g.fillRect(0, 0,(int)(w*wS), (int)(h*hS));
		//first button
		
		
		
		g.setColor(Color.red);
		g.fillRect(((int)(w*wS)/100)*20,((int)(h*hS)/100)*20,200,200);
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Game1",((int)(w*wS)/100)*20+30,((int)(h*hS)/100)*20+80);
		//second button
		g.setColor(Color.red);
		g.fillRect(((int)(w*wS)/100)*60,((int)(h*hS)/100)*20,200,200);
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Game2",((int)(w*wS)/100)*60+30,((int)(h*hS)/100)*20+80);
		
		g.setColor(Color.red);
		g.fillRect(((int)(w*wS)/100)*20,((int)(h*hS)/100)*60,200,200);
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Game3",((int)(w*wS)/100)*20+30,((int)(h*hS)/100)*60+80);
		
		g.setColor(Color.red);
		g.fillRect(((int)(w*wS)/100)*60,((int)(h*hS)/100)*60,200,200);
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Game4",((int)(w*wS)/100)*60+30,((int)(h*hS)/100)*60+80);
		
		g.setColor(Color.green);
		g.fillRect(((int)(w*wS)/100)*50-250,((int)(h*hS)/100)*2,500,70);
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Score",((int)(w*wS)/100)*50-30,((int)(h*hS)/100)*2+50);
	}
	
	
}
