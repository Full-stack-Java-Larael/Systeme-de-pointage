package JDBC101.serviceImpl;

import JDBC101.model.User;
import JDBC101.service.userService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements userService {
    private JDBC101.dao.userDao userDao;

    @Override
    public void addUser(User user) {
    userDao.saveUser(user);
    }

    @Override
    public Optional<User> fetchUserById(int id_user) {
        return userDao.getUser(id_user);
    }

    @Override
    public void deleteUserById(User id_user) {
        userDao.deleteUser(id_user);
    }

    @Override
    public void updateUserPasswordById(String newPassword, String[] id_user) {
        userDao.updateUser(newPassword, id_user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUser();
    }
}
