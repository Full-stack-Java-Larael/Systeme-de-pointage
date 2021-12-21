package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Role;

import java.util.List;

public interface RoleDao {
    Role getRole(long id) throws DAOException;

    List<Role> getAllRole() throws DAOException;

    void saveRole(Role t) throws DAOException;

    void updateRole(Role t, String[] params) throws DAOException;

    boolean deleteRole(Role t) throws DAOException;
}
