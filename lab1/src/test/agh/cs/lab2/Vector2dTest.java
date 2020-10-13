package agh.cs.lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {

        Vector2d testowy = new Vector2d();
        assertEquals("(0,0)",testowy.toString());

        Vector2d testowy1 = new Vector2d(2,4);
        assertEquals("(2,4)",testowy1.toString());

        Vector2d testowy2 = new Vector2d(-1,-3);
        assertEquals("(-1,-3)",testowy2.toString());

    }

    @Test
    void precedes() {

    }

    @Test
    void follows() {
    }

    @Test
    void upperRight() {
    }

    @Test
    void lowerLeft() {
    }

    @Test
    void add() {
        Vector2d testowy1 = new Vector2d(2,3);
        Vector2d testowy2 = new Vector2d(1,2);
        Vector2d result = new Vector2d(3,5);

        assertEquals(result,testowy1.add(testowy2));

    }

    @Test
    void subtract() {
        Vector2d testowy1 = new Vector2d(2,3);
        Vector2d testowy2 = new Vector2d(1,2);
        Vector2d result = new Vector2d(1,1);

        assertEquals(result,testowy1.subtract(testowy2));

    }

    @Test
    void opposite() {
        Vector2d testowy1 = new Vector2d(2,-3);
        Vector2d result = new Vector2d(-2,3);

        assertEquals(result,testowy1.opposite());

    }

    @Test
    void testEquals() {
        int x=0;
        Vector2d testowy = new Vector2d(1,1);
        Vector2d testowy1 = new Vector2d(1,2);

        assertNotEquals(testowy1, testowy);
        assertNotEquals(x, testowy);
        Vector2d testowy2 = new Vector2d(1,1);
        assertEquals(testowy2, testowy);



    }
}