package OverallGame;

import java.awt.Canvas;


public class OverallGame extends Canvas implements Runnable{


	private static final long serialVersionUID = -7182677228034972627L;

	public static final int WIDTH = 640, HEIGHT = WIDTH/12 * 9;
	
	private Thread thread;
	priavte boolean running;

	public OverallGame(){
		new Window(WIDTH, HEIGHT, "Estuary Game", this);
	}
	
	public synchronized void start(){
		new Thread(this).start();
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
		
		
	}

	public static void main(String[] args) {
		new OverallGame(); 
	}

}
