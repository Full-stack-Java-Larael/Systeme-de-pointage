package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Admin;

import java.util.List;
import java.util.Optional;

public interface adminDao {
    Admin getAdmin(long id) throws DAOException;

    List<Admin> getAllAdmin() throws DAOException;

    Admin saveAdmin(Admin admin) throws DAOException;

    Admin updateAdmin(Admin admin) throws DAOException;

    boolean deleteAdmin(Admin admin) throws DAOException;
}
