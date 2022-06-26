package entities;

import java.util.List;

public class Hotel {

    private String nome;
    private String cidade;
    private String telefone;
    private Integer classificacao;
    private List<Quarto> quartos;
    private Integer idHotel;

    public Hotel() {
    }

    public Hotel(String nome, String cidade, String telefone, Integer classificacao, List<Quarto> quartos, Integer idHotel) {
        this.nome = nome;
        this.cidade = cidade;
        this.telefone = telefone;
        this.classificacao = classificacao;
        this.quartos = quartos;
        this.idHotel = idHotel;
    }

    public void imprimirQuartos() {
        for (Quarto quarto: quartos) {
            System.out.println(quarto);
        }
    }
    public void imprimirHotel(){
        System.out.println("Hotel: " + nome +
                "\nCidade: " + cidade +
                "\nClassificação: " + classificacao + " Estrelas" +
                "\nTelefone: " + telefone +
                "\nIdHotel: " + idHotel);
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

    public Integer getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nCidade: " + cidade +
                "\nClassificação: " + classificacao + " Estrelas" +
                "\nTelefone: " + telefone;
    }
}

