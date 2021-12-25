package JDBC101.daoImpl;

import JDBC101.model.Address;
import JDBC101.model.Admin;
import JDBC101.model.Role;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class adminDaoImpTest {

    @Test
    void getAdmin() {
        adminDaoImp adminDaoImp = new adminDaoImp();
        assertNotNull(adminDaoImp.getAdmin(1).getId_user());
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
        admin.setId_user((long)1);
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
        adminDaoImp.updateAdmin(admin);

    }

    @Test
    void deleteAdmin() {
        adminDaoImp adminDaoImp = new adminDaoImp();
        Admin admin = new Admin();
        admin.setId_user((long)2);
        assertTrue(adminDaoImp.deleteAdmin(admin));
    }
}