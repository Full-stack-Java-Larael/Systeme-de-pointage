package JDBC101.daoImpl;

import JDBC101.model.Promotion;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.sql.Date;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class promotionDaoImpTest {
    static long id;
    @Test
    @Order(3)
    void getPromotion() {
        promotionDaoImp promotionDaoImp = new promotionDaoImp();
        assertInstanceOf(Promotion.class,promotionDaoImp.getPromotion(id));
    }

    @Test
    @Order(2)
    void getAllPromotion() {
        promotionDaoImp promotionDaoImp = new promotionDaoImp();
        ArrayList<Promotion> promotions = new ArrayList<Promotion>();
        assertInstanceOf(promotions.getClass(),promotionDaoImp.getAllPromotion());
    }

    @Test
    @Order(1)
    void savePromotion() {
        Promotion promotion = new Promotion();
        promotion.setName("promotion name");
        promotion.setStart_date(new Date(2022,11,10));
        promotion.setEnd_date(new Date(2023,11,10));
        promotion.setYear(2022);
        promotionDaoImp promotionDaoImp = new promotionDaoImp();
        Promotion newPromotion = promotionDaoImp.savePromotion(promotion);
        assertInstanceOf(Promotion.class,newPromotion);
        id = newPromotion.getId_promotion();
    }

    @Test
    @Order(4)
    void updatePromotion() {
        Promotion promotion = new Promotion();
        promotion.setId_promotion(id);
        promotion.setName("promotion new name");
        promotion.setStart_date(new Date(2024,11,10));
        promotion.setEnd_date(new Date(2025,11,10));
        promotion.setYear(2024);
        promotionDaoImp promotionDaoImp = new promotionDaoImp();
        promotionDaoImp.updatePromotion(promotion);
    }

    @Test
    @Order(5)
    void deletePromotion() {
        promotionDaoImp promotionDaoImp = new promotionDaoImp();
        Promotion promotion = new Promotion();
        promotion.setId_promotion(id);
        assertTrue(promotionDaoImp.deletePromotion(promotion));
    }
}