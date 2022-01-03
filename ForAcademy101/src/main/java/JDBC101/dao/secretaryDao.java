package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Secretary;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface secretaryDao {
    Secretary getSecretary(long id) throws DAOException;

    ArrayList<Secretary> getAllSecretary() throws DAOException;

    Secretary saveSecretary(Secretary secretary) throws DAOException;

    Secretary updateSecretary(Secretary secretary) throws DAOException;

    boolean deleteSecretary(long id) throws DAOException;
}
