package reservei.repository;

import reservei.exceptions.DBException;
import reservei.model.Hotel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelRepository implements Repositorio<Integer, Hotel> {


    @Override
    public Integer getProximoId(Connection connection) throws DBException {
        try {
            String sql = "SELECT SEQ_HOTEL.nextval mysequence from DUAL";
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
    public Hotel adicionar(Hotel hotel) throws DBException {
        Connection con = null;
        try {
            con = ConexaoDB.getConnection();

            Integer proximoId = this.getProximoId(con);
            hotel.setIdHotel(proximoId);

            String sql = "INSERT INTO HOTEL\n" +
                    "(ID_HOTEL, NOME, CIDADE, TELEFONE, CLASSIFICACAO)\n" +
                    "VALUES(?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, hotel.getIdHotel());
            stmt.setString(2, hotel.getNome());
            stmt.setString(3, hotel.getCidade());
            stmt.setString(4, hotel.getTelefone());
            stmt.setInt(5, hotel.getClassificacao());

            int res = stmt.executeUpdate();
            System.out.println("adicionarHotel.res=" + res);
            return hotel;
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

            String sql = "DELETE FROM HOTEL WHERE ID_HOTEL = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            int res = stmt.executeUpdate();
            System.out.println("removerHotelPorId.res=" + res);

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
    public boolean editar(Integer id, Hotel hotel) throws DBException {
        Connection con = null;
        try {
            con = ConexaoDB.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE hotel SET \n");
            hotel.toString();
            if (hotel != null) {
                if (hotel.getIdHotel() != null)
                    sql.append(" id_hotel = ?,");
            }
            if (hotel.getNome() != null) {
                sql.append(" nome = ?,");
            }
            if (hotel.getCidade() != null) {
                sql.append(" cidade = ?,");
            }
            if (hotel.getTelefone() != null) {
                sql.append(" telefone = ?,");
            }
            if (hotel.getClassificacao() != null) {
                sql.append(" classificação = ?,");
            }
            sql.deleteCharAt(sql.length() - 1);
            sql.append(" WHERE id_hotel = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            int index = 1;
            if (hotel != null) {
                if (hotel.getIdHotel() != null) {
                    stmt.setInt(index++, hotel.getIdHotel());
                }
            }
            if (hotel.getNome() != null) {
                stmt.setString(index++, hotel.getNome());
            }
            if (hotel.getCidade() != null) {
                stmt.setString(index++, hotel.getCidade());
            }
            if (hotel.getTelefone() != null) {
                stmt.setString(index++, hotel.getTelefone());
            }
            if (hotel.getClassificacao() != null) {
                stmt.setInt(index++, hotel.getClassificacao());
            }
            stmt.setInt(index++, id);

            int res = stmt.executeUpdate();
            System.out.println("editarHotel.res=" + res);
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
    public List<Hotel> listar() throws DBException {
        List<Hotel> hotels = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoDB.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT h.* " +
                    "FROM Hotel h";

            ResultSet res = stmt.executeQuery(sql);

            while (res.next()){
                Hotel hotelRetorno = hotels.stream().findFirst().get();
                System.out.println(hotelRetorno);
            }
            return hotels;
        } catch (SQLException e){
            throw  new DBException(e.getMessage());
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
}


