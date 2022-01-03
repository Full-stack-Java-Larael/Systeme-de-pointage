package JDBC101.serviceImpl;

import JDBC101.model.User;
import JDBC101.service.userService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements userService {
    
    private JDBC101.daoImpl.userDaoImp userDaoImp;


    @Override
    public void addUser(User user) {
        JDBC101.daoImpl.userDaoImp.saveUser(user);
    }

    @Override
    public User fetchUserById(long id_user) {
        return null;
    }

    @Override
    public void deleteUserById(User user) {
        
    }

    @Override
    public void updateUserPasswordById(String newPassword, long id_user) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

}
