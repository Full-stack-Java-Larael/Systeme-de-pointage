package JDBC101.service;

import JDBC101.model.Manager;

import java.util.List;

public interface managerService {
     void addManager(Manager Manager);
    Manager fetchManagerById(long id_manager);
    void deleteManagerById(Manager manager);

     List<Manager> getAllManagers();
}
