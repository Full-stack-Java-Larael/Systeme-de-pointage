package JDBC101.serviceImpl;

import JDBC101.daoImpl.classRoomDaoImp;
import JDBC101.model.ClassRoom;
import JDBC101.service.classRoomService;

import java.util.List;
import java.util.Optional;

public class ClassRoomServiceImpl implements classRoomService {
    private classRoomDaoImp classRoom = new classRoomDaoImp();
    @Override
    public void addClassRoom(ClassRoom ClassRoom) {
classRoom.saveClassRoom(ClassRoom);
    }

    @Override
    public ClassRoom fetchClassRoomById(long id_classRoom) {
        return classRoom.getClassRoom(id_classRoom);
    }

    @Override
    public void deleteClassRoomById(ClassRoom id_classRoom) {
classRoom.deleteClassRoom(id_classRoom);
    }

    @Override
    public List<ClassRoom> getAllClassRooms() {
        return classRoom.getAllClassRoom();
    }
}
