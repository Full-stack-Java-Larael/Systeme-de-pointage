package JDBC101.service;

import JDBC101.model.ClassRoom;

import java.util.List;
import java.util.Optional;

public interface classRoomService {
    public void addClassRoom(ClassRoom ClassRoom);
    public Optional<ClassRoom> fetchClassRoomById(int id_classRoom);
    public void deleteClassRoomById(ClassRoom id_classRoom);
    public void updateClassRoomPasswordById(String newPassword, String[] id_classRoom);
    public List<ClassRoom> getAllClassRooms();
}
