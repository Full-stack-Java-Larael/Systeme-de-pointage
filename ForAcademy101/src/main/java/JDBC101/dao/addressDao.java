package JDBC101.dao;

import JDBC101.model.Address;

import java.util.List;
import java.util.Optional;

public interface addressDao {

    Optional<Address> getAddress(long id);

    List<Address> getAllAddress();

    void saveAddress(Address t);

    void updateAddress(Address t, String[] params);

    void deleteAddress(Address t);
}
