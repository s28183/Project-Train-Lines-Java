import Exceptiony.MaksymalnaIloscOsobException;

public class WagonPasazerski extends Wagon {
    public int nrIdWagonu = 0;
    public int liczbaMiejscSiedzacych;
    public int liczbaPrzedzialow;
    public int liczbaOsobWWagonie;
    public int wagaWagonuPasazerskiego;

    WagonPasazerski() {
        super("WagonPasazerski", 15000, 17000, true);
        liczbaMiejscSiedzacych = 80;
        liczbaPrzedzialow = 10;
        nrIdWagonu = numer;
    }

    public void zaladujOsoby(int osoby) throws MaksymalnaIloscOsobException {
        if (liczbaOsobWWagonie + osoby > liczbaMiejscSiedzacych) {
            throw new MaksymalnaIloscOsobException("Podana liczba osob przekracza liczbe miejsc");
        } else {
            liczbaOsobWWagonie = osoby + liczbaOsobWWagonie;
            wagaWagonuPasazerskiego = liczbaOsobWWagonie * 80 + wagaNiezaladowanego;
            System.out.println("Załadowałes osoby do wagonu, zostalo ci " + (liczbaMiejscSiedzacych - liczbaOsobWWagonie));
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", napiecie elektryczne: " + napiecieElektryczne + ", liczba miejsc siedzacych: " + liczbaMiejscSiedzacych +
                ", liczba przedzialow: " + liczbaPrzedzialow;
    }
}
