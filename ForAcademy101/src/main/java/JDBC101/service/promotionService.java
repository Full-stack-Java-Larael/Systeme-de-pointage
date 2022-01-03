package JDBC101.service;

import JDBC101.model.Promotion;

import java.util.List;

public interface promotionService {
    void addPromotion(Promotion Promotion);
    Promotion fetchPromotionById(long id_promotion);
    void deletePromotionById(Promotion id_promotion);
    void updatePromotionPasswordById(String newPassword, long id_promotion);
    List<Promotion> getAllPromotions();
}
