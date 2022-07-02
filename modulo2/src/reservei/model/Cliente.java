package reservei.model;

public class Cliente {

    private Integer idCliente;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    private String senha;

    public Cliente() {
    }

    public Cliente(Integer idCliente, String nome, String cpf, String telefone, String email, String senha) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String toString() {
        return "IdCliente: " + idCliente +
                "\nNome: " + nome +
                "\nCpf: " + cpf +
                "\nTelefone: " + telefone +
                "\nEmail: " + email;
    }
}
