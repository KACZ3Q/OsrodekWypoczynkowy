import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Polaczenie {
    static Connection polacz;

    protected void getPolacz() {
        try {
            polacz= DriverManager.getConnection("jdbc:mysql://localhost:3306/osrodekwypoczynkowy","root","");
            if (polacz != null) System.out.println("Polaczono z baza danych");
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}