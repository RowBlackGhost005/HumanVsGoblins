package Engine;

import Entities.Entity;
import Entities.Goblin;

/**
 * Game class holds the game state and acts as the orchestrator of the game.
 * It connects the user input with the user game events and world movement.
 */
public class Game {

    private WorldGen world;
    private boolean stillAlive;
    private Combat activeCombat;

    /**
     * Creates a new Game objects and initializes a new playable world.
     */
    public Game() {
        stillAlive = true;
        world = new WorldGen();
    }

    /**
     * Manages the movement of the player in the world based on the parameter given.
     * @param moveDirection Direction to move (W | A | S | D)
     */
    public void move(char moveDirection){
        switch(moveDirection){
            case 'w':
                moveNorth();
                break;

            case 's':
                moveSouth();
                break;

            case 'd':
                moveEast();
                break;

            case 'a':
                moveWest();
                break;
        }
    }

    /**
     * Displays the Map of the game.
     */
    public void showMap(){
        world.printWorld();
    }

    /**
     * Moves the player at the North Land based on its position and manages the events triggered by an entity
     * if there is any in the Land to move
     */
    public void moveNorth() {
        Entity entity = world.peakNorth();

        if(entity != null){
            handleEntity(entity);
        }

        world.moveNorth();
    }

    /**
     * Moves the player at the East Land based on its position and manages the events triggered by an entity
     * if there is any in the Land to move
     */
    public void moveEast() {
        //Ask to peak
        Entity entity = world.peakEast();

        //Check if there is something
        if(entity != null){
            handleEntity(entity);
        }

        //If all good, move
        world.moveEast();
    }

    /**
     * Moves the player at the South Land based on its position and manages the events triggered by an entity
     * if there is any in the Land to move
     */
    public void moveSouth() {
        //Ask to peak
        Entity entity = world.peakSouth();

        //Check if there is something
        if(entity != null){
            handleEntity(entity);
        }

        //If all good, move
        world.moveSouth();
    }

    /**
     * Moves the player at the West Land based on its position and manages the events triggered by an entity
     * if there is any in the Land to move
     */
    public void moveWest() {
        //Ask to peak
        Entity entity = world.peakWest();

        //Check if there is something
        if(entity != null){
            handleEntity(entity);
        }

        //If all good, move
        world.moveWest();
    }

    /**
     * Returns weather the player is still alive or not.
     * @return True if the player is still alive, False otherwise.
     */
    public boolean isStillAlive(){
        return stillAlive;
    }

    /**
     * Returns weather a combat is active or not.
     * @return True if a combat is active, False otherwise.
     */
    public boolean isInCombat(){
        return this.activeCombat != null;
    }

    /**
     * Returns the active combat.
     * @return Combat object representing the active combat.
     */
    public Combat getActiveCombat(){
        return this.activeCombat;
    }

    /**
     * Executes the last combat that was stored in this game state.
     * @return The Result of the game combat given by the Combat object in this Game state.
     */
    public String execCombat(){
        this.activeCombat.execCombat();

        if(!this.activeCombat.isWon()){
            stillAlive = false;
        }

        String combatResult = this.activeCombat.result();
        this.activeCombat = null;

        return combatResult;
    }

    /**
     * Routes the entity that the player collide with into the correct flow.
     * @param entity Entity that the user collided with.
     */
    public void handleEntity(Entity entity){

        if(entity instanceof Goblin){
            activeCombat = new Combat(entity);
        }
    }

    /**
     * Return weather the game state is in a Game Over state in which the game will not continue.
     * @return True if the game is over, False otherwise
     */
    public boolean gameOver(){
        return !isStillAlive();
    }
}
