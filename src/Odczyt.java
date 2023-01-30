import java.sql.*;

public class Odczyt extends Polaczenie{
    public static void Rezerwacje()
    {
        String sql="Select * from rezerwacje";

        {
            try {

                Statement statement = polacz.createStatement();
                ResultSet wynik=statement.executeQuery(sql);
                System.out.println("Tabela rezerwacje: ");
                while (wynik.next())
                {
                    System.out.println(
                            "ID: "+wynik.getInt(1)+" Data: "+wynik.getString(2)
                            +" Godzina: "+wynik.getString(3) +" Ilosc godzin: "+wynik.getString(4)
                            +" ID miejsca: "+wynik.getString(5) +" Cena: "+wynik.getString(6)
                            +" ID klienta: "+wynik.getString(7)+" ID pracownika: "+wynik.getString(8));
                }
                //polacz.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void Klienci()
    {

        String sql="Select * from klienci";

        {
            try {

                Statement statement = polacz.createStatement();
                ResultSet wynik=statement.executeQuery(sql);
                System.out.println("Tabela klienci: ");
                while (wynik.next())
                {
                    System.out.println(
                            "ID: "+wynik.getInt(1)+" Imie i Nazwisko: "+wynik.getString(2)
                                    +" "+wynik.getString(3) +" Data urodzenia: "+wynik.getString(4)
                                    +" Email: "+wynik.getString(5) +" Numer telefonu: "+wynik.getString(6));
                }
                //polacz.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void Pracownicy()
    {

        String sql="Select * from pracownicy";

        {
            try {

                Statement statement = polacz.createStatement();
                ResultSet wynik=statement.executeQuery(sql);
                System.out.println("Tabela pracownicy: ");
                while (wynik.next())
                {
                    System.out.println(
                            "ID: "+wynik.getInt(1)+" Imie i Nazwisko: "+wynik.getString(2)
                                    +" "+wynik.getString(3) +" Data urodzenia: "+wynik.getString(4)
                                    +" Data zatrundienia: "+wynik.getString(5) +" Email: "+wynik.getString(6)
                                    +" Numer telefonu: "+wynik.getString(7)+" ID stanowiska: "+wynik.getString(8)
                                    +" ID miejsca pracy: "+wynik.getString(9)+" Wynagrodzenie: "+wynik.getString(10));
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void DaneKlient()
    {

        String sql="select * from klienci where login=\"" + Logowanie.login + "\"";

        {
            try {

                Statement statement = polacz.createStatement();
                ResultSet wynik=statement.executeQuery(sql);
                while (wynik.next())
                {
                    System.out.println(
                            "ID: "+wynik.getInt(1)+" Imie i Nazwisko: "+wynik.getString(2)
                                    +" "+wynik.getString(3) +" Data urodzenia: "+wynik.getString(4)
                                    +" Email: "+wynik.getString(5) +" Numer telefonu: "+wynik.getString(6));
                }
                //polacz.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void RezerwacjeKlient()
    {

        String sql="select * from rezerwacje join klienci on rezerwacje.ID_klienta=klienci.ID_klienta where login=\""
                + Logowanie.login + "\"";

        {
            try {

                Statement statement = polacz.createStatement();
                ResultSet wynik=statement.executeQuery(sql);
                while (wynik.next())
                {
                    System.out.println(
                            "ID: "+wynik.getInt(1)+" Data: "+wynik.getString(2)
                                    +" Godzina: "+wynik.getString(3) +" Ilosc godzin: "+wynik.getString(4)
                                    +" ID miejsca: "+wynik.getString(5) +" Cena: "+wynik.getString(6)
                                    +" ID klienta: "+wynik.getString(7)+" ID pracownika: "+wynik.getString(8));
                }
                //polacz.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}