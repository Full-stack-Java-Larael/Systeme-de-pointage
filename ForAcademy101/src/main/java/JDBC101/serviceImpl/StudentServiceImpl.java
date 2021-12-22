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
    public Optional<Student> fetchStudentById(int id_student) {
        return Optional.empty();
    }

    @Override
    public void deleteStudentById(Student id_student) {

    }

    @Override
    public void updateStudentPasswordById(String newPassword, String[] id_student) {

    }

    @Override
    public List<Student> getAllStudents() {
        return null;
    }
}
