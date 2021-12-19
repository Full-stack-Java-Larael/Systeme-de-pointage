package JDBC101.daoImpl;

import JDBC101.dao.adminDao;
import JDBC101.model.Admin;

import java.util.List;
import java.util.Optional;

public class adminDaoImp implements adminDao {
    @Override
    public Optional<Admin> getAdmin(long id) {
        return Optional.empty();
    }

    @Override
    public List<Admin> getAllAdmin() {
        return null;
    }

    @Override
    public void saveAdmin(Admin t) {

    }

    @Override
    public void updateAdmin(Admin t, String[] params) {

    }

    @Override
    public void deleteAdmin(Admin t) {

    }
}
