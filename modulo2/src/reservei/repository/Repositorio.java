package reservei.repository;

import reservei.exceptions.DBException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repositorio<CHAVE, OBJETO> {

    Integer getProximoId(Connection connection) throws SQLException;

    OBJETO adicionar(OBJETO objetc) throws DBException;

    boolean remover(CHAVE id) throws DBException;

    boolean editar(CHAVE id, OBJETO objeto) throws DBException;

    List<OBJETO> listar() throws DBException;

}
