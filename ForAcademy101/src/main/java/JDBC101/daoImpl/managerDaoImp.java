package JDBC101.daoImpl;

import JDBC101.dao.managerDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Manager;

import java.util.List;
import java.util.Optional;

public class managerDaoImp implements managerDao {

    @Override
    public Optional<Manager> getManager(long id) throws DAOException {
        return Optional.empty();
    }

    @Override
    public List<Manager> getAllManager() throws DAOException {
        return null;
    }

    @Override
    public void saveManager(Manager t) throws DAOException {

    }

    @Override
    public void updateManager(Manager t, String[] params) throws DAOException {

    }

    @Override
    public void deleteManager(Manager t) throws DAOException {

    }
}
