package JDBC101.daoImpl;

import JDBC101.model.Address;
import JDBC101.model.Speciality;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class specialityDaoImpTest {

    @Test
    void getSpeciality() {
        specialityDaoImp specialityDaoImp = new specialityDaoImp();
        Speciality speciality = new Speciality();
        speciality.setId_speciality(6);
        assertInstanceOf(Speciality.class,specialityDaoImp.getSpeciality(speciality));
    }

    @Test
    void getAllSpeciality() {
        specialityDaoImp specialityDaoImp = new specialityDaoImp();
        ArrayList<Speciality> specialities = new ArrayList<Speciality>();
        assertInstanceOf(specialities.getClass(),specialityDaoImp.getAllSpeciality());
    }

    @Test
    void saveSpeciality() {
        specialityDaoImp specialityDaoImp = new specialityDaoImp();
        Speciality speciality = new Speciality();
        speciality.setName("JAVA");
        assertInstanceOf(Speciality.class,specialityDaoImp.saveSpeciality(speciality));
    }

    @Test
    void updateSpeciality() {
        specialityDaoImp specialityDaoImp = new specialityDaoImp();
        Speciality speciality = new Speciality();
        speciality.setId_speciality(4);
        speciality.setName("JAVASCRIPT");
        assertNotNull(specialityDaoImp.updateSpeciality(speciality));
    }

    @Test
    void deleteSpeciality() {
        specialityDaoImp specialityDaoImp = new specialityDaoImp();
        Speciality speciality = new Speciality();
        speciality.setId_speciality(4);
        assertTrue(specialityDaoImp.deleteSpeciality(speciality));
    }
}