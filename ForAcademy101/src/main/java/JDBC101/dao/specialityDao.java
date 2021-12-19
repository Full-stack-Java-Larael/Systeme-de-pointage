package JDBC101.dao;

import JDBC101.model.Specialty;

import java.util.List;
import java.util.Optional;

public interface specialityDao {
    Optional<Specialty> getSpecialty(long id);

    List<Specialty> getAllSpecialty();

    void saveSpecialty(Specialty t);

    void updateSpecialty(Specialty t, String[] params);

    void deleteSpecialty(Specialty t);
}
