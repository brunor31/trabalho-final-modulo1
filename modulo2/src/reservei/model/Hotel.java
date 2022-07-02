package reservei.model;

import java.util.List;

public class Hotel {

    private Integer idHotel;
    private String nome;
    private String cidade;
    private String telefone;
    private Integer classificacao;
    private List<Quarto> quartos;

    public Hotel() {
    }

    public Hotel(String nome, String cidade, String telefone, Integer classificacao) {
        this.nome = nome;
        this.cidade = cidade;
        this.telefone = telefone;
        this.classificacao = classificacao;
    }

    public Integer getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Integer classificacao) {
        this.classificacao = classificacao;
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }

    public void imprimirQuartos() {
        for (Quarto quarto : quartos) {
            System.out.println(quarto);
        }
    }

    @Override
    public String toString() {
        return "IdHotel: " + idHotel +
                "\nNome: " + nome +
                "\nCidade: " + cidade +
                "\nClassificação: " + classificacao + " Estrelas" +
                "\nTelefone: " + telefone +
                "\n";
    }
}
