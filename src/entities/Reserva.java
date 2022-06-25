package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
public class Reserva {

    private Hotel hotel;
    private Quarto quarto;
    private Cliente cliente;
    private Date dataEntrada;
    private Date dataSaida;
    private Integer idReserva;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva() {
    }
    public Reserva(Hotel hotel, Quarto quarto, Cliente cliente, String dataEntrada, String dataSaida, Integer idReserva) throws ParseException {
        this.hotel = hotel;
        this.quarto = quarto;
        this.cliente = cliente;
        this.dataEntrada = sdf.parse(dataEntrada);
        this.dataSaida = sdf.parse(dataSaida);
        this.idReserva = idReserva;
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

    public Date getDataEntrada(){
        return dataEntrada;
    }
    public String getDataEntradaString() {
        return sdf.format(dataEntrada);
    }
    public void setDataEntrada(Date dataEntrada){
        this.dataEntrada = dataEntrada;
    }
    public void setDataEntradaString(String data) throws ParseException {
        this.dataEntrada = sdf.parse(data);
    }
    public Date getDateSaida() {
        return dataSaida;
    }
    public String getDateSaidaString() {
        return sdf.format(dataSaida);
    }
    public void setDateSaida(Date dataSaida){
        this.dataSaida = dataSaida;
    }
    public void setDateSaidaString(String data) throws ParseException {
        this.dataSaida = sdf.parse(data);
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
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

    @Override
    public String toString() {
        return "IdReserva: " + idReserva +
                "\nHotel: " + getHotel().getNome() +
                "\nNúmero do Quarto: " + getQuarto().getNumero() +
                "\nCliente: " + getCliente().getNome() +
                "\nData de Entrada: " + sdf.format(dataEntrada) +
                "\nData de Saída: " + sdf.format(dataSaida) +
                "\nQuantidade de diárias: " + imprimirDiarias() +
                "\nValor da Reserva: " + String.format("%.2f", calcularDiarias());
    }
}
