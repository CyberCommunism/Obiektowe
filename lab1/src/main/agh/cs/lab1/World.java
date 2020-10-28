package agh.cs.lab1;
import agh.cs.lab3.*;
import agh.cs.lab2.*;
import agh.cs.lab4.*;



public class World {
    public static void main(String[] args) {
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);

        System.out.print(((RectangularMap) map).animals.get(0));
        System.out.print(((RectangularMap) map).animals.get(1));

    }
}
















/*
Przyjrzyj się interfejsowi IWorldMap, który znajduje się w tym katalogu.

zdefiniuj konstruktor Animal(IWorldMap map); wykorzystaj argument map tak aby w metodzie move można było odwołać się do mapy i zweryfikować,
czy zwierzę może przesunąć się na daną pozycję,

zdefiniuj konstruktor Animal(IWorldMap map, Vector2d initialPosition), który dodatkowo określa początkowe położenie zwierzęcia na mapie,
zastanów się nad dotychczasowym konstruktorem bezparametrowym
dodaj metodę Vector2d getPosition(), która zwraca pozycję zwierzęcia,
zmodyfikuj metodę toString tak by zwracała jedynie schematyczną orientację zwierzęcia w postaci łańcucha składającego się z jednego znaku, Np. jeśli zwierzę ma orientację północną to metoda toString() powinna zwracać łańcuch "N" albo "^".
zmodyfikuj metodę move, tak by korzystała z wywołania canMoveTo interfejsu IWorldMap.
Zdefiniuj klasę RectangularMap, która:
definiuje prostokątną mapę,
implementuje interfejs IWorldMap
w konstruktorze akceptuje dwa parametry width oraz height wskazujące szerokość oraz wysokość mapy (zignoruj sytuację, w której użytkownik klasy poda niepoprawne wartości),
umożliwia poruszanie się w obrębie zdefiniowanego prostokąta (jak w laboratorium 3),
umożliwia występowanie więcej niż jednego zwierzęcia na mapie,
uniemożliwia występowanie więcej niż jednego zwierzęcia na tej samej pozycji,
posiada metodę toString rysującą aktualną konfigurację mapy (wykorzystaj klasę MapVisualizer która znajduje się w tym katalogu),
w metodzie run na przemian steruje ruchem wszystkich zwierząt. Przykładowo, jeśli użytkownik wprowadzi ciąg: f b r l a na mapie są dwa zwierzęcia, to pierwsze zwierzę otrzyma ruchy f i r, a drugie b i l. Ruchy obu zwierząt mają być wykonywane na przemian, tzn. po każdym ruchu pierwszego zwierzęcia następuje ruch drugiego zwierzęcia.
Wykonaj następujący kod w metodzie main klasy World:
MoveDirection[] directions = new OptionsParser().parse(args);
IWorldMap map = new RectangularMap(10, 5);
map.place(new Animal(map));
map.place(new Animal(map,new Vector2d(3,4)));
map.run(directions);
Sprawdź czy zwierzęta poruszają się poprawnie dla ciągu: f b r l f f r r f f f f f f f f.

Dodaj testy integracyjne weryfikujące, że implementacja jest poprawna. Wykorzystaj dane z punktu 5 w celu ustalenia przebiegu testu.
(Dla zaawansowanych) Stwórz tekstowy widget biblioteki Swing, który będzie wyświetlał animację poruszających się zwierzaków.

=========================================================================================================================================================================================

czy zwierzę ma właściwą orientację,
czy zwierzę przemieszcza się na właściwe pozycje,
czy zwierzę nie wychodzi poza mapę,
czy dane wejściowe podane jako tablica łańcuchów znaków są poprawnie interpretowane.
*/






/*
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

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
    }*/

