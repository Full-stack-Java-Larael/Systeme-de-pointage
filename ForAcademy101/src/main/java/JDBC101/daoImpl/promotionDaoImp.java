package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.promotionDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Promotion;
import JDBC101.model.Promotion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class promotionDaoImp implements promotionDao {


    private static final String INSERT_PROMOTION_SQL = "INSERT INTO promotion (name, year, start_date,end_date ) VALUES (?, ?,?,?);";
    private static final String SELECT_PROMOTION_BY_ID = "select * from promotion where id_promotion =?";
    private static final String SELECT_ALL_PROMOTIONS = "select * from promotion";
    private static final String DELETE_PROMOTION_SQL = "delete from promotion where id_promotion = ?;";
    private static final String UPDATE_PROMOTION_SQL = "update promotion set name = ?,year= ?, start_date =? , end_date = ? where id = ?;";


    @Override
    public Promotion getPromotion(long id) throws DAOException  {
        Promotion promotion = null;

        try (Connection connection = ConnectionFactory.getInstance().getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROMOTION_BY_ID);) {
            preparedStatement.setLong(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                String name = rs.getString("name");
                int year = rs.getInt("year");
                String start_date = rs.getString("start_date");
                String end_date = rs.getString("end_date");
                promotion = new Promotion( name, year, start_date,end_date);


            }

        } catch (DAOException | SQLException e) {
            // printSQLException(e);
        }
        return promotion;



    }

    @Override
    public List<Promotion> getAllPromotion() throws DAOException  {


        List <Promotion> promotionList = new ArrayList<Promotion>();

        try (Connection connection = ConnectionFactory.getInstance().getConnection();


             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROMOTIONS);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {

                Promotion promotion = new Promotion();

                promotion.setId_promotion(rs.getInt("id_promotion"));
                promotion.setName(rs.getString("name"));
                promotion.setYear(rs.getInt("year"));
                promotion.setStart_date(rs.getString("start_date"));
                promotion.setEnd_date(rs.getString("end_date"));

                promotionList.add(promotion);
            }
        } catch (SQLException e) {
            //   printSQLException(e);
        }
        return promotionList;

    }

    @Override
    public void savePromotion(Promotion t) throws DAOException {

        try (Connection connection = ConnectionFactory.getInstance().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROMOTION_SQL)) {
            preparedStatement.setString(1, t.getName());
            preparedStatement.setInt(2,t.getYear() );
            preparedStatement.setString(3,t.getStart_date() );
            preparedStatement.setString(4, t.getEnd_date());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }



    @Override
    public void updatePromotion(Promotion t) throws DAOException {
        try (Connection connection = ConnectionFactory.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_PROMOTION_SQL);) {
            statement.setString(1, t.getName());
            statement.setInt(2, t.getYear());
            statement.setString(3, t.getStart_date());
            statement.setString(4, t.getEnd_date());
            statement.setLong(5, t.getId_promotion());

            statement.executeUpdate() ;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


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
