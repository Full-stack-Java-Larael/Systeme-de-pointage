package JDBC101.daoImpl;

import JDBC101.model.Address;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class addressDaoImpTest {

    @Test
    void getAddress() {
        addressDaoImp addressDaoImp = new addressDaoImp();
        assertInstanceOf(Address.class,addressDaoImp.getAddress((long)1));
    }

    @Test
    void getAllAddress() {
        addressDaoImp addressDaoImp = new addressDaoImp();
        ArrayList<Address> addresses = new ArrayList<Address>();
        assertInstanceOf(addresses.getClass(),addressDaoImp.getAllAddress());
    }

    @Test
    void saveAddress() {
        // address
        Address address = new Address();
        address.setId_address(1);
        address.setCity("city");
        address.setPostal_code(56784);
        address.setStreet("street");
        addressDaoImp addressDaoImp = new addressDaoImp();
        assertInstanceOf(Address.class,addressDaoImp.saveAddress(address));
    }

    @Test
    void updateAddress() {
        addressDaoImp addressDaoImp = new addressDaoImp();
        Address address = new Address();
        address.setId_address(4);
        address.setCity("new city");
        address.setStreet("new Street");
        address.setPostal_code(3434656);
        assertNotNull(addressDaoImp.updateAddress(address));
    }

    @Test
    void deleteAddress() {
        addressDaoImp addressDaoImp = new addressDaoImp();
        Address address = new Address();
        address.setId_address(6);
        assertTrue(addressDaoImp.deleteAddress(address));
    }
}