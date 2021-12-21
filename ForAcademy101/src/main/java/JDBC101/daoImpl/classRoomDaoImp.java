package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.classRoomDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.ClassRoom;
import JDBC101.model.Speciality;

import java.sql.*;
import java.util.List;

public class classRoomDaoImp implements classRoomDao {
    private final String SELECT_ALL = "SELECT * FROM classroom WHERE id_classroom = ? LIMIT 1";
    private final String SAVE_CLASS_ROOM = "INSERT INTO classroom (name,day_start_hour,day_end_hour,id_speciality) VALUES (?,?,?,?)";

    @Override
    public ClassRoom getClassRoom(long id) throws DAOException {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return new ClassRoom(resultSet.getInt("id_classroom"),
                        resultSet.getString("name"),
                        resultSet.getString("day_start"),
                        resultSet.getString("day_end"),
                        new Speciality(resultSet.getInt("id_speciality"))
                );
            }
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Unable to get Classroom");
        }
        return new ClassRoom();
    }

    @Override
    public List<ClassRoom> getAllClassRoom() throws DAOException {
        return null;
    }

    @Override
    public ClassRoom saveClassRoom(ClassRoom classRoom) throws DAOException {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SAVE_CLASS_ROOM);
            statement.setString(1,classRoom.getName());
            statement.setTime(2,classRoom.getDay_start_hour());
            statement.setTime(3,classRoom.getDay_end_hour());
            statement.setLong(4,classRoom.getSpecialty().getId_speciality());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            System.out.println(resultSet.getFetchSize());
            while (resultSet.next()){
                System.out.println("id: "+resultSet.getInt(1));
            }
            return classRoom;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("cannot save ClassRoom!");
        }
        return null;
    }

    @Override
    public void updateClassRoom(ClassRoom t, String[] params) throws DAOException {

    }

    @Override
    public void deleteClassRoom(ClassRoom t) throws DAOException {

    }
}
