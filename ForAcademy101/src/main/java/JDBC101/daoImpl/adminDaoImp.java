package JDBC101.daoImpl;

import JDBC101.dao.adminDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Admin;

import java.util.List;
import java.util.Optional;

public class adminDaoImp implements adminDao {

    @Override
    public Optional<Admin> getAdmin(long id) throws DAOException {
        return Optional.empty();
    }

    @Override
    public List<Admin> getAllAdmin() throws DAOException {
        return null;
    }

    @Override
    public void saveAdmin(Admin t) throws DAOException {

    }

    @Override
    public void updateAdmin(Admin t, String[] params) throws DAOException {

    }

    @Override
    public void deleteAdmin(Admin t) throws DAOException {

    }
}
