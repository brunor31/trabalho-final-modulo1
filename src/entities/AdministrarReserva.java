package entities;

import java.util.ArrayList;

public class AdministrarReserva {

    private ArrayList<Reserva> reservas;

    public AdministrarReserva(){
    }

    public void AdministrarReserva(Reserva reserva){
       this.reservas.add(reserva);
    }
}
