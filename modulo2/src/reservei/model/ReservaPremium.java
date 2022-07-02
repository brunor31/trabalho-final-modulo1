package reservei.model;

import reservei.enums.TipoReserva;

import java.util.Date;

public class ReservaPremium extends Reserva {

    private Double desconto = 0.10;

    public ReservaPremium(Integer idReserva, Hotel hotel, Quarto quarto, Cliente cliente, Date dataEntrada, Date dataSaida, TipoReserva tipo, Double valorReserva) {
        super(idReserva, hotel, quarto, cliente, dataEntrada, dataSaida, tipo, valorReserva);
    }
}
