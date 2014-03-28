import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Money object will pop around the screen until the user clicks on it at which point the dollar amount goes up.
 * 
 * @author Meg Prescott 
 * @version 1.0
 */
public class Money extends Actor
{
    private int dollarValue;

    /**
     * No-arg Constructor
     */
    public Money()
    {
        this(1);
    }

    /**
     * Constructor
     * @param int value Dollar value for this money object
     */
    public Money(int value)
    {
        dollarValue = value;   
    }

    /**
     * Act - do whatever the Money wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        fly();
        if (isGrabbed())
        {
            getWorld().removeObject(this);
        }
    }

    public boolean isGrabbed()
    {
        return Greenfoot.mouseClicked(this);
    }

    public void fly()
    {
        if(Greenfoot.getRandomNumber(100)>69)
        {
            turn(Greenfoot.getRandomNumber(91)-45);
        }

        checkForEdge();

        move(Greenfoot.getRandomNumber(10)+1);
    }

    public void checkForEdge()
    {
        int maxX = getWorld().getWidth() - 10;   //Highest X-value a money object can have
        int maxY = getWorld().getHeight() - 10;   //Hightest Y-value a money object can have
        
        //check to see if getting too close to the right edge
        if(getX() > maxX)
        {  turnTowards(0, getY()); }

        //check to see if getting too close to the left edge
        if(getX() < 10)
        {  turnTowards(maxX, getY()); }

        //check to see if getting too close to the bottom edge
        if(getY() > maxY)
        {  turnTowards(getX(), 0); }

        //check to see if getting too close to the left edge
        if(getY() < 10)
        {  turnTowards(getX(), maxY); }

    }
}
