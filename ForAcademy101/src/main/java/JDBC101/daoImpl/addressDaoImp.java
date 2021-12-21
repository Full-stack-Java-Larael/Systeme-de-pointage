package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.addressDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import JDBC101.JDBCfactory.ConnectionFactory;

public class addressDaoImp implements addressDao {


    private static final String INSERT_ADDRESS_SQL = "INSERT INTO address" + "  (postal_code, city, street) VALUES " +
            " (?, ?, ?);";

    private static final String SELECT_ADDRESS_BY_ID = "select * from address where id_user =?";
    private static final String SELECT_ALL_ADDRESS = "select * from address";
    private static final String DELETE_ADDRESS_SQL = "delete from address where id_address = ?;";
    private static final String UPDATE_ADDRESS_SQL = "update address set postal_code = ?,city= ?, street =? where id = ?;";

    @Override
    public Address getAddress(long id) throws DAOException  {
        Address address = null;

        try (Connection connection = ConnectionFactory.getInstance().getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADDRESS_BY_ID);) {
            preparedStatement.setLong(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int postal_code = rs.getInt("postal_code");
                String city = rs.getString("city");
                String street = rs.getString("street");
                address = new Address( postal_code, city, street);


            }

        } catch (DAOException | SQLException e) {
           // printSQLException(e);
        }
        return address;



    }

    @Override
    public List<Address> getAllAddress() throws DAOException  {


        List < Address > adress = new ArrayList<Address  >();

        try (Connection connection = ConnectionFactory.getInstance().getConnection();


             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADDRESS);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int id = rs.getInt("id");
                int postal_code = rs.getInt("postal_code");
                String city = rs.getString("city");
                String street = rs.getString("street");
                adress.add( new Address( postal_code, city, street));
            }
        } catch (SQLException e) {
         //   printSQLException(e);
        }
        return adress;

    }

    @Override
    public void saveAddress(Address t) throws DAOException {

        try (Connection connection = ConnectionFactory.getInstance().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADDRESS_SQL)) {
            preparedStatement.setInt(1, t.getPostal_code());
            preparedStatement.setString(2,t.getCity() );
            preparedStatement.setString(3,t.getStreet() );
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
           // printSQLException(e);
        }



    }

    @Override
    public void updateAddress(Address t, String[] params) throws DAOException {
        try (Connection connection = ConnectionFactory.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_ADDRESS_SQL);) {
            statement.setInt(1, t.getPostal_code());
            statement.setString(2, t.getCity());
            statement.setString(3, t.getStreet());
            statement.setLong(4, t.getId_address());

            statement.executeUpdate() ;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public boolean deleteAddress(Address t) throws DAOException {

        boolean rowDeleted = false;
        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ADDRESS_SQL);) {
            statement.setLong(1, t.getId_address());
            if(statement.executeUpdate() > 0){
                rowDeleted = true;
            };
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return rowDeleted;

    }
}
