package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Hotel hotel;
    private Quarto quarto;
    private Cliente cliente;
    private Date dataEntrada;
    private Date dataSaida;
    private Integer idReserva;
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva() {
    }
    public Reserva(Hotel hotel, Quarto quarto, Cliente cliente, Date dataEntrada, Date dataSaida, Integer idReserva) {
        this.hotel = hotel;
        this.quarto = quarto;
        this.cliente = cliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.idReserva = idReserva;
    }
    public long imprimirDiarias(){
        long diff = dataSaida.getTime() - dataEntrada.getTime();
        TimeUnit time = TimeUnit.DAYS;
        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
        return diffrence;
    }
    public double calcularDiarias(){
        Double valorTotal = imprimirDiarias() * quarto.getPrecoDiaria();
        return valorTotal;
    }
    public void imprimirReserva(){
        System.out.println(this);
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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    @Override
    public String toString() {
        return "IdReserva: " + idReserva +
                "\nHotel: " + getHotel().getNome() +
                "\nNúmero do Quarto: " + getQuarto().getNumero() +
                "\nCliente: " + getCliente().getNome() +
                "\nData de Entrada: " + sdf.format(dataEntrada) +
                "\nData de Saída: " + sdf.format(dataSaida) +
                "\nQuantidade de diárias: " + imprimirDiarias() +
                "\nValor da Reserva: " + String.format("%.2f", calcularDiarias()) +
                "\n";
    }
}
