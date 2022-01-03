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
    public Secretary fetchSecretaryById(long id_secretary) {
        return Optional.empty();
    }

    @Override
    public void deleteSecretaryById(Secretary secretary) {

    }

    @Override
    public void updateSecretaryPasswordById(String newPassword, long id_secretary) {

    }

    @Override
    public List<Secretary> getAllSecretarys() {
        return null;
    }
}
