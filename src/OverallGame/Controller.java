package OverallGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferStrategy;
import java.io.*;


public class Controller extends Canvas{

	private static final long serialVersionUID = 1L;
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WIDTH =	(int)(screenSize.getWidth());
	public static final int HEIGHT = WIDTH/16*9;

	private Thread thread;
	private boolean running = false;
	
	private Menu menu;
	private MenuView menuView;
	private Game4 game4;
	
	public static STATE gameState = STATE.Menu;

	private Controller(){
		Window w = new Window(WIDTH, HEIGHT, "Estuary Game");
		w.frame.add(this);
		w.frame.setVisible(true);
		menu = new Menu(w.frame);
		//game1 = new Game1();
		//game2 = new Game2();
		//game3 = new Game3();
		game4 = new Game4();
		this.addMouseListener(menu);
		this.start();
		this.run();
	}
	
	private synchronized void start(){
		thread = new Thread(String.valueOf(this));
		thread.start();
		running = true;	
	}
	
	private synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();	
		}
	}
	
	private void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			if(running)
				render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
		stop();
	}
	

	private void tick(){
		//System.out.println("Tick");
		switch(gameState){
		case Menu:
			gameState = menu.tick();
			break;
		case Game1:
			break;
		case Game2:
			break;
		case Game3:
			break;
		case Game4:
			break;
		}
	}
	
	private void render(){
		//System.out.println("Render");
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();	
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		switch(gameState){
		case Menu:
			menu.menuView.render(g);
			break;
		case Game1:
			break;
		case Game2:
			break;
		case Game3:
			break;
		case Game4:
			System.out.println("Game4");
			break;
		}
		g.dispose();
		bs.show();
	}
	

	public static void main(String[] args) {
		new Controller(); 
	}

}
