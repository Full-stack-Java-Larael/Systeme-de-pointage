package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Manager;

import java.util.List;
import java.util.Optional;

public interface managerDao {
    Optional<Manager> getManager(long id) throws DAOException;

    List<Manager> getAllManager() throws DAOException;

    void saveManager(Manager t) throws DAOException;

    void updateManager(Manager t, String[] params) throws DAOException;

    void deleteManager(Manager t) throws DAOException;
}
