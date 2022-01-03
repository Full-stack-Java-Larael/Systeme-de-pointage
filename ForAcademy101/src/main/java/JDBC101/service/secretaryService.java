package JDBC101.service;

import JDBC101.model.Secretary;

import java.util.List;

public interface secretaryService {
     void addSecretary(Secretary Secretary);
     Secretary fetchSecretaryById(long id_secretary);
     void deleteSecretaryById(Secretary secretary);
     void updateSecretaryPasswordById(String newPassword, long id_secretary);
     List<Secretary> getAllSecretarys();
}
