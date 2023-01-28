import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Logowanie extends Odczyt{



    static String login, haslo;
    static Scanner wprowadz = new Scanner(System.in);


    protected static void logowanieKlient() {



        System.out.println("Login: ");//user1
        login = wprowadz.nextLine();

        System.out.println("Haslo: ");//8tb4
        haslo = wprowadz.nextLine();

        String sql = "select * from klienci where login=\"" + login + "\"";
        try {

            Statement statement = Polaczenie.polacz.createStatement();
            ResultSet result = statement.executeQuery(sql);
            result.next();
            String hasloBaza = result.getString("haslo");

            if (hasloBaza.equals(haslo)) {

                System.out.println("Zalogowano");
                Menu.menuKlient();
            }
        }
        catch(Exception e){
            System.out.println("Wpisano niepoprawne dane");
            Menu.menuKlientLogowanie();
        }
    }
    protected static void logowaniePracownik()
    {

        System.out.println("Login: ");//emp1
        login = wprowadz.nextLine();

        System.out.println("Haslo: ");//kc7s
        haslo = wprowadz.nextLine();

        String sql = "select * from pracownicy where login=\"" + login + "\"";
        try {

            Statement statement = Polaczenie.polacz.createStatement();
            ResultSet result = statement.executeQuery(sql);
            result.next();
            String hasloBaza = result.getString("haslo");

            if (hasloBaza.equals(haslo)) {

                System.out.println("Zalogowano");
                Menu.menuPracownik();
            }
        }
        catch(Exception e){
            System.out.println("Wpisano niepoprawne dane");
            Menu.menuPracownikLogowanie();
        }
    }
}
