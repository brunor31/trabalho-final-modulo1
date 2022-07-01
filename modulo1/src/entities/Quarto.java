package entities;

public class Quarto {
    private Integer numero;
    private String tipo;
    private boolean disponibilidade;
    private Double precoDiaria;
    private Integer idQuarto;

    public boolean verificarDisponibilidade() {
        return disponibilidade;
    }
    public void imprimirQuarto() {
        String ehDisponivel = "Disponível";
        if (!verificarDisponibilidade()) {
            ehDisponivel = "Indisponível";
        }
        System.out.println("Quarto: " + numero +
                "\nTipo: " + tipo +
                "\nDispobilidade: " + ehDisponivel +
                "\nPreço da diária: " + String.format("%.2f", precoDiaria) +
                "\nIdQuarto: " + idQuarto);
    }

    @Override
    public String toString() {
        return "Quarto: " + numero +
                "\nTipo: " + tipo +
                "\nPreço da diária: " + String.format("%.2f", precoDiaria) +
                "\n";
    }

    public Quarto() {
    }

    public Quarto(Integer numero, String tipo, boolean disponibilidade, Double precoDiaria, Integer idQuarto) {
        this.numero = numero;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
}

