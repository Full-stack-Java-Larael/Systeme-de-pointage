package JDBC101.serviceImpl;

import JDBC101.daoImpl.studentDaoImp;
import JDBC101.model.Student;
import JDBC101.service.studentService;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements studentService {

    private studentDaoImp studentDao = new studentDaoImp();
    @Override
    public void addStudent(Student Student) {
studentDao.saveStudent(Student);
    }

    @Override
    public Student fetchStudentById(long id_student) {
        return studentDao.getStudent(id_student);
    }

    @Override
    public void deleteStudentById(Student student) {
        studentDao.deleteStudent(student.getId_user());

    }



    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudent();
    }
}
