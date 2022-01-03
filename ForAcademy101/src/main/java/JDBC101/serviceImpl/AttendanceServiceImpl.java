package JDBC101.serviceImpl;

import JDBC101.daoImpl.attendanceDaoImp;
import JDBC101.model.Attendance;
import JDBC101.service.attendanceService;

import java.util.List;
import java.util.Optional;

public class AttendanceServiceImpl implements attendanceService {
    private attendanceDaoImp attendanceDao = new attendanceDaoImp();
    @Override
    public void addAttendance(Attendance Attendance) {
        attendanceDao.saveAttendance(Attendance);
    }

    @Override
    public Attendance fetchAttendanceById(long id_attendance) {
        return attendanceDao.getAttendance(id_attendance);
    }

    @Override
    public void deleteAttendanceById(Attendance id_attendance) {
attendanceDao.deleteAttendance(id_attendance);
    }



    @Override
    public List<Attendance> getAllAttendances() {
        return attendanceDao.getAllAttendances();
    }
}
