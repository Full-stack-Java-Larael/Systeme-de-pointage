package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.attendanceDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Attendance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class attendanceDaoImp implements attendanceDao {
    private static final String GET_ATTENDANCE = "SELECT * FROM attendance";
    @Override
    public Attendance getAttendance(long id) throws DAOException {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_ATTENDANCE);
            ResultSet resultSet = statement.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Cannot seletct attandance");
        }
        return  null;
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
