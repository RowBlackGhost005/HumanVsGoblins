package Entities;


import java.util.Random;
import java.util.random.RandomGenerator;

public class Land {

    private static RandomGenerator numberGenerator = new Random();
    Land north;
    Land south;
    Land east;
    Land west;

    Entity entity;

    public Land () {
        generateEntity();
    }

    public Land getNorth () {
        return north;
    }

    public void setNorth (Land land) {
        if(this.north == null){
            this.north = land;
        }

        if(land.getSouth() == null){
            land.setSouth(this);
        }
    }

    public Land getSouth () {
        return south;
    }

    public void setSouth (Land land) {

        if(this.south == null){
            this.south = land;
        }

        if(land.getNorth() == null){
            land.setNorth(this);
        }

    }

    public Land getEast () {
        return east;
    }

    public void setEast (Land land) {
        if(this.east == null){
            this.east = land;
        }

        if(land.getWest() == null){
            land.setWest(this);
        }

    }

    public Land getWest () {
        return west;
    }

    public void setWest (Land land) {
        if(this.west == null){
            this.west = land;
        }

        if(land.getEast() == null){
            land.setEast(this);
        }
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

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
