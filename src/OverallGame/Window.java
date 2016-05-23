package OverallGame;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Window is the class that holds the frame and handles all the variables of the frame's window size
 * 
 * @author Team 7
 * @version 5/17
 */

public class Window{
	public static JFrame frame;
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public Dimension screenDimension;
	public static double SCALE;
	
	/**
	 * Constructor for Window objects
	 * 
	 * @param title title of the window
	 * @param c controller of the window
	 */
	public Window(String title,Controller c){
		frame = new JFrame(title);
		screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		Dimension scaledDimension = getScaledDimension(screenDimension,new Dimension(WIDTH,HEIGHT));
		if(gd.isFullScreenSupported()){
			screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
			frame.setUndecorated(true);
			gd.setFullScreenWindow(frame);
		}else{
			System.err.println("Full screen not supported");
			GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
			screenDimension = env.getMaximumWindowBounds().getSize();
			scaledDimension = getScaledDimension(screenDimension,new Dimension(WIDTH,HEIGHT));
			frame.getRootPane().putClientProperty("apple.awt.fullscreenable", Boolean.valueOf(true));
		}	
		SCALE = scaledDimension.getWidth()/1280.0;
		frame.setPreferredSize(scaledDimension);
		frame.setMaximumSize(scaledDimension);
		frame.setMinimumSize(scaledDimension);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(c);
		frame.setResizable(false);
		frame.setVisible(true);
		
		
		System.out.println("Actual Screen Dimension: X:"+screenDimension.getWidth()+" Y: "+screenDimension.getHeight());
		System.out.println("Scaled Screen Dimension: X:"+scaledDimension.getWidth()+" Y: "+scaledDimension.getHeight());
	}
	
	/**
	 * Takes actual and virtual dimensions and returns fixed dimensions for the window
	 * 
	 * @param actual the actual dimensions of the window
	 * @param virtual the virtual dimensions of the window
	 * @return Returns the fixed dimensions for the window
	 */
	public static Dimension getScaledDimension(Dimension actual, Dimension virtual) {
		
		double aRatio = actual.getWidth()/actual.getHeight();
		double vRatio = virtual.getWidth()/virtual.getHeight();
		double fixedH = actual.getHeight();
		double fixedW = actual.getWidth();
		
		if(aRatio<vRatio){
			fixedW = actual.getWidth();
			fixedH = (actual.getWidth()/16.0)*9.0;
		}else if(aRatio>vRatio){
			fixedH = actual.getHeight();
			fixedW = actual.getHeight()*(16.0/9.0);
		}
		return(new Dimension((int)fixedW,(int)fixedH));
	}
}
