package JDBC101.service;

import JDBC101.model.ClassRoom;

import java.util.List;
import java.util.Optional;

public interface classRoomService {
     void addClassRoom(ClassRoom ClassRoom);
    ClassRoom fetchClassRoomById(long id_classRoom);
     void deleteClassRoomById(ClassRoom id_classRoom);

     List<ClassRoom> getAllClassRooms();
}
