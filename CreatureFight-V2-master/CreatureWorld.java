/**
 * TODO (75): Add an assignment comment block below...
 * 
 * Name: Nandini Anaparti
 * Course: Software Development
 * Teacher: Mr.Scott Hardman
 * Date Last Modified: 11/22/2018
 */

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

////TODO (1): Import the javax.swing.JOptionPane library
import javax.swing.JOptionPane;
/**
 * Write a description of class CreatureWorld here.
 * 
 * CreatureWorld sets up the world with all the creature objects which references the playerOneObject,the playerTwoObject, their respective buttons, and the text 
 * associated to them.
 * 
 * @param None There are no parameters
 * @return Nothing is Returned
 * 
 * @author (Nandini Anaparti) 
 * @version (Date Last Modified: 11/22/2018)
 */
public class CreatureWorld extends World
{
    private Creature playerOneCreature;
    private Creature playerTwoCreature;
    
    //TODO (2): Declare an integer instance variable called turnNumber
    //an integer instance variable called turnNumber
    int turnNumber;
    
    //TODO (3): Declare a Menu instance variable called oneFightMenu
    //a Menu instance variable called oneFightMenu
    Menu oneFightMenu;
    
    //TODO (4): Declare a Menu instance variable called oneSwitchMenu
    //a Menu instance variable called oneSwitchMenu
    Menu oneSwitchMenu;
    
    //TODO (5): Declare a Menu instance variable called twoFightMenu
    //a Menu instance variable called twoFightMenu
    Menu twoFightMenu;
    
    //TODO (6): Declare a Menu instance variable called twoSwitchMenu
    //a Menu instance variable called twoSwitchMenu
    Menu twoSwitchMenu;
    
    //TODO (7): Declare a String instance variable called playerOneName initialized to "1"
    //a String instance variable called playerOneName initialized to "1"
    String playerOneName = "1";
    
    //TODO (8): Declare a String instance variable called playerTwoName initialized to "2"
    //a String instance variable called playerTwoName initialized to "2"
    String playerTwoName = "2";

    /**
     * Default constructor for objects of class CreatureWorld.
     * 
     * @param None There are no parameters
     * @return an object of class CreatureWorld
     */
    public CreatureWorld()
    {    
        // Create a new world with 400x400 cells with a cell size of 1x1 pixels.
        super(400, 400, 1);
        
        //playerOneCreature is initialzed to a new Charmander object using the parameter, this
        playerOneCreature = new Charmander(this);
        
        //playerTwoCreature is initialzed to a new Pikachu object using the parameter, this
        playerTwoCreature = new Pikachu(this);
        
        //calls the prepareCreatures method
        prepareCreatures();
        
        //TODO (9): Initialize the turnNumber variable to 0
        //integer variable turnNumber is initialized to 0
        turnNumber = 0;
        
        //starts the scenario
        Greenfoot.start();
    }
    
