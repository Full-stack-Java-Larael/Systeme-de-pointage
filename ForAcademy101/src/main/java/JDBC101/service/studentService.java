package JDBC101.service;

import JDBC101.model.Student;

import java.util.List;

public interface studentService {
     void addStudent(Student Student);
     Student fetchStudentById(long id_student);
     void deleteStudentById(Student student);
     void updateStudentPasswordById(String newPassword, long id_student);
     List<Student> getAllStudents();
}
