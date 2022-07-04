package reservei.repository;

import oracle.sql.DATE;
import reservei.enums.TipoReserva;
import reservei.exceptions.DBException;
import reservei.model.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReservaRepository implements Repositorio<Integer, Reserva> {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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
                    "(ID_RESERVA, ID_HOTEL, ID_QUARTO, ID_CLIENTE, DATA_ENTRADA, DATA_SAIDA, TIPO, VALOR_RESERVA)\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, reserva.getIdReserva());
            stmt.setInt(2, reserva.getHotel().getIdHotel());
            stmt.setInt(3, reserva.getQuarto().getIdQuarto());
            stmt.setInt(4, reserva.getCliente().getIdCliente());
            stmt.setDate(5, Date.valueOf(reserva.getDataEntrada()));
            stmt.setDate(6, Date.valueOf(reserva.getDataSaida()));
            stmt.setInt(7, reserva.getTipo().ordinal());
            stmt.setDouble(8, reserva.getValorReserva());
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
        Connection con = null;
        try {
            con = ConexaoDB.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE Reserva SET \n");
            reserva.toString();
            if (reserva != null) {
                if (reserva.getDataEntrada() != null)
                    sql.append(" data_entrada = ?,");
            }
            if (reserva.getDataSaida() != null) {
                sql.append(" data_saida = ?,");
            }
            sql.deleteCharAt(sql.length() - 1);
            sql.append(" WHERE id_reserva = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            int index = 1;
            if (reserva != null) {
                if (reserva.getDataEntrada() != null) {
                    stmt.setDate(index++, Date.valueOf(reserva.getDataEntrada()));
                }
            }
            if (reserva.getDataSaida() != null) {
                stmt.setDate(index++, Date.valueOf(reserva.getDataSaida()));
            }
            stmt.setInt(index++, id);

            int res = stmt.executeUpdate();
            System.out.println("editarReserva.res=" + res);
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
    public List<Reserva> listar() throws DBException {
        return null;
    }
    public List<Reserva> listarReservaPorCPF(String cpf) throws DBException {
        List<Reserva> reservas = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoDB.getConnection();

            String sql = "SELECT r.*, " +
                    "            h.NOME AS NOME_HOTEL,  " +
                    "            a.NUMERO AS QUARTO_NUMERO," +
                    "            c.NOME AS NOME_CLIENTE " +
                    "       FROM RESERVA r " +
                    "      INNER JOIN HOTEL h ON h.ID_HOTEL = r.ID_HOTEL " +
                    "      INNER JOIN QUARTO a ON a.ID_QUARTO = r.ID_QUARTO " +
                    "      INNER JOIN CLIENTE c ON c.ID_CLIENTE = r.ID_CLIENTE" +
                    "      WHERE c.CPF = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Reserva reserva = getReservaFromResultSet(res);
                reservas.add(reserva);
            }
            return reservas;
        } catch (SQLException e) {
            e.printStackTrace();
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

    private Reserva getReservaFromResultSet(ResultSet res) throws SQLException {
        Reserva reserva = new Reserva();
        reserva.setIdReserva(res.getInt("id_reserva"));
        Hotel hotel = new Hotel();
        hotel.setIdHotel(res.getInt("id_hotel"));
        hotel.setNome(res.getString("nome_hotel"));
        reserva.setHotel(hotel);
        Quarto quarto = new Quarto();
        quarto.setIdQuarto(res.getInt("id_quarto"));
        quarto.setNumero(res.getInt("quarto_numero"));
        reserva.setQuarto(quarto);
        Cliente cliente = new Cliente();
        cliente.setIdCliente(res.getInt("id_cliente"));
        cliente.setNome(res.getString("nome_cliente"));
        reserva.setCliente(cliente);
        reserva.setDataEntrada(res.getDate("data_entrada").toLocalDate());
        reserva.setDataSaida(res.getDate("data_saida").toLocalDate());
        reserva.setTipo(TipoReserva.values()[res.getInt("tipo")]);
        reserva.setValorReserva(res.getDouble("valor_reserva"));
        return reserva;
    }
}


