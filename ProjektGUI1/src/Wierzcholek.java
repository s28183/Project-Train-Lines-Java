import java.util.ArrayList;
import java.util.List;

public class Wierzcholek implements Comparable<Wierzcholek> {
    String nazwa;
    int odleglosc;
    boolean odwiedzony = false;
    List<Polaczenie> listaPolaczen;

    Wierzcholek(String nazwa) {
        this.nazwa = nazwa;
        this.odleglosc = Integer.MAX_VALUE;
        this.listaPolaczen = new ArrayList<>();
    }

    public Polaczenie znajdzPolaczenie(Wierzcholek innyWierzcholek) {
        for (Polaczenie polaczenie : listaPolaczen) {
            if (polaczenie.cel == innyWierzcholek) {
                return polaczenie;
            }
        }
        return null;
    }

    @Override
    public int compareTo(Wierzcholek o) {
        return Integer.compare(odleglosc, o.odleglosc);
    }

    @Override
    public String toString() {
        return nazwa + " " + odleglosc;
    }

}