package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface teacherDao {
    Optional<Teacher> getTeacher(long id) throws DAOException;

    List<Teacher> getAllTeacher() throws DAOException;

    void saveTeacher(Teacher t) throws DAOException;

    void updateTeacher(Teacher t, String[] params) throws DAOException;

    void deleteTeacher(Teacher t) throws DAOException;
}
