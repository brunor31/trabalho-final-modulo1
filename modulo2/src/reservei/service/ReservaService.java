package reservei.service;

import reservei.exceptions.DBException;
import reservei.model.Cliente;
import reservei.model.Reserva;
import reservei.model.ReservaPremium;
import reservei.repository.ReservaRepository;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReservaService {

    private ReservaRepository reservaRepository;

    public ReservaService() {
        reservaRepository = new ReservaRepository();
    }

    public void adicionarReserva(Reserva reserva) {
        try {
            reserva.setValorReserva(calcularDiarias(reserva));
            reservaRepository.adicionar(reserva);
            System.out.println("Reserva adicionada com sucesso!");
        } catch (DBException e) {
            System.out.println(e.getMessage());
        }
    }
    public void editarReserva(Integer indice, Reserva reserva) {
        try {
            boolean deuCerto = reservaRepository.editar(indice, reserva);
            System.out.println("Edição concluída? " + deuCerto + "| com id=" + indice);
        } catch (DBException e) {
            System.out.println(e.getMessage());
        }
    }

    public void imprimirReserva(String cpf) {
        try {
            reservaRepository.listarReservaPorCPF(cpf).forEach(System.out::println);
        } catch (DBException e) {
            System.out.println(e.getMessage());
        }
    }
    public void excluirReserva(Integer id) {
        try {
            boolean deuCerto = reservaRepository.remover(id);
            System.out.println("Reserva excluída com sucesso? " + deuCerto + "| com id=" + id);
        } catch (DBException e) {
            System.out.println(e.getMessage());
        }
    }

    private Double calcularDiarias(Reserva reserva) {
        LocalDate d1 = LocalDate.parse(reserva.getDataEntrada().toString(), DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate d2 = LocalDate.parse(reserva.getDataSaida().toString(), DateTimeFormatter.ISO_LOCAL_DATE);
        Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
        long diffDays = diff.toDays();
        if (reserva instanceof ReservaPremium) {
            ReservaPremium reservaPremium = (ReservaPremium) reserva;
            return diffDays * reserva.getQuarto().getPrecoDiaria() * reservaPremium.getDesconto();
        } else {
            return diffDays * reserva.getQuarto().getPrecoDiaria();
        }
    }

}
