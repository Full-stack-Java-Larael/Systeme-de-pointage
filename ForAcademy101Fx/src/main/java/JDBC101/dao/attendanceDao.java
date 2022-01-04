package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Attendance;

import java.util.List;
import java.util.Optional;

public interface attendanceDao {
    Attendance getAttendance(long id) throws DAOException;

    List<Attendance> getAllAttendances() throws DAOException;

    Attendance saveAttendance(Attendance attendance) throws DAOException;

    boolean updateAttendance(Attendance attendance) throws DAOException;

    boolean deleteAttendance(Attendance attendance) throws DAOException;
}
