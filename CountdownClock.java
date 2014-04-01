import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

/**
 * Write a description of class CountdownClock here.
 * 
 * @author Meg Prescott
 * @version 1.0
 */
public class CountdownClock extends Actor
{
    private final int WIDTH = 100;
    private final int HEIGHT = 50;
    private final float FONT_SIZE = 22.0f;
    private String display;

    public CountdownClock()
    {
        display = "1:00";
        updateImage();
    }
    
    public void act()
    {
        updateImage();
    }
    

    public void updateImage()
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        image.setColor(new Color(0, 0, 0, 160));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(255, 255, 255, 100));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(display, 10, (HEIGHT/2)+(((int)FONT_SIZE)/4));
        setImage(image);

    }
}
