package Engine;

import Entities.Entity;
import Entities.Goblin;

public class Game {

    private WorldGen world;
    private boolean stillAlive;
    private Combat activeCombat;

    public Game() {
        stillAlive = true;
        world = new WorldGen();
    }

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

    public void showMap(){
        world.printWorld();
    }

    public void moveNorth() {
        //Ask to peak
        Entity entity = world.peakNorth();

        //Check if there is something
        if(entity != null){
            handleEntity(entity);
        }

        //If all good, move
        world.moveNorth();
    }

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

    public boolean isStillAlive(){
        return stillAlive;
    }

    public boolean isInCombat(){
        return this.activeCombat != null;
    }

    public Combat getActiveCombat(){
        return this.activeCombat;
    }

    public String execCombat(){
        this.activeCombat.execCombat();

        if(!this.activeCombat.isWon()){
            stillAlive = false;
        }

        String combatResult = this.activeCombat.result();
        this.activeCombat = null;

        return combatResult;
    }

    public void handleEntity(Entity entity){

        if(entity instanceof Goblin){
            activeCombat = new Combat(entity);
        }
    }

    public boolean gameOver(){
        return !isStillAlive();
    }
}
