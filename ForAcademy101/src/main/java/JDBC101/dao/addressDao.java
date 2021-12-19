package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Address;

import java.util.List;
import java.util.Optional;

public interface addressDao {

    Optional<Address> getAddress(long id) throws DAOException;

    List<Address> getAllAddress() throws DAOException;

    void saveAddress(Address t) throws DAOException;

    void updateAddress(Address t, String[] params) throws DAOException;

    void deleteAddress(Address t) throws DAOException;
}
