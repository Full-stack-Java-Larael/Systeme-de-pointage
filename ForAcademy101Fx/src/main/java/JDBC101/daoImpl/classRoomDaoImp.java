package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.classRoomDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.ClassRoom;
import JDBC101.model.Speciality;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class classRoomDaoImp implements classRoomDao {
    private final String GET_ALL_CLASS_ROOMS = "SELECT * FROM classroom";
    private final String SELECT_ALL_BY_ID = "SELECT * FROM classroom WHERE id_classroom = ? LIMIT 1";
    private final String SAVE_CLASS_ROOM = "INSERT INTO classroom (name,day_start_hour,day_end_hour,id_speciality) VALUES (?,?,?,?)";
    private final String UPDATE_CLASS_ROOM = "UPDATE classroom SET name=?,day_start_hour=?,day_end_hour=?,id_speciality=? WHERE id_classroom=?";
    private final String DELETE_CLASS_ROOM = "DELETE FROM classroom WHERE id_classroom=?";
    private long lastInsertId;
    @Override
    public ClassRoom getClassRoom(long id) throws DAOException {
        try(
            Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BY_ID)
        ) {
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            ClassRoom classRoom = new ClassRoom();
            while (resultSet.next()) {
                classRoom.setId_class_room(resultSet.getInt("id_classroom"));
                classRoom.setName(resultSet.getString("name"));
                classRoom.setSpecialty(new specialityDaoImp().getSpeciality(resultSet.getInt("id_speciality")));
                classRoom.setDay_end_hour(resultSet.getString("day_end_hour"));
                classRoom.setDay_start_hour(resultSet.getString("day_start_hour"));
            }
            return classRoom;
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Unable to get Classroom");
        }
        return new ClassRoom();
    }

    @Override
    public ArrayList<ClassRoom> getAllClassRoom() throws DAOException {
        ArrayList<ClassRoom> classRooms = new ArrayList<ClassRoom>();
        try(
            Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_ALL_CLASS_ROOMS)
        ){
          ResultSet resultSet = statement.executeQuery();
          while (resultSet.next()){
              ClassRoom classRoom = new ClassRoom();
              classRoom.setId_class_room(resultSet.getInt("id_classroom"));
              classRoom.setName(resultSet.getString("name"));
              classRoom.setDay_start_hour(resultSet.getString("day_start_hour"));
              classRoom.setDay_end_hour(resultSet.getString("day_end_hour"));
              classRoom.setSpecialty(new specialityDaoImp().getSpeciality(resultSet.getLong("id_speciality")));
              classRooms.add(classRoom);
          }
          return classRooms;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ClassRoom saveClassRoom(ClassRoom classRoom) throws DAOException {
        try( Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SAVE_CLASS_ROOM,Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1,classRoom.getName());
            statement.setTime(2,classRoom.getDay_start_hour());
            statement.setTime(3,classRoom.getDay_end_hour());
            statement.setLong(4,classRoom.getSpecialty().getId_speciality());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();

            while (resultSet.next()){
                this.lastInsertId = resultSet.getLong(1);
            }
            classRoom.setId_class_room(this.lastInsertId);
            return classRoom;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("cannot save ClassRoom!");
        }
        return null;
    }

    @Override
    public ClassRoom updateClassRoom(ClassRoom classRoom) throws DAOException {
        try(
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_CLASS_ROOM);
        ){
            statement.setString(1,classRoom.getName());
            statement.setTime(2,classRoom.getDay_start_hour());
            statement.setTime(3,classRoom.getDay_end_hour());
            statement.setLong(4,classRoom.getSpecialty().getId_speciality());
            statement.setLong(5,classRoom.getId_class_room());
            System.out.println(statement.executeUpdate());;
            return classRoom;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteClassRoom(ClassRoom classRoom) throws DAOException {
        try(
            Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_CLASS_ROOM)
        ){
            statement.setLong(1,classRoom.getId_class_room());
            statement.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
