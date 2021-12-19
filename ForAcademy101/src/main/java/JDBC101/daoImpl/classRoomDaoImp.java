package JDBC101.daoImpl;

import JDBC101.dao.classRoomDao;
import JDBC101.model.ClassRoom;

import java.util.List;
import java.util.Optional;

public class classRoomDaoImp implements classRoomDao {


    @Override
    public Optional<ClassRoom> getClassRoom(long id) {
        return Optional.empty();
    }

    @Override
    public List<ClassRoom> getAllClassRoom() {
        return null;
    }

    @Override
    public void saveClassRoom(ClassRoom t) {

    }

    @Override
    public void updateClassRoom(ClassRoom t, String[] params) {

    }

    @Override
    public void deleteClassRoom(ClassRoom t) {

    }
}
