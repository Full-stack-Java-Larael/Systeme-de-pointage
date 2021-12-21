package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Speciality;

import java.util.List;

public interface specialityDao {
    Speciality getSpeciality(long id) throws DAOException;

    List<Speciality> getAllSpeciality() throws DAOException;

    void saveSpeciality(Speciality t) throws DAOException;

    void updateSpeciality(Speciality t, String[] params) throws DAOException;

    boolean deleteSpeciality(Speciality t) throws DAOException;

}
