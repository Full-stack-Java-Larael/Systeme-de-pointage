package JDBC101.daoImpl;

import JDBC101.dao.attendanceDao;
import JDBC101.model.Attendance;

import java.util.List;
import java.util.Optional;

public class attendanceDaoImp implements attendanceDao {
    @Override
    public Optional<Attendance> getAttendance(long id) {
        return Optional.empty();
    }

    @Override
    public List<Attendance> getAllAttendances() {
        return null;
    }

    @Override
    public void saveAttendance(Attendance t) {

    }

    @Override
    public void updateAttendance(Attendance t, String[] params) {

    }

    @Override
    public void deleteAttendance(Attendance t) {

    }
}
