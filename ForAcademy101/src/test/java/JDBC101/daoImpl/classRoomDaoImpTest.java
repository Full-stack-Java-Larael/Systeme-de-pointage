package JDBC101.daoImpl;

import JDBC101.model.ClassRoom;
import JDBC101.model.Speciality;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class classRoomDaoImpTest {
    static long id;
    @Test
    @Order(3)
    void getClassRoom() {
        classRoomDaoImp classRoomDaoImp = new classRoomDaoImp();
        assertNotNull(classRoomDaoImp.getClassRoom(id));
    }

    @Test
    @Order(2)
    void getAllClassRoom() {
        classRoomDaoImp classRoomDaoImp = new classRoomDaoImp();
        ArrayList<ClassRoom> classRooms = new ArrayList<ClassRoom>();
        assertInstanceOf(classRooms.getClass(),classRoomDaoImp.getAllClassRoom());
    }

    @Test
    @Order(1)
    void saveClassRoom() {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setName("JAVA/ANGULAR");
        classRoom.setDay_start_hour("2354324322");
        classRoom.setDay_end_hour("34Z42365346");
        classRoom.setSpecialty(new specialityDaoImp().getAllSpeciality().get(0));
        classRoomDaoImp classRoomDaoImp = new classRoomDaoImp();
        classRoomDaoImp.saveClassRoom(classRoom);
        ClassRoom res = classRoomDaoImp.saveClassRoom(classRoom);
        assertNotNull(res);
    }

    @Test
    @Order(4)
    void updateClassRoom() {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setId_class_room(id);
        classRoom.setName("JAVA/ANGULAR");
        classRoom.setDay_start_hour("2354324322");
        classRoom.setDay_end_hour("34Z42365346");
        Speciality speciality = new Speciality();
        speciality.setName("JAVA");
        speciality.setId_speciality(5);
        classRoom.setSpecialty(speciality);
        classRoomDaoImp classRoomDaoImp = new classRoomDaoImp();
        ClassRoom res = classRoomDaoImp.updateClassRoom(classRoom);
        assertNotNull(res);
    }

    @Test
    @Order(5)
    void deleteClassRoom() {
        classRoomDaoImp classRoomDaoImp = new classRoomDaoImp();
        ClassRoom classRoom = new ClassRoom();
        classRoom.setId_class_room(id);
        assertTrue(classRoomDaoImp.deleteClassRoom(classRoom));
    }
}