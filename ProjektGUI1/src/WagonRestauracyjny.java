import Exceptiony.MaksymalnaIloscOsobException;

public class WagonRestauracyjny extends Wagon {
    public int nrIdWagonu = 0;
    int iloscKucharzy;
    int iloscMiejscPrzyStolach;
    int iloscOsobPrzyStolach = 0;
    int wagaWagonuRestauracyjnego;

    WagonRestauracyjny() {
        super("WagonRestauracyjny", 17000, 20000, true);
        iloscKucharzy = 2;
        iloscMiejscPrzyStolach = 50;
        nrIdWagonu = numer;
    }

    public void dodajOsobeDoStolika(int iloscOsob) throws MaksymalnaIloscOsobException {
        if (iloscOsobPrzyStolach + iloscOsob > iloscMiejscPrzyStolach) {
            throw new MaksymalnaIloscOsobException("Brak miejsc przy stolikach");
        } else {
            iloscOsobPrzyStolach = iloscOsobPrzyStolach + iloscOsob;
            wagaWagonuRestauracyjnego = iloscOsobPrzyStolach * 80 + wagaNiezaladowanego;
            System.out.println("Dodales osobe do stolika, zostało ci tyle miejsc " + (iloscMiejscPrzyStolach - iloscOsobPrzyStolach));

        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Ilosc kucharzy: " + iloscKucharzy +
                ", ilosc miejsc przy stolach: " + iloscMiejscPrzyStolach;
    }
}

