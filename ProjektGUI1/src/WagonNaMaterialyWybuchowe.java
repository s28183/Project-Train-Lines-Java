import Exceptiony.MaksymalnaIloscMaterialuException;
import Exceptiony.MaksymalnaIloscUchwytowException;

public class WagonNaMaterialyWybuchowe extends WagonTowarowyCiezki {
    public int nrIdWagonu = 0;
    int liczbaUchwytow;
    int iloscZajetychUchwytow;
    boolean podwojneSciany;
    int wagaWagonuNaMaterialyWybuchowe;

    WagonNaMaterialyWybuchowe() {
        super();
        nazwa = "WagonNaMaterialyWybuchowe";
        liczbaUchwytow = 100;
        nrIdWagonu = numer;
        podwojneSciany = true;
    }

    public void wsadzBomby(int bomby) throws MaksymalnaIloscMaterialuException {
        if (iloscZajetychUchwytow + bomby > liczbaUchwytow) {
            throw new MaksymalnaIloscMaterialuException("Wszyskie uchwyty są zajete");
        } else {
            iloscZajetychUchwytow = iloscZajetychUchwytow + bomby;
            wagaWagonuNaMaterialyWybuchowe = iloscZajetychUchwytow * 100 + wagaNiezaladowanego;
            System.out.println("Wsadzono bomby, zostalo tyle miejsca " + (liczbaUchwytow - bomby));
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", liczba uchwytow na bomby:" + liczbaUchwytow +
                ", podwojne sciany: " + podwojneSciany;
    }
}
