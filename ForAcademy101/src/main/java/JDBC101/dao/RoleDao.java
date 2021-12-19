package JDBC101.dao;

import JDBC101.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleDao {
    Optional<Role> getRole(long id);

    List<Role> getAllRole();

    void saveRole(Role t);

    void updateRole(Role t, String[] params);

    void deleteRole(Role t);
}
