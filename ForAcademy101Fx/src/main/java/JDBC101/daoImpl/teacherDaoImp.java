package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.teacherDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class teacherDaoImp implements teacherDao {
    private final String GET_All_TEACHERS = "SELECT * FROM teacher";
    private final String GET_TEACHER = "SELECT * FROM teacher WHERE id_user = ?";
    private final String SAVE_TEACHER = "INSERT INTO teacher (email,first_name,last_name,gender,phone,password,status,id_speciality,id_address,id_role) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE_TEACHER = "UPDATE teacher SET email = ?, first_name = ?, last_name = ?, address_id = ?, role = ?, phone = ?,gender = ?,password = ?,status = ? WHERE id_user = ?";
    private final String DELETE_TEACHER = "DELETE FROM teachers WHERE id_user = ?";
    @Override
    public Teacher getTeacher(long id) throws DAOException {
        try (
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(GET_TEACHER)
        ){

            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            // new teacher model
            Teacher teacher = new Teacher();
            while (resultSet.next()){
                // set teacher data
                teacher.setId_user(resultSet.getLong("id_user"));
                teacher.setFirst_name(resultSet.getString("first_name"));
                teacher.setLast_name(resultSet.getString("last_name"));
                teacher.setAddress(new addressDaoImp().getAddress(resultSet.getLong("id_user"))); // fill address model usin teacher id
                teacher.setRole(new roleDaoImp().getRole(resultSet.getLong("id_user"))); // fill role model using teacher id
                teacher.setPhone(resultSet.getString("phone"));
                teacher.setEmail(resultSet.getString("email"));
                teacher.setGender(resultSet.getString("gender"));
                teacher.setPassword(resultSet.getString("password"));
                teacher.setStatus(resultSet.getBoolean("status"));
            }
            return teacher;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("unable to get All teachers!");
        }
        return null;
    }

    @Override
    public ArrayList<Teacher> getAllTeacher() throws DAOException {
        try(
            Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_All_TEACHERS)
        ) {

            ResultSet resultSet = statement.executeQuery();
            ArrayList<Teacher> teachersList = new ArrayList<Teacher>();
            while (resultSet.next()){
                Teacher teacher = new Teacher();
                teacher.setId_user(resultSet.getLong("id_user"));
                teacher.setFirst_name(resultSet.getString("first_name"));
                teacher.setLast_name(resultSet.getString("last_name"));
                teacher.setAddress(new addressDaoImp().getAddress(resultSet.getLong("id_user")));
                teacher.setRole(new roleDaoImp().getRole(resultSet.getLong("id_user")));
                teacher.setPhone(resultSet.getString("phone"));
                teacher.setEmail(resultSet.getString("email"));
                teacher.setGender(resultSet.getString("gender"));
                teacher.setPassword(resultSet.getString("password"));
                teacher.setStatus(resultSet.getBoolean("status"));
                teachersList.add(teacher);
            }
            return  teachersList;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("unable to get All teachers!");
        }
        return null;
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) throws DAOException {
        try (Connection connection =   ConnectionFactory.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SAVE_TEACHER, Statement.RETURN_GENERATED_KEYS);
        ){
            statement.setString(1, teacher.getEmail());
            statement.setString(2, teacher.getFirst_name());
            statement.setString(3, teacher.getLast_name());
            statement.setString(4,teacher.getGender());
            statement.setString(5,teacher.getPhone());
            statement.setString(6,teacher.getPassword());
            statement.setBoolean(7,teacher.getStatus()); // is active
            statement.setLong(8,teacher.getSpeciality().getId_speciality());
            statement.setLong(9,teacher.getAddress().getId_address());
            statement.setLong(10,teacher.getRole().getId_role());
            statement.execute();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()){
                teacher.setId_user(resultSet.getLong(1));
            }
            new addressDaoImp().saveAddress(teacher.getAddress());
            new roleDaoImp().saveRole(teacher.getRole());
            return teacher;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("unable to save the Teacher");
        }
        return null;
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) throws DAOException {
        try(
                Connection connection =   ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_TEACHER)
        ) {
            statement.setString(1, teacher.getEmail());
            statement.setString(2, teacher.getFirst_name());
            statement.setString(3, teacher.getLast_name());
            statement.setLong(4, teacher.getAddress().getId_address());
            statement.setLong(5,teacher.getRole().getId_role());
            statement.setString(6,teacher.getPhone());
            statement.setString(7,teacher.getGender());
            statement.setString(8,teacher.getPassword());
            statement.setBoolean(9,teacher.getStatus()); // is active
            statement.setLong(10, teacher.getId_user());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("unable to save the Teacher");
        }
        return null;
    }

    @Override
    public boolean deleteTeacher(long id) throws DAOException {
        try(
            Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_TEACHER)
        ) {
            statement.setLong(1,id);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("unable to Delete Teacher!");
        }
        return false;
    }
}
