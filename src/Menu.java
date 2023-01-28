import java.util.Scanner;

public class Menu {
    static int wybor;
    static Scanner wybierz = new Scanner(System.in);

    public static void menuStart() {
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Witaj! Wybierz jedna z ponizszych opcji: ");

        System.out.println
                ("1) Zaloguj sie jako klient\n"
                        + "2) Zaloguj sie jako pracownik\n"
                        + "3) Zamknij aplikacje");

        System.out.println("-----------------------------------------------------------------");

        wybor = wybierz.nextInt();

        switch (wybor) {
            case 1:
                Logowanie.logowanieKlient();
                break;
            case 2:
                Logowanie.logowaniePracownik();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Prosze wybrac odpowiednia opcje");
                menuStart();
        }
    }

    public static void menuKlient() {
        System.out.println("-----------------------------------------------------------------");

        System.out.println
                ("1) Sprwadz swoje dane\n"
                        + "2) Sprwadz swoja rezerwacje\n"
                        + "3) Wroc do menu\n"
                        + "4) Zamknij aplikacje");

        System.out.println("-----------------------------------------------------------------");

        wybor = wybierz.nextInt();

        switch (wybor) {
            case 1:
                Odczyt.DaneKlient();
                System.out.println("\n");
                menuPowrotKlient();
                break;
            case 2:
                Odczyt.RezerwacjeKlient();
                System.out.println("\n");
                menuPowrotKlient();
                break;
            case 3:
                menuStart();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Prosze wybrac odpowiednia opcje");
                menuKlient();
        }
    }

    public static void menuPracownik() {
        System.out.println("-----------------------------------------------------------------");

        System.out.println
                ("1) Sprawdz rezerwacje\n"
                        + "2) Sprwadz dane Klientow\n"
                        + "3) Sprwadz dane Pracownikow\n"
                        + "4) Wroc do menu\n"
                        + "5) Zamknij aplikacje");

        System.out.println("-----------------------------------------------------------------");
        wybor = wybierz.nextInt();

        switch (wybor) {
            case 1:
                Odczyt.Rezerwacje();
                System.out.println("\n");
                zaradzanieRezerwacja();

                break;
            case 2:
                Odczyt.Klienci();
                System.out.println("\n");
                zaradzanieKlientem();
                break;
            case 3:
                Odczyt.Pracownicy();
                System.out.println("\n");
                zaradzaniePracownik();
                break;
            case 4:
                menuStart();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Prosze wybrac odpowiednia opcje");
                menuPracownik();

        }
    }

    public static void menuKlientLogowanie() {
        System.out.println("-----------------------------------------------------------------");

        System.out.println
                ("1) Zaloguj sie ponownie\n"
                        + "2) Powroc do glownego menu\n"
                        + "3) Zamknij aplikacje");

        System.out.println("-----------------------------------------------------------------");

        wybor = wybierz.nextInt();

        switch (wybor) {
            case 1:
                Logowanie.logowanieKlient();
                break;
            case 2:
                menuStart();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Prosze wybrac odpowiednia opcje");
                menuKlientLogowanie();
        }
    }

    public static void menuPracownikLogowanie() {
        System.out.println("-----------------------------------------------------------------");

        System.out.println
                ("1) Zaloguj sie ponownie\n"
                        + "2) Powroc do glownego menu\n"
                        + "3) Zamknij aplikacje");

        System.out.println("-----------------------------------------------------------------");

        wybor = wybierz.nextInt();

        switch (wybor) {
            case 1:
                Logowanie.logowaniePracownik();
                break;
            case 2:
                menuStart();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Prosze wybrac odpowiednia opcje");
                menuPracownikLogowanie();
        }
    }

    public static void menuPowrotKlient() {
        System.out.println("-----------------------------------------------------------------");

        System.out.println
                ("1)Wroc do menu glownego\n"
                        + "2) Zamknij aplikacje");

        System.out.println("-----------------------------------------------------------------");

        wybor = wybierz.nextInt();

        switch (wybor) {
            case 1:
                menuKlient();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.println("Prosze wybrac odpowiednia opcje");
                menuPowrotKlient();
        }
    }

