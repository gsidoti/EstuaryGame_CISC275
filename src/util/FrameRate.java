
/**
 * Write a description of class FrameRate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 
package util;

public class FrameRate {

    private String frameRate;
    private long lastTime;
    private long delta;
    private int frameCount;

    public void initialize() {
        lastTime = System.currentTimeMillis();
        frameRate = "FPS 0";
    }

    public void calculate() {
        long current = System.currentTimeMillis();
        delta += current-lastTime;
        lastTime = current;
        frameCount++;
        if( delta > 1000 ) {
            delta -= 1000;
            frameRate = String.format( "FPS %s", frameCount );
            frameCount = 0;
        }
    }
    
    public String getFrameRate() {
        return frameRate;
    }
}