package reservei.model;

import reservei.enums.TipoReserva;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva {

    private Integer idReserva;
    private Hotel hotel;
    private Quarto quarto;
    private Cliente cliente;
    private Date dataEntrada;
    private Date dataSaida;

    private TipoReserva tipo;
    private Double valorReserva;

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva() {
    }

    public Reserva(Integer idReserva, Hotel hotel, Quarto quarto, Cliente cliente, Date dataEntrada, Date dataSaida, TipoReserva tipo, Double valorReserva) {
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
}
    /*
    @Override
    public String toString() {
        return "IdReserva: " + idReserva +
                "\nHotel: " + getHotel().getNome() +
                "\nNúmero do Quarto: " + getQuarto().getNumero() +
                "\nCliente: " + getCliente().getNome() +
                "\nData de Entrada: " + sdf.format(dataEntrada) +
                "\nData de Saída: " + sdf.format(dataSaida) +
                "\nValor da Reserva: " + String.format("%.2f", calcularDiarias()) +
                "\n";
}
     */
