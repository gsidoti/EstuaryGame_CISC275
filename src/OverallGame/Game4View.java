package OverallGame;

import java.awt.Color;
import java.awt.Graphics;

public class Game4View{
	G4Player player;
	
	public Game4View(G4Player player){
		this.player = player;
	}
	
	public void update(G4Player player){
		this.player = player;
	}
	public void render(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, (int)(Window.WIDTH*Window.scaleW), (int)(Window.HEIGHT*Window.scaleH));
		g.setColor(Color.blue);
		g.fillRect(player.x,player.y,100,100);
		g.setColor(Color.green);
		g.fillRect(1300, 75, 50, 150);
		g.setColor(Color.red);
		g.fillRect(1355, 75, 50, 150);
	}
	
	
	
}