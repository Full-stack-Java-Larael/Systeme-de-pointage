package JDBC101;

import JDBC101.daoImpl.classRoomDaoImp;
import JDBC101.daoImpl.specialityDaoImp;
import JDBC101.daoImpl.teacherDaoImp;
import JDBC101.model.ClassRoom;
import JDBC101.model.Speciality;

import java.sql.Time;

import java.util.Date;


public class MainApp {


    public static void main(String[] args) {

        ClassRoom classRoom = new ClassRoom();
        classRoom.setName("JAVA/ANGULAR");
        classRoom.setDay_start_hour("2354324322");
        classRoom.setDay_end_hour("34Z42365346");

        Speciality speciality = new Speciality();
        speciality.setName("JAVA");
        speciality.setId_speciality(1);

        classRoom.setSpecialty(speciality);
        //System.out.println(classRoom.toString());
        classRoomDaoImp classRoomDaoImp = new classRoomDaoImp();
        classRoomDaoImp.saveClassRoom(classRoom);
        System.out.println(classRoomDaoImp.saveClassRoom(classRoom).toString());

        teacherDaoImp teacherDao = new teacherDaoImp();
        // Speciality
        /*
        specialityDaoImp specialityImp = new specialityDaoImp();
        Speciality speciality = new Speciality();
        speciality.setName("Java");
        specialityImp.saveSpeciality(speciality);
*/
        /*
        specialityDaoImp specialityImp = new specialityDaoImp();
        Speciality sp = specialityImp.getSpeciality(1);
        System.out.println(specialityImp.deleteSpeciality(sp));
*/
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