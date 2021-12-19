package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Speciality;

import java.util.List;
import java.util.Optional;

public interface specialityDao {
    Optional<Speciality> getSpecialty(long id) throws DAOException;

    List<Speciality> getAllSpecialty() throws DAOException;

    void saveSpecialty(Speciality t) throws DAOException;

    void updateSpecialty(Speciality t, String[] params) throws DAOException;

    void deleteSpecialty(Speciality t) throws DAOException;
}
