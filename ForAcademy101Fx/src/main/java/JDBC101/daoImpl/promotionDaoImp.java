package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.promotionDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Promotion;
import JDBC101.model.Promotion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class promotionDaoImp implements promotionDao {


    private static final String INSERT_PROMOTION_SQL = "INSERT INTO promotion (name, year, start_date,end_date ) VALUES (?, ?,?,?);";
    private static final String SELECT_PROMOTION_BY_ID = "select * from promotion where id_promotion =?";
    private static final String SELECT_ALL_PROMOTIONS = "select * from promotion";
    private static final String DELETE_PROMOTION_SQL = "delete from promotion where id_promotion = ?;";
    private static final String UPDATE_PROMOTION_SQL = "update promotion set name = ?,year= ?, start_date =? , end_date = ? where id_promotion = ?;";


    @Override
    public Promotion getPromotion(long id) throws DAOException  {
        Promotion promotion = null;

        try (Connection connection = ConnectionFactory.getInstance().getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROMOTION_BY_ID);) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                String name = rs.getString("name");
                int year = rs.getInt("year");
                Date start_date = rs.getDate("start_date");
                Date end_date = rs.getDate("end_date");
                promotion = new Promotion( name, year, start_date,end_date);


            }

        } catch (DAOException | SQLException e) {
            // printSQLException(e);
        }
        return promotion;



    }

    @Override
    public ArrayList<Promotion> getAllPromotion() throws DAOException  {
        try (
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROMOTIONS)
        ) {
            ArrayList <Promotion> promotionList = new ArrayList<Promotion>();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Promotion promotion = new Promotion();
                promotion.setId_promotion(rs.getInt("id_promotion"));
                promotion.setName(rs.getString("name"));
                promotion.setYear(rs.getInt("year"));
                promotion.setStart_date(rs.getDate("start_date"));
                promotion.setEnd_date(rs.getDate("end_date"));
                promotionList.add(promotion);
            }
            return promotionList;
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return null;
    }

    @Override
    public Promotion savePromotion(Promotion promotion) throws DAOException {

        try (
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT_PROMOTION_SQL,Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1,promotion.getName());
            statement.setInt(2,promotion.getYear() );
            statement.setDate(3,promotion.getStart_date() );
            statement.setDate(4,promotion.getEnd_date());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()){
                promotion.setId_promotion(resultSet.getLong(1));
            }
            return promotion;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public Promotion updatePromotion(Promotion promotion) throws DAOException {
        try (
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_PROMOTION_SQL)
        ) {
            statement.setString(1, promotion.getName());
            statement.setInt(2, promotion.getYear());
            statement.setDate(3, promotion.getStart_date());
            statement.setDate(4, promotion.getEnd_date());
            statement.setLong(5, promotion.getId_promotion());
            if (statement.executeUpdate() != 0){
                return promotion;
            }
            System.out.println("Promotion not found");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deletePromotion(Promotion t) throws DAOException {

        boolean rowDeleted = false;
        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PROMOTION_SQL);) {
            statement.setLong(1, t.getId_promotion());
            if(statement.executeUpdate() > 0){
                rowDeleted = true;
            };
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return rowDeleted;

    }
}
