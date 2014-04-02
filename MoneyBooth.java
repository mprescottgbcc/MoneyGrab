import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MoneyBooth here.
 * 
 * @author Meg Prescott 
 * @version 1.0
 */
public class MoneyBooth extends World
{
    private final int MAX_BILLS = 100;
    private int[] denominations;
    private Scoreboard scoreboard;
    private CountdownClock clock;
    public static final int SPEED = 50;

    /**
     * Constructor for objects of class TestWorld.
     * 
     */
    public MoneyBooth()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        int[] vals = { 1,5,10,20,50,100 };
        denominations = vals;
        Greenfoot.setSpeed(SPEED);
        prepare();
        
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Money bill;
        int index;
        //Create MAX_BILLS dollar bills of random denominations and place in random locations and random angles
        for(int i=0; i<MAX_BILLS; i++)
        {
            //get a random int for index of the denomiations array
            index = Greenfoot.getRandomNumber(denominations.length);
            bill = new Money(denominations[index]);
            bill.turn(Greenfoot.getRandomNumber(91)-45);
            addObject(bill, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getWidth()));
        }

        scoreboard = new Scoreboard();
        addObject(scoreboard, getWidth()-50, getHeight()-25);
        clock = new CountdownClock();
        addObject(clock, 50, getHeight()-25);
    }

    /**
     * Accept a dollar value from a Money object to add to the cash in the scoreboard
     * @param int dollarValue
     */
    public void updateScoreboard(int dollarValue)
    {
        scoreboard.addCash(dollarValue); 
    }
    
    /**
     * Decide how the world will end the game
     */
    public void endGame()
    {
        int bonusSeconds = clock.getSeconds();
        Greenfoot.stop();
    }
}



