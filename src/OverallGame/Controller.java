package OverallGame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Controller implements Runnable {

	//this is a test
	private static final long serialVersionUID = -7182677228034972627L;

	public static final int WIDTH = 640, HEIGHT = WIDTH/12 * 9;
	private gameframe frame;
	private Thread thread;
	private boolean running;

	public Controller(){
		frame = new gameframe();
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
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				long lastTime = System.nanoTime();
//				double amountOfTicks = 60.0;
//				double ns = 1000000000 / amountOfTicks;
//				double delta = 0;
//				long timer = System.currentTimeMillis();
//				int updates = 0;
//				int frames = 0;
//				try {
//					gameframe frame = new gameframe();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				while(running){
//					long now = System.nanoTime();
//					delta += (now - lastTime) / ns;
//					lastTime = now;
//					while(delta >= 1){
//						tick();
//						updates++;
//						delta--;
//					}
//					if(running)
//						frame.render();
//					frames++;
//					
//					if(System.currentTimeMillis() - timer > 1000){
//						timer += 1000;
//						System.out.println("FPS: " + frames + " TICKS: " + updates);
//						frames = 0;
//						updates = 0;
//					}
//				}
//				stop();
//			}
//		});
//	}
	

	
	private void tick(){
		
	}
	
	@Override
	public void run() {
		
		try {
			gameframe frame = new gameframe();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					gameframe frame = new gameframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}