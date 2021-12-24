package JDBC101.daoImpl;

import JDBC101.model.Address;
import JDBC101.model.Admin;
import JDBC101.model.Attendance;
import JDBC101.model.Role;
import netscape.javascript.JSObject;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class adminDaoImpTest {

    @Test
    void getAdmin() {
        adminDaoImp adminDaoImp = new adminDaoImp();
        assertNotNull(adminDaoImp.getAdmin(2).getId_user());
    }

    @Test
    void getAllAdmin() {
        adminDaoImp adminDaoImp = new adminDaoImp();
        List<Admin> admins = new ArrayList<Admin>();
        admins = adminDaoImp.getAllAdmin();
        assertInstanceOf(new ArrayList<Admin>().getClass(),admins);
    }

    @Test
    void saveAdmin() {

        // address
        Address address = new Address();
        address.setId_address(1);
        address.setCity("city");
        address.setPostal_code(56784);
        address.setStreet("street");

        // Role
        Role role = new Role();
        role.setId_role(1);
        role.setName("admin");
        role.setPrivileges("admin,manager,student,teacher");

        // Admin
        Admin admin = new Admin();
        admin.setEmail("email@foracademy.com");
        admin.setFirst_name("first name");
        admin.setLast_name("last name");
        admin.setGender("male");
        admin.setPhone("0612345678");
        admin.setStatus(true);
        admin.setPassword("pass1234");
        admin.setAddress(address);
        admin.setRole(role);
        adminDaoImp adminDaoImp = new adminDaoImp();
        adminDaoImp.saveAdmin(admin);
    }

    @Test
    void updateAdmin() {
    }

    @Test
    void deleteAdmin() {
    }
}