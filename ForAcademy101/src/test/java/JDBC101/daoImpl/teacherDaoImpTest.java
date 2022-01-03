package JDBC101.daoImpl;

import JDBC101.model.Teacher;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class teacherDaoImpTest {
    static long id;
    @Test
    @Order(2)
    void getTeacher() {
        teacherDaoImp teacherDaoImp = new teacherDaoImp();
        assertInstanceOf(Teacher.class,teacherDaoImp.getTeacher(id));
    }

    @Test
    @Order(3)
    void getAllTeacher() {
        teacherDaoImp teacherDaoImp = new teacherDaoImp();
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();
        assertInstanceOf(teachers.getClass(),teacherDaoImp.getAllTeacher());
    }

    @Test
    @Order(1)
    void saveTeacher() {
        Teacher teacher = new Teacher();
        teacher.setEmail("email@foracademy.com");
        teacher.setFirst_name("first name");
        teacher.setLast_name("last name");
        teacher.setGender("male");
        teacher.setPhone("0612345678");
        teacher.setStatus(true);
        teacher.setPassword("pass1234");
        teacher.setAddress(new addressDaoImp().getAllAddress().get(0));
        teacher.setRole(new roleDaoImp().getAllRole().get(0));
        teacher.setSpeciality(new specialityDaoImp().getAllSpeciality().get(0));
        teacherDaoImp teacherDaoImp = new teacherDaoImp();
        Teacher newTeacher = teacherDaoImp.saveTeacher(teacher);
        assertInstanceOf(Teacher.class,newTeacher);
        id = newTeacher.getId_user();
    }

    @Test
    @Order(4)
    void updateTeacher() {
        Teacher teacher = new Teacher();
        teacher.setEmail("new.email@foracademy.com");
        teacher.setFirst_name("new first name");
        teacher.setLast_name("new last name");
        teacher.setGender("male");
        teacher.setPhone("0600045678");
        teacher.setStatus(false);
        teacher.setPassword("pass@1234");
        teacher.setAddress(new addressDaoImp().getAllAddress().get(0));
        teacher.setRole(new roleDaoImp().getAllRole().get(0));
        teacher.setSpeciality(new specialityDaoImp().getAllSpeciality().get(0));
        teacherDaoImp teacherDaoImp = new teacherDaoImp();
        assertInstanceOf(Teacher.class,teacherDaoImp.saveTeacher(teacher));
    }

    @Test
    @Order(5)
    void deleteTeacher() {
        teacherDaoImp teacherDaoImp = new teacherDaoImp();
        assertTrue(teacherDaoImp.deleteTeacher(id));
    }
}