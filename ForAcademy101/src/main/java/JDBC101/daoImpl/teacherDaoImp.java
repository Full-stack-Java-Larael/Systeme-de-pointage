package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.teacherDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class teacherDaoImp implements teacherDao {



    @Override
    public Teacher getTeacher(long id) throws DAOException {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM teacher WHERE id_user = ?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            // new teacher model
            Teacher teacher = new Teacher();
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
            return teacher;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("unable to get All teachers!");
        }
        return null;
    }

    @Override
    public List<Teacher> getAllTeacher() throws DAOException {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM teacher");
            ResultSet resultSet = statement.executeQuery();
            List<Teacher> teachersList = new ArrayList<Teacher>();
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
    public void saveTeacher(Teacher teacher) throws DAOException {
        try {
            //   Connection connection = DriverManager.getConnection(url, teachername, password);
            Connection connection =   ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement
                    ("INSERT INTO teacher (email,first_name,last_name,gender,phone,password,status) VALUES (?,?,?,?,?,?,?)");
            statement.setString(1, teacher.getEmail());
            statement.setString(2, teacher.getFirst_name());
            statement.setString(3, teacher.getLast_name());
            statement.setString(4,teacher.getGender());
            statement.setString(5,teacher.getPhone());
            statement.setString(6,teacher.getPassword());
            statement.setBoolean(7,teacher.isStatus()); // is active
            statement.setLong(8,teacher.getSpeciality().getId_speciality());
            boolean resultSet = statement.execute();
            new addressDaoImp().saveAddress(teacher.getAddress());
            new roleDaoImp().saveRole(teacher.getRole());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("unable to save the Teacher");
        }
    }

    @Override
    public void updateTeacher(Teacher teacher) throws DAOException {
        try {
            Connection connection =   ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement
                    ("UPDATE teacher SET email = ?, first_name = ?, last_name = ?, address_id = ?, role = ?, phone = ?,gender = ?,password = ?,status = ? WHERE id_user = ?");
            statement.setString(1, teacher.getEmail());
            statement.setString(2, teacher.getFirst_name());
            statement.setString(3, teacher.getLast_name());
            statement.setLong(4, teacher.getAddress().getId_address());
            statement.setLong(5,teacher.getRole().getId_role());
            statement.setString(6,teacher.getPhone());
            statement.setString(7,teacher.getGender());
            statement.setString(8,teacher.getPassword());
            statement.setBoolean(9,teacher.isStatus()); // is active
            statement.setLong(10, teacher.getId_user());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("unable to save the Teacher");
        }
    }

    @Override
    public void deleteTeacher(Teacher teacher) throws DAOException {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM teachers WHERE id_user = ?");
            statement.setLong(1,teacher.getId_user());
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("unable to Delete Teacher!");
        }
    }
}