    public static void zaradzanieRezerwacja() {
        System.out.println("-----------------------------------------------------------------");

        System.out.println
                ("1) Dodaj nowa rezerwacje\n"
                        + "2) Usun rezerwacje\n"
                        + "3) Zaktualizuj dane rezerwacji\n"
                        + "4) Wroc do menu\n"
                        + "5) Zamknij aplikacje");

        System.out.println("-----------------------------------------------------------------");

        wybor = wybierz.nextInt();
        switch (wybor) {
            case 1:
                Zapis.Rezerwacja();
                System.out.println("\n");
                menuPracownik();
                break;
            case 2:
                Usun.Rezerwacja();
                System.out.println("\n");
                menuPracownik();
                break;
            case 3:
                Aktualizacja.Rezerwacja();
                System.out.println("\n");
                menuPracownik();
                break;
            case 4:
                menuPracownik();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Prosze wybrac odpowiednia opcje");
                zaradzanieRezerwacja();

        }
    }

    public static void zaradzanieKlientem() {
        System.out.println("-----------------------------------------------------------------");

        System.out.println
                ("1) Dodaj nowego klienta\n"
                        + "2) Usun klienta\n"
                        + "3) Zaktualizuj dane klienta\n"
                        + "4) Wroc do menu\n"
                        + "5) Zamknij aplikacje");

        System.out.println("-----------------------------------------------------------------");

        wybor = wybierz.nextInt();
        switch (wybor) {
            case 1:
                Zapis.Klient();
                System.out.println("\n");
                menuPracownik();
                break;
            case 2:
                Usun.Klient();
                System.out.println("\n");
                menuPracownik();
                break;
            case 3:
                Aktualizacja.Klient();
                System.out.println("\n");
                menuPracownik();
                break;
            case 4:
                menuPracownik();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Prosze wybrac odpowiednia opcje");
                zaradzanieKlientem();

        }
    }

    public static void zaradzaniePracownik() {
        System.out.println("-----------------------------------------------------------------");

        System.out.println
                ("1) Dodaj nowego Pracownika\n"
                        + "2) Usun Pracownika\n"
                        + "3) Zaktualizuj dane pracownika\n"
                        + "4) Wroc do menu\n"
                        + "5) Zamknij aplikacje");

        System.out.println("-----------------------------------------------------------------");

        wybor = wybierz.nextInt();
        switch (wybor) {
            case 1:
                Zapis.Pracownik();
                System.out.println("\n");
                menuPracownik();
                break;
            case 2:
                Usun.Pracownik();
                System.out.println("\n");
                menuPracownik();
                break;
            case 3:
                Aktualizacja.Pracownik();
                System.out.println("\n");
                menuPracownik();
                break;
            case 4:
                menuPracownik();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Prosze wybrac odpowiednia opcje");
                zaradzaniePracownik();

        }
    }

    public static void MenuPowrotUsunPracownika() {
        System.out.println("-----------------------------------------------------------------");

        System.out.println
                ("1)Wpisz ponownie dane\n"
                        + "2) Wroc do menu");

        System.out.println("-----------------------------------------------------------------");

        wybor = wybierz.nextInt();

        switch (wybor) {
            case 1:
                Odczyt.Pracownicy();
                System.out.println("\n");
                Usun.Pracownik();
                break;
            case 2:
                Menu.zaradzaniePracownik();
                break;
            default:
                System.out.println("Prosze wybrac odpowiednia opcje");
                System.out.println("\n");
                MenuPowrotUsunPracownika();
        }
    }

    public static void MenuPowrotUsunKlienta() {
        System.out.println("-----------------------------------------------------------------");

        System.out.println
                ("1)Wpisz ponownie dane\n"
                        + "2) Wroc do menu");

        System.out.println("-----------------------------------------------------------------");

        wybor = wybierz.nextInt();

        switch (wybor) {
            case 1:
                Odczyt.Klienci();
                System.out.println("\n");
                Usun.Klient();
                break;
            case 2:
                Menu.zaradzanieKlientem();
                break;
            default:
                System.out.println("Prosze wybrac odpowiednia opcje");
                System.out.println("\n");
                MenuPowrotUsunKlienta();
        }
    }

    public static void MenuPowrotUsunRezerwacje() {
        System.out.println("-----------------------------------------------------------------");

        System.out.println
                ("1)Wpisz ponownie dane\n"
                        + "2) Wroc do menu");

        System.out.println("-----------------------------------------------------------------");

        wybor = wybierz.nextInt();

        switch (wybor) {
            case 1:
                Odczyt.Rezerwacje();
                System.out.println("\n");
                Usun.Rezerwacja();
                break;
            case 2:
                Menu.zaradzanieRezerwacja();
                break;
            default:
                System.out.println("Prosze wybrac odpowiednia opcje");
                System.out.println("\n");
                MenuPowrotUsunRezerwacje();
        }
    }

