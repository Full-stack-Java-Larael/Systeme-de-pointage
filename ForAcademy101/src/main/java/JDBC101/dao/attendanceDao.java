package JDBC101.dao;

import JDBC101.model.Attendance;

import java.util.List;
import java.util.Optional;

public interface attendanceDao {
    Optional<Attendance> getAttendance(long id);

    List<Attendance> getAllAttendances();

    void saveAttendance(Attendance t);

    void updateAttendance(Attendance t, String[] params);

    void deleteAttendance(Attendance t);
}
