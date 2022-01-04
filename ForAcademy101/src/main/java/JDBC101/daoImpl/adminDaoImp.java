package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.adminDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Admin;
import JDBC101.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class adminDaoImp implements adminDao{
    private final String SAVE_ADMIN = "INSERT INTO admin (email,first_name,last_name,id_address,id_role,phone,gender,password,status) VALUES (?,?,?,?,?,?,?,?,?)";
    private final String GET_ADMIN = "select * from admin where id_user = ?";
    private final String GET_ADMINS = "SELECT * FROM admin";
    private final String UPDATE_ADMIN = "UPDATE admin SET first_name = ?, last_name = ?,phone = ?,email = ?,password = ?, id_address = ?, id_role = ? WHERE id_user = ?";
    private final String DELETE_ADMIN = "DELETE FROM admin WHERE id_user = ?";
    @Override
    public Admin getAdmin(long id_user) throws DAOException {
        try (
                Connection connection =   ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(GET_ADMIN);
            ){
            statement.setLong(1,id_user);
            ResultSet resultSet = statement.executeQuery();
            Admin admin = new Admin();
            while(resultSet.next()){
                admin.setId_user(resultSet.getLong("id_user"));
                admin.setFirst_name(resultSet.getString("first_name"));
                admin.setLast_name(resultSet.getString("last_name"));
                admin.setEmail(resultSet.getString("email"));
                admin.setPassword(resultSet.getString("password"));
                admin.setStatus(resultSet.getBoolean("status"));
                admin.setGender(resultSet.getString("gender"));
                admin.setPhone(resultSet.getString("phone"));
                admin.setRole(new roleDaoImp().getRole(resultSet.getLong("id_role")));
                admin.setAddress(new addressDaoImp().getAddress(resultSet.getLong("id_address")));
            }
            return admin;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Admin> getAllAdmin() throws DAOException {
        try (
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(GET_ADMINS);
            ){
            ResultSet resultSet = statement.executeQuery();
            List<Admin> AdminsList = new ArrayList<Admin>();
            while(resultSet.next()){
                Admin admin = new Admin();
                admin.setId_user(resultSet.getLong("id_user"));
                admin.setFirst_name(resultSet.getString("first_name"));
                admin.setLast_name(resultSet.getString("last_name"));
                admin.setEmail(resultSet.getString("email"));
                admin.setPassword(resultSet.getString("password"));
                admin.setStatus(resultSet.getBoolean("status"));
                admin.setGender(resultSet.getString("gender"));
                admin.setPhone(resultSet.getString("phone"));
                admin.setRole(new roleDaoImp().getRole(resultSet.getLong("id_role")));
                admin.setAddress(new addressDaoImp().getAddress(resultSet.getLong("id_address")));
                AdminsList.add(admin);
            }
            return  AdminsList;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public Admin saveAdmin(Admin admin) throws DAOException {

        try (
                Connection connection =   ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(SAVE_ADMIN, Statement.RETURN_GENERATED_KEYS);
             ){
            statement.setString(1, admin.getEmail());
            statement.setString(2, admin.getFirst_name());
            statement.setString(3, admin.getLast_name());
            statement.setLong(4, admin.getAddress().getId_address());
            statement.setLong(5,admin.getRole().getId_role());
            statement.setString(6,admin.getPhone());
            statement.setString(7,admin.getGender());
            statement.setString(8,admin.getPassword());
            statement.setBoolean(9,admin.getStatus()); // is active
            statement.execute();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()){
                admin.setId_user(resultSet.getLong(1));
            }
            return admin;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Admin updateAdmin(Admin admin) throws DAOException{
        try (
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_ADMIN)
            ){
            statement.setString(1, admin.getFirst_name());
            statement.setString(2, admin.getLast_name());
            statement.setString(3, admin.getPhone());
            statement.setString(4, admin.getEmail());
            statement.setString(5, admin.getPassword());
            statement.setLong(6, admin.getAddress().getId_address());
            statement.setLong(7,admin.getRole().getId_role());
            statement.setLong(8, admin.getId_user());
            statement.execute();
            return admin;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Unable to update Admin!");
        }
        return null;
    }

    @Override
    public boolean deleteAdmin(Admin admin) throws DAOException{
        try (
            Connection connection =   ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_ADMIN);
        ){
            statement.setLong(1, admin.getId_user());
            statement.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Unable to delete Admin!");
        }
        return false;
    }


}
