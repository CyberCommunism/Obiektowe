package agh.cs.lab1;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        out.println("START PROGRAMU");
        run(transfer(args));
        out.println("KONIEC PROGRAMU");
    }

    private static final Set VALU = Set.of("f", "b", "l", "r");

    public static void run(Direction[] args) {

        Stream<Direction> our_stream = Arrays.stream(args);
        our_stream.map(World::whatText).forEach(out::println);
    }

    public static Direction[] transfer(String[] args) {
        Stream<String> our_stream = Arrays.stream(args);
        return our_stream.filter(VALU::contains).map(World::whatEn).toArray(Direction[]::new);
    }

    public static String whatText(Direction whatEn) {
        return switch (whatEn) {
            case FORWARD -> "Zwierzak idzie do przodu";
            case BACKWARD -> "Zwierzak idzie do tylu";
            case LEFT -> "Zwierzak idzie do w lewo";
            case RIGHT -> "Zwierzak idzie do prawo";
        };
    }
    public static Direction whatEn(String cha){
        return switch (cha){
            case "f"->Direction.FORWARD;
            case "b"->Direction.BACKWARD;
            case "l"->Direction.LEFT;
            case "r"->Direction.RIGHT;
            default -> throw new IllegalStateException("Unexpected value: " + cha);
        };
    }
}
