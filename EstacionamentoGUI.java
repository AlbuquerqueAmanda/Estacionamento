import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EstacionamentoGUI extends JFrame {

    private final CarroDAO dao = new CarroDAO();
    private final JTable table;
    private final DefaultTableModel model;

    private final JTextField txtId;
    private final JTextField txtMarca;
    private final JTextField txtPlaca;
    private final JTextField txtCor;
    private final JTextField txtHoraEntrada;
    private final JTextField txtHoraSaida;

    public EstacionamentoGUI() {
        setTitle("Gestão de Estacionamento");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel de formulário
        JPanel panelForm = new JPanel(new GridLayout(6, 2, 5, 5));

        panelForm.add(new JLabel("ID:"));
        txtId = new JTextField();
        panelForm.add(txtId);

        panelForm.add(new JLabel("Marca:"));
        txtMarca = new JTextField();
        panelForm.add(txtMarca);

        panelForm.add(new JLabel("Placa:"));
        txtPlaca = new JTextField();
        panelForm.add(txtPlaca);

        panelForm.add(new JLabel("Cor:"));
        txtCor = new JTextField();
        panelForm.add(txtCor);

        panelForm.add(new JLabel("Hora Entrada:"));
        txtHoraEntrada = new JTextField();
        panelForm.add(txtHoraEntrada);

        panelForm.add(new JLabel("Hora Saída:"));
        txtHoraSaida = new JTextField();
        panelForm.add(txtHoraSaida);

        // Botões
        JPanel panelButtons = new JPanel();

        JButton btnInserir = new JButton("Inserir");
        JButton btnAtualizar = new JButton("Atualizar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnListar = new JButton("Listar");

        panelButtons.add(btnInserir);
        panelButtons.add(btnAtualizar);
        panelButtons.add(btnExcluir);
        panelButtons.add(btnListar);

        // Tabela
        model = new DefaultTableModel(new String[]{"ID", "Marca", "Placa", "Cor", "Hora Entrada", "Hora Saída"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Layout principal
        setLayout(new BorderLayout());
        add(panelForm, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Ações dos botões
        btnInserir.addActionListener(e -> inserirCarro());
        btnAtualizar.addActionListener(e -> atualizarCarro());
        btnExcluir.addActionListener(e -> excluirCarro());
        btnListar.addActionListener(e -> listarCarros());
    }

    private void inserirCarro() {
        try {
            String idText = txtId.getText().trim();
            Carro carro;
            if (!idText.isEmpty()) {
                int id = Integer.parseInt(idText);
                carro = new Carro(id, txtMarca.getText(), txtPlaca.getText(), txtCor.getText(),
                        Integer.parseInt(txtHoraEntrada.getText()),
                        Integer.parseInt(txtHoraSaida.getText()));
                dao.inserirComId(carro);
            } else {
                carro = new Carro(txtMarca.getText(), txtPlaca.getText(), txtCor.getText(),
                        Integer.parseInt(txtHoraEntrada.getText()),
                        Integer.parseInt(txtHoraSaida.getText()));
                dao.inserir(carro);
            }
            JOptionPane.showMessageDialog(this, "Carro inserido com sucesso!");
            limparCampos();
            listarCarros();
        } catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao inserir carro: " + ex.getMessage());
        }
    }

    private void atualizarCarro() {
        try {
            int id = Integer.parseInt(txtId.getText());
            Carro carro = new Carro(id, txtMarca.getText(), txtPlaca.getText(), txtCor.getText(),
                    Integer.parseInt(txtHoraEntrada.getText()),
                    Integer.parseInt(txtHoraSaida.getText()));
            dao.atualizar(carro);
            JOptionPane.showMessageDialog(this, "Carro atualizado com sucesso!");
            limparCampos();
            listarCarros();
        } catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar carro: " + ex.getMessage());
        }
    }

    private void excluirCarro() {
        try {
            int id = Integer.parseInt(txtId.getText());
            dao.excluir(id);
            JOptionPane.showMessageDialog(this, "Carro excluído com sucesso!");
            limparCampos();
            listarCarros();
        } catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir carro: " + ex.getMessage());
        }
    }

    private void listarCarros() {
        try {
            List<Carro> carros = dao.listar();
            model.setRowCount(0); // Limpa a tabela
            for (Carro c : carros) {
                model.addRow(new Object[]{c.getId(), c.getMarca(), c.getPlaca(), c.getCor(),
                        c.getHoraEntrada(), c.getHoraSaida()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao listar carros: " + ex.getMessage());
        }
    }

    private void limparCampos() {
        txtId.setText("");
        txtMarca.setText("");
        txtPlaca.setText("");
        txtCor.setText("");
        txtHoraEntrada.setText("");
        txtHoraSaida.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EstacionamentoGUI().setVisible(true));
    }
}
