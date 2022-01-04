package JDBC101.service;

import JDBC101.model.Speciality;

import java.util.List;

public interface specialityService {
     void addSpeciality(Speciality Speciality);
     Speciality fetchSpecialityById(long id_Speciality);
     void deleteSpecialityById(Speciality id_Speciality);

     List<Speciality> getAllSpecialities();
}
