package entities;


import java.util.Random;
import java.util.random.RandomGenerator;

/**
 * Land is a single piece of the world represented by the '□' UTF-8 Character.
 *
 * Every land has the ability to hold the information of their colliding neighbours of Land type.
 * Every entity has a chance of spawning inside this piece of Land.
 * The spawn table is as follows:
 * Goblin: 20%
 *
 * Developed by: Luis Marin
 */
public class Land {

    private static RandomGenerator numberGenerator = new Random();
    private Land north;
    private Land south;
    private Land east;
    private Land west;

    private Entity entity;

    /**
     * Creates a new empty Land with the possibility of housing an Entity.
     */
    public Land () {
        generateEntity();
    }


    /**
     * Returns the Land that its at the North of this Land.
     * @return Land object at the north, null if there's nothing.
     */
    public Land getNorth () {
        return north;
    }

    /**
     * Sets the given Land as the northern Land of this Land object.
     * If there's already one, the new Land is ignored to preserve integrity.
     * @param land Land to set at the North of this Land.
     */
    public void setNorth (Land land) {
        if(this.north == null){
            this.north = land;
        }

        if(land.getSouth() == null){
            land.setSouth(this);
        }
    }

    /**
     * Returns the Land that its at the South of this Land.
     * @return Land object at the south, null if there's nothing.
     */
    public Land getSouth () {
        return south;
    }

    /**
     * Sets the given Land as the southern Land of this Land object.
     * If there's already one, the new Land is ignored to preserve integrity.
     * @param land Land to set at the South of this Land.
     */
    public void setSouth (Land land) {

        if(this.south == null){
            this.south = land;
        }

        if(land.getNorth() == null){
            land.setNorth(this);
        }

    }

    /**
     * Returns the Land that its at the East of this Land.
     * @return Land object at the east, null if there's nothing.
     */
    public Land getEast () {
        return east;
    }

    /**
     * Sets the given Land as the eastern Land of this Land object.
     * If there's already one, the new Land is ignored to preserve integrity.
     * @param land Land to set at the East of this Land.
     */
    public void setEast (Land land) {
        if(this.east == null){
            this.east = land;
        }

        if(land.getWest() == null){
            land.setWest(this);
        }

    }

    /**
     * Returns the Land that its at the West of this Land.
     * @return Land object at the west, null if there's nothing.
     */
    public Land getWest () {
        return west;
    }

    /**
     * Sets the given Land as the western Land of this Land object.
     * If there's already one, the new Land is ignored to preserve integrity.
     * @param land Land to set at the West of this Land.
     */
    public void setWest (Land land) {
        if(this.west == null){
            this.west = land;
        }

        if(land.getEast() == null){
            land.setEast(this);
        }
    }

    /**
     * Returns the entity that its in this Land.
     * @return Entity in this Land, null if there's none.
     */
    public Entity getEntity() {
        return entity;
    }

    /**
     * Sets the entity in this Land.
     * This method overrides any entity that might be in here.
     * @param entity Entity to set.
     */
    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    /**
     * Randomly generates an entity in this Land.
     * Current distribution:
     * 20% - Goblin
     * 80% - None
     */
    public void generateEntity(){
        int probability = numberGenerator.nextInt(100);

        if(probability <= 20){
            setEntity(new Goblin());
        }else{
            setEntity(null);
        }
    }

    @Override
    public String toString() {
        if (entity != null) {
            return entity.toString();
        } else {
            return "□";
        }
    }
}
