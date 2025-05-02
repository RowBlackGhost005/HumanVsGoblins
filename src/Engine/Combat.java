package Engine;

import Entities.Entity;
import Entities.Goblin;
import Entities.Player;

import java.util.Random;
import java.util.random.RandomGenerator;

public class Combat {

    private Entity entity;
    private boolean combatWon;
    private static RandomGenerator probability = new Random();

    public Combat(Entity entity){
        setEntity(entity);
    }

    public void execCombat(){
        combatWon = probability.nextInt(100) >= 20;
    }

    public void setEntity(Entity entity){
        this.entity = entity;
    }

    public boolean isWon(){
        return combatWon;
    }

    public String combatType(){
        if(this.entity instanceof Goblin){
            return "Entering a combat with a goblin!";
        }

        return "";
    }

    public String result(){
        if(combatWon){
            return "You've defeated the goblin!";
        }

        return "The goblin has defeated you!";
    }

    public Entity getEntity(){
        return this.entity;
    }
}
