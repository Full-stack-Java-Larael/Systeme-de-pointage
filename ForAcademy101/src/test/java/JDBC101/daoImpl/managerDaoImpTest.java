package JDBC101.daoImpl;

import JDBC101.model.Address;
import JDBC101.model.Manager;
import JDBC101.model.Role;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.sql.Date;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(OrderAnnotation.class)
class managerDaoImpTest {
    static long id;

    @Test
    @Order(3)
    void getManager() {
        managerDaoImp managerDaoImp = new managerDaoImp();
        assertInstanceOf(Manager.class,managerDaoImp.getManager(id));
    }

    @Test
    @Order(2)
    void getAllManager() {
        managerDaoImp managerDaoImp = new managerDaoImp();
        ArrayList<Manager> managers = new ArrayList<Manager>();
        assertInstanceOf(managers.getClass(),managerDaoImp.getAllManager());
    }

    @Test
    @Order(1)
    void saveManager() {
        managerDaoImp managerDaoImp = new managerDaoImp();
        Manager manager = new Manager();
        manager.setFirst_name("manager f name");
        manager.setLast_name("manager l name");
        manager.setGender("male");
        manager.setEmail("manager@foracademy.com");
        manager.setPhone("0612345678");
        manager.setPassword("pass1234");
        manager.setEntry_date(new Date(2022,01,01));
        manager.setStatus(true);
        Role role = new Role();
        role.setId_role(1);
        manager.setRole(role);
        Address address = new Address();
        address.setId_address(1);
        manager.setAddress(address);
        Manager newManager = managerDaoImp.saveManager(manager);
        id = newManager.getId_user();
        assertInstanceOf(Manager.class,newManager);
    }

    @Test
    @Order(4)
    void updateManager() {
        managerDaoImp managerDaoImp = new managerDaoImp();
        Manager manager = new Manager();
        manager.setId_user(id);
        manager.setFirst_name("manager new f name");
        manager.setLast_name("manager new l name");
        manager.setGender("male");
        manager.setEmail("manager2@foracademy.com");
        manager.setPhone("0600045678");
        manager.setPassword("pass@1234");
        manager.setEntry_date(new Date(2022,05,30));
        manager.setStatus(false);
        Role role = new Role();
        role.setId_role(2);
        manager.setRole(role);
        Address address = new Address();
        address.setId_address(2);
        manager.setAddress(address);
        assertInstanceOf(Manager.class,managerDaoImp.updateManager(manager));
    }

    @Test
    @Order(5)
    void deleteManager() {
        managerDaoImp managerDaoImp = new managerDaoImp();
        Manager manager = new Manager();
        manager.setId_user(id);
        assertTrue(managerDaoImp.deleteManager(manager));
    }
}