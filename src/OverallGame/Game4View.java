package OverallGame;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Game4View {
	int WIDTH, HEIGHT;
	JFrame frame;
	int px;
	int py;
	
	public Game4View(int w, int h){
		this.WIDTH = w;
		this.HEIGHT = h;
	}
	
	
	public void render(Graphics g){
		g.setColor(Color.green);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.blue);
		g.fillRect(px,py,100,100);
	}
	
	
}