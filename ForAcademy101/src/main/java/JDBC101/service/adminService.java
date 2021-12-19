package JDBC101.service;

import JDBC101.model.Admin;

import java.util.List;
import java.util.Optional;

public interface adminService {
    public void addAdmin(Admin Admin);
    public Optional<Admin> fetchAdminById(int id_admin);
    public void deleteAdminById(Admin id_admin);
    public void updateAdminPasswordById(String newPassword, String[] id_admin);
    public List<Admin> getAllAdmins();
}
