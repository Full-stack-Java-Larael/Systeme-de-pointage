package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface managerDao {
    Manager getManager(long id) throws DAOException;

    ArrayList<Manager> getAllManager() throws DAOException;

    Manager saveManager(Manager t) throws DAOException;

    Manager updateManager(Manager manager) throws DAOException;

    boolean deleteManager(Manager t) throws DAOException;
}
