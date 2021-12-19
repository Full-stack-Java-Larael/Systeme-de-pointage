package JDBC101.service;

import JDBC101.model.Role;

import java.util.List;
import java.util.Optional;

public interface roleService {
    public void addRole(Role Role);
    public Optional<Role> fetchRoleById(int id_role);
    public void deleteRoleById(Role id_role);
    public void updateRolePasswordById(String newPassword, String[] id_role);
    public List<Role> getAllRoles();
}
