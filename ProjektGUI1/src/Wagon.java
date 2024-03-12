abstract class Wagon {
    public int nrIdWagonu = 0;
    public static int numer = 1;
    public String nazwa;
    public int wagaNiezaladowanego;
    public int maksymalnyCiezar;
    public boolean napiecieElektryczne;

    Wagon(String nazwa, int wagaNieZaladowanego, int maksymalnyCiezar, boolean napiecieElektryczne) {
        this.nazwa = nazwa;
        this.wagaNiezaladowanego = wagaNieZaladowanego;
        this.napiecieElektryczne = napiecieElektryczne;
        this.maksymalnyCiezar = maksymalnyCiezar;
        nrIdWagonu = numer++;
    }

    @Override
    public String toString() {
        return "Nazwa wagonu: " + nazwa + ", numer ID wagonu: " + nrIdWagonu + ", waga niezaladowanego: " + wagaNiezaladowanego + ", napiecie elektryczne: " + napiecieElektryczne;
    }
}
