package JDBC101.serviceImpl;
import JDBC101.model.Address;
import JDBC101.service.*;
import JDBC101.daoImpl.*;

import java.util.List;
import java.util.Optional;

public class AddressServiceImpl implements addressService  {

    private addressDaoImp addressDao;
    @Override
    public void addAddress(Address address) {

        addressDao.saveAddress(address);
    }

    @Override
    public Optional<Address> fetchAddressById(int id_address) {
        return Optional.empty();
    }

    @Override
    public void deleteAddressById(Address id_address) {

    }

    @Override
    public void updateAddressPasswordById(String newPassword, String[] id_address) {

    }

    @Override
    public List<Address> getAllAddresss() {
        return null;
    }
}
