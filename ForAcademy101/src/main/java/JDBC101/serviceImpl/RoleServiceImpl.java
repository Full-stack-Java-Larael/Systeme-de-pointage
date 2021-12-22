package JDBC101.serviceImpl;

import JDBC101.model.Role;
import JDBC101.service.roleService;

import java.util.List;
import java.util.Optional;

public class RoleServiceImpl implements roleService {
    @Override
    public void addRole(Role Role) {

    }

    @Override
    public Optional<Role> fetchRoleById(int id_role) {
        return Optional.empty();
    }

    @Override
    public void deleteRoleById(Role id_role) {

    }

    @Override
    public void updateRolePasswordById(String newPassword, String[] id_role) {

    }

    @Override
    public List<Role> getAllRoles() {
        return null;
    }
}
