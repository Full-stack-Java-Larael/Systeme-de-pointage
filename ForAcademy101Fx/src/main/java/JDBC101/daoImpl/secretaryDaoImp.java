package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.secretaryDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Admin;
import JDBC101.model.Secretary;
import JDBC101.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class secretaryDaoImp implements secretaryDao {
    private final String SAVE_SECRETARY = "INSERT INTO secretary (email,first_name,last_name,id_address,id_role,phone,gender,password,status) VALUES (?,?,?,?,?,?,?,?,?)";
    private final String GET_SECRETARY = "select * from secretary where id_user = ?";
    private final String GET_SECRETARYS = "SELECT * FROM secretary";
    private final String UPDATE_SECRETARY = "UPDATE secretary SET first_name = ?, last_name = ?,phone = ?,email = ?,gender=?,password = ?, id_address = ?,status=?, id_role = ? WHERE id_user = ?";
    private final String DELETE_SECRETARY = "DELETE FROM secretary WHERE id_user = ?";
    @Override
    public Secretary getSecretary(long id) throws DAOException {
        try(
            Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_SECRETARY)
        ){
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            Secretary secretary = new Secretary();
            while (resultSet.next()){
                secretary.setId_user(resultSet.getLong("id_user"));
                secretary.setEmail(resultSet.getString("email"));
                secretary.setFirst_name(resultSet.getString("first_name"));
                secretary.setLast_name(resultSet.getString("last_name"));
                secretary.setGender(resultSet.getString("gender"));
                secretary.setPhone(resultSet.getString("phone"));
                secretary.setStatus(resultSet.getBoolean("status"));
                secretary.setPassword(resultSet.getString("password"));
                secretary.setAddress(new addressDaoImp().getAddress(resultSet.getLong("id_address")));
                secretary.setRole(new roleDaoImp().getRole(resultSet.getLong("id_role")));
            }
            return secretary;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Secretary> getAllSecretary() throws DAOException {
        try(
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(GET_SECRETARYS)
        ){
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Secretary> secretaries = new ArrayList<Secretary>();
            while (resultSet.next()){
                Secretary secretary = new Secretary();
                secretary.setId_user(resultSet.getLong("id_user"));
                secretary.setEmail(resultSet.getString("email"));
                secretary.setFirst_name(resultSet.getString("first_name"));
                secretary.setLast_name(resultSet.getString("last_name"));
                secretary.setGender(resultSet.getString("gender"));
                secretary.setPhone(resultSet.getString("phone"));
                secretary.setStatus(resultSet.getBoolean("status"));
                secretary.setPassword(resultSet.getString("password"));
                secretary.setAddress(new addressDaoImp().getAddress(resultSet.getLong("id_address")));
                secretary.setRole(new roleDaoImp().getRole(resultSet.getLong("id_role")));
                secretaries.add(secretary);
            }
            return secretaries;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Secretary saveSecretary(Secretary secretary) throws DAOException {
        try (
                Connection connection =   ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(SAVE_SECRETARY, Statement.RETURN_GENERATED_KEYS);
        ){
            statement.setString(1, secretary.getEmail());
            statement.setString(2, secretary.getFirst_name());
            statement.setString(3, secretary.getLast_name());
            statement.setLong(4, secretary.getAddress().getId_address());
            statement.setLong(5,secretary.getRole().getId_role());
            statement.setString(6,secretary.getPhone());
            statement.setString(7,secretary.getGender());
            statement.setString(8,secretary.getPassword());
            statement.setBoolean(9,secretary.getStatus()); // is active
            statement.execute();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()){
                secretary.setId_user(resultSet.getLong(1));
            }
            return secretary;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Secretary updateSecretary(Secretary secretary) throws DAOException {
        try (
                Connection connection =   ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_SECRETARY);
        ){
            statement.setString(1, secretary.getFirst_name());
            statement.setString(2, secretary.getLast_name());
            statement.setString(3,secretary.getPhone());
            statement.setString(4, secretary.getEmail());
            statement.setString(5,secretary.getGender());
            statement.setString(6,secretary.getPassword());
            statement.setLong(7, secretary.getAddress().getId_address());
            statement.setBoolean(8,secretary.getStatus()); // is active
            statement.setLong(9,secretary.getRole().getId_role());
            statement.setLong(10,secretary.getId_user()); // is active
            statement.execute();
            return secretary;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteSecretary(long id) throws DAOException {
        try (
                Connection connection =   ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_SECRETARY);
        ){
            statement.setLong(1,id);
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
