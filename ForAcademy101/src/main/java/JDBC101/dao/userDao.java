package JDBC101.dao;


import JDBC101.model.User;
import JDBC101.model.User;

import java.util.List;
import java.util.Optional;

public interface userDao {

    Optional<User> getUser(long id);

    List<User> getAllUser();

    void saveUser(User t);

    void updateUser(User t, String[] params);

    void deleteUser(User t);

}
