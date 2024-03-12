import Exceptiony.MaksymalnaIloscCieczyException;

public class WagonNaCiekleMaterialyToksyczne extends WagonTowarowyCiezki
        implements WagonNaMaterialyCiekleInterface {
    public int nrIdWagonu = 0;
    int pojemnoscWLitrach;
    int iloscOtworowWlewczych;
    int iloscOdpowietrznikow;
    boolean podwojnaSciana;
    int aktualnyStan;
    int wagaWagonuNaCiekleMaterialyToksyczne;

    WagonNaCiekleMaterialyToksyczne() {
        super();
        nazwa = "WagonNaCiekleMaterialyToksyczne";
        pojemnoscWLitrach = 19999;
        iloscOtworowWlewczych = 4;
        podwojnaSciana = true;
        iloscOdpowietrznikow = 4;
        nrIdWagonu = numer;
    }

    public void wlejCiecz(int iloscLitrow) throws MaksymalnaIloscCieczyException {
        if (aktualnyStan + iloscLitrow > pojemnoscWLitrach) {
            throw new MaksymalnaIloscCieczyException("Przekroczono pojemnosc Wagonu");
        } else {
            aktualnyStan = iloscLitrow + aktualnyStan;
            wagaWagonuNaCiekleMaterialyToksyczne = aktualnyStan + wagaNiezaladowanego;
            System.out.println("Wlales ciecz do wagonu, zostalo ci tyle miejsca" + (aktualnyStan - pojemnoscWLitrach));
        }
    }

    public String toString() {
        return super.toString() + ", pojemnosc w litrach: " + pojemnoscWLitrach + ", ilosc otworow wlewczych: " + iloscOtworowWlewczych + ", ilosc odpowietrznikow: " + iloscOdpowietrznikow + ", podwojna sciana: " + podwojnaSciana;
    }
}
