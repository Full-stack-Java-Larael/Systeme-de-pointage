package JDBC101.daoImpl;

import JDBC101.dao.managerDao;
import JDBC101.model.Manager;

import java.util.List;
import java.util.Optional;

public class managerDaoImp implements managerDao {
    @Override
    public Optional<Manager> getManager(long id) {
        return Optional.empty();
    }

    @Override
    public List<Manager> getAllManager() {
        return null;
    }

    @Override
    public void saveManager(Manager t) {

    }

    @Override
    public void updateManager(Manager t, String[] params) {

    }

    @Override
    public void deleteManager(Manager t) {

    }
}
