package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.ClassRoom;

import java.util.List;
import java.util.Optional;

public interface classRoomDao {
    ClassRoom getClassRoom(long id) throws DAOException;

    List<ClassRoom> getAllClassRoom() throws DAOException;

    ClassRoom saveClassRoom(ClassRoom t) throws DAOException;

    void updateClassRoom(ClassRoom t, String[] params) throws DAOException;

    void deleteClassRoom(ClassRoom t) throws DAOException;
}
