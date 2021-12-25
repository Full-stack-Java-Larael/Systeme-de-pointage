package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Address;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface addressDao {

    Address getAddress(long id) throws DAOException, SQLException;

    List<Address> getAllAddress() throws DAOException;

    Address saveAddress(Address address) throws DAOException;

    Address updateAddress(Address t) throws DAOException;

    boolean  deleteAddress(Address t) throws DAOException;
}
