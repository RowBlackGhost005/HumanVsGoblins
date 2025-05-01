package Engine;

import Entities.Entity;

public class Game {

    WorldGen world;

    public Game() {
        world = new WorldGen();

        moveNorth();
        world.printWorld();
    }

    public void moveNorth() {
        //Ask to peak north
        Entity entity = world.peakNorth();

        //Check if there is something on north
        if(entity != null){
            // Act accordingly
        }

        //If all good, move
        world.moveNorth();
    }
}
