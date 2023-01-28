import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Aktualizacja extends Polaczenie{

    static String id,email,numer,data,godzina,iloscGodzin,cena;
    static Scanner wczytaj = new Scanner(System.in);

    public static void Klient(){
        System.out.println("Podaj id klienta ktorego dane chcesz zaaktualizowac: ");
        id=wczytaj.nextLine();
        System.out.println("Podaj nowy email: ");
        email=wczytaj.nextLine();
        System.out.println("Podaj nowy numer telefonu (9 cyfr): ");
        numer=wczytaj.nextLine();

            String sql="UPDATE klienci SET email='"+email+"',Numer_tel='"+numer+"'WHERE ID_Klienta='"+id+"'";

        try {
            PreparedStatement statement=polacz.prepareStatement(sql);
            int row = statement.executeUpdate(sql);
            if (row>0 ) System.out.println("Dane pomyslnie zaktualizowane");
            else
            {
                System.out.println("Wpisano niepoprawne dane ");
                Menu.MenuPowrotAktualizacjaKlienta();
            }

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
    public static void Pracownik(){
        System.out.println("Podaj id pracownika ktorego dane chcesz zaaktualizowac: ");
        id=wczytaj.nextLine();

        System.out.println("Podaj nowy email: ");
        email=wczytaj.nextLine();
        System.out.println("Podaj nowy numer telefonu (9 cyfr): ");
        numer=wczytaj.nextLine();

        String sql="UPDATE pracownicy SET email='"+email+"',Numer_tel='"+numer+"'WHERE ID_Pracownika='"+id+"'";

        try {
            PreparedStatement statement=polacz.prepareStatement(sql);
            int row = statement.executeUpdate(sql);
            if (row>0) System.out.println("Dane pomyslnie zaktualizowane");
            else
            {
                System.out.println("Wpisano niepoprawne dane ");
                Menu.MenuPowrotAktualizacjaPracownika();
            }

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public static void Rezerwacja(){
        System.out.println("Podaj id rezerwacji ktorej dane chcesz zaaktualizowac: ");
        id=wczytaj.nextLine();
        System.out.println("Podaj nowa date (YYYY-MM-DD): ");
        data=wczytaj.nextLine();
        System.out.println("Podaj nowa godzine (00:00:00): ");
        godzina=wczytaj.nextLine();
        System.out.println("Podaj nowa ilosc godzin rezerwacji: ");
        iloscGodzin=wczytaj.nextLine();
        System.out.println("Podaj nowa cene rezerwacji: ");
        cena=wczytaj.nextLine();

        String sql="UPDATE rezerwacje SET Data='"+data+"',Godzina='"+godzina+"',Ilosc_godzin='"+iloscGodzin+"',Cena_rezerwacji='"+cena+"'WHERE ID_rezerwacji='"+id+"'";

        try {
            PreparedStatement statement=polacz.prepareStatement(sql);
            int row = statement.executeUpdate(sql);
            if (row>0 ) System.out.println("Dane pomyslnie zaktualizowane");
            else
            {
                System.out.println("Wpisano niepoprawne dane ");
                Menu.MenuPowrotAktualizacjaRezerwacji();
            }

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
