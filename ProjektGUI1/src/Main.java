
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static WierzcholekPolaczenie mapka;
    public static String tablicaNazwMiast[] = {
            "Warszawa", "Krakow", "Lodz", "Wroclaw", "Poznan", "Gdansk", "Szczecin", "Bydgoszcz", "Lublin", "Katowice", "Bialystok",
            "Gdynia", "Czestochowa", "Radom", "Sosnowiec", "Torun", "Kielce", "Gliwice", "Zabrze", "Olsztyn", "Pinczow", "Bytom", "Rzeszow",
            "Koszalin", "Rybnik", "Tychy", "Zabki", "Plock", "Elblag", "Opole", "Mszana", "Wloclawek", "Chorzow", "Tarnow", "Lachowice",
            "Nadulki", "Legnica", "Kalisz", "Grudziadz", "Jaworzno", "Sopot", "Serwy", "Myslowice", "Piastow", "Koluszki",
            "Ilawa", "Inowroclaw", "Lubin", "Swinoujscie", "Lomza", "Skierniewice", "Przemysl", "Wieliczka", "Chelm", "Kwidzyn",
            "Zamosc", "Zakopane", "Mielec", "Krotoszyn", "Swidnica", "Ostroda", "Bilgoraj", "Leczna", "Kety", "Gubin", "Czorsztyn",
            "Pleszew", "Debica", "Kolobrzeg", "Nisko", "Sulejowek", "Wieruszow", "Pruszkow", "Dzierzoniow", "Pruszkow", "Sieradz",
            "Wieliczka", "Kluczbork", "Szczyrk", "Krasnik", "Szamotuly", "Wegorzewo", "Konskie", "Konin", "Grodzisk",
            "Brzesko", "Bialogard", "Kluszkowce", "Gostynin", "Koscierzyna", "Pszczyna", "Swiecie", "Koszuty", "Zar", "Izabelin",
            "Lomianki", "Warka", "Wisla", "Koninki", "Andrychow"
    };
    public static ArrayList<SkladPociagu> listaSkladPociagu = new ArrayList<>();

    public static void main(String[] args) {
        mapka = mapa(tablicaNazwMiast);
        Menu.instrukcjaSkladPociagu();

    }

    public static WierzcholekPolaczenie mapa(String[] tablicaNazwMiast) {
        WierzcholekPolaczenie graf = new WierzcholekPolaczenie();

        for (int i = 0; i < tablicaNazwMiast.length; i++) {
            graf.dodajMiasto(tablicaNazwMiast[i]);
        }
        Random rand = new Random();
        for (int i = 0; i < tablicaNazwMiast.length; i++) {
            for (int j = i + 1; j < tablicaNazwMiast.length; j++) {
                if (i == j) continue;
                if (graf.czyPolaczenieIstnieje(tablicaNazwMiast[i], tablicaNazwMiast[j])) continue;
                if (rand.nextDouble() < 0.2) {  // jalocha
                    int odleglosc = rand.nextInt(1000) + 1;
                    graf.dodajPolaczenie(tablicaNazwMiast[i], tablicaNazwMiast[j], odleglosc);
                }
            }
        }
        //graf.najkrotszaSciezka("Warszawa", "Gdansk");
        return graf;
    }

    public static void menuMapa(String[] tablicaNazwMiast) {
        System.out.println("Witaj w menu Mapy i Generatora");
        System.out.println("Wybierz opcje wpisujac znaki");
        System.out.println("wsp   - > Wygeneruj Sklady Pociagow");
        System.out.println("dnp   - > Dodaj Nowe Polaczenie");
        System.out.println("sns   - > Stworz Nowa Stacje");
        System.out.println("wmsa  - > Wyswietl Miasta Stworzone Automatycznie");
        System.out.println("ws    - > Wygeneruj Symulacje");
        System.out.println("stop  - > Wyjdz z menu");
        boolean czyPrawda = false;
        Scanner scan = new Scanner(System.in);
        while (!czyPrawda) {
            String s = scan.nextLine();
            switch (s) {
                case "wsp":
                    wygenerujSklady(mapka);
                    System.out.println("Wybierz opcje wpisujac znaki");
                    System.out.println("wsp   - > Wygeneruj Sklady Pociagow");
                    System.out.println("dnp   - > Dodaj Nowe Polaczenie");
                    System.out.println("sns   - > Stworz Nowa Stacje");
                    System.out.println("wmsa  - > Wyswietl Miasta Stworzone Automatycznie");
                    System.out.println("ws    - > Wygeneruj Symulacje");
                    System.out.println("stop  - > Wyjdz z menu");
                    break;
                case "dnp":
                    System.out.println("Podaj nazwe miasta poczatkowego: ");
                    String mp = scan.nextLine();
                    System.out.println("Podaj nazwe miasta koncowego: ");
                    String mk = scan.nextLine();
                    System.out.println("Podaj odleglosc miedzy miastami: ");
                    int odleglosc = scan.nextInt();
                    if (mapka.czyPolaczenieIstnieje(mp, mk)) {
                        System.out.println("Podane polaczenie juz istnieje");
                    } else {
                        mapka.dodajPolaczenie(mp, mk, odleglosc);
                        scan.nextLine();
                        System.out.println("Dodano polaczenie miedzy: " + mp + " i " + mk + " o odleglosci: " + odleglosc);
                    }
                    System.out.println("Wybierz opcje wpisujac znaki");
                    System.out.println("wsp   - > Wygeneruj Sklady Pociagow");
                    System.out.println("dnp   - > Dodaj Nowe Polaczenie");
                    System.out.println("sns   - > Stworz Nowa Stacje");
                    System.out.println("wmsa  - > Wyswietl Miasta Stworzone Automatycznie");
                    System.out.println("ws    - > Wygeneruj Symulacje");
                    System.out.println("stop  - > Wyjdz z menu");
                    break;
                case "sns":
                    System.out.println("Podaj nazwe stacji: ");
                    String miasto = scan.nextLine();
                    for (int i = 0; i < tablicaNazwMiast.length; i++) {
                        if (tablicaNazwMiast[i].equals(miasto)) {
                            System.out.println("Podana stacja juz istnieje");
                        } else {
                            mapka.dodajMiasto(miasto);
                        }
                    }
                    System.out.println("Wybierz opcje wpisujac znaki");
                    System.out.println("wsp   - > Wygeneruj Sklady Pociagow");
                    System.out.println("dnp   - > Dodaj Nowe Polaczenie");
                    System.out.println("sns   - > Stworz Nowa Stacje");
                    System.out.println("wmsa  - > Wyswietl Miasta Stworzone Automatycznie");
                    System.out.println("ws    - > Wygeneruj Symulacje");
                    System.out.println("stop  - > Wyjdz z menu");
                    break;
                case "wmsa":
                    wyswietlMiasta(tablicaNazwMiast);
                    System.out.println("Wybierz opcje wpisujac znaki");
                    System.out.println("wsp   - > Wygeneruj Sklady Pociagow");
                    System.out.println("dnp   - > Dodaj Nowe Polaczenie");
                    System.out.println("sns   - > Stworz Nowa Stacje");
                    System.out.println("wmsa  - > Wyswietl Miasta Stworzone Automatycznie");
                    System.out.println("ws    - > Wygeneruj Symulacje");
                    System.out.println("stop  - > Wyjdz z menu");
                    break;
                case "ws":
                    try {
                        List<Thread> listaSkladowNaTrasie = new ArrayList<>();
                        for (SkladPociagu skladPociagu : listaSkladPociagu) {
                            Runnable sklad = () -> {
                                try {
                                    skladPociagu.jazdaPociagow();
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            };
                            Thread thread = new Thread(sklad);
                            listaSkladowNaTrasie.add(thread);
                            thread.start();
                        }

                        for (Thread thread : listaSkladowNaTrasie) {
                            try {
                                thread.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Nie wygenerowano skladow pociagow");
                    }
                    System.out.println("Wybierz opcje wpisujac znaki");
                    System.out.println("wsp   - > Wygeneruj Sklady Pociagow");
                    System.out.println("dnp   - > Dodaj Nowe Polaczenie");
                    System.out.println("sns   - > Stworz Nowa Stacje");
                    System.out.println("wmsa  - > Wyswietl Miasta Stworzone Automatycznie");
                    System.out.println("ws    - > Wygeneruj Symulacje");
                    System.out.println("stop  - > Wyjdz z menu");
                    break;
                case "stop":
                    czyPrawda = true;
                    System.out.println("Wybierz opcje wpisujac znaki");
                    System.out.println("snsp - > Stworz Nowy Sklad Pociagu");
                    System.out.println("mzsp - > Modyfikuj Zrobiony Sklad Pociagu");
                    System.out.println("wusp - > Wyswietl Utworzone Sklady Pociagow");
                    System.out.println("mmig - > Menu Mapy i Generatora");
                    System.out.println("usp  - > Usun Sklad Pociagu");
                    System.out.println("stop - > Zakoncz Program");
                    break;
                default:
                    System.out.println("Podales nie poprawny ciag liter, prosze o powtorzenie");
                    break;
            }
        }
    }

    public static List<SkladPociagu> wygenerujSklady(WierzcholekPolaczenie graf) {
        ArrayList<SkladPociagu> wygenerowaneSklady = new ArrayList<>();
        ArrayList<Wierzcholek> miasta = new ArrayList<>();
        for (int i = 0; i < tablicaNazwMiast.length; i++) {
            miasta.add(new Wierzcholek(tablicaNazwMiast[i]));
        }
        String nazwyWagonow[] = {
                "WagonPasazerski", "WagonPocztowy", "WagonBagazowoPocztowy",
                "WagonRestauracyjny", "WagonTowarowyPodstawowy", "WagonTowarowyCiezki",
                "WagonChlodniczy", "WagonNaMaterialyCiekle", "WagonNaMaterialyGazowe",
                "WagonNaMaterialyWybuchowe", "WagonNaMaterialyToksyczne", "WagonNaCiekleMaterialyToksyczne"
        };
        while (wygenerowaneSklady.size() < 25) {
            int iloscWagonow = (int) (Math.random() * 5 + 5);

            Random random = new Random();
            int i1;
            int i2;

            do {
                i1 = random.nextInt(miasta.size());
                i2 = random.nextInt(miasta.size());
            } while (i1 == i2);

            Wierzcholek stacjaStartowa = miasta.get(i1);
            Wierzcholek stacjaKoncowa = miasta.get(i2);

            SkladPociagu nowySklad = new SkladPociagu(graf, stacjaStartowa, stacjaKoncowa);
            for (int i = 0; i < iloscWagonow; i++) {
                if (Lokomotywa.maksymalnaWagaTransportowanegoLadunku < zliczSumeWag(wygenerowaneSklady)) {
                    System.out.println("Przekroczono maksymalna wage transportowanego ladunku");
                } else if (Lokomotywa.maksymalnaLiczbaWagonow < zliczIloscWagonow(wygenerowaneSklady)) {
                    System.out.println("Za duzo podlaczonych wagnow");
                } else if (Lokomotywa.maksymalnaLiczbaWagonowWymagajacaPodlaczeniaDoSieci < zliczIloscWagonowWymagajacaPodlaczeniaDoSieci(wygenerowaneSklady)) {
                    System.out.println("Za duzo wagonow wymagajacych podlaczenia do sieci");
                }
                nowySklad.podepnijWagon(SkladPociagu.jakiWagon(nazwyWagonow[(int) (Math.random() * 11)]));
            }
            wygenerowaneSklady.add(nowySklad);
            listaSkladPociagu = wygenerowaneSklady;
        }
        for (int i = 0; i < wygenerowaneSklady.size(); i++) {
            System.out.print(wygenerowaneSklady.get(i) + " Podlaczone wagony: ");
            System.out.print(wygenerowaneSklady.get(i).listaWagonow);
            System.out.println();
        }
        return wygenerowaneSklady;
    }

    public static int zliczSumeWag(ArrayList<SkladPociagu> wygenerowaneSklady) {
        int sumaWag = 0;
        for (int i = 0; i < wygenerowaneSklady.size(); i++) {
            sumaWag = sumaWag + wygenerowaneSklady.get(i).sumaWagWagonow;
        }
        return sumaWag;
    }

    public static int zliczIloscWagonow(ArrayList<SkladPociagu> wygenerowaneSklady) {
        int iloscWagonow = 0;
        for (int i = 0; i < wygenerowaneSklady.size(); i++) {
            iloscWagonow = iloscWagonow + wygenerowaneSklady.get(i).listaWagonow.size();
        }
        return iloscWagonow;
    }

    public static int zliczIloscWagonowWymagajacaPodlaczeniaDoSieci(ArrayList<SkladPociagu> wygenerowaneSklady) {
        int iloscWagonowWymagajacaPodlaczeniaDoSieci = 0;
        for (int i = 0; i < wygenerowaneSklady.size(); i++) {
            iloscWagonowWymagajacaPodlaczeniaDoSieci = iloscWagonowWymagajacaPodlaczeniaDoSieci + wygenerowaneSklady.get(i).listaWagonow.size();
        }
        return iloscWagonowWymagajacaPodlaczeniaDoSieci;
    }

    public static void wyswietlMiasta(String[] tablicaNazwMiast) {
        for (int i = 0; i < tablicaNazwMiast.length; i++) {
            System.out.println(tablicaNazwMiast[i]);
        }
    }
}

// mapa();
//menuMapa();
//        WierzcholekPolaczenie graf = new WierzcholekPolaczenie();
//        graf.dodajMiasto("A");
//        graf.dodajMiasto("B");
//        graf.dodajMiasto("C");
//        graf.dodajMiasto("D");
//        graf.dodajMiasto("E");
//        graf.dodajMiasto("F");
//        graf.dodajPolaczenie("A", "B", 2);
//        graf.dodajPolaczenie("A", "C", 4);
//        graf.dodajPolaczenie("B", "C", 3);
//        graf.dodajPolaczenie("B", "D", 1);
//        graf.dodajPolaczenie("B", "E", 5);
//        graf.dodajPolaczenie("E", "D", 1);
//        graf.dodajPolaczenie("E", "F", 2);
//        graf.dodajPolaczenie("F", "D", 4);
//        graf.dodajPolaczenie("C", "D", 2);
//        graf.najkrotszaSciezka("A", "F");
