package JDBC101;

import JDBC101.daoImpl.classRoomDaoImp;
import JDBC101.model.ClassRoom;
import JDBC101.model.Speciality;

import java.sql.Time;


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
       // System.out.println(classRoom.toString());
        classRoomDaoImp classRoomDaoImp = new classRoomDaoImp();
        classRoomDaoImp.saveClassRoom(classRoom);
        //System.out.println(classRoomDaoImp.saveClassRoom(classRoom).toString());
    }

}