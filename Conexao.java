import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:ucanaccess://C:/Users/Amanda Albuquerque/Desktop/POOII - AVA2/CarroApp/estacionamento.accdb";

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
            throw e;
        }
    }
}
