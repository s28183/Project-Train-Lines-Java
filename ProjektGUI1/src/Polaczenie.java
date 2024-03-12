public class Polaczenie {
    public Wierzcholek cel;
    public int odlegloscPomiedzySasiadami;

    Polaczenie(Wierzcholek cel, int odlegloscDrogi) {
        this.cel = cel;
        this.odlegloscPomiedzySasiadami = odlegloscDrogi;
    }

    public String toString() {
        return "odleglosc drogi: " + odlegloscPomiedzySasiadami;
    }
}