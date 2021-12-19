package JDBC101.daoImpl;

import JDBC101.dao.classRoomDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.ClassRoom;

import java.util.List;
import java.util.Optional;

public class classRoomDaoImp implements classRoomDao {


    @Override
    public Optional<ClassRoom> getClassRoom(long id) throws DAOException {
        return Optional.empty();
    }

    @Override
    public List<ClassRoom> getAllClassRoom() throws DAOException {
        return null;
    }

    @Override
    public void saveClassRoom(ClassRoom t) throws DAOException {

    }

    @Override
    public void updateClassRoom(ClassRoom t, String[] params) throws DAOException {

    }

    @Override
    public void deleteClassRoom(ClassRoom t) throws DAOException {

    }
}
