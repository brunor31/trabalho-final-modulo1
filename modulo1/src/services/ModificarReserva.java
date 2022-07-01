package services;

import entities.Reserva;

import java.util.Date;

public interface ModificarReserva {

    public void modificarReserva(Integer id, int numero, Date dataEntrada, Date dataSaida);

}
