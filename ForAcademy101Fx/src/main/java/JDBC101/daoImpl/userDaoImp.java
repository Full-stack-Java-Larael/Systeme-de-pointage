package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.userDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userDaoImp implements userDao{
    private final String SAVE_USER = "INSERT INTO users (email,first_name,last_name,id_address,id_role,phone,gender,password,status) VALUES (?,?,?,?,?,?,?,?,?)";
    private final String UPDATE_USER = "UPDATE users SET first_name = ?, last_name = ?,id_address = ?,phone = ?,email = ?,password = ?,id_role = ? WHERE id_user = ?";
    public final String GET_USER = "select * from users where id_user = ?";

    @Override
    public User getUser(long id_user) throws DAOException {
        try(
                Connection connection =   ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(GET_USER)
        ) {
            statement.setLong(1,id_user);
            ResultSet resultSet = statement.executeQuery();
            User user = new User();
            while(resultSet.next()){
                user.setId_user(resultSet.getLong("id_user"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setLast_name(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setStatus(resultSet.getBoolean("status"));
                user.setGender(resultSet.getString("gender"));
                user.setPhone(resultSet.getString("phone"));
                user.setRole(new roleDaoImp().getRole(resultSet.getLong("id_role")));
                user.setAddress(new addressDaoImp().getAddress(resultSet.getLong("id_address")));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<User> getAllUser() throws DAOException {
        try(Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");) {

            ResultSet resultSet = statement.executeQuery();
            ArrayList<User> usersList = new ArrayList<User>();
            while(resultSet.next()){
                User user = new User();
                user.setId_user(resultSet.getLong("id_user"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setLast_name(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setStatus(resultSet.getBoolean("status"));
                user.setGender(resultSet.getString("gender"));
                user.setPhone(resultSet.getString("phone"));
                user.setRole(new roleDaoImp().getRole(resultSet.getLong("id_role")));
                user.setAddress(new addressDaoImp().getAddress(resultSet.getLong("id_address")));
                usersList.add(user);
            }
            return  usersList;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public User saveUser(User user) throws DAOException {

        try(
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(SAVE_USER,Statement.RETURN_GENERATED_KEYS);
        ) {
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
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()){
                user.setId_user(resultSet.getLong(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("unable to save the product");
        }
        return null;
    }


    @Override
    public User updateUser(User user) throws DAOException{
        try(
                Connection connection =   ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_USER)
        ) {
            statement.setString(1, user.getFirst_name());
            statement.setString(2, user.getLast_name());
            statement.setLong(3, user.getAddress().getId_address());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getPassword());
            statement.setLong(7,user.getRole().getId_role());
            statement.setLong(8, user.getId_user());
            statement.execute();
            return user;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Unable to update user!");
        }
        return null;
    }

    @Override
    public boolean deleteUser(long id) throws DAOException{
        try(   Connection connection =   ConnectionFactory.getInstance().getConnection();
               PreparedStatement statement = connection.prepareStatement
                       ("DELETE FROM users WHERE id_user = ?");) {

            statement.setLong(1, id);
            statement.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Unable to delete user!");
        }
        return false;
    }




}

