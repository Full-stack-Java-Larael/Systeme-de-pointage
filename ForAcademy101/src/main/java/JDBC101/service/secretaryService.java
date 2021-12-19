package JDBC101.service;

import JDBC101.model.Secretary;

import java.util.List;
import java.util.Optional;

public interface secretaryService {
    public void addSecretary(Secretary Secretary);
    public Optional<Secretary> fetchSecretaryById(int id_secretary);
    public void deleteSecretaryById(Secretary id_secretary);
    public void updateSecretaryPasswordById(String newPassword, String[] id_secretary);
    public List<Secretary> getAllSecretarys();
}
