package JDBC101.dao;

import JDBC101.model.Student;

import java.util.List;
import java.util.Optional;

public interface studentDao {
    Optional<Student> getStudent(long id);

    List<Student> getAllStudent();

    void saveStudent(Student t);

    void updateStudent(Student t, String[] params);

    void deleteStudent(Student t);
}
