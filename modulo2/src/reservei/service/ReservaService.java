package reservei.service;

import reservei.model.Reserva;
import reservei.repository.ReservaRepository;

public class ReservaService {

    private ReservaRepository reservaRepository;

    public ReservaService (){
        reservaRepository = new ReservaRepository();
    }

    public void adicionarReserva(Reserva reserva) {
    }
}
