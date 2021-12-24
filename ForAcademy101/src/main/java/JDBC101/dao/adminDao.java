package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Admin;

import java.util.List;
import java.util.Optional;

public interface adminDao {
    Admin getAdmin(long id) throws DAOException;

    List<Admin> getAllAdmin() throws DAOException;

    void saveAdmin(Admin t) throws DAOException;

    Admin updateAdmin(Admin admin) throws DAOException;

    void deleteAdmin(Admin t) throws DAOException;
}
