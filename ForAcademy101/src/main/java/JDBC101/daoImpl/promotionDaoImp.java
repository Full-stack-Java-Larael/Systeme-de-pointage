package JDBC101.daoImpl;

import JDBC101.dao.promotionDao;
import JDBC101.model.Promotion;

import java.util.List;
import java.util.Optional;

public class promotionDaoImp implements promotionDao {
    @Override
    public Optional<Promotion> getPromotion(long id) {
        return Optional.empty();
    }

    @Override
    public List<Promotion> getAllPromotion() {
        return null;
    }

    @Override
    public void savePromotion(Promotion t) {

    }

    @Override
    public void updatePromotion(Promotion t, String[] params) {

    }

    @Override
    public void deletePromotion(Promotion t) {

    }
}
