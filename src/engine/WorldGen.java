package engine;

import entities.Entity;
import entities.Land;
import entities.Player;
import java.util.ArrayList;
import java.util.List;

/**
 * WorldGen class manages the initialization and world generation as the player moves.
 * The WorldGen class holds the world information based on the player position and displays the world as a
 * 3 x 3 grid with the player in the middle.
 * The world is generated in chunks of 1 x 3 or 3 x 1 matrix based on the player movement.
 */
public class WorldGen {

    Land playerPosition;

    /**
     * Creates a WorldGen objects that initializes a basic 3 x 3 world with the player in the middle.
     */
    public WorldGen() {
        initWorld();
    }

    /**
     * Initializes the world with a 3 x 3 Land Object grid with the character in the middle.
     */
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

    /**
     * Returns the entity that's in the North Land of the player.
     * @return Entity, null if none exists.
     */
    public Entity peakNorth(){
        return playerPosition.getNorth().getEntity();
    }

    /**
     * Moves the player at the land at its North, generates and connects a matrix of 1 x 3 representing the new world.
     */
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

        //Generating connections between norths
        // - - -
        // x x x
        playerPosition.getNorth().setEast(playerPosition.getEast().getNorth());
        playerPosition.getNorth().setWest(playerPosition.getWest().getNorth());
    }

    /**
     * Returns the entity that's in the East Land of the player.
     * @return Entity, null if none exists.
     */
    public Entity peakEast(){
        return playerPosition.getEast().getEntity();
    }

    /**
     * Moves the player at the land at its East, generates and connects a matrix of 3 x 1 representing the new world.
     */
    public void moveEast(){
        Player player = (Player) playerPosition.getEntity();
        playerPosition.setEntity(null);
        playerPosition = playerPosition.getEast();
        playerPosition.setEntity(player);

        //Generating new Easts
        // x -
        // x -
        // x -
        playerPosition.getNorth().setEast(new Land());
        playerPosition.setEast(new Land());
        playerPosition.getSouth().setEast(new Land());

        //Generating connection between Easts
        // x |
        // x |
        // x |
        playerPosition.getEast().setNorth(playerPosition.getNorth().getEast());
        playerPosition.getEast().setSouth(playerPosition.getSouth().getEast());
    }

    /**
     * Returns the entity that's in the South Land of the player.
     * @return Entity, null if none exists.
     */
    public Entity peakSouth(){
        return playerPosition.getSouth().getEntity();
    }

    /**
     * Moves the player at the land at its South, generates and connects a matrix of 1 x 3 representing the new world.
     */
    public void moveSouth(){
        Player player = (Player) playerPosition.getEntity();
        playerPosition.setEntity(null);
        playerPosition = playerPosition.getSouth();
        playerPosition.setEntity(player);

        //Generating new Souths
        // x x x
        // | | |
        playerPosition.getEast().setSouth(new Land());
        playerPosition.setSouth(new Land());
        playerPosition.getWest().setSouth(new Land());

        //Generating connections between Souths
        // x x x
        // - - -
        playerPosition.getSouth().setEast(playerPosition.getEast().getSouth());
        playerPosition.getSouth().setWest(playerPosition.getWest().getSouth());
    }

    /**
     * Returns the entity that's in the West Land of the player.
     * @return Entity, null if none exists.
     */
    public Entity peakWest(){
        return playerPosition.getWest().getEntity();
    }

    /**
     * Moves the player at the land at its West, generates and connects a matrix of 3 x 1 representing the new world.
     */
    public void moveWest(){
        Player player = (Player) playerPosition.getEntity();
        playerPosition.setEntity(null);
        playerPosition = playerPosition.getWest();
        playerPosition.setEntity(player);

        //Generating new Wests
        // - x
        // - x
        // - x
        playerPosition.getNorth().setWest(new Land());
        playerPosition.setWest(new Land());
        playerPosition.getSouth().setWest(new Land());

        //Generating connections between Wests
        // | x
        // | x
        // | x
        playerPosition.getWest().setNorth(playerPosition.getNorth().getWest());
        playerPosition.getWest().setSouth(playerPosition.getSouth().getWest());
    }

    /**
     * Prints the world in console as a 3 x 3 matrix with the user in the middle.
     */
    public void printWorld(){
        System.out.println("\n=======\n");
        System.out.printf(" %s %s %s \n", playerPosition.getNorth().getWest() , playerPosition.getNorth(), playerPosition.getNorth().getEast());
        System.out.printf(" %s %s %s \n", playerPosition.getWest() , playerPosition, playerPosition.getEast());
        System.out.printf(" %s %s %s \n", playerPosition.getSouth().getWest() , playerPosition.getSouth(), playerPosition.getSouth().getEast());
        System.out.println("\n=======\n");
    }

    /**
     * For debug purposes, prints the 1 x 3 matrix representing the North side of the player.
     */
    public void printNorth(){
        System.out.printf("%s%s%s\n", playerPosition.getNorth().getWest() , playerPosition.getNorth(), playerPosition.getNorth().getEast());
    }

    /**
     * For debug purposes, prints the 3 x 1 matrix representing the East side of the player.
     */
    public void printEast(){
        System.out.printf("%s\n%s\n%s\n", playerPosition.getNorth().getEast() , playerPosition.getEast(), playerPosition.getSouth().getEast());
    }

    /**
     * For debug purposes, prints the 1 x 3 matrix representing the South side of the player.
     */
    public void printSouth(){
        System.out.printf("%s%s%s\n", playerPosition.getSouth().getWest() , playerPosition.getSouth(), playerPosition.getSouth().getEast());
    }

    /**
     * For debug purposes, prints the 3 x 1 matrix representing the West side of the player.
     */
    public void printWest(){
        System.out.printf("%s\n%s\n%s\n", playerPosition.getNorth().getWest(), playerPosition.getWest(), playerPosition.getSouth().getWest());
    }
}
