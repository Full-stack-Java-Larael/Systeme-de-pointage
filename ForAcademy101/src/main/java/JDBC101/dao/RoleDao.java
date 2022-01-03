package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Role;

import java.util.ArrayList;
import java.util.List;

public interface RoleDao {
    Role getRole(long id) throws DAOException;

    ArrayList<Role> getAllRole() throws DAOException;

    Role saveRole(Role t) throws DAOException;

    Role updateRole(Role t) throws DAOException;

    boolean deleteRole(Role t) throws DAOException;
}
