import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Usun extends Polaczenie{

    static String id;
    static Scanner wczytaj = new Scanner(System.in);

    public static void Klient(){
        System.out.println("Podaj id klienta ktorego chcesz usunac: ");
        id=wczytaj.nextLine();
        //Test commita
        if (id.matches("\\d+")) {
            String sql = "DELETE FROM klienci WHERE ID_klienta=" + id;


            try {
                PreparedStatement statement = polacz.prepareStatement(sql);
                int row = statement.executeUpdate(sql);
                if (row > 0) System.out.println("Klient pomyslnie usuniety");
                else {
                    System.out.println("Wpisano niepoprawne dane ");
                    Menu.MenuPowrotUsunKlienta();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            System.out.println("Wpisano niepoprawne dane ");
            Menu.MenuPowrotUsunKlienta();
        }

    }
    public static void Pracownik(){
        System.out.println("Podaj id pracownika ktorego chcesz usunac: ");
        id=wczytaj.nextLine();
        if (id.matches("\\d+")) {
            String sql = "DELETE FROM pracownicy WHERE ID_pracownika=" + id;


            try {
                PreparedStatement statement = polacz.prepareStatement(sql);
                int row = statement.executeUpdate(sql);
                if (row > 0) System.out.println("Pracownik pomyslnie usuniety");
                else {
                    System.out.println("Wpisano niepoprawne dane ");
                    Menu.MenuPowrotUsunPracownika();
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.out.println("Wpisano niepoprawne dane ");
            Menu.MenuPowrotUsunPracownika();
        }

    }
    public static void Rezerwacja(){
        System.out.println("Podaj id rezerwacji ktora chcesz usunac: ");
        id=wczytaj.nextLine();
        if (id.matches("\\d+")) {
            String sql = "DELETE FROM rezerwacje WHERE ID_rezerwacji=" + id;


            try {
                PreparedStatement statement = polacz.prepareStatement(sql);
                int row = statement.executeUpdate(sql);
                if (row > 0) System.out.println("Rezerwacja pomyslnie usunieta");
                else {
                    System.out.println("Wpisano niepoprawne dane ");
                    Menu.MenuPowrotUsunRezerwacje();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.out.println("Wpisano niepoprawne dane ");
            Menu.MenuPowrotUsunRezerwacje();
        }
    }
}
