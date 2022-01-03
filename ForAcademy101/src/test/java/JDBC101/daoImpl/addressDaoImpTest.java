package JDBC101.daoImpl;

import JDBC101.model.Address;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class addressDaoImpTest {
    static long id;
    @Test
    @Order(3)
    void getAddress() {
        addressDaoImp addressDaoImp = new addressDaoImp();
        assertInstanceOf(Address.class,addressDaoImp.getAddress(id));
    }

    @Test
    @Order(2)
    void getAllAddress() {
        addressDaoImp addressDaoImp = new addressDaoImp();
        ArrayList<Address> addresses = new ArrayList<Address>();
        assertInstanceOf(addresses.getClass(),addressDaoImp.getAllAddress());
    }

    @Test
    @Order(1)
    void saveAddress() {
        // address
        Address address = new Address();
        address.setCity("city");
        address.setPostal_code(56784);
        address.setStreet("street");
        addressDaoImp addressDaoImp = new addressDaoImp();
        Address newAddress = addressDaoImp.saveAddress(address);
        assertInstanceOf(Address.class,newAddress);
        id = newAddress.getId_address();
    }

    @Test
    @Order(5)
    void updateAddress() {
        addressDaoImp addressDaoImp = new addressDaoImp();
        Address address = new Address();
        address.setId_address(id);
        address.setCity("new city");
        address.setStreet("new Street");
        address.setPostal_code(3434656);
        assertNotNull(addressDaoImp.updateAddress(address));
    }

    @Test
    @Order(5)
    void deleteAddress() {
        addressDaoImp addressDaoImp = new addressDaoImp();
        Address address = new Address();
        address.setId_address(id);
        assertTrue(addressDaoImp.deleteAddress(address));
    }
}