package reservei.enums;

public enum TipoReserva {

    RESERVA_COMUM("Reserva Comum"),
    RESERVA_PREMIUM("Reserva Premium");

    private String descricao;

    TipoReserva(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
