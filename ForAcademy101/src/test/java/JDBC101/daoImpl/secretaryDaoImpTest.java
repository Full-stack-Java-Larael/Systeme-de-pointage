package JDBC101.daoImpl;

import JDBC101.model.Secretary;
import JDBC101.model.Student;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class secretaryDaoImpTest {
    static long id;
    @Test
    @Order(2)
    void getSecretary() {
        secretaryDaoImp secretaryDaoImp = new secretaryDaoImp();
        assertInstanceOf(Secretary.class,secretaryDaoImp.getSecretary(id));
    }

    @Test
    @Order(3)
    void getAllSecretary() {
        secretaryDaoImp secretaryDaoImp = new secretaryDaoImp();
        ArrayList<Secretary> secretaries = new ArrayList<Secretary>();
        assertInstanceOf(secretaries.getClass(),secretaryDaoImp.getAllSecretary());
    }

    @Test
    @Order(1)
    void saveSecretary() {
        Secretary secretary = new Secretary();
        secretary.setEmail("email@foracademy.com");
        secretary.setFirst_name("first name");
        secretary.setLast_name("last name");
        secretary.setGender("male");
        secretary.setPhone("0612345678");
        secretary.setStatus(true);
        secretary.setPassword("pass1234");
        secretary.setAddress(new addressDaoImp().getAllAddress().get(0));
        secretary.setRole(new roleDaoImp().getAllRole().get(0));
        secretaryDaoImp secretaryDaoImp = new secretaryDaoImp();
        Secretary newSecretary = secretaryDaoImp.saveSecretary(secretary);
        assertInstanceOf(Secretary.class,newSecretary);
        id = newSecretary.getId_user();
    }

    @Test
    @Order(4)
    void updateSecretary() {
        Secretary secretary = new Secretary();
        secretary.setId_user(id);
        secretary.setEmail("new.email@foracademy.com");
        secretary.setFirst_name("new first name");
        secretary.setLast_name("new last name");
        secretary.setGender("male");
        secretary.setPhone("0600045678");
        secretary.setStatus(false);
        secretary.setPassword("pass@1234");
        secretary.setAddress(new addressDaoImp().getAllAddress().get(0));
        secretary.setRole(new roleDaoImp().getAllRole().get(0));
        secretaryDaoImp secretaryDaoImp = new secretaryDaoImp();
        assertInstanceOf(Secretary.class,secretaryDaoImp.updateSecretary(secretary));
    }

    @Test
    @Order(5)
    void deleteSecretary() {
        secretaryDaoImp secretaryDaoImp = new secretaryDaoImp();
        assertTrue(secretaryDaoImp.deleteSecretary(id));
    }
}