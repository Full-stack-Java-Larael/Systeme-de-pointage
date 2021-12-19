package JDBC101.daoImpl;

import JDBC101.dao.RoleDao;
import JDBC101.model.Role;

import java.util.List;
import java.util.Optional;

public class roleDaoImp implements RoleDao {
    @Override
    public Optional<Role> getRole(long id) {
        return Optional.empty();
    }

    @Override
    public List<Role> getAllRole() {
        return null;
    }

    @Override
    public void saveRole(Role t) {

    }

    @Override
    public void updateRole(Role t, String[] params) {

    }

    @Override
    public void deleteRole(Role t) {

    }
}
