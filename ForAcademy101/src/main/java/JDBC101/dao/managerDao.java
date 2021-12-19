package JDBC101.dao;

import JDBC101.model.Manager;

import java.util.List;
import java.util.Optional;

public interface managerDao {
    Optional<Manager> getManager(long id);

    List<Manager> getAllManager();

    void saveManager(Manager t);

    void updateManager(Manager t, String[] params);

    void deleteManager(Manager t);
}
