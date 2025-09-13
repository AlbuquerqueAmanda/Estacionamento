public class Carro {
    private int id;
    private String marca;
    private String placa;
    private String cor;
    private int horaEntrada;
    private int horaSaida;

    // Construtor vazio
    public Carro() {}

    // Construtor com id
    public Carro(int id, String marca, String placa, String cor, int horaEntrada, int horaSaida) {
        this.id = id;
        this.marca = marca;
        this.placa = placa;
        this.cor = cor;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    // Construtor sem id (para AutoNumber)
    public Carro(String marca, String placa, String cor, int horaEntrada, int horaSaida) {
        this.marca = marca;
        this.placa = placa;
        this.cor = cor;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
    public int getHoraEntrada() { return horaEntrada; }
    public void setHoraEntrada(int horaEntrada) { this.horaEntrada = horaEntrada; }
    public int getHoraSaida() { return horaSaida; }
    public void setHoraSaida(int horaSaida) { this.horaSaida = horaSaida; }
}
