import Exceptiony.MaksymalnaIloscOsobException;
import Exceptiony.TemperaturaException;

public class WagonChlodniczy extends WagonTowarowyPodstawowy {
    public int nrIdWagonu = 0;

    int maksymalnaTemperaturaUjemna;
    int maksymalnaTemperaturaDodatnia;
    int aktualnaTemperatura = 0;
    int iloscTowaruZaladowanego = 0;
    int wagaWagonuChlodniczego;

    WagonChlodniczy() {
        super();
        nazwa = "WagonChlodniczy";
        napiecieElektryczne = true;
        nrIdWagonu = numer;
        maksymalnaTemperaturaUjemna = -50;
        maksymalnaTemperaturaDodatnia = 8;
    }

    public void zaladujTowar(int towar) throws MaksymalnaIloscOsobException {
        if (iloscTowaruZaladowanego + towar > maksymalnyCiezar) {
            throw new MaksymalnaIloscOsobException("Zbyt duzy ciezar");
        } else {
            iloscTowaruZaladowanego = towar + iloscTowaruZaladowanego;
            wagaWagonuChlodniczego = iloscTowaruZaladowanego + wagaNiezaladowanego;
        }
    }

    public void zmienTemperature(int iloscStopni) throws TemperaturaException {
        if (aktualnaTemperatura + iloscStopni > maksymalnaTemperaturaDodatnia | aktualnaTemperatura + iloscStopni < maksymalnaTemperaturaUjemna) {
            throw new TemperaturaException("Przekroczony dozwolony limit temperatury, mozesz ustawic od " + maksymalnaTemperaturaUjemna + " do " + maksymalnaTemperaturaDodatnia);
        } else {
            aktualnaTemperatura = iloscStopni + aktualnaTemperatura;
            System.out.println("Zmienionio temperature na: " + iloscStopni);
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                ", maksymalna temperatura ujemna: " + maksymalnaTemperaturaUjemna + ", maksymalna temperatura dodatnia: " + maksymalnaTemperaturaDodatnia;
    }
}
