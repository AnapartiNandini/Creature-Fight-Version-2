import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    //an integer constant instance variable called WIDTH initialized to 200 which can only be accessed in this class
    private final int WIDTH = 200;
    
    //an integer constant instance variable called HEIGHT initialized to 30 which can only be accessed in this class
    private final int HEIGHT = 30;
    
    //an image variable called frame which can only be accessed in this class
    private GreenfootImage frame;
    
    //an image variable called healthBar which can only be accessed in this class 
    private GreenfootImage healthBar;
    
    //a Color variable called good which can only be accessed in this class
    private Color good;
    
    //a Color variable called warning which can only be accessed in this class
    private Color warning;
    
    //a Color variable called danger which can only be accessed in this class
    private Color danger;
    
    //an integer variable called target which can only be accessed in this class
    private int target;
    
    //an integer variable called current which can only be accessed in this class
    private int current;
    
    //an integer variable called max which can only be accessed in this class
    private int max;
    
    //an integer variable called speed which can only accessed in this class
    private int speed;

    /**
     * Default constructor for objects of the HealthBar class
     * 
     * @param There are no parameters
     * @return an object of the HealthBar type
     */
    public HealthBar()
    {
        //frame is intialized to a new Greenfoot image where the parameters are WIDTH and HEIGHT
        frame = new GreenfootImage(WIDTH, HEIGHT);
        
        //healthBar is initialized to a new Greenfoot image where the parameters are WIDTH and HEIGHT
        healthBar = new GreenfootImage(WIDTH, HEIGHT);

        //the color of the frame is set to grey
        frame.setColor( Color.GRAY );
        
        //the shape of the frame is a rectangle. The fill of the frame has parameters 0,0,WIDTH and HEIGHT
        frame.fillRect(0, 0, WIDTH, HEIGHT);
        
        //the varable good is initialized to the color green
        good = Color.GREEN;
        
        //the variable warning is initialied to the color yellow
        warning = Color.YELLOW;
        
        //the variable danger is initialized to the color red
        danger = Color.RED;

        //the variable max is initialized to 1000
        max = 1000;
        
        //the variable current is initialized to 600
        current = 600;
        
        //the variable target is initialized to the variable ccurrent, specifically, the value of the variable current
        target = current;
        
        //the variable speed is initialized to 1
        speed = 1;
        
        //sends instruction to update the code with all the information written in this method
        updateBar();
    }

    /**
     * Constructor for objects of the HealthBar class that allows for customization
     * 
     * @param c is the current value of health
     * @param m is the maximum health amount
     * @param s is the speed the health bar's health with change at
     * @return an object of the HealthBar type
     */
    public HealthBar(int c, int m, int s)
    {
        //frame is initialized to a new greenfoot image with parameters WIDTH and HEIGHT
        frame = new GreenfootImage(WIDTH, HEIGHT);
        
        //healthBar is initialized to a new greenfoot image with parameters WIDTH and HEIGHT
        healthBar = new GreenfootImage(WIDTH, HEIGHT);

        //the color of the frame is set to grey
        frame.setColor( Color.GRAY );
        
        //the fill of the rectangle, which is the shape of the frame, has parameters of 0,0,WIDTH and HEIGHT
        frame.fillRect(0, 0, WIDTH, HEIGHT);
        
        //the variable good is initialized to the color green
        good = Color.GREEN;
        
        //the variable warning is initialized to the color yellow 
        warning = Color.YELLOW;
        
        //the variable danger is intialized to the color red
        danger = Color.RED;
        
        //the variable max is initialized to m
        max = m;
        
        //the variable current is initialized to c
        current = c;
        
        //the variable target is initialized to the variable ccurrent, specifically, the value of the variable current
        target = current;
        
        //the variable speed is initialized to s
        speed = s;
        
        //sends instruction to update the code with all the information written in this method
        updateBar();
    }

    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //if current is greater than target...
        if( current > target )
        {
            //current is equal to negative speed
            current -= speed;
            
            //if current is less than target...
            if( current < target )
            {
                //current is equal to target
                current = target;
            }
        }
        
        //otherwise
        else
        {
            //current is equal to positive speed
            current += speed;

            //if current is greater than target...
            if( current > target )
            {
                //current is equal to target
                current = target;
            }
        }
        
        //sends instruction to update the code with all the information written in this method
        updateBar();
    }

    /**
     * updateBar updates the image of the health bar when the current health
     * changes values
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void updateBar()
    {
        //a greenfoot image variable called text is initialized to a new greenfoot image with parameters WIDTH and HEIGHT 
        GreenfootImage text = new GreenfootImage(WIDTH, HEIGHT);
        
        //a double variable called ratio is initialized to the value of current divided by max (which are casted to a double) 
        double ratio = (double)current / (double)max;
        
        //an integer variable called healthWidth is initialized to the round of Math. Math is casted to an int and round has parameters where ratio is multiplied to the width of the frame
        int healthWidth = (int)Math.round(ratio*frame.getWidth());
        
        //if current is greater than max divided by 2...
        if( current > max / 2 )
        {
            //the color of the healthBar will be good
            healthBar.setColor( good );
        }
        
        //otherwise, if current is greater than max divided by 4...
        else if( current > max / 4 )
        {
            //the color of the healthBar will be warning
            healthBar.setColor( warning );
        }
        
        //otherwise
        else
        {
            //the color of the healthBar will be danger
            healthBar.setColor( danger );
        }
        
        //the healthBar is cleared
        healthBar.clear();
        
        //the fill of the healthBar, which has a rectangle shape, has parameters of 0, 0, healthWidth, and HEIGHT
        healthBar.fillRect( 0, 0, healthWidth, HEIGHT );
        
        //the text is cleared
        text.clear();
        
        //the color of the text is set to black
        text.setColor( Color.BLACK );
        
        //the fonot of the text is set to a new font of Times New Roman and a size of 20 pixles
        text.setFont( new Font( "Times New Roman", false, false, 20 ) );
        
        //the text displays the value of current and max which are seperateed by a slash, at 0 on the x-axis and value of HEIGHT subtracted by half the font size of the the text on the y-axis 
        text.drawString(current + " / " + max, 0, HEIGHT-text.getFont().getSize()/2);
        
        //the frame is cleared
        frame.clear();
        frame.setColor( Color.GRAY );
        frame.fillRect(0, 0, WIDTH, HEIGHT);
        frame.drawImage( healthBar, 0, 0 );
        frame.drawImage( text, WIDTH/3, 0 );

        setImage( frame );
    }

    /**
     * add will change the current value of the health in the health bar
     * 
     * @param change is the amount that the current health will be changed by
     * @return Nothing is returned
     */
    public void add( int change )
    {
        target += change;

        if( target > max )
        {
            target = max;
        }

        if( target < 0 )
        {
            target = 0;
        }
    }

    /**
     * setTarget will change the target value to whatever the user chooses
     * 
     * @param t is the new, user-chosen target value
     * @return Nothing is returned
     */
    public void setTarget( int t )
    {
        target = t;
    }

    /**
     * setCurrent will change the current value to whatever the user chooses
     * 
     * @param c is the new, user-chosen current value
     * @return Nothing is returned
     */
    public void setCurrent( int c )
    {
        current = c;
    }

    /**
     * setMax will change the maximum value to whatever the user chooses
     * 
     * @param m is the new, user-chosen maximum value
     * @return Nothing is returned
     */
    public void setMax( int m )
    {
        max = m;
    }

    /**
     * setSpeed will change the speed to whatever the user chooses
     * 
     * @param s is the new, user-chosen speed
     * @return Nothing is returned
     */
    public void setSpeed( int s )
    {
        speed = s;
    }

    /**
     * getMax returns the maximum value for use in other sections of code or for the user's information
     * 
     * @param There are no parameters
     * @return an integer representing the maximum value
     */
    public int getMax()
    {
        return max;
    }

    /**
     * getCurrent returns the current health value for use in other sections of code or for the user's information
     * 
     * @param There are no parameters
     * @return an integer representing the current health value
     */
    public int getCurrent()
    {
        return current;
    }
    
    /**
     * getTarget returns the target health value for use in other sections of code or for the user's information
     * 
     * @param There are no parameters
     * @return an integer representing the target health value
     */
    public int getTarget()
    {
        return target;
    }

}
