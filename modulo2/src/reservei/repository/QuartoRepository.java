package reservei.repository;

import reservei.enums.TipoQuarto;
import reservei.exceptions.DBException;
import reservei.model.Quarto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuartoRepository implements Repositorio<Integer, Quarto> {
    @Override
    public Integer getProximoId(Connection connection) throws DBException {
        try {
            String sql = "SELECT SEQ_QUARTO.nextval mysequence from DUAL";
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
    public Quarto adicionar(Quarto objetc) throws DBException {
        return null;
    }

    @Override
    public boolean remover(Integer id) throws DBException {
        return false;
    }

    @Override
    public boolean editar(Integer id, Quarto quarto) throws DBException {
        return false;
    }

    @Override
    public List<Quarto> listar() throws DBException {
        List<Quarto> quartos = new ArrayList<>();
        Connection con = null;
        ResultSet res;
        try {
            con = ConexaoDB.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT q.* " +
                    "FROM Quarto q";

            res = stmt.executeQuery(sql);

            while (res.next()) {
                Quarto quarto = getQuartoFromResultSet(res);
                quartos.add(quarto);
            }
            return quartos;
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
    public List<Quarto> listarQuartosPorHotel(Integer id) throws DBException {
        List<Quarto> quartos = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoDB.getConnection();

            String sql = "SELECT Q.* " +
                    "       FROM QUARTO Q " +
                    " INNER JOIN HOTEL H ON (H.ID_HOTEL = Q.ID_HOTEL) " +
                    "      WHERE Q.ID_HOTEL = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Quarto quarto = getQuartoFromResultSet(res);
                quartos.add(quarto);
            }
            return quartos;
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
    public List<Quarto> listarQuartosPorId(Integer id) throws DBException {
        List<Quarto> quartos = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoDB.getConnection();

            String sql = "SELECT Q.* " +
                    "       FROM QUARTO Q " +
                    "      WHERE Q.ID_QUARTO = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Quarto quarto = getQuartoFromResultSet(res);
                quartos.add(quarto);
            }
            return quartos;
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
    private Quarto getQuartoFromResultSet(ResultSet res) throws SQLException {
        Quarto quarto = new Quarto();
        quarto.setIdQuarto(res.getInt("id_quarto"));
        quarto.setIdHotel(res.getInt("id_hotel"));
        quarto.setNumero(res.getInt("numero"));
        quarto.setTipo(TipoQuarto.ofType(res.getInt("tipo")));
        quarto.setDisponibilidade(res.getInt("disponibilidade"));
        quarto.setPrecoDiaria(res.getDouble("preco_diaria"));
        return quarto;
    }
}
