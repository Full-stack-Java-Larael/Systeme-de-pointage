package JDBC101.service;

import JDBC101.model.Student;

import java.util.List;
import java.util.Optional;

public interface studentService {
    public void addStudent(Student Student);
    public Optional<Student> fetchStudentById(int id_student);
    public void deleteStudentById(Student id_student);
    public void updateStudentPasswordById(String newPassword, String[] id_student);
    public List<Student> getAllStudents();
}