    /**
     * act will complete actions that the CreatureWorld object should
     * accomplish while the scenario is running
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
        //allObjects is a List variable which is initialized to getObjects  with null as the parameter
        List allObjects = getObjects(null);

        //TODO (10): If the turn number is equal to zero...
        //If the turn number is equal to zero...
        if(turnNumber == 0)
        {
            //TODO (73): Initialize the playerOneName variable by using a JOptionPane showInputDialog that uses null, a message to let the user know what to enter, a title for the input box, and JOptionPane.QUESTION_MESSAGE as parameters
            //Initialize the playerOneName variable by using a JOptionPane showInputDialog that uses null, a message to let the user know what to enter, a title for the input box, and JOptionPane.QUESTION_MESSAGE as parameters
            playerOneName = JOptionPane.showInputDialog(null,"Player One Name","Pokemon",JOptionPane.QUESTION_MESSAGE);
            
            //TODO (74): Initialize the playerTwoName variable by using a JOptionPane showInputDialog that uses null, a message to let the user know what to enter, a title for the input box, and JOptionPane.QUESTION_MESSAGE as parameters
            //Initialize the playerTwoName variable by using a JOptionPane showInputDialog that uses null, a message to let the user know what to enter, a title for the input box, and JOptionPane.QUESTION_MESSAGE as parameters
            playerTwoName = JOptionPane.showInputDialog(null,"Player Two Name","Pokemon",JOptionPane.QUESTION_MESSAGE);

            //TODO (11): Initialize the oneFightMenu variable to a new Menu object with " Fight ", " Scratch \n Flamethrower ", 24, BLACK, WHITE, BLACK, WHITE, and a new FightCommands() object as parameters
            //Initialize the oneFightMenu variable to a new Menu object with " Fight ", " Scratch \n Flamethrower ", 24, BLACK, WHITE, BLACK, WHITE, and a new FightCommands() object as parameters
            oneFightMenu = new Menu(" Fight ", " Scratch \n Flamethrower ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands()); 
            
            //TODO (12): Initialize the oneSwitchMenu variable to a new Menu object with " Switch ", " Golem \n Ivysaur ", 24, BLACK, WHITE, BLACK, WHITE, and a new SwitchCommands() object as parameters
            //Initialize the oneSwitchMenu variable to a new Menu object with " Switch ", " Golem \n Ivysaur ", 24, BLACK, WHITE, BLACK, WHITE, and a new SwitchCommands() object as parameters
            oneSwitchMenu = new Menu(" Switch ", " Golem \n Ivysaur ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());

            //TODO (13): Add the oneFightMenu at an x location of 173 and a y location of 100 pixels less than the height
            //Add the oneFightMenu at an x location of 173 and a y location of 100 pixels less than the height
            addObject(oneFightMenu, 173, getHeight() - 100);
            
            //TODO (14): Add the oneSwitchMenu at an x location of 241 and a y location of 100 pixels less than the height
            //Add the oneSwitchMenu at an x location of 241 and a y location of 100 pixels less than the height
            addObject(oneSwitchMenu, 241, getHeight() - 100);

            //TODO (15): Initialize the twoFightMenu variable to a new Menu object with " Fight ", " Tackle \n Thunderbolt ", 24, BLACK, WHITE, BLACK, WHITE, and a new FightCommands() object as parameters
            //Initialize the twoFightMenu variable to a new Menu object with " Fight ", " Tackle \n Thunderbolt ", 24, BLACK, WHITE, BLACK, WHITE, and a new FightCommands() object as parameters
            twoFightMenu = new Menu(" Fight ", " Tackle \n Thunderbolt ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
            
            //TODO (16): Initialize the twoSwitchMenu variable to a new Menu object with " Switch ", " Lapras \n Pidgeot ", 24, BLACK, WHITE, BLACK, WHITE, and a new SwitchCommands() object as parameters
            //Initialize the twoSwitchMenu variable to a new Menu object with " Switch ", " Lapras \n Pidgeot ", 24, BLACK, WHITE, BLACK, WHITE, and a new SwitchCommands() object as parameters
            twoSwitchMenu = new Menu(" Switch ", " Lapras \n Pidgeot ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());

            //TODO (17): Add the twoFightMenu at an x location of 131 and a y location of 75
            //Add the twoFightMenu at an x location of 131 and a y location of 75
            addObject(twoFightMenu, 131, 75);
            
            //TODO (18): Add the twoSwitchMenu at an x location of 199 and a y location of 75
            //Add the twoSwitchMenu at an x location of 199 and a y location of 75
            addObject(twoSwitchMenu, 199,75);

            //TODO (19): Set turnNumber to 1
            //turnNumber is an integer variable initialized to 1
            turnNumber = 1;
        }
        //TODO (20): Otherwise, if turnNumber is equal to 1...
        //Otherwise, if turnNumber is equal to 1...
        else if(turnNumber == 1)
        {
            //TODO (21): Use the showText method to display player one's name and the fact that it is their turn in the middle of the world
            //Displays that it is Carmander's turn at the center of the world by getting the width of the world and dividing it by two, and getting the height of the world and dividing it by two
            showText("Charmander, \n It is your turn ", getWidth()/2, getHeight()/2);  
        }
        //TODO (22): Otherwise...
        //Otherwise...
        else
        {
            //TODO (23): Use the showText method to display player two's name and the fact that it is their turn in the middle of the world
            //Displays that it is Pikachu's turn at the center of the world by getting the width of the world and dividing it by two, and getting the height of the world and dividing it by two
            showText("Pikachu, \n It is your turn",getWidth()/2, getHeight()/2);
        }
        
        //if the current HealthBar value of playerOneCreature is less than or equal to 0...
        if( playerOneCreature.getHealthBar().getCurrent() <= 0 )
        {
            //remove all the objects related to that specific class
            removeObjects(allObjects);
            
            //TODO (24): Change this showText to display player one's name instead of "Player One"
            //Changes the text to display player one's name instead of "Player One"
            showText("Charmander Has Lost", getWidth()/2, getHeight()/2);
            
            //the scenario stops, as in ends
            Greenfoot.stop();
        }
        
        //if the current HealthBar value of playerTwoCreature is less than or equal to 0...
        if( playerTwoCreature.getHealthBar().getCurrent() <= 0 )
        {
            //remove all the objects related to the specific creature
            removeObjects(allObjects);
            
            //TODO (25): Change this showText to display player two's name instead of "Player Two"
            //Changes the text to display player two's name instead of "Player Two"
            showText("Pikachu Has Lost", getWidth()/2, getHeight()/2);
            
            //the scenario stops, as in ends
            Greenfoot.stop();
        }
    }

    /**
     * prepareCreatures adds the creatures for both players to the world
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void prepareCreatures()
    {
        //adds a playerOneCreature object in the left bottom corner of the window
        addObject( playerOneCreature, playerOneCreature.getImage().getWidth()/2, getHeight() - playerOneCreature.getImage().getHeight()/2);
        
        //adds a playerTwoCreature object in the top right corner of the window
        addObject( playerTwoCreature, getWidth() - playerTwoCreature.getImage().getWidth()/2, playerTwoCreature.getImage().getHeight()/2);
    }
    
    /**
     * getPlayerOne returns player one's current creature for
     * use in other parts of the code or for the user's information
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    public Creature getPlayerOne()
    {
        //returns a playerOneCreature
        return playerOneCreature;
    }

    /**
     * getPlayerTwo returns player two's current creature for
     * use in other parts of the code or for the user's information
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    public Creature getPlayerTwo()
    {
        //returns a playerTwoCreature
        return playerTwoCreature;
    }

    /**
     * TODO (26): Declare a public method called getTurnNumber that returns an
     *            integer and has no parameters
     *            
     * TODO (27): Inside this method, return the turn number
     */
    
    /**
     * getTurnNumber returns which creature turn it currently is 
     * for use in other parts of the code or the user's information
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    public int getTurnNumber()
    {
        //returns a turnNumber (int) variable
        return turnNumber;
    }

    /**
     * TODO (28): Declare a public method called setTurnNumber that does not
     *            return anything and has an integer parameter called turn
     *            
     * TODO (29): Inside the method, set the turn number variable to the turn parameter
     */
    
    /**
     * setTurnNumber sets the turnNumber to whichever creature's turn it is currently
     * for use in other parts of the code or the user's information
     */
    public void setTurnNumber(int turn)
    {
        //sets turnNumber to equal to the turn (int) variable
        turnNumber = turn;
    }
}
