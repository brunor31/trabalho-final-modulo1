package entities;

import services.ProcessarReserva;

import java.util.ArrayList;

public class AdministrarReserva extends Reserva implements ProcessarReserva {

    private ArrayList<Reserva> reservas;

    public AdministrarReserva(){
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public void processarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void imprimirReservaProcessada(String cpf){
        imprimirReserva();
    }
}
