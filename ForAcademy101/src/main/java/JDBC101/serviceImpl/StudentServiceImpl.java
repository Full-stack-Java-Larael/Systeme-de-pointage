package JDBC101.serviceImpl;

import JDBC101.model.Student;
import JDBC101.service.studentService;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements studentService {
    @Override
    public void addStudent(Student Student) {

    }

    @Override
    public Student fetchStudentById(long id_student) {
        return null;
    }

    @Override
    public void deleteStudentById(Student student) {

    }

    @Override
    public void updateStudentPasswordById(String newPassword, long id_student) {

    }

    @Override
    public List<Student> getAllStudents() {
        return null;
    }
}
