package entities;

import java.util.Date;

public class ReservaPremium extends Reserva {

    private static Double desconto = 0.10;

    @Override
    public double calcularDiarias() {
        Double valorTotal = imprimirDiarias() * getQuarto().getPrecoDiaria();
        valorTotal -= (valorTotal * desconto);
        return valorTotal;
    }

    public ReservaPremium() {
    }

    public ReservaPremium(Hotel hotel, Quarto quarto, Cliente cliente, Date dataEntrada, Date dataSaida, Integer idReserva) {
        super(hotel, quarto, cliente, dataEntrada, dataSaida, idReserva);
    }
}
