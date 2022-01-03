package JDBC101.serviceImpl;

import JDBC101.daoImpl.secretaryDaoImp;
import JDBC101.model.Secretary;
import JDBC101.service.secretaryService;

import java.util.List;
import java.util.Optional;

public class SecretaryServiceImpl implements secretaryService {
    private secretaryDaoImp secretaryDao = new secretaryDaoImp();
    @Override
    public void addSecretary(Secretary Secretary) {
        secretaryDao.saveSecretary(Secretary);
    }

    @Override
    public Secretary fetchSecretaryById(long id_secretary) {
        return secretaryDao.getSecretary(id_secretary);
    }

    @Override
    public void deleteSecretaryById(Secretary secretary) {
        secretaryDao.deleteSecretary(secretary.getId_user());
    }



    @Override
    public List<Secretary> getAllSecretarys() {
        return secretaryDao.getAllSecretary();
    }
}
