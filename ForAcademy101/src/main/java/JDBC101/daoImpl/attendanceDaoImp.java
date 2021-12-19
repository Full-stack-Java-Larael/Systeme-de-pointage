package JDBC101.daoImpl;

import JDBC101.dao.attendanceDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Attendance;

import java.util.List;
import java.util.Optional;

public class attendanceDaoImp implements attendanceDao {

    @Override
    public Optional<Attendance> getAttendance(long id) throws DAOException {
        return Optional.empty();
    }

    @Override
    public List<Attendance> getAllAttendances() throws DAOException {
        return null;
    }

    @Override
    public void saveAttendance(Attendance t) throws DAOException {

    }

    @Override
    public void updateAttendance(Attendance t, String[] params) throws DAOException {

    }

    @Override
    public void deleteAttendance(Attendance t) throws DAOException {

    }
}
