package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Attendance;

import java.util.List;
import java.util.Optional;

public interface attendanceDao {
    Optional<Attendance> getAttendance(long id) throws DAOException;

    List<Attendance> getAllAttendances() throws DAOException;

    void saveAttendance(Attendance t) throws DAOException;

    void updateAttendance(Attendance t, String[] params) throws DAOException;

    void deleteAttendance(Attendance t) throws DAOException;
}
