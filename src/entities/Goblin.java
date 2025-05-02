package entities;

/**
 * Goblin is the entity that represents the basic enemy of the game.
 * A goblin is represented by the UTF-8 character '▲' inside the map.
 *
 * Developed by: Luis Marin
 */
public class Goblin extends Entity{


    @Override
    public String toString() {
        return "▲";
    }
}
