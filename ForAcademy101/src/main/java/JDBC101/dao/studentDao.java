package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Student;

import java.util.List;
import java.util.Optional;

public interface studentDao {
    Optional<Student> getStudent(long id) throws DAOException;

    List<Student> getAllStudent() throws DAOException;

    void saveStudent(Student t) throws DAOException;

    void updateStudent(Student t, String[] params) throws DAOException;

    void deleteStudent(Student t) throws DAOException;
}
