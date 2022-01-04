package JDBC101.service;

import JDBC101.model.Role;

import java.util.List;

public interface roleService {
     void addRole(Role Role);
     Role fetchRoleById(long id_role);
     void deleteRoleById(Role role);

     List<Role> getAllRoles();
}
