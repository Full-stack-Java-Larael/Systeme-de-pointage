package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Address;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface addressDao {

    Optional<Address> getAddress(long id) throws DAOException, SQLException;

    List<Address> getAllAddress() throws DAOException;

    void saveAddress(Address t) throws DAOException;

    void updateAddress(Address t, String[] params) throws DAOException;

    boolean  deleteAddress(Address t) throws DAOException;
}
