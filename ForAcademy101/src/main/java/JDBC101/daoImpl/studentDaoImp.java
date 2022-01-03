package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.studentDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class studentDaoImp implements studentDao {
    private final String SAVE_STUDENT = "INSERT INTO admin (email,first_name,last_name,id_address,id_role,phone,gender,password,status) VALUES (?,?,?,?,?,?,?,?,?)";
    private final String UPDATE_STUDENT = "UPDATE admin SET email=?,first_name=?,last_name=?,id_address=?,id_role=?,phone=?,gender=?,password=?,status=? WHERE id_user = ?";
    private final String GET_STUDENT = "SELECT * FROM student WHERE id_user = ? LIMIT 1";
    private final String GET_ALL_STUDENTS = "SELECT * FROM student";
    private final String DELETE_STUDENT = "DELETE FROM student WHERE id_user = ?";
    @Override
    public Student getStudent(long id) throws DAOException {
        try(
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(GET_STUDENT)
        ){
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            Student student = new Student();
            while (resultSet.next()){
                student.setId_user(resultSet.getLong("id_user"));
                student.setEmail(resultSet.getString("email"));
                student.setFirst_name(resultSet.getString("first_name"));
                student.setLast_name(resultSet.getString("last_name"));
                student.setAddress(new addressDaoImp().getAddress(resultSet.getLong("id_address")));
                student.setRole(new roleDaoImp().getRole(resultSet.getLong("id_role")));
                student.setPhone(resultSet.getString("phone"));
                student.setGender(resultSet.getString("gender"));
                student.setPassword(resultSet.getString("password"));
                student.setStatus(resultSet.getBoolean("status"));
            }
            return student;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Student> getAllStudent() throws DAOException {
        try(
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(GET_ALL_STUDENTS)
        ){
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Student> students = new ArrayList<Student>();
            while (resultSet.next()){
                Student student = new Student();
                student.setId_user(resultSet.getLong("id_user"));
                student.setEmail(resultSet.getString("email"));
                student.setFirst_name(resultSet.getString("first_name"));
                student.setLast_name(resultSet.getString("last_name"));
                student.setAddress(new addressDaoImp().getAddress(resultSet.getLong("id_address")));
                student.setRole(new roleDaoImp().getRole(resultSet.getLong("id_role")));
                student.setPhone(resultSet.getString("phone"));
                student.setGender(resultSet.getString("gender"));
                student.setPassword(resultSet.getString("password"));
                student.setStatus(resultSet.getBoolean("status"));
                students.add(student);
            }
            return students;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student saveStudent(Student student) throws DAOException {
        try (
                Connection connection =   ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(SAVE_STUDENT, Statement.RETURN_GENERATED_KEYS);
        ){
            statement.setString(1, student.getEmail());
            statement.setString(2, student.getFirst_name());
            statement.setString(3, student.getLast_name());
            statement.setLong(4, student.getAddress().getId_address());
            statement.setLong(5,student.getRole().getId_role());
            statement.setString(6,student.getPhone());
            statement.setString(7,student.getGender());
            statement.setString(8,student.getPassword());
            statement.setBoolean(9,student.getStatus()); // is active
            statement.execute();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()){
                student.setId_user(resultSet.getLong(1));
            }
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student updateStudent(Student student) throws DAOException {
        try (
                Connection connection =   ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT);
        ){
            statement.setString(1, student.getEmail());
            statement.setString(2, student.getFirst_name());
            statement.setString(3, student.getLast_name());
            statement.setLong(4, student.getAddress().getId_address());
            statement.setLong(5,student.getRole().getId_role());
            statement.setString(6,student.getPhone());
            statement.setString(7,student.getGender());
            statement.setString(8,student.getPassword());
            statement.setBoolean(9,student.getStatus()); // is active
            statement.setLong(10,student.getId_user());
            statement.execute();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()){
                student.setId_user(resultSet.getLong(1));
            }
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteStudent(long id) throws DAOException {
        try (
            Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT)
        ){
            statement.setLong(1,id);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
