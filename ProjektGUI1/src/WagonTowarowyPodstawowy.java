import Exceptiony.MaksymalnaIloscCiezaruException;

public class WagonTowarowyPodstawowy extends Wagon {
    public int nrIdWagonu = 0;

    int wysokoscScian;
    int powierzchnia;
    int iloscCiezaruZaladowanego;
    int wagaWagonuTowarowegoPodstawowego;

    WagonTowarowyPodstawowy() {
        super("WagonTowarowyPodstawowy", 10000, 25000, false);
        nrIdWagonu = numer;
        wysokoscScian = 2;
        powierzchnia = 40;
    }

    public void zaladujCiezar(int ciezar) throws MaksymalnaIloscCiezaruException {
        if (iloscCiezaruZaladowanego + ciezar > maksymalnyCiezar) {
            throw new MaksymalnaIloscCiezaruException("Wagon przeładowany");
        } else {
            iloscCiezaruZaladowanego = iloscCiezaruZaladowanego + ciezar;
            wagaWagonuTowarowegoPodstawowego = iloscCiezaruZaladowanego + wagaNiezaladowanego;
            System.out.println("Zaladowales ciezar do wagonu, zostalo ci tyle miejsca " + (maksymalnyCiezar - iloscCiezaruZaladowanego));
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", wysokosc scian: " + wysokoscScian +
                ", powierzchnia w metrach^2: " + powierzchnia;
    }
}
