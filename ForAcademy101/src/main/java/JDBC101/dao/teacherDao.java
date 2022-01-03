package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface teacherDao {
    Teacher getTeacher(long id) throws DAOException;

    ArrayList<Teacher> getAllTeacher() throws DAOException;

    Teacher saveTeacher(Teacher teacher) throws DAOException;

    Teacher updateTeacher(Teacher teacher) throws DAOException;

    boolean deleteTeacher(long id) throws DAOException;
}
