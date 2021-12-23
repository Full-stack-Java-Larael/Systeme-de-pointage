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
    @Override
    public Optional<Manager> getManager(long id) throws DAOException {
        return Optional.empty();
    }

    @Override
    public List<Manager> getAllManager() throws DAOException {
        List<Manager> managers = new ArrayList<Manager>();
        try(
            Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_ALL_MANAGERS, Statement.RETURN_GENERATED_KEYS)
        ){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Manager manager = new Manager();
                manager.setId_user(resultSet.getLong("id_user"));
                manager.setFirst_name(resultSet.getString("first_name"));
                manager.setLast_name(resultSet.getString("last_name"));
                manager.setEmail(resultSet.getString("email"));
                manager.setAddress(new addressDaoImp().getAddress(resultSet.getLong("id_adress")));
                manager.setGender(resultSet.getString("gender"));
                manager.setPhone(resultSet.getString("phone"));
                manager.setEntry_date(resultSet.getString("enrty_date"));
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
    public void saveManager(Manager t) throws DAOException {

    }

    @Override
    public void updateManager(Manager t, String[] params) throws DAOException {

    }

    @Override
    public void deleteManager(Manager t) throws DAOException {

    }
}
