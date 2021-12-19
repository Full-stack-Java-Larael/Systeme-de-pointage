package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Specialty;

import java.util.List;
import java.util.Optional;

public interface specialityDao {
    Optional<Specialty> getSpecialty(long id) throws DAOException;

    List<Specialty> getAllSpecialty() throws DAOException;

    void saveSpecialty(Specialty t) throws DAOException;

    void updateSpecialty(Specialty t, String[] params) throws DAOException;

    void deleteSpecialty(Specialty t) throws DAOException;
}
