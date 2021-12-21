package JDBC101.daoImpl;

import JDBC101.dao.specialityDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Speciality;

import java.util.List;
import java.util.Optional;

public class specialityDaoImp implements specialityDao {

    @Override
    public Optional<Speciality> getSpecialty(long id) throws DAOException {
        return Optional.empty();
    }

    @Override
    public List<Speciality> getAllSpecialty() throws DAOException {
        return null;
    }

    @Override
    public void saveSpecialty(Speciality t) throws DAOException {
        
    }

    @Override
    public void updateSpecialty(Speciality t, String[] params) throws DAOException {

    }

    @Override
    public void deleteSpecialty(Speciality t) throws DAOException {

    }
}
