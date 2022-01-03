package JDBC101.daoImpl;

import JDBC101.model.Admin;
import JDBC101.model.Student;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class studentDaoImpTest {
    static long id;
    @Test
    @Order(2)
    void getStudent() {
        studentDaoImp studentDaoImp = new studentDaoImp();
        assertInstanceOf(Student.class,studentDaoImp.getStudent(id));
    }

    @Test
    @Order(3)
    void getAllStudent() {
        studentDaoImp studentDaoImp = new studentDaoImp();
        ArrayList<Student> students = new ArrayList<Student>();
        assertInstanceOf(students.getClass(),studentDaoImp.getAllStudent());
    }

    @Test
    @Order(1)
    void saveStudent() {
        // Admin
        Student student = new Student();
        student.setEmail("email@foracademy.com");
        student.setFirst_name("first name");
        student.setLast_name("last name");
        student.setGender("male");
        student.setPhone("0612345678");
        student.setStatus(true);
        student.setPassword("pass1234");
        student.setAddress(new addressDaoImp().getAllAddress().get(0));
        student.setRole(new roleDaoImp().getAllRole().get(0));
        studentDaoImp studentDaoImp = new studentDaoImp();
        Student newStudent = studentDaoImp.saveStudent(student);
        assertInstanceOf(Student.class,newStudent);
        id = newStudent.getId_user();
    }

    @Test
    @Order(4)
    void updateStudent() {
        // Admin
        Student student = new Student();
        student.setId_user(id);
        student.setEmail("email@foracademy.com");
        student.setFirst_name("new first name");
        student.setLast_name("new last name");
        student.setGender("male");
        student.setPhone("0600045678");
        student.setStatus(false);
        student.setPassword("pass@1234");
        student.setAddress(new addressDaoImp().getAllAddress().get(0));
        student.setRole(new roleDaoImp().getAllRole().get(0));
        studentDaoImp studentDaoImp = new studentDaoImp();
        Student newStudent = studentDaoImp.updateStudent(student);
        assertInstanceOf(Student.class,newStudent);
    }

    @Test
    @Order(5)
    void deleteStudent() {
        studentDaoImp studentDaoImp = new studentDaoImp();
        assertTrue(studentDaoImp.deleteStudent(id));
    }
}