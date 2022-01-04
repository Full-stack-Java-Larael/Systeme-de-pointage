package JDBC101.serviceImpl;

import JDBC101.daoImpl.promotionDaoImp;
import JDBC101.model.Promotion;
import JDBC101.service.promotionService;

import java.util.List;
import java.util.Optional;

public class PromotionServiceImpl implements promotionService {
    private promotionDaoImp promotionDao = new promotionDaoImp();
    @Override
    public void addPromotion(Promotion Promotion) {
promotionDao.savePromotion(Promotion);
    }

    @Override
    public Promotion fetchPromotionById(long id_promotion) {
        return promotionDao.getPromotion(id_promotion);
    }

    @Override
    public void deletePromotionById(Promotion id_promotion) {
promotionDao.deletePromotion(id_promotion);
    }



    @Override
    public List<Promotion> getAllPromotions() {
        return promotionDao.getAllPromotion();
    }
}
