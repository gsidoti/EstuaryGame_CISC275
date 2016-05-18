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
		//Dimension screenDimension = env.getMaximumWindowBounds().getSize();
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		Insets insets = frame.getInsets();
		System.out.println("I:"+insets.bottom+" "+insets.top+" "+insets.left+" "+insets.right);
		screenDimension.height = screenDimension.height-insets.bottom-insets.top;
		screenDimension.width = screenDimension.width-insets.left-insets.right;
		Dimension scaledDimension = getScaledDimension(screenDimension,new Dimension(WIDTH,HEIGHT));
		SCALE = scaledDimension.getWidth()/1280.0;
		if(gd.isFullScreenSupported()){
			//screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
			frame.setUndecorated(true);
			gd.setFullScreenWindow(frame);
		}else{
			System.err.println("Full screen not supported");
			GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
			screenDimension = env.getMaximumWindowBounds().getSize();
			
		}
		//unnecessary apple full-screen functions
		//com.apple.eawt.FullScreenUtilities.setWindowCanFullScreen(frame,true);
		//com.apple.eawt.Application.getApplication().requestToggleFullScreen(frame);
	    frame.getRootPane().putClientProperty("apple.awt.fullscreenable", Boolean.valueOf(true));
		frame.setPreferredSize(scaledDimension);
		frame.setMaximumSize(scaledDimension);
		frame.setMinimumSize(scaledDimension);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(c);
		frame.setResizable(false);
		frame.setVisible(true);

		System.out.println(screenDimension);
		System.out.println(scaledDimension);
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
