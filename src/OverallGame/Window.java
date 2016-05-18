package OverallGame;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Window is the class that holds the frame and handles all the variables of the frame's window size
 * 
 * @author Team 7
 * @version 5/17
 */

public class Window{

	//private static final long serialVersionUID = 1L;
	public static JFrame frame;
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static double SCALE;
	
	/**
	 * 
	 * @param title
	 * @param c
	 */
	public Window(String title,Controller c){
		frame = new JFrame(title);
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
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
		//Window.SCALE = 0.4;
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
	 * 
	 * @param actual
	 * @param virtual
	 * @return
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
