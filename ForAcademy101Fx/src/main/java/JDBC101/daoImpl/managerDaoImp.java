package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.managerDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Manager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class managerDaoImp implements managerDao {
    private final String GET_ALL_MANAGERS = "SELECT * FROM manager";
    private final String SAVE_MANAGER = "INSERT INTO manager (first_name,last_name,id_address,id_role,phone,email,gender,status,password,enrty_date) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE_MANAGER = "UPDATE manager SET first_name=?, last_name=?, id_address=?, id_role=?, phone=?, email=?, gender=?, status=?, password=?, enrty_date=? WHERE id_user=?";
    private final String DELETE_MANAGER = "DELETE FROM manager WHERE id_user=?";
    private final String GET_MANAGER_BY_ID = "SELECT * FROM manager WHERE id_user = ? LIMIT 1";
    @Override
    public Manager getManager(long id) throws DAOException {
        try (
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(GET_MANAGER_BY_ID);
        ){
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            Manager manager = new Manager();
            while (resultSet.next()){
                manager.setId_user(resultSet.getLong("id_user"));
                manager.setFirst_name(resultSet.getString("first_name"));
                manager.setLast_name(resultSet.getString("last_name"));
                manager.setEmail(resultSet.getString("email"));
                manager.setAddress(new addressDaoImp().getAddress(resultSet.getLong("id_address")));
                manager.setGender(resultSet.getString("gender"));
                manager.setPhone(resultSet.getString("phone"));
                manager.setEntry_date(resultSet.getDate("enrty_date"));
                manager.setPassword(resultSet.getString("password"));
                manager.setStatus(resultSet.getBoolean("status"));
                manager.setRole(new roleDaoImp().getRole(resultSet.getLong("id_role")));
            }
            return manager;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Manager> getAllManager() throws DAOException {
        ArrayList<Manager> managers = new ArrayList<Manager>();
        try(
            Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_ALL_MANAGERS)
        ){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Manager manager = new Manager();
                manager.setId_user(resultSet.getLong("id_user"));
                manager.setFirst_name(resultSet.getString("first_name"));
                manager.setLast_name(resultSet.getString("last_name"));
                manager.setEmail(resultSet.getString("email"));
                manager.setAddress(new addressDaoImp().getAddress(resultSet.getLong("id_address")));
                manager.setGender(resultSet.getString("gender"));
                manager.setPhone(resultSet.getString("phone"));
                manager.setEntry_date(resultSet.getDate("enrty_date"));
                manager.setPassword(resultSet.getString("password"));
                manager.setStatus(resultSet.getBoolean("status"));
                manager.setRole(new roleDaoImp().getRole(resultSet.getLong("id_role")));
                managers.add(manager);
            }
            return managers;
        }catch (
                SQLException e
        ){
            e.printStackTrace();
            System.out.println("Cannot get Managers!");
        }
        return null;
    }

    @Override
    public Manager saveManager(Manager manager) throws DAOException {
        try(
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(SAVE_MANAGER,Statement.RETURN_GENERATED_KEYS)
        ){
            statement.setString(1,manager.getFirst_name());
            statement.setString(2,manager.getLast_name());
            statement.setLong(3,manager.getAddress().getId_address());
            statement.setLong(4,manager.getRole().getId_role());
            statement.setString(5,manager.getPhone());
            statement.setString(6,manager.getEmail());
            statement.setString(7,manager.getGender());
            statement.setBoolean(8,manager.getStatus());
            statement.setString(9,manager.getPassword());
            statement.setDate(10,manager.getEntry_date());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();

            while (resultSet.next()){
                manager.setId_user(resultSet.getLong(1));
            }
            return manager;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Manager updateManager(Manager manager) throws DAOException {
        try(
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_MANAGER)
        ){
            statement.setString(1,manager.getFirst_name());
            statement.setString(2,manager.getLast_name());
            statement.setLong(3,manager.getAddress().getId_address());
            statement.setLong(4,manager.getRole().getId_role());
            statement.setString(5,manager.getPhone());
            statement.setString(6,manager.getEmail());
            statement.setString(7,manager.getGender());
            statement.setBoolean(8,manager.getStatus());
            statement.setString(9,manager.getPassword());
            statement.setDate(10,manager.getEntry_date());
            statement.setLong(11,manager.getId_user());
            if (statement.executeUpdate() != 0){
                return manager;
            }
            System.out.println("Manager not found");
            return null;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteManager(Manager manager) throws DAOException {
        try(
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_MANAGER)
        ){
            statement.setLong(1,manager.getId_user());
            return (statement.executeUpdate() == 1)? true : false;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
