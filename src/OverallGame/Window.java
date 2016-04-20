package OverallGame;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;

import javax.swing.JFrame;

public class Window extends Canvas{

	//private static final long serialVersionUID = 1L;
	JFrame frame;
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static double scaleW,scaleH;
	

	public Window(String title,Controller c){
		frame = new JFrame(title);
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Dimension screenDimension = env.getMaximumWindowBounds().getSize();
		Insets insets = frame.getInsets();
		screenDimension.height = screenDimension.height-insets.bottom-insets.top;
		screenDimension.width = screenDimension.width-insets.left-insets.right;
		scaleW = screenDimension.getWidth()/1280;
		scaleH = screenDimension.getHeight()/720;
		frame.setPreferredSize(screenDimension);
		frame.setMaximumSize(screenDimension);
		frame.setMinimumSize(screenDimension);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(c);
		frame.setResizable(false);
		frame.setVisible(true);
		//System.out.println(screenDimension);
	}
}
