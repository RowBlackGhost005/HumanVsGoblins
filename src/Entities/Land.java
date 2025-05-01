package Entities;

public class Land {

    Land north;
    Land south;
    Land east;
    Land west;

    Entity entity;

    public Land () {
        this.entity = null;
    }

    public Land getNorth () {
        return north;
    }

    public void setNorth (Land land) {
        this.north = land;
        if(land.getSouth() == null){
            land.setSouth(this);
        }
    }

    public Land getSouth () {
        return south;
    }

    public void setSouth (Land land) {
        this.south = land;

        if(land.getNorth() == null){
            land.setNorth(this);
        }

    }

    public Land getEast () {
        return east;
    }

    public void setEast (Land land) {
        this.east = land;
        if(land.getWest() == null){
            land.setWest(this);
        }

    }

    public Land getWest () {
        return west;
    }

    public void setWest (Land land) {
        this.west = land;
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

    @Override
    public String toString() {
        if (entity != null) {
            return entity.toString();
        } else {
            return "□";
        }
    }
}
