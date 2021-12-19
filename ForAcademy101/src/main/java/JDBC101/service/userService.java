package JDBC101.service;

import JDBC101.model.User;

import java.util.List;
import java.util.Optional;

public interface userService {

    public void addUser(User user);
    public Optional<User> fetchUserById(int id_user);
    public void deleteUserById(User id_user);
    public void updateUserPasswordById(String newPassword, String[] id_user);
    public List<User> getAllUsers();

}
