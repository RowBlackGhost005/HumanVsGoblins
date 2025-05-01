package Engine;

import Entities.Entity;

public class Game {

    WorldGen world;

    public Game() {
        world = new WorldGen();

        //Testing all cases
        moveNorth();
        world.printNorth();
        moveEast();
        world.printEast();
        moveSouth();
        world.printSouth();
        moveWest();
        world.printWest();
    }

    public void moveNorth() {
        //Ask to peak
        Entity entity = world.peakNorth();

        //Check if there is something
        if(entity != null){
            // Act accordingly
        }

        //If all good, move
        world.moveNorth();
    }

    public void moveEast() {
        //Ask to peak
        Entity entity = world.peakEast();

        //Check if there is something
        if(entity != null){
            // Act accordingly
        }

        //If all good, move
        world.moveEast();
    }

    public void moveSouth() {
        //Ask to peak
        Entity entity = world.peakSouth();

        //Check if there is something
        if(entity != null){
            // Act accordingly
        }

        //If all good, move
        world.moveSouth();
    }

    public void moveWest() {
        //Ask to peak
        Entity entity = world.peakWest();

        //Check if there is something
        if(entity != null){
            // Act accordingly
        }

        //If all good, move
        world.moveWest();
    }
}
