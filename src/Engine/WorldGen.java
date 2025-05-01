package Engine;

import Entities.Entity;
import Entities.Land;
import Entities.Player;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class WorldGen {

    Land playerPosition;

    public WorldGen() {
        initWorld();

        printWorld();


    }

    public void initWorld(){
        List<Land> startingGrid = new ArrayList<>(9);

        for (int i = 0; i < 9; i++) {
            startingGrid.add(new Land());
        }

        //Setting up the player in the middle of the map
        startingGrid.get(4).setEntity(new Player());

        startingGrid.get(4).setNorth(startingGrid.get(1));
        startingGrid.get(4).setSouth(startingGrid.get(7));
        startingGrid.get(4).setEast(startingGrid.get(5));
        startingGrid.get(4).setWest(startingGrid.get(3));
        startingGrid.get(1).setEast(startingGrid.get(2));
        startingGrid.get(1).setWest(startingGrid.get(0));
        startingGrid.get(3).setNorth(startingGrid.get(0));
        startingGrid.get(3).setSouth(startingGrid.get(6));
        startingGrid.get(5).setNorth(startingGrid.get(2));
        startingGrid.get(5).setSouth(startingGrid.get(8));
        startingGrid.get(7).setEast(startingGrid.get(8));
        startingGrid.get(7).setWest(startingGrid.get(6));

        playerPosition = startingGrid.get(4);
    }

    public Entity peakNorth(){
        return playerPosition.getNorth().getEntity();
    }

    public void moveNorth(){
        Player player = (Player) playerPosition.getEntity();
        playerPosition.setEntity(null);
        playerPosition = playerPosition.getNorth();
        playerPosition.setEntity(player);

        //Generating new Norths
        // | | |
        // x x x
        playerPosition.getEast().setNorth(new Land());
        playerPosition.setNorth(new Land());
        playerPosition.getWest().setNorth(new Land());

        //Generating the connection between norths
        // - - -
        // x x x
        playerPosition.getNorth().setEast(playerPosition.getEast().getNorth());
        playerPosition.getNorth().setWest(playerPosition.getWest().getNorth());
    }



    public void printWorld(){
        System.out.printf("%s%s%s\n", playerPosition.getNorth().getWest() , playerPosition.getNorth(), playerPosition.getNorth().getEast());
        System.out.printf("%s%s%s\n", playerPosition.getWest() , playerPosition, playerPosition.getEast());
        System.out.printf("%s%s%s\n", playerPosition.getSouth().getWest() , playerPosition.getSouth(), playerPosition.getSouth().getEast());
        System.out.println("\n======\n");
    }

    public void printNorth(){
        System.out.printf("%s%s%s\n", playerPosition.getNorth().getWest() , playerPosition.getNorth(), playerPosition.getNorth().getEast());
    }
}
