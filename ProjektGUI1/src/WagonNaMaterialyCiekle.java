import Exceptiony.MaksymalnaIloscCieczyException;

public class WagonNaMaterialyCiekle extends WagonTowarowyPodstawowy {
    public int nrIdWagonu = 0;
    int pojemnoscWLitrach;
    int iloscOtworowWlewczych;
    int akutalnyStan;
    int wagaWagonuNaMaterialyCiekle;

    WagonNaMaterialyCiekle() {
        super();
        nazwa = "WagonNaMaterialyCiekle";
        pojemnoscWLitrach = 20000;
        iloscOtworowWlewczych = 4;
        nrIdWagonu = numer;
    }

    public void wlejCiecz(int iloscLitrow) throws MaksymalnaIloscCieczyException {
        if (akutalnyStan + iloscLitrow > pojemnoscWLitrach) {
            throw new MaksymalnaIloscCieczyException("Przekroczono pojemnosc Wagonu");
        } else {
            akutalnyStan = iloscLitrow + akutalnyStan;
            wagaWagonuNaMaterialyCiekle = akutalnyStan + wagaNiezaladowanego;
            System.out.println("Wlales ciecz do wagonu, zostalo ci tyle miejsca: " + (pojemnoscWLitrach - akutalnyStan));
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", pojemnosc w litrach: " + pojemnoscWLitrach + ", ilosc otworow wlewczych: " + iloscOtworowWlewczych;
    }
}
