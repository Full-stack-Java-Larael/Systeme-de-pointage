package JDBC101;

import JDBC101.daoImpl.*;
import JDBC101.model.Role;
import JDBC101.model.Speciality;
import JDBC101.model.Teacher;


public class MainApp {


    public static void main(String[] args) {
        teacherDaoImp teacherDao = new teacherDaoImp();
        // Speciality
        specialityDaoImp specialityImp = new specialityDaoImp();
        Speciality speciality = new Speciality();
        speciality.setName("Java");
        specialityImp.saveSpecialty(speciality);

        // Teacher
        /*Teacher Teacher = new Teacher();
        Teacher.setFirst_name("Abdelaziz");
        Teacher.setLast_name("Bardich");
        Teacher.setEmail("abdelazizbardich@gmail.com");
        Teacher.setSpeciality(speciality);
        Teacher.setGender("male");
        Teacher.setPassword("1234");
        Teacher.setPhone("0603768705");
        Teacher.setRole(new Role(1,"teacher","student,event,class"));
        Teacher.setStatus(true);
        teacherDao.saveTeacher(Teacher);
        */
    }

}