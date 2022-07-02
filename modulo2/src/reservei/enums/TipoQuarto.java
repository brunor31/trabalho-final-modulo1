package reservei.enums;

public enum TipoQuarto {

    QUARTO_SOLTEIRO("Quarto de Solteiro"),
    QUARTO_CASAL("Quarto de casal");

    private String descricao;
    TipoQuarto(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
