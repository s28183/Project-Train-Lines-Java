import Exceptiony.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SkladPociagu implements Runnable {
    public int sumaWagWagonow;
    private Lokomotywa lokomotywa;
    public static SkladPociagu skladPociagu;

    private WierzcholekPolaczenie graf;
    private Wierzcholek stacjaStartowa;
    private Wierzcholek stacjaDocelowa;

    ArrayList<Wagon> listaWagonow = new ArrayList<>();
    Scanner dodawanieWagonu = new Scanner(System.in);
    Scanner ktoryWagon = new Scanner(System.in);
    Scanner ileTowaru = new Scanner(System.in);

    public SkladPociagu(WierzcholekPolaczenie graf, Wierzcholek stacjaStartowa, Wierzcholek stacjaDocelowa) {
        this.graf = graf;
        this.stacjaStartowa = stacjaStartowa;
        this.stacjaDocelowa = stacjaDocelowa;
        lokomotywa = new Lokomotywa();
    }

    public void instrukcjaLokomotywy() {
        System.out.println("Witaj w menu Skladu Pociagu");
        System.out.println("Wybierz opcje wpisujac znaki");
        System.out.println("pnw  - > Podepnij Nowy Wagon");
        System.out.println("ztdw - > Zaladuj Towar Do Wagonu");
        System.out.println("wlw  - > Wyswietl Liste Wagonow");
        System.out.println("upw  - > Usun Podpiety Wagon");
        System.out.println("stop  - > Zamknij instrukcje");
        Scanner scan = new Scanner(System.in);
        boolean czyPrawda = false;
        while (!czyPrawda) {
            String s1 = scan.next();
            switch (s1) {
                case "pnw":
                    System.out.println("Jaki wagon chcesz podpiac ");
                    System.out.println("WagonPasazerski");
                    System.out.println("WagonPocztowy");
                    System.out.println("WagonBagazowoPocztowy");
                    System.out.println("WagonRestauracyjny");
                    System.out.println("WagonTowarowyPodstawowy");
                    System.out.println("WagonTowarowyCiezki");
                    System.out.println("WagonChlodniczy");
                    System.out.println("WagonNaMaterialyCiekle");
                    System.out.println("WagonNaMaterialyGazowe");
                    System.out.println("WagonNaMaterialyWybuchowe");
                    System.out.println("WagonNaMaterialyToksyczne");
                    System.out.println("WagonNaCiekleMaterialyToksyczne");
                    try {
                        podepnijWagon(jakiWagon(dodawanieWagonu.nextLine()));
                        System.out.println("Wybierz opcje wpisujac znaki");
                        System.out.println("pnw  - > Podepnij Nowy Wagon");
                        System.out.println("ztdw - > Zaladuj Towar Do Wagonu");
                        System.out.println("wlw  - > Wyswietl Liste Wagonow");
                        System.out.println("upw  - > Usun Podpiety Wagon");
                        System.out.println("stop  - > Zamknij instrukcje");
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex);
                        System.out.println("Wracasz do menu");
                        System.out.println("Wybierz opcje wpisujac znaki");
                        System.out.println("pnw  - > Podepnij Nowy Wagon");
                        System.out.println("ztdw - > Zaladuj Towar Do Wagonu");
                        System.out.println("wlw  - > Wyswietl Liste Wagonow");
                        System.out.println("upw  - > Usun Podpiety Wagon");
                        System.out.println("stop  - > Zamknij instrukcje");
                    }
                    break;
                case "ztdw":
                    if (listaWagonow.size() != 0) {
                        System.out.println("Wybierz numer z {liczba}, ktory wagon chcesz zaladowac: ");
                        try {
                            wyswietlListeWagonow();
                        } catch (Exception e) {
                            System.out.println("Niestety nie ma zadnego wagonu, prosze utworzyc wagon");
                        }
                        try {
                            Wagon wagon = listaWagonow.get(ktoryWagon.nextInt() - 1);
                            if (wagon instanceof WagonPasazerski) {
                                System.out.println("Wpisz ile osob chcesz zaladowac: ");
                                try {
                                    ((WagonPasazerski) wagon).zaladujOsoby(ileTowaru.nextInt());
                                } catch (InputMismatchException e) {
                                    System.out.println(e);
                                }
                            } else if (wagon instanceof WagonPocztowy) {
                                System.out.println("Wpisz ile listow chcesz zaladowac: ");
                                ((WagonPocztowy) wagon).wsadzListDoSkrytki(ileTowaru.nextInt());
                            } else if (wagon instanceof WagonBagazowoPocztowy) {
                                System.out.println("Wpisz ile bagazy chcesz zaladowac: ");
                                ((WagonBagazowoPocztowy) wagon).zaladujBagaz(ileTowaru.nextInt());
                            } else if (wagon instanceof WagonRestauracyjny) {
                                System.out.println("Wpisz ile osob chcesz zaladowac: ");
                                ((WagonRestauracyjny) wagon).dodajOsobeDoStolika(ileTowaru.nextInt());
                            } else if (wagon instanceof WagonNaMaterialyCiekle) {
                                System.out.println("Wpisz ile cieczy chcesz wlac: ");
                                ((WagonNaMaterialyCiekle) wagon).wlejCiecz(ileTowaru.nextInt());
                            } else if (wagon instanceof WagonNaMaterialyGazowe) {
                                System.out.println("Wpisz ile gazu chcesz wpuscic: ");
                                ((WagonNaMaterialyGazowe) wagon).wpuscGaz(ileTowaru.nextInt());
                            } else if (wagon instanceof WagonNaMaterialyWybuchowe) {
                                System.out.println("Wpisz ile bomb chcesz wsadzic: ");
                                ((WagonNaMaterialyWybuchowe) wagon).wsadzBomby(ileTowaru.nextInt());
                            } else if (wagon instanceof WagonNaMaterialyToksyczne) {
                                System.out.println("Wpisz ile towaru chcesz zaladowac: ");
                                ((WagonNaMaterialyToksyczne) wagon).zaladujMaterialToksyczny(ileTowaru.nextInt());
                            } else if (wagon instanceof WagonNaCiekleMaterialyToksyczne) {
                                System.out.println("Wpisz ile cieczy chcesz wlac: ");
                                ((WagonNaCiekleMaterialyToksyczne) wagon).wlejCiecz(ileTowaru.nextInt());

                            } else if (wagon instanceof WagonTowarowyPodstawowy) {
                                System.out.println("Wpisz ile towaru chcesz zaladowac: ");
                                ((WagonTowarowyPodstawowy) wagon).zaladujCiezar(ileTowaru.nextInt());

                            } else if (wagon instanceof WagonTowarowyCiezki) {
                                System.out.println("Wpisz ile ciezaru chcesz zaladowac: ");
                                ((WagonTowarowyCiezki) wagon).zaladujCiezar(ileTowaru.nextInt());

                            } else if (wagon instanceof WagonChlodniczy) {
                                System.out.println("Wpisz ile towaru chcesz zaladowac: ");
                                ((WagonChlodniczy) wagon).zaladujTowar(ileTowaru.nextInt());
                            }
                            System.out.println("Wybierz opcje wpisujac znaki");
                            System.out.println("pnw  - > Podepnij Nowy Wagon");
                            System.out.println("ztdw - > Zaladuj Towar Do Wagonu");
                            System.out.println("wlw  - > Wyswietl Liste Wagonow");
                            System.out.println("upw  - > Usun Podpiety Wagon");
                            System.out.println("stop  - > Zamknij instrukcje");
                        } catch (IllegalArgumentException ex) {
                            System.out.println(ex);
                            System.out.println("Wybierz opcje wpisujac znaki");
                            System.out.println("pnw  - > Podepnij Nowy Wagon");
                            System.out.println("ztdw - > Zaladuj Towar Do Wagonu");
                            System.out.println("wlw  - > Wyswietl Liste Wagonow");
                            System.out.println("upw  - > Usun Podpiety Wagon");
                            System.out.println("stop  - > Zamknij instrukcje");
                        } catch (MaksymalnaIloscListowException e) {
                            System.out.println(e);
                        } catch (MaksymalnaIloscMaterialuException e) {
                            System.out.println(e);
                        } catch (MaksymalnaIloscOsobException e) {
                            System.out.println(e);
                        } catch (MaksymalnaIloscCieczyException e) {
                            System.out.println(e);
                        } catch (MaksymalneCisnienieException e) {
                            System.out.println(e);
                        } catch (MaksymalnaIloscDuzychBagazyException e) {
                            System.out.println(e);
                        } catch (MaksymalnaIloscCiezaruException e) {
                            System.out.println(e);
                        }
                    } else {
                        System.out.println("Brak wagonow");
                        System.out.println("Wracasz do Wagonu");
                    }
                    break;
                case "wlw":
                    try {
                        System.out.println("Twoja lista Wagonow:");
                        wyswietlListeWagonow();
                        System.out.println("Wybierz opcje wpisujac znaki");
                        System.out.println("pnw  - > Podepnij Nowy Wagon");
                        System.out.println("ztdw - > Zaladuj Towar Do Wagonu");
                        System.out.println("wlw  - > Wyswietl Liste Wagonow");
                        System.out.println("upw  - > Usun Podpiety Wagon");
                        System.out.println("stop  - > Zamknij instrukcje");
                    } catch (Exception e) {
                        System.out.println("Brak wagonow");
                    }
                    break;
                case "upw":
                    try {
                        usunWagon();
                        System.out.println("Wybierz opcje wpisujac znaki");
                        System.out.println("pnw  - > Podepnij Nowy Wagon");
                        System.out.println("ztdw - > Zaladuj Towar Do Wagonu");
                        System.out.println("wlw  - > Wyswietl Liste Wagonow");
                        System.out.println("upw  - > Usun Podpiety Wagon");
                        System.out.println("stop  - > Zamknij instrukcje");
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex);
                        //menu
                        System.out.println("Wracasz do menu");
                        System.out.println("Wybierz opcje wpisujac znaki");
                        System.out.println("pnw  - > Podepnij Nowy Wagon");
                        System.out.println("ztdw - > Zaladuj Towar Do Wagonu");
                        System.out.println("wlw  - > Wyswietl Liste Wagonow");
                        System.out.println("upw  - > Usun Podpiety Wagon");
                        System.out.println("stop  - > Zamknij instrukcje");
                    }
                    break;
                case "stop":
                    System.out.println("Opuszczasz instrukcje");
                    System.out.println("snsp - > Stworz Nowy Sklad Pociagu");
                    System.out.println("wusp - > Wyswietl Utworzone Sklady Pociagow");
                    System.out.println("mzsp - > Modyfikuj Zrobiony Sklad Pociagu");
                    System.out.println("mmig - > Menu Mapy i Generatora");
                    System.out.println("usp  - > Usun Sklad Pociagu");
                    czyPrawda = true;
                    break;
                default:
                    System.out.println("Podales nie poprawny ciag liter, prosze o powtorzenie");
            }
        }
    }

    public void podepnijWagon(Wagon wagon) {
        if (listaWagonow.size() >= lokomotywa.maksymalnaLiczbaWagonow) {
            System.out.println("Nie można dodać więcej wagonów");
        } else {
            if (wagon != null) {
                listaWagonow.add(wagon);
            }
        }
    }

    public Lokomotywa getLokomotywa() {
        return lokomotywa;
    }

    public void wyswietlListeWagonow() {
        if (listaWagonow.size() == 0) {
            System.out.println("Brak wagonow");
        }
        for (int i = 0; i < listaWagonow.size(); i++) {
            System.out.println("{" + (i + 1) + "}" + " " + listaWagonow.get(i));
        }
    }

    public static Wagon jakiWagon(String nazwa) {
        try {
            return switch (nazwa) {
                case "WagonPasazerski" -> new WagonPasazerski();
                case "WagonPocztowy" -> new WagonPocztowy();
                case "WagonBagazowoPocztowy" -> new WagonBagazowoPocztowy();
                case "WagonRestauracyjny" -> new WagonRestauracyjny();
                case "WagonTowarowyPodstawowy" -> new WagonTowarowyPodstawowy();
                case "WagonTowarowyCiezki" -> new WagonTowarowyCiezki();
                case "WagonChlodniczy" -> new WagonChlodniczy();
                case "WagonNaMaterialyCiekle" -> new WagonNaMaterialyCiekle();
                case "WagonNaMaterialyGazowe" -> new WagonNaMaterialyGazowe();
                case "WagonNaMaterialyWybuchowe" -> new WagonNaMaterialyWybuchowe();
                case "WagonNaMaterialyToksyczne" -> new WagonNaMaterialyToksyczne();
                case "WagonNaCiekleMaterialyToksyczne" -> new WagonNaCiekleMaterialyToksyczne();
                default -> throw new IllegalArgumentException("Zla nazwa");
            };
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return null;
        }
    }

    public void usunWagon() {
        try {
            System.out.println("Aktualna lista wagonow");
            wyswietlListeWagonow();
            System.out.println("Wybierz numer z {liczba}:");
            listaWagonow.remove(ktoryWagon.nextInt() - 1);
            System.out.println("Akutalna listwa wagnow po usunieciu");
            wyswietlListeWagonow();
        } catch (Exception e) {
            System.out.println("Nie ma co usuwac");
        }
    }

    @Override
    public void run() {
        try {
            jazdaPociagow();
        } catch (InterruptedException e) {
            System.out.println("Watek przerwany");
            e.printStackTrace();
        }
    }

    public synchronized void jazdaPociagow() throws InterruptedException {
        if (lokomotywa != null) {
            List<Wierzcholek> trasa = graf.najkrotszaSciezka(stacjaStartowa, stacjaDocelowa);
            int pozostalaOdleglosc = stacjaDocelowa.odleglosc;
            Wierzcholek poprzedniWierzcholek = null;
            for (Wierzcholek miasto : trasa) {
                System.out.println("Pozostala odleglosc do celu: " + pozostalaOdleglosc);
                System.out.println("Pociąg jest obecnie w: " + miasto);
                if (poprzedniWierzcholek != null) {
                    Polaczenie polaczenie = poprzedniWierzcholek.znajdzPolaczenie(miasto);
                    if (polaczenie != null) {
                        pozostalaOdleglosc = pozostalaOdleglosc - polaczenie.odlegloscPomiedzySasiadami;
                    }
                }
                poprzedniWierzcholek = miasto;
                Thread.sleep(1000);
            }
        }
    }

    public String toString() {
        return "Sklad Pociagu id: " + lokomotywa.idLokomotywy;
    }

}
