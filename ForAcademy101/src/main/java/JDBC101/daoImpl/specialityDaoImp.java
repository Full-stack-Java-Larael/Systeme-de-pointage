package JDBC101.daoImpl;

import JDBC101.dao.specialityDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Specialty;

import java.util.List;
import java.util.Optional;

public class specialityDaoImp implements specialityDao {

    @Override
    public Optional<Specialty> getSpecialty(long id) throws DAOException {
        return Optional.empty();
    }

    @Override
    public List<Specialty> getAllSpecialty() throws DAOException {
        return null;
    }

    @Override
    public void saveSpecialty(Specialty t) throws DAOException {

    }

    @Override
    public void updateSpecialty(Specialty t, String[] params) throws DAOException {

    }

    @Override
    public void deleteSpecialty(Specialty t) throws DAOException {

    }
}
