import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        CarroDAO dao = new CarroDAO();

        // Inserir carro sem id (AutoNumber)
        Carro carro1 = new Carro("Toyota", "ABC-1234", "Preto", 10, 15);
        try {
            dao.inserir(carro1);
        } catch (SQLException e) {
            System.out.println("Erro ao inserir carro: " + e.getMessage());
        }

        // Inserir carro com id manual
        Carro carro2 = new Carro(2, "Honda", "XYZ-5678", "Branco", 11, 16);
        try {
            dao.inserirComId(carro2);
        } catch (SQLException e) {
            System.out.println("Erro ao inserir carro com id: " + e.getMessage());
        }

        // Listar todos os carros
        try {
            for (Carro c : dao.listar()) {
                System.out.println(c.getId() + " | " + c.getMarca() + " | " + c.getPlaca());
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar carros: " + e.getMessage());
        }
    }
}
