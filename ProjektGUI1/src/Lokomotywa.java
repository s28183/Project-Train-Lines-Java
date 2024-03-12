import java.util.*;

public class Lokomotywa {

    int idLokomotywy = 0;
    static int numer = 1;
    static int maksymalnaLiczbaWagonow;
    static int maksymalnaWagaTransportowanegoLadunku;
    static int maksymalnaLiczbaWagonowWymagajacaPodlaczeniaDoSieci;
    String nazwaLokomotywy;
    HashMap<Lokomotywa, ArrayList<Wagon>> MapaLokomotywa;

    Lokomotywa() {
        MapaLokomotywa = new HashMap<>();
        this.maksymalnaLiczbaWagonow = 250;
        this.maksymalnaWagaTransportowanegoLadunku = 500000;
        this.maksymalnaLiczbaWagonowWymagajacaPodlaczeniaDoSieci = 200;
        idLokomotywy = numer++;
    }

    public String toString() {
        return nazwaLokomotywy + " " + idLokomotywy;
    }
}


