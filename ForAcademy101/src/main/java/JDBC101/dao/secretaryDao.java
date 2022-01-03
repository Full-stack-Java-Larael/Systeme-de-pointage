package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Secretary;

import java.util.List;

public interface secretaryDao {
    Secretary getSecretary(long id) throws DAOException;

    List<Secretary> getAllSecretary() throws DAOException;

    void saveSecretary(Secretary t) throws DAOException;

    void updateSecretary(Secretary t, String[] params) throws DAOException;

    void deleteSecretary(Secretary t) throws DAOException;
}
