import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creature extends Actor
{
    //a private HealthBar instance variable called creatureBar
    private HealthBar creatureBar;
    
    //a private integer instance variable called healthNumber
    private int healthNumber;
    
    //a private integer instance variable called playerOwnership
    private int playerOwnership;
    
    //TODO (45): Declare a String instance variable called type
    //a String instance variable called type
    private String type;

    /**
     * Default constructor for objects of the Creature class
     * 
     * @param There are no parameters
     * @return an object of the Creature class
     */
    public Creature()
    {
        //the healthNumber variable is initialized to 500
        healthNumber = 500;
        
        //the playerOwnership variable is initialized to 0
        playerOwnership = 0;
        
        //the creatureBar variable is initialized to a new HealthBar object with the parameters as healthNumber,healthNumber, and 10
        creatureBar = new HealthBar(healthNumber, healthNumber, 10);
    }

    /**
     * Constructor that allows customization of objects of the Creature class
     * 
     * @param health is the amount of health the Creature object will have
     * @param whichPlayer discusses whether the creature belongs to player 1 or player 2
     * @param creatureType is a string parameter. It discusses if the method uses a Charmader object or a Pickachu object based on where this prameter is used 
     * @return an object of the Creature class
     */
    //TODO (46): Add a third parameter to this method signature, a String parameter called creatureType (change the method comment block accordingly)
    public Creature( int health, int whichPlayer, String creatureType)
    {
        //the healthNumber variable is initialized to health
        healthNumber = health;
        
        //the playerOwnership variable is initialized to whichPlayer
        playerOwnership = whichPlayer;
        
        //the creatureBar variable is initialized to a new HealthBar object with the parameters as healthNumber, healthNumber, and 10
        creatureBar = new HealthBar(healthNumber, healthNumber, 10);
        
        //TODO (47): Initialize the type variable to the creatureType parameter
        //type is initialized to the creatureType (String)parameter
        type = creatureType;
    }
    
    /**
     * act will complete actions that the Creature object should
     * accomplish while the scenario is running
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act() 
    {
        //empty method that will get overridden in subclasses
    }
    
    /**
     * TODO (50): Declare a public method called attack that does not
     *            return anything and has an integer parameter called idx
     *            
     * TODO (51): Inside the method, put a comment stating that attack is an
     *            "empty method that will get overridden in subclasses
     */
    /**
     * attack is an empty method which will be overridden in subclasses as well as, it is 
     * for use in other parts of the code or for the user's information
     * 
     * @param an integer parameter reffered to as idx is the only parameter
     * @return Nothing is returned
     */
    public void attack(int idx)
    {
        //empty method that will get overridden in subclasses
    }

    /**
     * getHealthBar returns the health bar for this creature
     * for use in other parts of the code or for the user's information
     * 
     * @param None There are no parameters
     * @return A HealthBar object that corresponds to the health bar
     *         for this creature
     */
    protected HealthBar getHealthBar()
    {
        //returns creatureBar
        return creatureBar;
    }

    /**
     * getPlayerOwner states whether the creature is owned by player
     * one or player two
     * 
     * @param None There are no parameters
     * @return An integer that represents which player this Creature belongs to
     */
    public int getPlayerOwner()
    {
        //returns playerOwner
        return playerOwnership;
    }
    
    /**
     * TODO (52): Declare a protected method called getType that returns a
     *            String and has no parameters
     * 
     * TODO (53): Inside the method, return the type of the Creature
     */
    
    /**
     * getType states which creature type the creature is as in, either a Charmander object or a Pikachu object. 
     * It is for use in other parts of the code or for the user's information
     * 
     * @param None There are no parameters
     * @return a string that represents which type the creature belongs to as in, either a Charmander object or a Pikachu object
     */
    protected String getType()
    {
        //returns the type of the creature
        return type; 
    }
}
