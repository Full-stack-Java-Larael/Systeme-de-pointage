package JDBC101.serviceImpl;

import JDBC101.model.Promotion;
import JDBC101.service.promotionService;

import java.util.List;
import java.util.Optional;

public class PromotionServiceImpl implements promotionService {
    @Override
    public void addPromotion(Promotion Promotion) {

    }

    @Override
    public Optional<Promotion> fetchPromotionById(int id_promotion) {
        return Optional.empty();
    }

    @Override
    public void deletePromotionById(Promotion id_promotion) {

    }

    @Override
    public void updatePromotionPasswordById(String newPassword, String[] id_promotion) {

    }

    @Override
    public List<Promotion> getAllPromotions() {
        return null;
    }
}
