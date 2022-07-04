package reservei.model;

import reservei.enums.TipoReserva;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Reserva {

    private Integer idReserva;
    private Hotel hotel;
    private Quarto quarto;
    private Cliente cliente;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private TipoReserva tipo;
    private Double valorReserva;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public Reserva() {
    }

    public Reserva(Integer idReserva, Hotel hotel, Quarto quarto, Cliente cliente, LocalDate dataEntrada, LocalDate dataSaida, TipoReserva tipo, Double valorReserva) {
        this.idReserva = idReserva;
        this.hotel = hotel;
        this.quarto = quarto;
        this.cliente = cliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.tipo = tipo;
        this.valorReserva = valorReserva;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }
    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public TipoReserva getTipo() {
        return tipo;
    }

    public void setTipo(TipoReserva tipo) {
        this.tipo = tipo;
    }

    public Double getValorReserva() {
        return valorReserva;
    }

    public void setValorReserva(Double valorReserva) {
        this.valorReserva = valorReserva;
    }

    @Override
    public String toString() {
        return "IdReserva: " + idReserva +
                "\nHotel: " + getHotel().getNome() +
                "\nNúmero do Quarto: " + getQuarto().getNumero() +
                "\nCliente: " + getCliente().getNome() +
                "\nData de Entrada: " + LocalDate.parse(dataEntrada.toString()) +
                "\nData de Saída: " + LocalDate.parse(dataSaida.toString()) +
                "\nTipo da Reserva: " + tipo.tipoString() +
                "\nValor da Reserva: R$" + String.format("%.2f", valorReserva) +
                "\n";
    }
}
