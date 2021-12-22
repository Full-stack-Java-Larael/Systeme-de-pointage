package JDBC101.daoImpl;

import JDBC101.model.ClassRoom;
import JDBC101.model.Speciality;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class classRoomDaoImpTest {

    @Test
    void getClassRoom() {

    }

    @Test
    void getAllClassRoom() {
        classRoomDaoImp classRoomDaoImp = new classRoomDaoImp();
        List<ClassRoom> classRooms = classRoomDaoImp.getAllClassRoom();


    }

    @Test
    void saveClassRoom() {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setName("JAVA/ANGULAR");
        classRoom.setDay_start_hour("2354324322");
        classRoom.setDay_end_hour("34Z42365346");
        Speciality speciality = new Speciality();
        speciality.setName("JAVA");
        speciality.setId_speciality(1);
        classRoom.setSpecialty(speciality);
        classRoomDaoImp classRoomDaoImp = new classRoomDaoImp();
        classRoomDaoImp.saveClassRoom(classRoom);
        ClassRoom res = classRoomDaoImp.saveClassRoom(classRoom);
        assertNotNull(res);
    }

    @Test
    void updateClassRoom() {
    }

    @Test
    void deleteClassRoom() {
    }
}