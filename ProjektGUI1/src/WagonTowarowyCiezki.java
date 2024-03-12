import Exceptiony.MaksymalnaIloscCiezaruException;

public class WagonTowarowyCiezki extends Wagon {
    public int nrIdWagonu = 0;
    public int liczbaDrzwiLadunkowych;
    public boolean krytyDach;
    int iloscCiezaruZaladowanego = 0;
    int wagaWagonuTowarowegoCiezkiego;

    WagonTowarowyCiezki() {
        super("WagonTowarowyCiezki", 15000, 35000, false);
        nrIdWagonu = numer;
        liczbaDrzwiLadunkowych = 4;
        krytyDach = true;
    }

    public void zaladujCiezar(int ciezar) throws MaksymalnaIloscCiezaruException {
        if (iloscCiezaruZaladowanego + ciezar > maksymalnyCiezar) {
            throw new MaksymalnaIloscCiezaruException("Podany ciezar jest za ciezki");
        } else {
            iloscCiezaruZaladowanego = iloscCiezaruZaladowanego + ciezar;
            wagaWagonuTowarowegoCiezkiego = iloscCiezaruZaladowanego + wagaNiezaladowanego;
            System.out.println("Zaladowales ciezar do wagonu, zostalo ci tyle miejsca " + (maksymalnyCiezar - iloscCiezaruZaladowanego));
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", liczba drzwi ladunkowych: " + liczbaDrzwiLadunkowych +
                ", kryty dach " + krytyDach;
    }
}
