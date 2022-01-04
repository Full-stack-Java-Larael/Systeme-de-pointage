package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.addressDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Address;

import java.sql.*;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.model.User;

public class addressDaoImp implements addressDao {



    private static final String INSERT_ADDRESS_SQL = "INSERT INTO address (postal_code, city, street) VALUES (?, ?, ?)";


    private static final String SELECT_ADDRESS_BY_ID = "select * from address where id_address =?";
    private static final String SELECT_ALL_ADDRESS = "select * from address";
    private static final String DELETE_ADDRESS_SQL = "delete from address where id_address = ?;";
    private static final String UPDATE_ADDRESS_SQL = "update address set postal_code = ?,city= ?, street =? where id_address = ?;";

    @Override
    public Address getAddress(long id) throws DAOException  {
        try (
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADDRESS_BY_ID);
         ) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Address address = new Address();
                address.setId_address(resultSet.getInt("id_address"));
                address.setStreet(resultSet.getString("street"));
                address.setCity(resultSet.getString("city"));
                address.setPostal_code(resultSet.getInt("postal_code"));
                return address;
            }
        } catch (DAOException | SQLException e) {
           // printSQLException(e);
        }
        return null;



    }

    @Override
    public ArrayList<Address> getAllAddress() throws DAOException  {
        ArrayList <Address> addressList = new ArrayList<Address>();
        try (
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADDRESS);
            ) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Address address = new Address();
                    address.setId_address(resultSet.getInt("id_address"));
                    address.setPostal_code(resultSet.getInt("postal_code"));
                    address.setCity(resultSet.getString("city"));
                    address.setStreet(resultSet.getString("street"));
                    addressList.add(address);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressList;
    }

    @Override
    public Address saveAddress(Address address) throws DAOException {

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_ADDRESS_SQL, Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setInt(1, address.getPostal_code());
            statement.setString(2,address.getCity() );
            statement.setString(3,address.getStreet() );
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()){
                address.setId_address(resultSet.getInt(1));
            }
            return address;
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return null;
    }



    @Override
    public Address updateAddress(Address address) throws DAOException {
        try (Connection connection = ConnectionFactory.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_ADDRESS_SQL);) {
            statement.setInt(1, address.getPostal_code());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getStreet());
            statement.setLong(4, address.getId_address());
            statement.executeUpdate();
            return address;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteAddress(Address address) throws DAOException {

        boolean rowDeleted = false;
        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ADDRESS_SQL);) {
            statement.setLong(1, address.getId_address());
            if(statement.executeUpdate() > 0){
                rowDeleted = true;
            };
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return rowDeleted;

    }
}
