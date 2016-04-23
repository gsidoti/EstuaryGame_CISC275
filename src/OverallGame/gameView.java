package OverallGame;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;


public abstract class gameView {
	ArrayList<image> images= new ArrayList<image>();
	
	//public abstract void render(Graphics g);
	
    protected boolean createImage(String imgName,int frameCount){
    	//int currFrame = 0;
    	//int imgWidth;
    	//int imgHeight;
    	image i = new image(imgName);
    	
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File("images/orc/orc_animation/"+imgName+".png"));
    		i.image = bufferedImage;
    		images.add(i);
    		//imgWidth = bufferedImage.getWidth()/frameCount;
    		//imgHeight = bufferedImage.getHeight();
    		return true;
    	} catch (IOException e) {
    		System.out.println("Error at Image: "+imgName);
    		return false;
    		//e.printStackTrace();
    	}
    	//while(currFrame<frameCount){
    		//bufferedImage.getSubimage(currFrame*imgWidth, 0, bufferedImage.getWidth(), imgHeight)
    	//}
    }
}

class image{
	String name;
	Image image;
	
	public image(String name){
		this.name = name;
	}
	public String toString(){
		return this.name;
	}
}
