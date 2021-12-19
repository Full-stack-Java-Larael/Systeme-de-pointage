package JDBC101.daoImpl;

import JDBC101.dao.addressDao;
import JDBC101.model.Address;

import java.util.List;
import java.util.Optional;

public class addressDaoImp implements addressDao {
    @Override
    public Optional<Address> getAddress(long id) {
        return Optional.empty();
    }

    @Override
    public List<Address> getAllAddress() {
        return null;
    }

    @Override
    public void saveAddress(Address t) {

    }

    @Override
    public void updateAddress(Address t, String[] params) {

    }

    @Override
    public void deleteAddress(Address t) {

    }
}
