package OverallGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public class Controller extends Canvas implements Runnable{

<<<<<<< HEAD:src/OverallGame/Game.java
	//this is a test
	private static final long serialVersionUID = -7182677228034972627L;

	public static final int WIDTH = 640, HEIGHT = WIDTH/12 * 9;
=======
	private static final long serialVersionUID = -7182677228034972627L
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WIDTH	=	(int)(screenSize.getWidth());
	public static final int HEIGHT	=	WIDTH/12*9;
>>>>>>> ae0cbdc5b45120404a55b876ed6adc80d5e35d83:src/OverallGame/Controller.java
	
	private Thread thread;
	private boolean running;

	public Controller(){
		new Window(WIDTH, HEIGHT, "Estuary Game", this);
	}
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;	
	}
	
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();	
		}
	}
	
	@Override
	public void run() {
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
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.gray);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.dispose();
		bs.show();
	}
	
	
	private void tick(){
		
	}

	public static void main(String[] args) {
		new Controller(); 
	}

}
