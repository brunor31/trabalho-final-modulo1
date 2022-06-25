package entities;

public class Quarto extends Hotel {

    private Integer numero;
    private Integer tipo;
    private String descricao;
    private boolean disponibilidade;
    private Double precoDiaria;
    private Integer idQuarto;

    public Quarto() {
    }

    public Quarto(Integer numero, Integer tipo, String descricao, boolean disponibilidade, Double precoDiaria, Integer idQuarto) {
        this.numero = numero;
        this.tipo = tipo;
        this.descricao = descricao;
        this.disponibilidade = disponibilidade;
        this.precoDiaria = precoDiaria;
        this.idQuarto = idQuarto;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(Double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public Integer getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(Integer idQuarto) {
        this.idQuarto = idQuarto;
    }

    public void imprimirQuarto(){
        String tipoQuarto = "";
        if (tipo == 1) {
            tipoQuarto = "Solteiro";
        } else if (tipo == 2){
            tipoQuarto = "Casal";
        }
        String ehDisponivel = "";
        if (disponibilidade){
            ehDisponivel = "Disponível para aluguel";
        } else {
            ehDisponivel = "Indisponível";
        }
        System.out.println("Quarto: " + numero +
                "\nTipo: " + tipoQuarto +
                "\nDescrição: " + descricao +
                "\nDispobilidade: " + ehDisponivel +
                "\nPreço da diária: " + String.format("%.2f", precoDiaria) +
                "\nIdQuarto: " + idQuarto);
    }

    public boolean verificarDisponibilidade(){
        if (disponibilidade == true){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String tipoQuarto = "";
        if (tipo == 1) {
            tipoQuarto = "Solteiro";
        } else if (tipo == 2){
            tipoQuarto = "Casal";
        }
        return  "Quarto: " + numero +
                "\nTipo: " + tipoQuarto +
                "\nDescrição: " + descricao +
                "\nPreço da diária: " + String.format("%.2f", precoDiaria) +
                "\n";
    }
}
