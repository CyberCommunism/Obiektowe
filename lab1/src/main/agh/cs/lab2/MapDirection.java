package agh.cs.lab2;

public enum MapDirection {
    NORTH( "N", new Vector2d(0, 1)),
    EAST("E", new Vector2d(1, 0)),
    SOUTH("S", new Vector2d(0, -1)),
    WEST("W", new Vector2d(-1, 0));

    final String mapDirSymbol;
    final Vector2d dirVector;
    private static final MapDirection[] vals = values();

    MapDirection(String mapDirSymbol, Vector2d dirVector) {
        this.mapDirSymbol = mapDirSymbol;
        this.dirVector = dirVector;
    }
    //@Override
    //public String toString() { return (String) vals[this.ordinal()]; }
    public MapDirection previous() {

        if(this.ordinal()==0){
            return MapDirection.WEST;
        }else{
            return vals[this.ordinal()-1];
        }

    }
    public MapDirection next() { return vals[(this.ordinal()+1) % vals.length]; }

    public Vector2d toUnitVector() { return dirVector; }
}