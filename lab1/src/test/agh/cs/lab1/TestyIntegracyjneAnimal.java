package agh.cs.lab1;

import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestyIntegracyjneAnimal {
    @Test
    void testNaOrientacje(){
        Animal noweZwierze = new Animal();

        noweZwierze.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST,noweZwierze.getDirection());

        noweZwierze.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.SOUTH,noweZwierze.getDirection());

        noweZwierze.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.WEST,noweZwierze.getDirection());

        noweZwierze.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.NORTH,noweZwierze.getDirection());
    }
    @Test
    void testNaPozycje(){
        Animal noweZwierze = new Animal();

        MoveDirection idztyl = MoveDirection.BACKWARD;
        MoveDirection idzprzod = MoveDirection.FORWARD;
        MoveDirection obrocprawo = MoveDirection.RIGHT;
        MoveDirection obroclewo = MoveDirection.LEFT;

        noweZwierze.move(idzprzod);
        assertEquals(new Vector2d(2,3),noweZwierze.getPosition());

        noweZwierze.move(idztyl);
        assertEquals(new Vector2d(2,2),noweZwierze.getPosition());

        noweZwierze.move(obroclewo);
        noweZwierze.move(obroclewo);
        noweZwierze.move(idzprzod);
        assertEquals(new Vector2d(2,1),noweZwierze.getPosition());

        noweZwierze.move(idzprzod);
        assertEquals(new Vector2d(2,0),noweZwierze.getPosition());

        noweZwierze.move(obrocprawo);
        noweZwierze.move(idzprzod);
        assertEquals(new Vector2d(1,0),noweZwierze.getPosition());

        noweZwierze.move(idzprzod);
        assertEquals(new Vector2d(0,0),noweZwierze.getPosition());

        for(int i=0; i<4; i++){
            noweZwierze.move(idztyl);
        }
        assertEquals(new Vector2d(4,0),noweZwierze.getPosition());
    }
    @Test
    void testNaOgraniczeniaMapy(){
        Animal noweZwierze = new Animal();

        MoveDirection idztyl = MoveDirection.BACKWARD;
        MoveDirection idzprzod = MoveDirection.FORWARD;
        MoveDirection obrocprawo = MoveDirection.RIGHT;

        noweZwierze.move(idzprzod);
        noweZwierze.move(idzprzod);
        assertEquals(new Vector2d(2,4),noweZwierze.getPosition());

        noweZwierze.move(idzprzod);
        assertEquals(new Vector2d(2,4),noweZwierze.getPosition());

        noweZwierze.move(obrocprawo);
        for (int i=0; i<100; i++){
            noweZwierze.move(idztyl);
        }
        assertEquals(new Vector2d(0,4),noweZwierze.getPosition());



    }
    @Test
    void testParse(){
        String[] val ={"f","123", "forward", "b","haha", "backward", "r", "right", "l", "left","x","mapa","1piwo","to","nie","piwo"};
        Set val1 = Set.of(MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.RIGHT,MoveDirection.LEFT);
        for (Object x:OptionsParser.parse(val)){
            assertTrue(val1.contains(x));
        }

    }
}
