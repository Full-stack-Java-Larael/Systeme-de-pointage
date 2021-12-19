package JDBC101.dao;

import JDBC101.model.Admin;

import java.util.List;
import java.util.Optional;

public interface adminDao {
    Optional<Admin> getAdmin(long id);

    List<Admin> getAllAdmin();

    void saveAdmin(Admin t);

    void updateAdmin(Admin t, String[] params);

    void deleteAdmin(Admin t);
}
