package JDBC101.service;

import JDBC101.model.User;

import java.util.List;

public interface userService {

     void addUser(User user);
     User fetchUserById(long id_user);
     void deleteUserById(User user);
     void updateUserPasswordById(String newPassword, long id_user);
     List<User> getAllUsers();

}
