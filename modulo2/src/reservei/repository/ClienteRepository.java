package reservei.repository;

import reservei.exceptions.DBException;
import reservei.model.Cliente;
import reservei.model.Hotel;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements Repositorio<Integer, Cliente> {

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        try {
            String sql = "SELECT SEQ_CLIENTE.nextval mysequence from DUAL";
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
    public Cliente adicionar(Cliente cliente) throws DBException {
        Connection con = null;
        try {
            con = ConexaoDB.getConnection();

            Integer proximoId = this.getProximoId(con);
            cliente.setIdCliente(proximoId);

            String sql = "INSERT INTO CLIENTE\n" +
                    "(ID_CLIENTE, NOME, CPF, TELEFONE, EMAIL, SENHA)\n" +
                    "VALUES(?, ?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, cliente.getIdCliente());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getSenha());

            int res = stmt.executeUpdate();
            System.out.println("adicionarCliente.res=" + res);
            return cliente;
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

            String sql = "DELETE FROM CLIENTE WHERE ID_CLIENTE = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            int res = stmt.executeUpdate();
            System.out.println("removerClientePorId.res=" + res);

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
    public boolean editar(Integer id, Cliente cliente) throws DBException {
        Connection con = null;
        try {
            con = ConexaoDB.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE cliente SET \n");
            cliente.toString();
            if (cliente != null) {
                if (cliente.getIdCliente() != null)
                    sql.append(" id_cliente = ?,");
            }
            if (cliente.getNome() != null) {
                sql.append(" nome = ?,");
            }
            if (cliente.getCpf() != null) {
                sql.append(" cpf = ?,");
            }
            if (cliente.getTelefone() != null) {
                sql.append(" telefone = ?,");
            }
            if (cliente.getEmail() != null) {
                sql.append(" email = ?,");
            }
            sql.deleteCharAt(sql.length() - 1);
            sql.append(" WHERE id_cliente = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            int index = 1;
            if (cliente != null) {
                if (cliente.getIdCliente() != null) {
                    stmt.setInt(index++, cliente.getIdCliente());
                }
            }
            if (cliente.getNome() != null) {
                stmt.setString(index++, cliente.getNome());
            }
            if (cliente.getCpf() != null) {
                stmt.setString(index++, cliente.getCpf());
            }
            if (cliente.getTelefone() != null) {
                stmt.setString(index++, cliente.getTelefone());
            }
            if (cliente.getEmail() != null) {
                stmt.setString(index++, cliente.getEmail());
            }
            stmt.setInt(index++, id);

            int res = stmt.executeUpdate();
            System.out.println("editarCliente.res=" + res);
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
    public List<Cliente> listar() throws DBException {
        List<Cliente> clientes = new ArrayList<>();
        Connection con = null;
        ResultSet res;
        try {
            con = ConexaoDB.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT c.* " +
                    "FROM Cliente c";

            res = stmt.executeQuery(sql);

            while (res.next()) {
                Cliente cliente = getClienteFromResultSet(res);
                clientes.add(cliente);
            }
            return clientes;
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

    public boolean validarCliente(String senha, String cpf) {
        Connection con = null;
        try {
            con = ConexaoDB.getConnection();
            String sql = "SELECT c.* " +
                    "FROM CLIENTE c " +
                    "WHERE SENHA = ? AND CPF = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, senha);
            stmt.setString(2, cpf);
            int res = stmt.executeUpdate();
            return res > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public List<Cliente> listarClientePorCPF(String cpf) throws DBException {
        List<Cliente> clientes = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoDB.getConnection();

            String sql = "SELECT c.* " +
                    "       FROM CLIENTE c " +
                    "      WHERE c.CPF = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Cliente cliente = getClienteFromResultSet(res);
                clientes.add(cliente);
            }
            return clientes;
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

    private Cliente getClienteFromResultSet (ResultSet res) throws SQLException {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(res.getInt("id_cliente"));
            cliente.setNome(res.getString("nome"));
            cliente.setCpf(res.getString("cpf"));
            cliente.setTelefone(res.getString("telefone"));
            cliente.setEmail(res.getString("email"));
            cliente.setSenha(res.getString("senha"));
            return cliente;
        }
    }


