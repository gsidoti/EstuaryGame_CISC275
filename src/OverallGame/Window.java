package OverallGame;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;

import javax.swing.JFrame;

import com.sun.glass.ui.Window.Level;

public class Window extends Canvas{

	//private static final long serialVersionUID = 1L;
	JFrame frame;
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static double scaleW,scaleH;
	public static double SCALE;
	

	public Window(String title,Controller c){
		frame = new JFrame(title);
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Dimension screenDimension = env.getMaximumWindowBounds().getSize();
		Insets insets = frame.getInsets();
		screenDimension.height = screenDimension.height-insets.bottom-insets.top;
		screenDimension.width = screenDimension.width-insets.left-insets.right;
		Dimension scaledDimension = getScaledDimension(screenDimension,new Dimension(WIDTH,HEIGHT));//= new Dimension((int)(screenDimension.getHeight()*1.777778),screenDimension.height);
		SCALE = scaledDimension.getWidth()/1280.0;
		double d = scaledDimension.getHeight()/720.0;
		scaleW = screenDimension.getWidth()/1280;
		scaleH = screenDimension.getHeight()/720;
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
		System.out.println(1280.0*SCALE+ " "+ 720.0*SCALE);
		
		System.out.println(d);
		System.out.println(SCALE);
	}
	
	
	
	public static Dimension getScaledDimension(Dimension actual, Dimension virtual) {
		
		double aRatio = actual.getWidth()/actual.getHeight();
		double vRatio = virtual.getWidth()/virtual.getHeight();
		double fixedH = actual.getHeight();
		double fixedW = actual.getWidth();
		
		if(aRatio<vRatio){
			fixedW = actual.getWidth();
			fixedH = (actual.getWidth()/16)*9;
		}else if(aRatio>vRatio){
			fixedH = actual.getHeight();
			fixedW = actual.getHeight()*1.7777778;
		}
		return(new Dimension((int)fixedW,(int)fixedH));
		
/*
	    int original_width = imgSize.width;
	    int original_height = imgSize.height;
	    int bound_width = boundary.width;
	    int bound_height = boundary.height;
	    double new_width = original_width;
	    double new_height = original_height;

	    // first check if we need to scale width
	    if (original_width > bound_width) {
	        //scale width to fit
	        new_width = bound_width;
	        //scale height to maintain aspect ratio
	        new_height = (new_width * original_height) / original_width;
	    }

	    // then check if we need to scale even with the new height
	    if (new_height > bound_height) {
	        //scale height to fit instead
	        new_height = bound_height;
	        //scale width to maintain aspect ratio
	        new_width = (new_height * original_width) / original_height;
	    }

	    return new Dimension((int)new_width,(int) new_height);
	    */
	}
}
