package JDBC101.service;

import JDBC101.model.Address;

import java.util.List;
import java.util.Optional;

public interface addressService {
    public void addAddress(Address Address);
    public Optional<Address> fetchAddressById(int id_address);
    public void deleteAddressById(Address id_address);
    public void updateAddressPasswordById(String newPassword, String[] id_address);
    public List<Address> getAllAddresss();
}
