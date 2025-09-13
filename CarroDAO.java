import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {

    // Inserir carro sem id (AutoNumber)
    public void inserir(Carro carro) throws SQLException {
String sql = "INSERT INTO Carro (marca, placa, cor, horaEntrada, horaSaida) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, carro.getMarca());
            stmt.setString(2, carro.getPlaca());
            stmt.setString(3, carro.getCor());
            stmt.setInt(4, carro.getHoraEntrada());
            stmt.setInt(5, carro.getHoraSaida());

            stmt.executeUpdate();
            System.out.println("Carro inserido com sucesso!");
        }
    }

    // Inserir carro com id (manual)
    public void inserirComId(Carro carro) throws SQLException {
        String sql = "INSERT INTO [Carro] ([id], [marca], [placa], [cor], [horaEntrada], [horaSaida]) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, carro.getId());
            stmt.setString(2, carro.getMarca());
            stmt.setString(3, carro.getPlaca());
            stmt.setString(4, carro.getCor());
            stmt.setInt(5, carro.getHoraEntrada());
            stmt.setInt(6, carro.getHoraSaida());

            stmt.executeUpdate();
            System.out.println("Carro inserido com sucesso (com id)!");
        }
    }

    // Atualizar
    public void atualizar(Carro carro) throws SQLException {
        String sql = "UPDATE [Carro] SET [marca]=?, [placa]=?, [cor]=?, [horaEntrada]=?, [horaSaida]=? WHERE [id]=?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, carro.getMarca());
            stmt.setString(2, carro.getPlaca());
            stmt.setString(3, carro.getCor());
            stmt.setInt(4, carro.getHoraEntrada());
            stmt.setInt(5, carro.getHoraSaida());
            stmt.setInt(6, carro.getId());

            stmt.executeUpdate();
            System.out.println("Carro atualizado com sucesso!");
        }
    }

    // Excluir
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM [Carro] WHERE [id]=?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Carro excluído com sucesso!");
        }
    }

    // Listar
    public List<Carro> listar() throws SQLException {
        List<Carro> carros = new ArrayList<>();
        String sql = "SELECT * FROM [Carro]";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Carro carro = new Carro(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("placa"),
                        rs.getString("cor"),
                        rs.getInt("horaEntrada"),
                        rs.getInt("horaSaida")
                );
                carros.add(carro);
            }
        }
        return carros;
    }
}
