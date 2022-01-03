package JDBC101.daoImpl;

import JDBC101.model.Role;
import netscape.javascript.JSObject;
import org.junit.jupiter.api.*;
import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class roleDaoImpTest {
    static long id;
    @Test
    @Order(3)
    void getRole() {
        roleDaoImp roleDaoImp = new roleDaoImp();
        assertInstanceOf(Role.class,roleDaoImp.getRole(id));
    }

    @Test
    @Order(2)
    void getAllRole() {
        roleDaoImp roleDaoImp = new roleDaoImp();
        ArrayList<Role> roles = new ArrayList<Role>();
        assertInstanceOf(roles.getClass(),roleDaoImp.getAllRole());
    }

    @Test
    @Order(1)
    void saveRole() {
        roleDaoImp roleDaoImp = new roleDaoImp();
        Role role = new Role();
        role.setName("admin");
        ArrayList previlages = new ArrayList<String>();
        role.setPrivileges("admin,manager,student,teacher");
        Role newRole = roleDaoImp.saveRole(role);
        assertInstanceOf(Role.class,newRole);
        id = newRole.getId_role();
        roleDaoImp.saveRole(role);
    }

    @Test
    @Order(4)
    void updateRole() {
        roleDaoImp roleDaoImp = new roleDaoImp();
        Role role = new Role();
        role.setId_role(id);
        role.setName("admin");
        role.setPrivileges("admin,manager,student,teacher");
        assertInstanceOf(Role.class,roleDaoImp.updateRole(role));
    }

    @Test
    @Order(5)
    void deleteRole() {
        roleDaoImp roleDaoImp = new roleDaoImp();
        Role role = new Role();
        role.setId_role(id);
        assertTrue(roleDaoImp.deleteRole(role));
    }
}