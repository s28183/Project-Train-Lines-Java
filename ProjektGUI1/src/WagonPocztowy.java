import Exceptiony.MaksymalnaIloscListowException;

public class WagonPocztowy extends Wagon {
    public int nrIdWagonu = 0;
    public int liczbaSkrytek;
    public int liczbaSkrytekPodzielonychNaMiasta;
    int iloscListowWSkrytkach;
    int wagaWagonuPocztowego;

    WagonPocztowy() {
        super("WagonPocztowy", 15000, 1650, true);
        liczbaSkrytek = 1000;
        liczbaSkrytekPodzielonychNaMiasta = 20;
        nrIdWagonu = numer;
    }

    public void wsadzListDoSkrytki(int iloscListow) throws MaksymalnaIloscListowException {
        if (iloscListowWSkrytkach + iloscListow > liczbaSkrytek) {
            throw new MaksymalnaIloscListowException("Podana liczba przekracza ilosc skrytek");
        } else {
            iloscListowWSkrytkach = iloscListowWSkrytkach + iloscListow;
            wagaWagonuPocztowego = iloscListowWSkrytkach + wagaNiezaladowanego;
            System.out.println("Zaladowales list/y do Skrytki zostało ci tyle miejsca " + (liczbaSkrytek - iloscListowWSkrytkach));
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", liczba skrytek: " + liczbaSkrytek +
                ", liczbaSkrytekPodzielonychNaMiasta: " + liczbaSkrytekPodzielonychNaMiasta;
    }
}
