package agh.cs.lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {

        Vector2d testowy = new Vector2d();
        assertEquals("(0,0)", testowy.toString());

        Vector2d testowy1 = new Vector2d(2, 4);
        assertEquals("(2,4)", testowy1.toString());

        Vector2d testowy2 = new Vector2d(-1, -3);
        assertEquals("(-1,-3)", testowy2.toString());

    }

    @Test
    void precedes() {
        Vector2d position1 = new Vector2d(2, 1);
        Vector2d position2 = new Vector2d(3, 4);
        assertTrue(position1.precedes(position2));
        assertFalse(position2.precedes(position1));
    }

    @Test
    void follows() {
        Vector2d position1 = new Vector2d(0, 0);
        Vector2d position2 = new Vector2d(1, 1);
        assertTrue(position2.follows(position1));
        assertFalse(position1.follows(position2));
    }

    @Test
    void upperRight() {
        Vector2d position1 = new Vector2d(0, 1);
        Vector2d position2 = new Vector2d(1, 0);
        assertEquals(new Vector2d(1, 1), position1.upperRight(position2));
    }

    @Test
    void lowerLeft() {
        Vector2d position1 = new Vector2d(0, 1);
        Vector2d position2 = new Vector2d(1, 0);
        assertEquals(new Vector2d(0, 0), position1.lowerLeft(position2));
    }

    @Test
    void add() {
        Vector2d testowy1 = new Vector2d(2, 3);
        Vector2d testowy2 = new Vector2d(1, 2);
        assertEquals(new Vector2d(3, 5), testowy1.add(testowy2));

    }

    @Test
    void subtract() {
        Vector2d testowy1 = new Vector2d(2, 3);
        Vector2d testowy2 = new Vector2d(1, 2);

        assertEquals(new Vector2d(1, 1), testowy1.subtract(testowy2));

    }

    @Test
    void opposite() {
        Vector2d testowy1 = new Vector2d(2, -3);
        assertEquals(new Vector2d(-2, 3), testowy1.opposite());
    }

    @Test
    void testEquals() {
        int x = 0;
        Vector2d testowy = new Vector2d(1, 1);
        Vector2d testowy1 = new Vector2d(1, 2);

        assertNotEquals(testowy1, testowy);
        assertNotEquals(x, testowy);

        Vector2d testowy2 = new Vector2d(1, 1);

        assertEquals(testowy2, testowy);
    }
}