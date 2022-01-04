package JDBC101.serviceImpl;

import JDBC101.daoImpl.roleDaoImp;
import JDBC101.model.Role;
import JDBC101.service.roleService;

import java.util.List;
import java.util.Optional;

public class RoleServiceImpl implements roleService {
    private roleDaoImp roleDao = new roleDaoImp();
    @Override
    public void addRole(Role Role) {
roleDao.saveRole(Role);
    }

    @Override
    public Role fetchRoleById(long id_role) {
        return roleDao.getRole(id_role);
    }

    @Override
    public void deleteRoleById(Role role) {
roleDao.deleteRole(role);
    }



    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRole();
    }
}
