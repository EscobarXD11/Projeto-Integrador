package pi.model;

public class Codigo {

    private int Id;
    private String NomeCliente;
    private String CPF;
    private String DataNascimento;
    private String MetodoPagamento;
    private String ModeloCarro;
    private String AnoCarro;
    private String NomeCarro;
    private String Placa;
    private double Valor;
    private String Servico;
    private boolean Realizado;
    
    public Codigo(){
        }

    public Codigo(int Id, String NomeCliente, String CPF, String DataNascimento, String MetodoPagamento, String ModeloCarro, String AnoCarro, String NomeCarro, String Placa, double Valor, String Servico, boolean Realizado) {
        this.Id = Id;
        this.NomeCliente = NomeCliente;
        this.CPF = CPF;
        this.DataNascimento = DataNascimento;
        this.MetodoPagamento = MetodoPagamento;
        this.ModeloCarro = ModeloCarro;
        this.AnoCarro = AnoCarro;
        this.NomeCarro = NomeCarro;
        this.Placa = Placa;
        this.Valor = Valor;
        this.Servico = Servico;
        this.Realizado = Realizado;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNomeCliente() {
        return NomeCliente;
    }

    public void setNomeCliente(String NomeCliente) {
        this.NomeCliente = NomeCliente;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public String getMetodoPagamento() {
        return MetodoPagamento;
    }

    public void setMetodoPagamento(String MetodoPagamento) {
        this.MetodoPagamento = MetodoPagamento;
    }

    public String getModeloCarro() {
        return ModeloCarro;
    }

    public void setModeloCarro(String ModeloCarro) {
        this.ModeloCarro = ModeloCarro;
    }

    public String getAnoCarro() {
        return AnoCarro;
    }

    public void setAnoCarro(String AnoCarro) {
        this.AnoCarro = AnoCarro;
    }

    public String getNomeCarro() {
        return NomeCarro;
    }

    public void setNomeCarro(String NomeCarro) {
        this.NomeCarro = NomeCarro;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public String getServico() {
        return Servico;
    }

    public void setServico(String Servico) {
        this.Servico = Servico;
    }

    public boolean isRealizado() {
        return Realizado;
    }

    public void setRealizado(boolean Realizado) {
        this.Realizado = Realizado;
    }

    
    

   public static String ConverterParaSql(String DataAntiga) {
    String[] partesData = DataAntiga.split("/");
    
    // Verificar se o array possui exatamente 3 partes
    if (partesData.length != 3) {
        throw new IllegalArgumentException("Formato de data inválido: " + DataAntiga);
    }

    String DataNova = partesData[2] + "-" + partesData[1] + "-" + partesData[0];
    return DataNova;
}
   
    public static String ConverterParaJava(String DataAntiga) {
        if (DataAntiga == null) {
            return null; // Ou faça algo para lidar com o valor nulo, dependendo do caso
        }

        String[] partesData = DataAntiga.split("-");
        if (partesData.length != 3) {
            // Se não houver exatamente três partes separadas por '-', isso indica que a string não está no formato esperado
            return null; // Ou faça algo para lidar com o formato inválido
        }

        String DataNova = partesData[2] + "/" + partesData[1] + "/" + partesData[0];
        return DataNova;
    }
    
    
}




