package JDBC101.daoImpl;

import JDBC101.model.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class userDaoImpTest {
    static long id;
    @Test
    @Order(2)
    void getUser() {
        userDaoImp userDaoImp = new userDaoImp();
        assertInstanceOf(User.class,userDaoImp.getUser(id));
    }

    @Test
    @Order(3)
    void getAllUser() {
        userDaoImp userDaoImp = new userDaoImp();
        ArrayList<User> users = new ArrayList<User>();
        assertInstanceOf(users.getClass(),userDaoImp.getAllUser());
    }

    @Test
    @Order(1)
    void saveUser() {
        User user = new User();
        user.setEmail("user@foracademy.com");
        user.setFirst_name("first name");
        user.setLast_name("last name");
        user.setGender("male");
        user.setPhone("0612345678");
        user.setStatus(true);
        user.setPassword("pass1234");
        user.setAddress(new addressDaoImp().getAllAddress().get(0));
        user.setRole(new roleDaoImp().getAllRole().get(0));
        userDaoImp userDaoImp = new userDaoImp();
        User newUser = userDaoImp.saveUser(user);
        assertInstanceOf(User.class,newUser);
        id = newUser.getId_user();
    }

    @Test
    @Order(4)
    void updateUser() {
        User user = new User();
        user.setId_user(id);
        user.setEmail("new.user@foracademy.com");
        user.setFirst_name("new first name");
        user.setLast_name("new last name");
        user.setGender("male");
        user.setPhone("0600045678");
        user.setStatus(true);
        user.setPassword("pass@1234");
        user.setAddress(new addressDaoImp().getAllAddress().get(0));
        user.setRole(new roleDaoImp().getAllRole().get(0));
        userDaoImp userDaoImp = new userDaoImp();
        assertInstanceOf(User.class,userDaoImp.updateUser(user));
    }

    @Test
    @Order(5)
    void deleteUser() {
        userDaoImp userDaoImp = new userDaoImp();
        assertTrue(userDaoImp.deleteUser(id));
    }
}