    public static void MenuPowrotAktualizacjaKlienta() {
        System.out.println("-----------------------------------------------------------------");

        System.out.println
                ("1)Wpisz ponownie dane\n"
                        + "2) Wroc do menu");

        System.out.println("-----------------------------------------------------------------");

        wybor = wybierz.nextInt();
        switch (wybor) {
            case 1:
                Odczyt.Klienci();
                System.out.println("\n");
                Aktualizacja.Klient();
                break;
            case 2:
                Menu.zaradzanieKlientem();
                break;
            default:
                System.out.println("Prosze wybrac odpowiednia opcje");
                System.out.println("\n");
                MenuPowrotAktualizacjaKlienta();
        }
    }

    public static void MenuPowrotAktualizacjaPracownika() {
        System.out.println("-----------------------------------------------------------------");

        System.out.println
                ("1)Wpisz ponownie dane\n"
                        + "2) Wroc do menu");

        System.out.println("-----------------------------------------------------------------");

        wybor = wybierz.nextInt();
        switch (wybor) {
            case 1:
                Odczyt.Pracownicy();
                System.out.println("\n");
                Aktualizacja.Pracownik();
                break;
            case 2:
                Menu.zaradzaniePracownik();
                break;
            default:
                System.out.println("Prosze wybrac odpowiednia opcje");
                System.out.println("\n");
                MenuPowrotAktualizacjaPracownika();
        }
    }

    public static void MenuPowrotAktualizacjaRezerwacji() {
        System.out.println("-----------------------------------------------------------------");

        System.out.println
                ("1)Wpisz ponownie dane\n"
                        + "2) Wroc do menu");

        System.out.println("-----------------------------------------------------------------");

        wybor = wybierz.nextInt();
        switch (wybor) {
            case 1:
                Odczyt.Rezerwacje();
                System.out.println("\n");
                Aktualizacja.Rezerwacja();
                break;
            case 2:
                Menu.zaradzaniePracownik();
                break;
            default:
                System.out.println("Prosze wybrac odpowiednia opcje");
                System.out.println("\n");
                MenuPowrotAktualizacjaRezerwacji();
        }
    }
    public static void MenuPowrotDodajKlienta(){
        System.out.println("-----------------------------------------------------------------");

        System.out.println
                ("1)Wpisz ponownie dane\n"
                        + "2) Wroc do menu");

        System.out.println("-----------------------------------------------------------------");

        wybor = wybierz.nextInt();
        switch (wybor) {
            case 1:
                Odczyt.Klienci();
                System.out.println("\n");
                Zapis.Klient();
                break;
            case 2:
                Menu.zaradzaniePracownik();
                break;
            default:
                System.out.println("Prosze wybrac odpowiednia opcje");
                System.out.println("\n");
                MenuPowrotDodajKlienta();
        }
    }
    public static void MenuPowrotDodajPracownika(){
        System.out.println("-----------------------------------------------------------------");

        System.out.println
                ("1)Wpisz ponownie dane\n"
                        + "2) Wroc do menu");

        System.out.println("-----------------------------------------------------------------");

        wybor = wybierz.nextInt();
        switch (wybor) {
            case 1:
                Odczyt.Pracownicy();
                System.out.println("\n");
                Zapis.Rezerwacja();
                break;
            case 2:
                Menu.zaradzaniePracownik();
                break;
            default:
                System.out.println("Prosze wybrac odpowiednia opcje");
                System.out.println("\n");
                MenuPowrotDodajPracownika();
        }
    }
    public static void MenuPowrotDodajRezerwacje(){
        System.out.println("-----------------------------------------------------------------");

        System.out.println
                ("1)Wpisz ponownie dane\n"
                        + "2) Wroc do menu");

        System.out.println("-----------------------------------------------------------------");

        wybor = wybierz.nextInt();
        switch (wybor) {
            case 1:
                Odczyt.Rezerwacje();
                System.out.println("\n");
                Zapis.Rezerwacja();
                break;
            case 2:
                Menu.zaradzaniePracownik();
                break;
            default:
                System.out.println("Prosze wybrac odpowiednia opcje");
                System.out.println("\n");
                MenuPowrotDodajRezerwacje();
        }
    }
}