package agh.cs.lab1;

class Animal {
    final Vector2d PRAWAGRANICA = new Vector2d(4,4);
    final Vector2d LEWAGRANICA = new Vector2d(0,0);


    private Vector2d position = new Vector2d(2,2);
    private MapDirection orietationt = MapDirection.NORTH;



    public String toString(){
        return "( pozycja " + position.toString() + " --- kierunek " + orietationt.toString() + " )";
    }
    public void move(MoveDirection direction){
        Vector2d testF = this.position.add(this.orietationt.toUnitVector());
        Vector2d testB = this.position.subtract(this.orietationt.toUnitVector());
        switch (direction){
            case RIGHT -> this.orietationt = this.orietationt.next();
            case LEFT -> this.orietationt = this.orietationt.previous();
            case FORWARD -> {
                if(testF.precedes(PRAWAGRANICA) && testF.follows(LEWAGRANICA)){
                    this.position = testF;
                }
            }
            case BACKWARD -> {
                if(testB.precedes(PRAWAGRANICA)&&testB.follows(LEWAGRANICA)){
                    this.position = testB;
                }
            }
        }
    }
    public MapDirection getDirection(){
        return this.orietationt;
    }
    public Vector2d getPosition(){
        return this.position;
    }

}