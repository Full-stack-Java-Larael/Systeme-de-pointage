package JDBC101.daoImpl;

import JDBC101.model.Speciality;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class specialityDaoImpTest {

    @Test
    void getSpeciality() {
    }

    @Test
    void getAllSpeciality() {
    }

    @Test
    void saveSpeciality() {
        specialityDaoImp specialityDaoImp = new specialityDaoImp();
        Speciality speciality = new Speciality();
        speciality.setId_speciality(1);
        speciality.setName("JAVA");
        System.out.println(specialityDaoImp.saveSpeciality(speciality));
    }

    @Test
    void updateSpeciality() {
    }

    @Test
    void deleteSpeciality() {
    }
}