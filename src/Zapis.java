import java.sql.*;
import java.util.Scanner;

public class Zapis extends Polaczenie{

    static Scanner wczytaj = new Scanner(System.in);
    static String imie,nazwisko,dataur,datazat,email,numertel,login1, haslo1,cena,idmiejscapracy,idstanowiska,wynagordzenie,idpracownika,idklienta,idmiesjca,data,godzina,iloscGodzin;

    public static void Klient(){

        System.out.println("Imie: ");
        imie=wczytaj.nextLine();
        System.out.println("Nazwisko: ");
        nazwisko=wczytaj.nextLine();
        System.out.println("Data urodzenia (YYYY-MM-DD): ");
        dataur=wczytaj.nextLine();
        System.out.println("Email: ");
        email=wczytaj.nextLine();
        System.out.println("Numer telefonu (9 cyfr): ");
        numertel=wczytaj.nextLine();
        System.out.println("Login: ");
        login1=wczytaj.nextLine();
        System.out.println("Haslo (max 4 znaki): ");
        haslo1=wczytaj.nextLine();
        if (imie.length() > 0 && nazwisko.length() > 0 && dataur.matches("\\d{4}-\\d{2}-\\d{2}") && email.contains("@")
                && numertel.matches("\\d{9}") && login1.length() > 0 && haslo1.length() <= 4)
        {
            String sql = "INSERT INTO klienci(Imie,Nazwisko,Data_ur,email,Numer_tel,login,haslo) " +
                    "VALUES('" + imie + "','" + nazwisko + "','" + dataur + "','" + email + "','" + numertel + "','" + login1 + "','" + haslo1 + "')";

            try {
                PreparedStatement statement = polacz.prepareStatement(sql);
                int row = statement.executeUpdate(sql);
                if (row > 0) System.out.println("Klient pomyslnie dodany");
                else {
                    System.out.println("Wpisano niepoprawne dane: ");
                    Menu.MenuPowrotDodajKlienta();
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.out.println("Wpisano niepoprawne dane: ");
            Menu.MenuPowrotDodajKlienta();
        }
    }
    public static void Pracownik(){

        System.out.println("Imie: ");
        imie=wczytaj.nextLine();
        System.out.println("Nazwisko: ");
        nazwisko=wczytaj.nextLine();
        System.out.println("Data urodzenia (YYYY-MM-DD): ");
        dataur=wczytaj.nextLine();
        System.out.println("Data zatrudniena (YYYY-MM-DD): ");
        datazat=wczytaj.nextLine();
        System.out.println("Email: ");
        email=wczytaj.nextLine();
        System.out.println("Numer telefonu (9 cyfr): ");
        numertel=wczytaj.nextLine();
        System.out.println("ID stanowiska (1-4): ");
        idstanowiska=wczytaj.nextLine();
        System.out.println("ID miejsca pracy (1-4): ");
        idmiejscapracy=wczytaj.nextLine();
        System.out.println("Wynagrodzenie: ");
        wynagordzenie=wczytaj.nextLine();
        System.out.println("Login: ");
        login1=wczytaj.nextLine();
        System.out.println("Haslo (max 4 znaki): ");
        haslo1=wczytaj.nextLine();

        if (imie.length() > 0 && nazwisko.length() > 0 && dataur.matches("\\d{4}-\\d{2}-\\d{2}")&& datazat.matches("\\d{4}-\\d{2}-\\d{2}") && email.contains("@")
                && numertel.matches("\\d{9}") && idstanowiska.length()>0&& idmiejscapracy.length()>0 && wynagordzenie.matches("\\d+(\\.\\d{2})?") && login1.length() > 0 && haslo1.length() <= 4)
        {
            String sql = "INSERT INTO pracownicy(Imie,Nazwisko,Data_ur,Data_zat,email,Numer_tel,ID_stanowiska,ID_miejsca_pracy,Wynagrodzenie,login,haslo) " +
                    "VALUES('" + imie + "','" + nazwisko + "','" + dataur + "','" + datazat + "','" + email + "','" + numertel + "','" + idstanowiska + "','" + idmiejscapracy + "','" + wynagordzenie + "','" + login1 + "','" + haslo1 + "')";

            try {
                PreparedStatement statement = polacz.prepareStatement(sql);
                int row = statement.executeUpdate(sql);
                if (row > 0) System.out.println("Pracownik pomyslnie dodany");
                else {
                    System.out.println("Wpisano niepoprawne dane ");
                    Menu.MenuPowrotDodajPracownika();
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.out.println("Wpisano niepoprawne dane ");
            Menu.MenuPowrotDodajPracownika();
        }
    }
    public static void Rezerwacja()
    {
        System.out.println("Dzien rezerwacji (YYYY-MM-DD): ");
        data=wczytaj.nextLine();
        System.out.println("Godzina (00:00:00): ");
        godzina=wczytaj.nextLine();
        System.out.println("Ilosc godzin: ");
        iloscGodzin=wczytaj.nextLine();
        System.out.println("ID miejsca rezerwacji (1-4): ");
        idmiesjca=wczytaj.nextLine();
        System.out.println("Cena: ");
        cena=wczytaj.nextLine();
        System.out.println("ID pracownika: ");
        idpracownika=wczytaj.nextLine();
        System.out.println("ID klienta: ");
        idklienta=wczytaj.nextLine();
        if (data.matches("\\d{4}-\\d{2}-\\d{2}") && godzina.matches("\\d{2}:\\d{2}:\\d{2}") && iloscGodzin.matches("\\d+")
                && idmiesjca.matches("[1-4]") && cena.matches("\\d+(\\.\\d{2})?") && idpracownika.matches("\\d+") && idklienta.matches("\\d+"))
        {
            String sql = "INSERT INTO rezerwacje(Data,Godzina,Ilosc_godzin,ID_miejsca,Cena_rezerwacji,ID_pracownika,ID_klienta) " +
                    "VALUES('" + data + "','" + godzina + "','" + iloscGodzin + "','" + idmiesjca + "','" + cena + "','" + idpracownika + "','" + idklienta + "')";

            try {
                PreparedStatement statement = polacz.prepareStatement(sql);
                int row = statement.executeUpdate(sql);
                if (row > 0) System.out.println("Rezerwacja pomyslnie dodana");
                else {
                    System.out.println("Wpisano niepoprawne dane ");
                    Menu.MenuPowrotDodajRezerwacje();
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.out.println("Wpisano niepoprawne dane ");
            Menu.MenuPowrotDodajRezerwacje();
        }
    }
}
