package JDBC101.service;

import JDBC101.model.Address;

import java.util.List;

public interface addressService {
     void addAddress(Address Address);
     Address fetchAddressById(long id_address);
     void deleteAddressById(Address id_address);
     void updateAddressPasswordById(String newPassword, long id_address);
     List<Address> getAllAddresss();
}
