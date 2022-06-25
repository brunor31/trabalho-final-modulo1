package entities;

public class Cliente {

    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Integer idCliente;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String telefone, String email, Integer idCliente) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
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

    public Integer getId() {
        return idCliente;
    }

    public void setId(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public void imprimirCliente(){
        System.out.println(this);
    }
    public String toString(){
        return "Nome: " + nome +
                "\nCpf: " + cpf +
                "\nTelefone: " + telefone +
                "\nEmail: " + email +
                "\nIdCliente: " + idCliente;
    }
}
