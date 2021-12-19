package JDBC101.service;

import JDBC101.model.Manager;

import java.util.List;
import java.util.Optional;

public interface managerService {
    public void addManager(Manager Manager);
    public Optional<Manager> fetchManagerById(int id_manager);
    public void deleteManagerById(Manager id_manager);
    public void updateManagerPasswordById(String newPassword, String[] id_manager);
    public List<Manager> getAllManagers();
}
