import Exceptiony.MaksymalnaIloscDuzychBagazyException;

public class WagonBagazowoPocztowy extends Wagon {
    public int nrIdWagonu = 0;
    int liczbaSkrytekNaBagaze;
    int liczbaMijescNaRowery;
    int aktualnaIloscRowerow;
    int aktualnaIloscBagazu;
    int wagaWagonuBagazowoPocztowego;

    WagonBagazowoPocztowy() {
        super("WagonBagazowoPocztowy", 17000, 30000, false);
        liczbaSkrytekNaBagaze = 900;
        liczbaMijescNaRowery = 10;
        nrIdWagonu = numer;
    }

    public void zaladujBagaz(int iloscBagazu) throws MaksymalnaIloscDuzychBagazyException {
        if (aktualnaIloscBagazu + iloscBagazu > liczbaSkrytekNaBagaze) {
            throw new MaksymalnaIloscDuzychBagazyException("Podana liczba przekracza ilosc dostepncyh skrytek ");
        } else {
            aktualnaIloscBagazu = iloscBagazu + aktualnaIloscBagazu;
            wagaWagonuBagazowoPocztowego = aktualnaIloscBagazu * 3 + wagaNiezaladowanego;
            System.out.println("Zaladowales Bagaz/e, zostalo ci tyle miejsca: " + (liczbaSkrytekNaBagaze - aktualnaIloscBagazu));
        }
    }

    public void wyslijRower(int rower) throws MaksymalnaIloscDuzychBagazyException {
        if (aktualnaIloscRowerow + rower > liczbaMijescNaRowery) {
            throw new MaksymalnaIloscDuzychBagazyException("Zbyt duza liczba rowerow");
        } else {
            aktualnaIloscRowerow = rower + aktualnaIloscRowerow;
            System.out.println("Zaladowales rower, zostało tyle miejsc " + (liczbaMijescNaRowery - aktualnaIloscRowerow));
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                ", liczba skrytek na bagaze: " + liczbaSkrytekNaBagaze + ", liczba miejsc na rowery " +
                liczbaMijescNaRowery;
    }
}
