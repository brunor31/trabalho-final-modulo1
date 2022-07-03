package reservei.model;

import reservei.enums.TipoQuarto;

public class Quarto {

    private Integer idQuarto;
    private Integer numero;
    private TipoQuarto tipo;
    private Integer disponibilidade;
    private Double precoDiaria;

    public Quarto() {
    }

    public Quarto(Integer idQuarto, Integer numero, TipoQuarto tipo, Integer disponibilidade, Double precoDiaria) {
        this.idQuarto = idQuarto;
        this.numero = numero;
        this.tipo = tipo;
        this.disponibilidade = disponibilidade;
        this.precoDiaria = precoDiaria;
    }

    public Integer getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(Integer idQuarto) {
        this.idQuarto = idQuarto;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public TipoQuarto getTipo() {
        return tipo;
    }

    public void setTipo(TipoQuarto tipo) {
        this.tipo = tipo;
    }

    public Integer getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Integer disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(Double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    @Override
    public String toString() {
        return "IdQuarto: " + idQuarto +
                "\nQuarto: " + numero +
                "\nTipo: " + tipo.getType() +
                "\nPreço da diária: " + String.format("%.2f", precoDiaria) +
                "\n";
    }
}
