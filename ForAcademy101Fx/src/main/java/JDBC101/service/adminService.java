package JDBC101.service;

import JDBC101.model.Admin;

import java.util.List;
import java.util.Optional;

public interface adminService {
     void addAdmin(Admin Admin);
     Admin fetchAdminById(long id_admin);
     void deleteAdminById(Admin id_admin);


    void updateAdminPasswordById(String newPassword, long id_admin);

     List<Admin> getAllAdmins();
     boolean Login(String Email, String Password);
}
