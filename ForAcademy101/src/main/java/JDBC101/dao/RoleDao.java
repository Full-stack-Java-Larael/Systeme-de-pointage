package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleDao {
    Optional<Role> getRole(long id) throws DAOException;

    List<Role> getAllRole() throws DAOException;

    void saveRole(Role t) throws DAOException;

    void updateRole(Role t, String[] params) throws DAOException;

    void deleteRole(Role t) throws DAOException;
}
