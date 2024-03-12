import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WierzcholekPolaczenie {
    int odlegloscCalkowita;

    HashMap<String, Wierzcholek> miasto = new HashMap<>();

    public void dodajMiasto(String nazwaMiasta) {
        miasto.put(nazwaMiasta, new Wierzcholek(nazwaMiasta));
    }

    public void dodajPolaczenie(String nazwaMiasta1, String nazwaMiasta2, int odleglosc) {
        if (miasto.containsKey(nazwaMiasta1) && miasto.containsKey(nazwaMiasta2)) {
            miasto.get(nazwaMiasta1).listaPolaczen.add(new Polaczenie(miasto.get(nazwaMiasta2), odleglosc));
            miasto.get(nazwaMiasta2).listaPolaczen.add(new Polaczenie(miasto.get(nazwaMiasta1), odleglosc));
        }
    }

    public List<Wierzcholek> najkrotszaSciezka(Wierzcholek poczatkowy, Wierzcholek koncowy) {
        Map<Wierzcholek, Wierzcholek> ostatniaOdwiedzonaStacja = new HashMap<>();
        ArrayList<Wierzcholek> nieOdwiedzoneStacje = new ArrayList<>();
        for (Wierzcholek wierzcholek : miasto.values()) {
            wierzcholek.odleglosc = Integer.MAX_VALUE;
            nieOdwiedzoneStacje.add(wierzcholek);
            ostatniaOdwiedzonaStacja.put(wierzcholek, null);
        }
        poczatkowy.odleglosc = 0;
        while (!nieOdwiedzoneStacje.isEmpty()) {
            Wierzcholek aktualny = nieOdwiedzoneStacje.get(0);
            for (int i = 0; i < nieOdwiedzoneStacje.size(); i++) {
                if (aktualny.odleglosc > nieOdwiedzoneStacje.get(i).odleglosc) {
                    aktualny = nieOdwiedzoneStacje.get(i);
                }
            }
            //System.out.println("aktualny: " + aktualny.nazwa + " " + aktualny.odleglosc);
            if (aktualny == koncowy) {
                break;
            }
            for (Polaczenie polaczenie : aktualny.listaPolaczen) {
                int aktualnaOdlegloscTrasy = aktualny.odleglosc + polaczenie.odlegloscPomiedzySasiadami;
                if (aktualnaOdlegloscTrasy < polaczenie.cel.odleglosc) {
                    polaczenie.cel.odleglosc = aktualnaOdlegloscTrasy;
                    ostatniaOdwiedzonaStacja.put(polaczenie.cel, aktualny);
                }
            }
            nieOdwiedzoneStacje.remove(aktualny);
        }
        //System.out.println(ostatniaOdwiedzonaStacja);
        List<Wierzcholek> trasa = new ArrayList<>();
        while (koncowy != null) {
            trasa.add(0, koncowy);
            koncowy = ostatniaOdwiedzonaStacja.get(koncowy);
        }
        System.out.println("Odleglosc: " + odlegloscCalkowita);
        System.out.println(trasa);
        return trasa;
    }

    public boolean czyPolaczenieIstnieje(String nazwaMiasta1, String nazwaMiasta2) {
        if (miasto.containsKey(nazwaMiasta1) && miasto.containsKey(nazwaMiasta2)) {
            for (Polaczenie polaczenie : miasto.get(nazwaMiasta1).listaPolaczen) {
                if (polaczenie.cel.nazwa.equals(nazwaMiasta2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void usunStacje(String nazwaMiasta) {
        if (miasto.containsKey(nazwaMiasta)) {
            for (Wierzcholek wierzcholek : miasto.values()) {
                for (int i = 0; i < wierzcholek.listaPolaczen.size(); i++) {
                    if (wierzcholek.listaPolaczen.get(i).cel.nazwa.equals(nazwaMiasta)) {
                        wierzcholek.listaPolaczen.remove(i);
                    }
                }
            }
            miasto.remove(nazwaMiasta);
            System.out.println("gratulacje usunales stacje");
        } else {
            System.out.println("Nie ma takiej stacji");
        }
    }
}



