import Exceptiony.MaksymalneCisnienieException;

public class WagonNaMaterialyGazowe extends WagonTowarowyPodstawowy {
    public int nrIdWagonu = 0;
    int maxCisnienie;
    boolean systemAntyZapalny;
    int aktualneCisnienie = 0;
    int wagaWagonuNaMaterialyGazowe;

    WagonNaMaterialyGazowe() {
        super();
        nazwa = "WagonNaMaterialyGazowe";
        nrIdWagonu = numer;
        maxCisnienie = 9999;
        systemAntyZapalny = true;
    }

    public void wpuscGaz(int gaz) throws MaksymalneCisnienieException {
        if (aktualneCisnienie + gaz > maxCisnienie) {
            throw new MaksymalneCisnienieException("Osiagnieto maksymalna ilosc cisnienia");
        } else {
            aktualneCisnienie = aktualneCisnienie + gaz;
            wagaWagonuNaMaterialyGazowe = aktualneCisnienie * 1 + wagaNiezaladowanego;
            System.out.println("Wpuszczono gaz, zostało ci tyle miejsca " + (maxCisnienie - aktualneCisnienie));
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", maksymalne cisnienie " + maxCisnienie + ", system antyzapalny: " + systemAntyZapalny;
    }
}
