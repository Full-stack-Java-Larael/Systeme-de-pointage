package JDBC101.daoImpl;

import JDBC101.model.Address;
import JDBC101.model.Admin;
import JDBC101.model.Role;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class adminDaoImpTest {
    static long id;
    @Test
    @Order(3)
    void getAdmin() {
        adminDaoImp adminDaoImp = new adminDaoImp();
        assertNotNull(adminDaoImp.getAdmin(id).getId_user());
    }

    @Test
    @Order(2)
    void getAllAdmin() {
        adminDaoImp adminDaoImp = new adminDaoImp();
        List<Admin> admins = new ArrayList<Admin>();
        admins = adminDaoImp.getAllAdmin();
        assertInstanceOf(new ArrayList<Admin>().getClass(),admins);
    }

    @Test
    @Order(1)
    void saveAdmin() {

        // Admin
        Admin admin = new Admin();
        admin.setEmail("email@foracademy.com");
        admin.setFirst_name("first name");
        admin.setLast_name("last name");
        admin.setGender("male");
        admin.setPhone("0612345678");
        admin.setStatus(true);
        admin.setPassword("pass1234");
        admin.setAddress(new addressDaoImp().getAllAddress().get(0));
        admin.setRole(new roleDaoImp().getAllRole().get(0));
        adminDaoImp adminDaoImp = new adminDaoImp();
        Admin newAdmin = adminDaoImp.saveAdmin(admin);
        assertInstanceOf(Admin.class,newAdmin);
        id = newAdmin.getId_user();
        adminDaoImp.saveAdmin(admin);
    }

    @Test
    @Order(4)
    void updateAdmin() {
        // Admin
        Admin admin = new Admin();
        admin.setId_user(id);
        admin.setEmail("email@foracademy.com");
        admin.setFirst_name("first name");
        admin.setLast_name("last name");
        admin.setGender("male");
        admin.setPhone("0612345678");
        admin.setStatus(true);
        admin.setPassword("pass1234");
        admin.setAddress(new addressDaoImp().getAllAddress().get(0));
        admin.setRole(new roleDaoImp().getAllRole().get(0));
        adminDaoImp adminDaoImp = new adminDaoImp();
        assertInstanceOf(Admin.class,adminDaoImp.updateAdmin(admin));
    }

    @Test
    @Order(5)
    void deleteAdmin() {
        adminDaoImp adminDaoImp = new adminDaoImp();
        Admin admin = new Admin();
        admin.setId_user(id);
        assertTrue(adminDaoImp.deleteAdmin(admin));
    }
}