package JDBC101.service;

import JDBC101.model.Attendance;

import java.util.List;
import java.util.Optional;

public interface attendanceService {
     void addAttendance(Attendance Attendance);
     Attendance fetchAttendanceById(long id_attendance);
     void deleteAttendanceById(Attendance id_attendance);

     List<Attendance> getAllAttendances();
}
