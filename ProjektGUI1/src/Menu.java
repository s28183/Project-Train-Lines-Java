import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    static Scanner ktorySklad = new Scanner(System.in);

    public static void instrukcjaSkladPociagu() {
        System.out.println("Witaj w Menu");
        System.out.println("Wybierz opcje wpisujac znaki");
        System.out.println("snsp - > Stworz Nowy Sklad Pociagu");
        System.out.println("mzsp - > Modyfikuj Zrobiony Sklad Pociagu");
        System.out.println("wusp - > Wyswietl Utworzone Sklady Pociagow");
        System.out.println("mmig - > Menu Mapy i Generatora");
        System.out.println("usp  - > Usun Sklad Pociagu");
        System.out.println("stop - > Zakoncz Program");
        boolean czyPrawda = false;
        Scanner scan = new Scanner(System.in);
        while (!czyPrawda) {
            String s = scan.nextLine();
            switch (s) {
                case ("snsp"):
                    Main.wyswietlMiasta(Main.tablicaNazwMiast);
                    System.out.println("Podaj nazwe miasta z ktorego chcesz ruszyc: ");
                    String miastoStartowe = scan.nextLine();
                    Wierzcholek start = Main.mapka.miasto.get(miastoStartowe);
                    while (start == null) {
                        System.out.println("Nieprawidłowa nazwa miasta startowego, spróbuj ponownie: ");
                        miastoStartowe = scan.nextLine();
                        start = Main.mapka.miasto.get(miastoStartowe);
                    }
                    System.out.println("Podaj nazwe miasta do ktorego chcesz dojechac: ");
                    String miastoDocelowe = scan.nextLine();
                    Wierzcholek koniec = Main.mapka.miasto.get(miastoDocelowe);
                    while (koniec == null) {
                        System.out.println("Nieprawidłowa nazwa miasta startowego, spróbuj ponownie: ");
                        miastoStartowe = scan.nextLine();
                        koniec = Main.mapka.miasto.get(miastoStartowe);
                    }
                    Main.listaSkladPociagu.add(new SkladPociagu(Main.mapka, start, koniec));
                    System.out.println("Utworzyles Nowy Sklad Pociagu");
                    System.out.println("Co chcesz dalej zrobic");
                    System.out.println("Wybierz opcje wpisujac znaki");
                    System.out.println("snsp - > Stworz Nowy Sklad Pociagu");
                    System.out.println("wusp - > Wyswietl Utworzone Sklady Pociagow");
                    System.out.println("mzsp - > Modyfikuj Zrobiony Sklad Pociagu");
                    System.out.println("mmig - > Menu Mapy i Generatora");
                    System.out.println("usp  - > Usun Sklad Pociagu");
                    break;
                case ("wusp"):
                    try {
                        System.out.println("Aktualna lista pociagow:");
                        wyswietlListeSkladowPociagow();
                        System.out.println("Wybierz opcje wpisujac znaki");
                        System.out.println("snsp - > Stworz Nowy Sklad Pociagu");
                        System.out.println("wusp - > Wyswietl Utworzone Sklady Pociagow");
                        System.out.println("mzsp - > Modyfikuj Zrobiony Sklad Pociagu");
                        System.out.println("mmig - > Menu Mapy i Generatora");
                        System.out.println("usp  - > Usun Sklad Pociagu");
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex);
                    }
                    break;
                case ("mzsp"):
                    System.out.println("Wybierz numer z {liczba}, ktory Sklad chcesz zmodyfikowac: ");
                    wyswietlListeSkladowPociagow();
                    if (!Main.listaSkladPociagu.isEmpty()) {
                        try {
                            Main.listaSkladPociagu.get(ktorySklad.nextInt() - 1).instrukcjaLokomotywy();
                        } catch (InputMismatchException e) {
                            System.out.println("Podaj liczbe a nie znaki");
                        }
                    } else {
                        System.out.println("Nie ma wagonow, ktore mozesz zmodyfikowac");
                    }
                    break;
                case ("usp"):
                    try {
                        usunSkladPociagu();
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex);
                    }
                    System.out.println("Wybierz opcje wpisujac znaki");
                    System.out.println("snsp - > Stworz Nowy Sklad Pociagu");
                    System.out.println("wusp - > Wyswietl Utworzone Sklady Pociagow");
                    System.out.println("mzsp - > Modyfikuj Zrobiony Sklad Pociagu");
                    System.out.println("mmig - > Menu Mapy i Generatora");
                    System.out.println("usp  - > Usun Sklad Pociagu");

                    break;
                case "mmig":
                    Main.menuMapa(Main.tablicaNazwMiast);
                    break;
                case "stop":
                    System.out.println("Opuszczasz instrukcje");
                    czyPrawda = true;
                    break;
                default:
                    System.out.println("Podales nie poprawny ciag liter, prosze o powtorzenie");
            }
        }
    }

    public static void wyswietlListeSkladowPociagow() {
        for (int i = 0; i < Main.listaSkladPociagu.size(); i++) {
            System.out.println("{" + (i + 1) + "}" + " " + Main.listaSkladPociagu.get(i));
        }
    }

    public static void usunSkladPociagu() {

        System.out.println("Aktualna lista Skladow Pociagow: ");
        wyswietlListeSkladowPociagow();
        try {
            if (Main.listaSkladPociagu.isEmpty()) {
                System.out.println("Brak Skladow do usuniecia");
            } else {
                System.out.println("Wybierz numer z {liczba}:");
                Main.listaSkladPociagu.remove(ktorySklad.nextInt() - 1);
                System.out.println("Akutalna lista Skladow Pociagow po usunieciu: ");
                wyswietlListeSkladowPociagow();
            }
        } catch (Exception e) {
            System.out.println("Nie ma takiego ");
        }
    }

}
