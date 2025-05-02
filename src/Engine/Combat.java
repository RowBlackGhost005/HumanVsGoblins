package Engine;

import Entities.Entity;
import Entities.Goblin;
import java.util.Random;
import java.util.random.RandomGenerator;

/**
 * Combat Class that manages the combat between the Player and an Entity
 * This class is used to create and hold the information of a Combat and execute it when needed it by
 * the game.
 * This class cannot be a game state by itself due to it needing the Player that is going to be hold by the Game Class.
 */
public class Combat {

    private Entity entity;
    private boolean combatWon;
    private static final RandomGenerator probability = new Random();

    /**
     * Creates a new Combat object with the given entity.
     * @param entity Entity to enter in combat with.
     */
    public Combat(Entity entity){
        setEntity(entity);
    }

    /**
     * Executes the Combat based on the Entity stored in this Combat.
     */
    public void execCombat(){
        combatWon = probability.nextInt(100) >= 20;
    }

    /**
     * Sets the Entity that entered this Combat.
     * @param entity Entity to enter in Combat with.
     */
    public void setEntity(Entity entity){
        this.entity = entity;
    }

    /**
     * Return weather this Combat was won by the Player.
     * @return True if the combat was won by the player, False otherwise
     */
    public boolean isWon(){
        return combatWon;
    }

    /**
     * Returns the combat type based on the Entity that is in this Combat.
     * @return Descriptive String of the combat.
     */
    public String combatType(){
        if(this.entity instanceof Goblin){
            return "Entering a combat with a goblin!";
        }

        return "";
    }

    /**
     * Returns the combat result.
     * @return Descriptive String of the combat result.
     */
    public String result(){
        if(combatWon){
            return "You've defeated the goblin!";
        }

        return "The goblin has defeated you!";
    }

    /**
     * Returns the Entity that is in this Combat.
     * @return Entity in this Combat.
     */
    public Entity getEntity(){
        return this.entity;
    }
}
