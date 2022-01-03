package JDBC101.daoImpl;

import JDBC101.dao.secretaryDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Secretary;

import java.util.ArrayList;
import java.util.List;

public class secretaryDaoImp implements secretaryDao {

    @Override
    public Secretary getSecretary(long id) throws DAOException {
        return null;
    }

    @Override
    public ArrayList<Secretary> getAllSecretary() throws DAOException {
        return null;
    }

    @Override
    public Secretary saveSecretary(Secretary secretary) throws DAOException {
        return null;
    }

    @Override
    public Secretary updateSecretary(Secretary secretary) throws DAOException {
        return null;
    }

    @Override
    public boolean deleteSecretary(long id) throws DAOException {
        return false;
    }
}
