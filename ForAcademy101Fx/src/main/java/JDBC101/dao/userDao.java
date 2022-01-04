package JDBC101.dao;


import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.User;

import java.util.ArrayList;
import java.util.List;

public interface userDao{


    User getUser(long id) throws DAOException;

    ArrayList<User> getAllUser() throws DAOException;

    User saveUser(User t) throws DAOException;

    User updateUser(User user) throws DAOException;

    boolean deleteUser(long id) throws DAOException;
}
