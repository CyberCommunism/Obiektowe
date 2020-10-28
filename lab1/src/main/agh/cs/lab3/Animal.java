package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;

public class Animal {
    private Vector2d position;
    private MapDirection orietationt = MapDirection.NORTH;

    private IWorldMap map;

    //Animal(){}

    public Animal(IWorldMap map){
        this(map,new Vector2d(2,2));
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map; // co jak jest okupywany
        this.position = initialPosition;
    }

    public String toString(){
        return this.position.toString() + orietationt.toString();
    }
    public void move(MoveDirection direction){

        switch (direction){
            case RIGHT -> this.orietationt = this.orietationt.next();
            case LEFT -> this.orietationt = this.orietationt.previous();
            case FORWARD -> changePositionIfPosibble(this.orietationt.toUnitVector());
            case BACKWARD -> changePositionIfPosibble(this.orietationt.toUnitVector().opposite());
        }
    }
    public void changePositionIfPosibble(Vector2d gdzie) {
        Vector2d nowyTestowy = this.position.add(gdzie);
        if(map.canMoveTo(nowyTestowy)){
            this.position = nowyTestowy;
        }
    }
    public MapDirection getDirection(){ return this.orietationt; }
    public Vector2d getPosition(){
        return this.position;
    }

    public boolean equals(Object other){
        if (this == other) return true;
        if (!(other instanceof Animal)) return false;
        Animal that = (Animal) other;
        return this.position.equals(that.position);
    }
}