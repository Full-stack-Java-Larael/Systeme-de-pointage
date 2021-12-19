package JDBC101.daoImpl;

import JDBC101.dao.secretaryDao;
import JDBC101.model.Secretary;

import java.util.List;
import java.util.Optional;

public class secretaryDaoImp implements secretaryDao {
    @Override
    public Optional<Secretary> getSecretary(long id) {
        return Optional.empty();
    }

    @Override
    public List<Secretary> getAllSecretary() {
        return null;
    }

    @Override
    public void saveSecretary(Secretary t) {

    }

    @Override
    public void updateSecretary(Secretary t, String[] params) {

    }

    @Override
    public void deleteSecretary(Secretary t) {

    }
}
