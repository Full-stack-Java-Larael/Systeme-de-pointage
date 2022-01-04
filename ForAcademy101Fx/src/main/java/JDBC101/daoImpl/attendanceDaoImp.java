package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.attendanceDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Attendance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class attendanceDaoImp implements attendanceDao {
    private static final String GET_ALL_ATTENDANCE = "SELECT * FROM attendance";
    private static final String GET_ATTENDANCE = "SELECT * FROM attendance WHERE id_attendance = ?";
    public static final  String SAVE_ATTENDANCE = "INSERT INTO attendance (date,arrival_hour,departure_hour) VALUES (?,?,?)";
    public static final  String UPDATE_ATTENDANCE = "UPDATE attendance SET date=?,arrival_hour=?,departure_hour=? WHERE id_attendance = ?";
    public static final  String DELETE_ATTENDANCE = "DELETE FROM attendance WHERE id_attendance = ?";

    @Override
    public Attendance getAttendance(long id) throws DAOException {
        try( Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ATTENDANCE)) {
                statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            Attendance attendance = new Attendance();
            while (resultSet.next()){
//                attendance.setUser(new userDaoImp().getUser(resultSet.getLong("id_user")));
                attendance.setId_attendance((int)resultSet.getLong("id_attendance"));
                attendance.setDate(resultSet.getTime("date"));
                attendance.setArrival_hour(resultSet.getTime("arrival_hour"));
                attendance.setDeparture_hour(resultSet.getTime("departure_hour"));
            }
            return attendance;
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Cannot seletct attandance");
        }
        return  null;
    }

    @Override
    public List<Attendance> getAllAttendances() throws DAOException {
        try(
            Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_ALL_ATTENDANCE);
        ){
            ResultSet resultSet = statement.executeQuery();
            List<Attendance> attendances = new ArrayList<Attendance>();
            while (resultSet.next()){
                Attendance attendance = new Attendance();
//                attendance.setUser(new userDaoImp().getUser(resultSet.getLong("id_user")));
                attendance.setId_attendance((int)resultSet.getLong("id_attendance"));
                attendance.setDate(resultSet.getTime("date"));
                attendance.setArrival_hour(resultSet.getTime("arrival_hour"));
                attendance.setDeparture_hour(resultSet.getTime("departure_hour"));
                attendances.add(attendance);
            }
            return attendances;
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Cannt get All attendances");
        }
        return null;
    }

    @Override
    public Attendance saveAttendance(Attendance attendance) throws DAOException {
        try(Connection connection = ConnectionFactory.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SAVE_ATTENDANCE,Statement.RETURN_GENERATED_KEYS)){
            statement.setDate(1,(Date) attendance.getDate());
            statement.setTime(2,attendance.getArrival_hour());
            statement.setTime(3,attendance.getDeparture_hour());
//            statement.setLong(4,attendance.getUser().getId_user());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();

            while (resultSet.next()){
                attendance.setId_attendance((int)resultSet.getLong(1));
            }
            return attendance;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Cannot save Attendance!");
        }
        return  null;
    }

    @Override
    public boolean updateAttendance(Attendance attendance) throws DAOException {
        try(Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_ATTENDANCE)){
            statement.setDate(1,(Date) attendance.getDate());
            statement.setTime(2,attendance.getArrival_hour());
            statement.setTime(3,attendance.getDeparture_hour());
//            statement.setLong(4,attendance.getUser().getId_user());
            statement.setLong(4,attendance.getId_attendance());
            if(statement.executeUpdate() == 1)
                return true;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Cannot update Attendance!");
        }
        return  false;
    }

    @Override
    public boolean deleteAttendance(Attendance attendance) throws DAOException {
        try(Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_ATTENDANCE)){
            statement.setLong(1,attendance.getId_attendance());
            if(statement.executeUpdate() > 0) return true;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Cannot delete Attendance!");
        }
        return  false;
    }
}
