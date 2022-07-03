package reservei.repository;

import reservei.exceptions.DBException;
import reservei.model.Reserva;

import java.sql.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReservaRepository implements Repositorio<Integer, Reserva> {

    @Override
    public Integer getProximoId(Connection connection) throws DBException {
        try {
            String sql = "SELECT SEQ_RESERVA.nextval mysequence from DUAL";
            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery(sql);

            if (res.next()) {
                return res.getInt("mysequence");
            }
            return null;
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }

    }

    @Override
    public Reserva adicionar(Reserva reserva) throws DBException {
        Connection con = null;
        try {
            con = ConexaoDB.getConnection();

            Integer proximoId = this.getProximoId(con);
            reserva.setIdReserva(proximoId);

            String sql = "INSERT INTO RESERVA\n" +
                    "(ID_RESERVA, ID_HOTEL, ID_QUARTO, ID_CLIENTE, DATA_ENTRADA, DATA_SAIDA, TIPO)\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, reserva.getIdReserva());
            stmt.setInt(2, reserva.getHotel().getIdHotel());
            stmt.setInt(3, reserva.getQuarto().getIdQuarto());
            stmt.setInt(4, reserva.getCliente().getIdCliente());
            stmt.setDate(5, (Date) reserva.getDataEntrada());
            stmt.setDate(6, (Date) reserva.getDataSaida());
            stmt.setInt(7, reserva.getTipo().ordinal());
            stmt.setDouble(8, imprimirDiarias(reserva));

            int res = stmt.executeUpdate();
            System.out.println("adicionarReserva.res=" + res);
            return reserva;
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean remover(Integer id) throws DBException {
        Connection con = null;
        try {
            con = ConexaoDB.getConnection();

            String sql = "DELETE FROM RESERVA WHERE ID_RESERVA = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            int res = stmt.executeUpdate();
            System.out.println("removerReservaPorId.res=" + res);

            return res > 0;
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean editar(Integer id, Reserva reserva) throws DBException {
        return false;
    }

    @Override
    public List<Reserva> listar() throws DBException {
        return null;
    }
    public Double imprimirDiarias(Reserva reserva) {
        long diff = reserva.getDataSaida().getTime() - reserva.getDataEntrada().getTime();
        TimeUnit time = TimeUnit.DAYS;
        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
        return diffrence * reserva.getQuarto().getPrecoDiaria();
    }
}


