import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * Write a description of class Charmander here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Charmander extends Creature
{
    /**
     * Constructor for objects of class Charmander
     * 
     * @param w is a reference to the world that Charmander gets added to
     * @return An object of type Charmander
     */
    public Charmander(World w)
    {
        //TODO (48): Add a third parameter of Fire to this super line
        super(700, 1, "Fire");
        
        //the charmander object is scaled to 150 pixles on the x-axis and 100 pixles on the y-axis
        getImage().scale(150, 100);
        
        //add a world object which is a HealthBar object at 300 pixles on the x-axis and 50 pixles from the total height of the world
        w.addObject( getHealthBar() , 300, w.getHeight() - 50 );
    }
    
    /**
     * Act - do whatever the Charmander wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //a CreatureWorld object called playerWorld which stores a reference to CreatureWorld
        CreatureWorld playerWorld = (CreatureWorld)getWorld();
        
        //if the current HealthBar value is less than on equal to 0...
        if( getHealthBar().getCurrent() <= 0 )
        {
            //In the world, show the text that Charmander has fainted in the center of the world width and the world height plus 26
            getWorld().showText("Charmander has fainted...", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
            
            //delay the actions by 30 runs of the act cycle
            Greenfoot.delay(30);
        }
    }
    
    /**
     * TODO (55): Declare a public method called attack that does not return
     *            anything and has an integer parameter called idx
     *            
     * TODO (56): Declare a local CreatureWorld variable called playerWorld that stores a reference to the CreatureWorld
     * 
     * TODO (57): Declare a local Creature variable called enemy that is initialized to player two's creature (you will need to use the getPlayerTwo method of playerWorld)
     * 
     * TODO (58): Declare a local String variable called enemyType that is initialized to the enemy's type (you will need to use the getType method of enemy)
     * 
     * TODO (59): If the idx parameter is equal to 0...
     * 
     *      TODO (60): The user has chosen Scratch, so add -25 points of health to the enemy's health bar (you will need to use the add method of health bar and use the getHealthBar method of enemy to do this)
     *      
     * TODO (61): Otherwise...
     * 
     *      TODO (62): The user has chosen Flamethrower, so add -70 points of health to the enemy's health bar
     *      
     * TODO (63): Set the turn number to player two's turn (Use the setTurnNumber method of playerWorld to change the turn number to 2)
     */
    
    public void attack(int idx)
    {
        //a local CreatureWorld variable called playerWorld that stores a reference to the CreatureWorld
        CreatureWorld playerWorld = (CreatureWorld)getWorld();
        
        //a local Creature variable called enemy that is initialized to player two's creature
        Creature enemy = playerWorld.getPlayerTwo();
        
        //a local String variable called enemyType that is initialized to the enemy's type
        String enemyType = enemy.getType();
        
        //if the idx parameter is equal to 0...
        if (idx == 0)
        {
            //Scratch has been chosen, so add -25 points of health to the enemy's health bar 
            enemy.getHealthBar().add(-25);
        }
        //otherwise....
        else
        {
            //Flamethrower has been chosen, so add -70 points of health to the enemy's health bar
            enemy.getHealthBar().add(-70);       
        }
        
        //Set the turn number to player two's turn
        playerWorld.setTurnNumber(2);
    }
}
