package entities;

import services.CancelarReserva;
import services.ModificarReserva;
import services.ProcessarReserva;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Reserva;

public class ManipularReserva implements ProcessarReserva, ModificarReserva, CancelarReserva {

    private List<Reserva> reservas;

    public ManipularReserva() {
        this.reservas = new ArrayList<>();
    }

    public void imprimirListaDeReservas() {
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }

    @Override
    public void processarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public void imprimirQuartosDisponiveis(Integer id) {
        List<Reserva> imprimirQuartos = reservas.stream().filter(reserva -> reserva.getIdReserva().equals(id)).toList();
        imprimirQuartos.stream().forEach(reserva -> reserva.getHotel().imprimirQuartos());
    }

    @Override
    public void modificarReserva(Integer id, int numero, Date dataEntrada, Date dataSaida) {
        Reserva modificacao = reservas.stream()
                .filter(reserva -> reserva.getIdReserva().equals(id))
                .findFirst().get();
        modificacao.getQuarto().setNumero(numero);
        modificacao.setDataEntrada(dataEntrada);
        modificacao.setDataSaida(dataSaida);
    }

    @Override
    public void cancelarReserva(Integer id) {
        List<Reserva> cancelamento = reservas.stream().filter(reserva -> reserva.getIdReserva().equals(id)).toList();
        reservas.removeAll(cancelamento);
    }

    public void imprimirReserva(String cpf) {
        List<Reserva> impressao = reservas.stream().filter(reserva -> reserva.getCliente().getCpf().equals(cpf)).toList();
        if (impressao.size() == 0) {
            System.out.println("Você não possui reserva ativa!");
        } else {
            impressao.stream().forEach(System.out::println);
        }
    }
}
