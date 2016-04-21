package OverallGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.imageio.ImageIO;


public abstract class gameView {
	ArrayList<image> images= new ArrayList<image>();
	AffineTransform at;
	
	public abstract void render(Graphics g);
	
    private boolean createImage(String imgName,int frameCount){
    	int currFrame = 0;
    	int imgWidth;
    	int imgHeight;
    	image i = new image(imgName);
    	
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File("images/orc/orc_animation/"+imgName+".png"));
    		imgWidth = bufferedImage.getWidth()/frameCount;
    		imgHeight = bufferedImage.getHeight();
    	} catch (IOException e) {
    		System.out.println("Error at Image: "+imgName);
    		e.printStackTrace();
    	}
    	while(currFrame<frameCount){
    		//bufferedImage.getSubimage(currFrame*imgWidth, 0, bufferedImage.getWidth(), imgHeight)
    	}
    	images.add(i);
    	return true;
    }
}

class image{
	String name;
	ArrayList<Image> frame = new ArrayList<Image>();
	
	public image(String name){
		this.name = name;
	}
	public String toString(){
		return this.name;
	}
}
