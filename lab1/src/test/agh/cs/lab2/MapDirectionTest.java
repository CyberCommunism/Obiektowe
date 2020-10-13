package agh.cs.lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void next() {

        MapDirection zmienna = MapDirection.EAST;
        assertEquals(MapDirection.SOUTH,zmienna.next());

        zmienna = MapDirection.WEST;
        assertEquals(MapDirection.NORTH,zmienna.next());

        zmienna = MapDirection.NORTH;
        assertEquals(MapDirection.EAST,zmienna.next());

        zmienna = MapDirection.SOUTH;
        assertEquals(MapDirection.WEST,zmienna.next());

    }

    @Test
    void previous() {

        MapDirection zmienna = MapDirection.EAST;
        assertEquals(MapDirection.NORTH,zmienna.previous());

        zmienna = MapDirection.WEST;
        assertEquals(MapDirection.SOUTH,zmienna.previous());

        zmienna = MapDirection.NORTH;
        assertEquals(MapDirection.WEST,zmienna.previous());

        zmienna = MapDirection.SOUTH;
        assertEquals(MapDirection.EAST,zmienna.previous());

    }
}

