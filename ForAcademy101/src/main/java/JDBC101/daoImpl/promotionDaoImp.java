package JDBC101.daoImpl;

import JDBC101.dao.promotionDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Promotion;

import java.util.List;
import java.util.Optional;

public class promotionDaoImp implements promotionDao {

    @Override
    public Optional<Promotion> getPromotion(long id) throws DAOException {
        return Optional.empty();
    }

    @Override
    public List<Promotion> getAllPromotion() throws DAOException {
        return null;
    }

    @Override
    public void savePromotion(Promotion t) throws DAOException {

    }

    @Override
    public void updatePromotion(Promotion t, String[] params) throws DAOException {

    }

    @Override
    public void deletePromotion(Promotion t) throws DAOException {

    }
}
