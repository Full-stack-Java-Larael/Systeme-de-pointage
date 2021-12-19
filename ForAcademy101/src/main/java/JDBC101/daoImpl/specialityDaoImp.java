package JDBC101.daoImpl;

import JDBC101.dao.specialityDao;
import JDBC101.model.Specialty;

import java.util.List;
import java.util.Optional;

public class specialityDaoImp implements specialityDao {
    @Override
    public Optional<Specialty> getSpecialty(long id) {
        return Optional.empty();
    }

    @Override
    public List<Specialty> getAllSpecialty() {
        return null;
    }

    @Override
    public void saveSpecialty(Specialty t) {

    }

    @Override
    public void updateSpecialty(Specialty t, String[] params) {

    }

    @Override
    public void deleteSpecialty(Specialty t) {

    }
}
