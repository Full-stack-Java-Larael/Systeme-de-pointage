package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Promotion;

import java.util.List;
import java.util.Optional;

public interface promotionDao {
    Promotion getPromotion(long id) throws DAOException;

    List<Promotion> getAllPromotion() throws DAOException;

    void savePromotion(Promotion t) throws DAOException;

    void updatePromotion(Promotion t) throws DAOException;

    boolean deletePromotion(Promotion t) throws DAOException;
}
