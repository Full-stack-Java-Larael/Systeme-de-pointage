package JDBC101.dao;


import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.User;
import JDBC101.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface userDao{

    Optional<User> getUser(long id) throws DAOException;

    List<User> getAllUser() throws DAOException;

    void saveUser(User t) throws DAOException;

    void updateUser(User t, String[] params) throws DAOException;

    void deleteUser(User t) throws DAOException;

}
