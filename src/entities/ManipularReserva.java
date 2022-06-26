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

    public void imprimirQuartosDisponiveis(String cpf) {
        List<Reserva> imprimirQuartos = reservas.stream().filter(reserva -> reserva.getCliente().getCpf().equals(cpf)).toList();
        imprimirQuartos.stream().forEach(reserva -> reserva.getHotel().imprimirQuartos());
    }

    @Override
    public void modificarReserva(String cpf, int numero, Date dataEntrada, Date dataSaida) {
        List<Reserva> modificacao = reservas.stream().filter(reserva -> reserva.getCliente().getCpf().equals(cpf)).toList();
        modificacao.stream().forEach(reserva -> reserva.getQuarto().setNumero(numero));
        modificacao.stream().forEach(reserva -> reserva.setDataEntrada(dataEntrada));
        modificacao.stream().forEach(reserva -> reserva.setDataSaida(dataSaida));
    }

    @Override
    public void cancelarReserva(String cpf) {
        List<Reserva> cancelamento = reservas.stream().filter(reserva -> reserva.getCliente().getCpf().equals(cpf)).toList();
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
