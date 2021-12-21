package JDBC101.daoImpl;

import JDBC101.dao.RoleDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Role;

import java.util.List;
import java.util.Optional;

public class roleDaoImp implements RoleDao {

    @Override
    public Role getRole(long id) throws DAOException {
        return null;
    }

    @Override
    public List<Role> getAllRole() throws DAOException {
        return null;
    }

    @Override
    public void saveRole(Role t) throws DAOException {

    }

    @Override
    public void updateRole(Role t, String[] params) throws DAOException {

    }

    @Override
    public void deleteRole(Role t) throws DAOException {

    }
}
