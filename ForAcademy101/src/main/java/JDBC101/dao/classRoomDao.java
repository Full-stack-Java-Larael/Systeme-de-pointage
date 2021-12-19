package JDBC101.dao;

import JDBC101.model.ClassRoom;

import java.util.List;
import java.util.Optional;

public interface classRoomDao {
    Optional<ClassRoom> getClassRoom(long id);

    List<ClassRoom> getAllClassRoom();

    void saveClassRoom(ClassRoom t);

    void updateClassRoom(ClassRoom t, String[] params);

    void deleteClassRoom(ClassRoom t);
}
