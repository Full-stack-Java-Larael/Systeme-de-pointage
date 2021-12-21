package JDBC101.service;

import JDBC101.model.Speciality;

import java.util.List;
import java.util.Optional;

public interface specialityService {
    public void addSpeciality(Speciality Speciality);
    public Optional<Speciality> fetchSpecialityById(int id_Speciality);
    public void deleteSpecialityById(Speciality id_Speciality);
    public void updateSpecialityPasswordById(String newPassword, String[] id_Speciality);
    public List<Speciality> getAllSpecialities();
}
