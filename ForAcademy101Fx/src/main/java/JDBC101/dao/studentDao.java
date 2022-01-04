package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface studentDao {
    Student getStudent(long id) throws DAOException;

    ArrayList<Student> getAllStudent() throws DAOException;

    Student saveStudent(Student t) throws DAOException;

    Student updateStudent(Student student) throws DAOException;

    boolean deleteStudent(long id) throws DAOException;
}
