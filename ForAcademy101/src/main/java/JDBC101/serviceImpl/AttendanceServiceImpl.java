package JDBC101.serviceImpl;

import JDBC101.model.Attendance;
import JDBC101.service.attendanceService;

import java.util.List;
import java.util.Optional;

public class AttendanceServiceImpl implements attendanceService {
    @Override
    public void addAttendance(Attendance Attendance) {

    }

    @Override
    public Optional<Attendance> fetchAttendanceById(int id_attendance) {
        return Optional.empty();
    }

    @Override
    public void deleteAttendanceById(Attendance id_attendance) {

    }

    @Override
    public void updateAttendancePasswordById(String newPassword, String[] id_attendance) {

    }

    @Override
    public List<Attendance> getAllAttendances() {
        return null;
    }
}
