package JDBC101.dao;


import JDBC101.model.User;

import java.util.List;

public interface userDao {

    public abstract void saveUser(User user);
    public abstract User getUserById(Long id_user);
    public abstract List<User> getAllUsersDetails();

}
