public class Cliente {

    private String nome;
    private String cpf;
    private TipoCliente tipoCliente;

    public Cliente(String nome, String cpf, TipoCliente tipoCliente) {
        this.nome = nome;
        this.cpf = cpf;
        this.tipoCliente = tipoCliente;
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public TipoCliente getTipoCliente() { return tipoCliente; }
}
