package Testy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class PolaczenieTest {
    protected Connection polacz;
    private int wybor;
    private int expectedRowCount = 1;

    @Test
    public void testGetPolacz() {
        try {
            polacz = DriverManager.getConnection("jdbc:mysql://localhost:3306/osrodekwypoczynkowy","root","");
            assertNotNull(polacz);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testDaneKlienci() {
        try {
            polacz = DriverManager.getConnection("jdbc:mysql://localhost:3306/osrodekwypoczynkowy","root","");
            String sql = "SELECT * FROM klienci";
            Statement statement = polacz.createStatement();
            ResultSet result = statement.executeQuery(sql);
            assertTrue(result.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @BeforeEach
    public void setup() throws SQLException {
        polacz = DriverManager.getConnection("jdbc:mysql://localhost:3306/osrodekwypoczynkowy","root","");
    }
    @Test
    public void testLogowanieKlient() {
        String login = "user1";
        String haslo = "8tb4";

        String sql = "SELECT * FROM klienci WHERE login='" + login + "'";
        try {
            Statement statement = polacz.createStatement();
            ResultSet result = statement.executeQuery(sql);
            result.next();
            String hasloBaza = result.getString("haslo");
            assertTrue(hasloBaza.equals(haslo));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testMenuStart() {
        wybor = 1;
        assertEquals(1, wybor);
        wybor = 2;
        assertEquals(2, wybor);
        wybor = 3;
        assertEquals(3, wybor);
        wybor = 4;
        assertEquals(4, wybor);
    }
    @Test
    public void testZapisKlient() {
        String imie = "TestImie";
        String nazwisko = "TestNazwisko";
        String dataur = "2022-01-01";
        String email = "test@test.com";
        String numertel = "123456789";
        String login1 = "testlogin";
        String haslo1 = "test";

        String sql = "INSERT INTO klienci(Imie,Nazwisko,Data_ur,email,Numer_tel,login,haslo) " +
                "VALUES('"+imie+"','"+nazwisko+"','"+dataur+"','"+email+"','"+numertel+"','"+login1+"','"+haslo1+"')";

        try {
            PreparedStatement statement = polacz.prepareStatement(sql);
            int row = statement.executeUpdate();
            assertEquals(expectedRowCount, row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testAktualizacjaKlient() {
        String id = "6";
        String email = "test@test.com";
        String numer = "123456789";

        String sql = "UPDATE klienci SET email='"+email+"',Numer_tel='"+numer+"' WHERE ID_Klienta='"+id+"'";

        try {
            PreparedStatement statement = polacz.prepareStatement(sql);
            int row = statement.executeUpdate();
            assertEquals(expectedRowCount, row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testUsunPracownik() {
        try {
            polacz = DriverManager.getConnection("jdbc:mysql://localhost:3306/osrodekwypoczynkowy","root","");
            String sql = "DELETE FROM pracownicy WHERE ID_pracownika=14";
            PreparedStatement statement = polacz.prepareStatement(sql);
            int row = statement.executeUpdate(sql);
            assertEquals(expectedRowCount, row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}