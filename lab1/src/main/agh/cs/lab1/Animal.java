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

    /*
    zdefiniuj konstruktor Animal(IWorldMap map); wykorzystaj argument map tak aby w metodzie move można było odwołać
    się do mapy i zweryfikować, czy zwierzę może przesunąć się na daną pozycję,

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

Napisz testy integracyjne weryfiujące poprawność implementacji. Uwzględnij:
czy zwierzę ma właściwą orientację,
czy zwierzę przemieszcza się na właściwe pozycje,
czy zwierzę nie wychodzi poza mapę,
czy dane wejściowe podane jako tablica łańcuchów znaków są poprawnie interpretowane.*/

}