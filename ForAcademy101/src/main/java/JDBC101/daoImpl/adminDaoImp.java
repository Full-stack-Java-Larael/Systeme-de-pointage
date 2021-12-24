package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.adminDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class adminDaoImp implements adminDao{
    private final String SAVE_ADMIN = "INSERT INTO admin (email,first_name,last_name,id_address,id_role,phone,gender,password,status) VALUES (?,?,?,?,?,?,?,?,?)";
    private final String GET_ADMIN = "select * from admin where id_user = ?";
    private final String GET_ADMINS = "SELECT * FROM admin";
    @Override
    public Optional<Admin> getAdmin(long id_user) throws DAOException {
        try (
                Connection connection =   ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(GET_ADMIN);
            ){
            statement.setLong(1,id_user);
            ResultSet resultSet = statement.executeQuery();

            Admin Admin = new Admin();
            Optional<Admin> opt = Optional.ofNullable(Admin);
            while(resultSet.next()){
                Admin.setId_user(resultSet.getLong("id_Admin"));
                Admin.setFirst_name(resultSet.getString("first_name"));
                Admin.setLast_name(resultSet.getString("last_name"));
                Admin.setEmail(resultSet.getString("email"));
            }
            return opt;
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

    public void saveAdmin(Admin admin) throws DAOException {

        try (
                Connection connection =   ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(SAVE_ADMIN);
             ){
            statement.setString(1, admin.getEmail());
            statement.setString(2, admin.getFirst_name());
            statement.setString(3, admin.getLast_name());
            statement.setLong(4, admin.getAddress().getId_address());
            statement.setLong(5,admin.getRole().getId_role());
            statement.setString(6,admin.getPhone());
            statement.setString(7,admin.getGender());
            statement.setString(8,admin.getPassword());
            statement.setBoolean(9,admin.isStatus()); // is active
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("unable to save the admin");
        }
    }


    @Override
    public void updateAdmin(Admin Admin) throws DAOException{
        try {
            Connection connection =   ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement
                    ("UPDATE Admins  first_name = ?, last_name = ?,address_id = ?,phone = ?,email = ?,password = ?,role = ) WHERE id_Admin = ?");
            statement.setString(1, Admin.getFirst_name());
            statement.setString(2, Admin.getLast_name());
            statement.setLong(3, Admin.getAddress().getId_address());
            statement.setString(4, Admin.getPhone());
            statement.setString(5, Admin.getEmail());
            statement.setString(6, Admin.getPassword());
            statement.setLong(7, Admin.getId_user());
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Unable to update Admin!");
        }
    }

    @Override
    public void deleteAdmin(Admin Admin) throws DAOException{
        try {
            Connection connection =   ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement
                    ("DELETE FROM Admins WHERE id_Admin = ?");
            statement.setLong(1, Admin.getId_user());
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Unable to delete Admin!");
        }
    }
}
