package JDBC101.daoImpl;

import JDBC101.model.Address;
import JDBC101.model.Attendance;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class addressDaoImpTest {

    @Test
    void getAddress() {

    }

    @Test
    void getAllAddress() {
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
    }

    @Test
    void deleteAddress() {
    }
}