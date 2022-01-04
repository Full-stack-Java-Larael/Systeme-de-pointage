package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Speciality;

import java.util.ArrayList;
import java.util.List;

public interface specialityDao {
    Speciality getSpeciality(long id) throws DAOException;

    ArrayList<Speciality> getAllSpeciality() throws DAOException;

    Speciality saveSpeciality(Speciality t) throws DAOException;

    Speciality updateSpeciality(Speciality speciality) throws DAOException;

    boolean deleteSpeciality(Speciality t) throws DAOException;

}
