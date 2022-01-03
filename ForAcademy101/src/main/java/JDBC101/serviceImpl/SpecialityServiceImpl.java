package JDBC101.serviceImpl;

import JDBC101.daoImpl.specialityDaoImp;
import JDBC101.model.Speciality;
import JDBC101.service.specialityService;

import java.util.List;
import java.util.Optional;

public class SpecialityServiceImpl implements specialityService {
    private specialityDaoImp specialityDao = new specialityDaoImp();
    @Override
    public void addSpeciality(Speciality Speciality) {
        specialityDao.saveSpeciality(Speciality);
    }

    @Override
    public Speciality fetchSpecialityById(long id_Speciality) {
        return null;
    }

    @Override
    public void deleteSpecialityById(Speciality id_Speciality) {
        specialityDao.deleteSpeciality(id_Speciality);

    }



    @Override
    public List<Speciality> getAllSpecialities() {
        return specialityDao.getAllSpeciality();
    }
}
