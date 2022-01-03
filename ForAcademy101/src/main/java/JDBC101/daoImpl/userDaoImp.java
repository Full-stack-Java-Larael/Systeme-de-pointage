package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.userDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userDaoImp implements userDao{


    public userDaoImp() {
    }

    @Override
    public User getUser(long id_user) throws DAOException {
        try( Connection connection =   ConnectionFactory.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement
                     ("select * from users where id_user = ?;");) {

            statement.setLong(1,id_user);
            ResultSet resultSet = statement.executeQuery();

            User user = new User();

            while(resultSet.next()){
                user.setId_user(resultSet.getLong("id_user"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setLast_name(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> getAllUser() throws DAOException {
        try(Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");) {

            ResultSet resultSet = statement.executeQuery();
            List<User> usersList = new ArrayList<User>();
            while(resultSet.next()){
                User user = new User();
                user.setId_user(resultSet.getLong("id_user"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setLast_name(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                usersList.add(user);
            }
            return  usersList;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void saveUser(User user) throws DAOException {

        try(    Connection connection =   ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement
                        ("INSERT INTO users (email,first_name,last_name,address_id,role,phone,gender,password,status) VALUES (?,?,?,?,?,?,?,?,?)");) {
            //   Connection connection = DriverManager.getConnection(url, username, password);

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getFirst_name());
            statement.setString(3, user.getLast_name());
            statement.setLong(4, user.getAddress().getId_address());
            statement.setLong(5,user.getRole().getId_role());
            statement.setString(6,user.getPhone());
            statement.setString(7,user.getGender());
            statement.setString(8,user.getPassword());
            statement.setBoolean(9,user.getStatus()); // is active
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("unable to save the product");
        }
        }


    @Override
    public void updateUser(User user) throws DAOException{
        try(  Connection connection =   ConnectionFactory.getInstance().getConnection();
              PreparedStatement statement = connection.prepareStatement
                      ("UPDATE users  first_name = ?, last_name = ?,address_id = ?,phone = ?,email = ?,password = ?,role = ) WHERE id_user = ?");) {

            statement.setString(1, user.getFirst_name());
            statement.setString(2, user.getLast_name());
            statement.setLong(3, user.getAddress().getId_address());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getPassword());
            statement.setLong(7, user.getId_user());
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Unable to update user!");
        }
    }

    @Override
    public void deleteUser(User user) throws DAOException{
        try(   Connection connection =   ConnectionFactory.getInstance().getConnection();
               PreparedStatement statement = connection.prepareStatement
                       ("DELETE FROM users WHERE id_user = ?");) {

            statement.setLong(1, user.getId_user());
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Unable to delete user!");
        }
    }
}

