package JDBC101.service;

import JDBC101.model.Attendance;

import java.util.List;
import java.util.Optional;

public interface attendanceService {
    public void addAttendance(Attendance Attendance);
    public Optional<Attendance> fetchAttendanceById(int id_attendance);
    public void deleteAttendanceById(Attendance id_attendance);
    public void updateAttendancePasswordById(String newPassword, String[] id_attendance);
    public List<Attendance> getAllAttendances();
}
