package JDBC101.dao;

import JDBC101.model.Promotion;

import java.util.List;
import java.util.Optional;

public interface promotionDao {
    Optional<Promotion> getPromotion(long id);

    List<Promotion> getAllPromotion();

    void savePromotion(Promotion t);

    void updatePromotion(Promotion t, String[] params);

    void deletePromotion(Promotion t);
}
