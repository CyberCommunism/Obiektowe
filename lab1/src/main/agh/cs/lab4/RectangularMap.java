package agh.cs.lab4;
import agh.cs.lab3.*;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import java.util.ArrayList;
import java.util.List;
public class RectangularMap implements IWorldMap {

    Vector2d RIGHT;
    Vector2d LEFT = new Vector2d(0,0);
    public List<Animal> animals = new ArrayList<>();
    public RectangularMap(int x, int y){
        this.RIGHT = new Vector2d(x,y);
    }

    public String toString(){
        MapVisualizer doRysowania = new MapVisualizer(this);
        return doRysowania.draw(this.LEFT,this.RIGHT);
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(this.RIGHT) && position.follows(LEFT) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            this.animals.add(animal);
            return true;
        }
        else return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int index = 0;
        for(MoveDirection x:directions){
            this.animals.get(index%this.animals.size()).move(x);
            index++;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        Animal kamil = new Animal(this,position);
        return this.animals.contains(kamil);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        Animal animal = new Animal(this,position);
        if(this.animals.contains(animal)){
            return this.animals.get(this.animals.indexOf(animal));
        }
        return null;
    }
    public String animalsToString(){
        String result = "";
        for(Animal i:this.animals){
            result=result+i.toString()+"/n";
        }
        return result;
    }

}
