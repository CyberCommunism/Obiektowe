package agh.cs.lab2;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapDirectionTest {


    @Test
    void previous() {
        MapDirection testowa1 = MapDirection.EAST;
        MapDirection testowa2 = MapDirection.SOUTH;
        MapDirection testowa3 = MapDirection.NORTH;
        MapDirection testowa4 = MapDirection.WEST;
        assertEquals(MapDirection.EAST,testowa2.previous());
        assertEquals(MapDirection.WEST,testowa3.previous());
        assertEquals(MapDirection.NORTH,testowa1.previous());
        assertEquals(MapDirection.SOUTH,testowa4.previous());

    }

    @Test
    void testToString() {
    }

    @Test
    void next() {
        MapDirection testowa1 = MapDirection.EAST;
        MapDirection testowa2 = MapDirection.SOUTH;
        MapDirection testowa3 = MapDirection.NORTH;
        MapDirection testowa4 = MapDirection.WEST;
        assertEquals(MapDirection.EAST,testowa3.next());
        assertEquals(MapDirection.WEST,testowa2.next());
        assertEquals(MapDirection.NORTH,testowa4.next());
        assertEquals(MapDirection.SOUTH,testowa1.next());

    }

    @Test
    void testPrevious() {
    }

    @Test
    void toUnitVector() {
    }

    @Test
    void values() {
    }

    @Test
    void valueOf() {
    }
}
