import Exceptiony.MaksymalnaIloscMaterialuException;

public class WagonNaMaterialyToksyczne extends WagonTowarowyCiezki {
    public int nrIdWagonu = 0;
    int superSzczelneSkrytki;
    boolean promieniowanie;
    int aktualneSuperSzczelneSkrytki;
    int wagaWagonuNaMaterialyToksyczne;

    WagonNaMaterialyToksyczne() {
        super();
        nazwa = "WagonNaMaterialyToksyczne";
        nrIdWagonu = numer;
        superSzczelneSkrytki = 20;
        promieniowanie = false;
    }

    public void zaladujMaterialToksyczny(int toxic) throws MaksymalnaIloscMaterialuException {
        if (aktualneSuperSzczelneSkrytki + toxic > superSzczelneSkrytki) {
            throw new MaksymalnaIloscMaterialuException("Za mało miejsca na dodanie tylu materialu");
        } else {
            aktualneSuperSzczelneSkrytki = aktualneSuperSzczelneSkrytki + toxic;
            wagaWagonuNaMaterialyToksyczne = aktualneSuperSzczelneSkrytki * 100 + wagaNiezaladowanego;
            System.out.println("Dodałes materialy do skrytek, zostalo ci tyle miejsca: " + (superSzczelneSkrytki - aktualneSuperSzczelneSkrytki));
        }
    }

    public String toString() {
        return super.toString() + ", liczba super szczelnych skrytek: " + superSzczelneSkrytki + ", promieniowanie " + promieniowanie;
    }
}
