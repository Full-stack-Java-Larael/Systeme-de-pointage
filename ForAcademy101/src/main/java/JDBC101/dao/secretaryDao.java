package JDBC101.dao;

import JDBC101.model.Secretary;

import java.util.List;
import java.util.Optional;

public interface secretaryDao {
    Optional<Secretary> getSecretary(long id);

    List<Secretary> getAllSecretary();

    void saveSecretary(Secretary t);

    void updateSecretary(Secretary t, String[] params);

    void deleteSecretary(Secretary t);
}
