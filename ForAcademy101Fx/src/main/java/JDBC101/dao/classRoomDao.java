package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.ClassRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface classRoomDao {
    ClassRoom getClassRoom(long id) throws DAOException;

    ArrayList<ClassRoom> getAllClassRoom() throws DAOException;

    ClassRoom saveClassRoom(ClassRoom t) throws DAOException;

    ClassRoom updateClassRoom(ClassRoom classRoom) throws DAOException;

    boolean deleteClassRoom(ClassRoom t) throws DAOException;
}
