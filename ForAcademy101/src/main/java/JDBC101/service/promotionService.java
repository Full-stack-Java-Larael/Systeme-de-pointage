package JDBC101.service;

import JDBC101.model.Promotion;

import java.util.List;
import java.util.Optional;

public interface promotionService {
    public void addPromotion(Promotion Promotion);
    public Optional<Promotion> fetchPromotionById(int id_promotion);
    public void deletePromotionById(Promotion id_promotion);
    public void updatePromotionPasswordById(String newPassword, String[] id_promotion);
    public List<Promotion> getAllPromotions();
}
