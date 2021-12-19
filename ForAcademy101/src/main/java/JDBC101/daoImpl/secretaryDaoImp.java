package JDBC101.daoImpl;

import JDBC101.dao.secretaryDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Secretary;

import java.util.List;
import java.util.Optional;

public class secretaryDaoImp implements secretaryDao {

    @Override
    public Optional<Secretary> getSecretary(long id) throws DAOException {
        return Optional.empty();
    }

    @Override
    public List<Secretary> getAllSecretary() throws DAOException {
        return null;
    }

    @Override
    public void saveSecretary(Secretary t) throws DAOException {

    }

    @Override
    public void updateSecretary(Secretary t, String[] params) throws DAOException {

    }

    @Override
    public void deleteSecretary(Secretary t) throws DAOException {

    }
}
