package JDBC101.serviceImpl;

import JDBC101.model.ClassRoom;
import JDBC101.service.classRoomService;

import java.util.List;
import java.util.Optional;

public class ClassRoomServiceImpl implements classRoomService {
    @Override
    public void addClassRoom(ClassRoom ClassRoom) {

    }

    @Override
    public Optional<ClassRoom> fetchClassRoomById(int id_classRoom) {
        return Optional.empty();
    }

    @Override
    public void deleteClassRoomById(ClassRoom id_classRoom) {

    }

    @Override
    public void updateClassRoomPasswordById(String newPassword, String[] id_classRoom) {

    }

    @Override
    public List<ClassRoom> getAllClassRooms() {
        return null;
    }
}
