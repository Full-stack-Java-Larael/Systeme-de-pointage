package JDBC101.daoImpl;

import JDBC101.dao.addressDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Address;

import java.util.List;
import java.util.Optional;

public class addressDaoImp implements addressDao {

    @Override
    public Optional<Address> getAddress(long id) throws DAOException {
        return Optional.empty();
    }

    @Override
    public List<Address> getAllAddress() throws DAOException {
        return null;
    }

    @Override
    public void saveAddress(Address t) throws DAOException {

    }

    @Override
    public void updateAddress(Address t, String[] params) throws DAOException {

    }

    @Override
    public void deleteAddress(Address t) throws DAOException {

    }
}
