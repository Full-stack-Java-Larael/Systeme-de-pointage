package JDBC101.serviceImpl;

import JDBC101.model.Secretary;
import JDBC101.service.secretaryService;

import java.util.List;
import java.util.Optional;

public class SecretaryServiceImpl implements secretaryService {
    @Override
    public void addSecretary(Secretary Secretary) {

    }

    @Override
    public Optional<Secretary> fetchSecretaryById(int id_secretary) {
        return Optional.empty();
    }

    @Override
    public void deleteSecretaryById(Secretary id_secretary) {

    }

    @Override
    public void updateSecretaryPasswordById(String newPassword, String[] id_secretary) {

    }

    @Override
    public List<Secretary> getAllSecretarys() {
        return null;
    }
}
