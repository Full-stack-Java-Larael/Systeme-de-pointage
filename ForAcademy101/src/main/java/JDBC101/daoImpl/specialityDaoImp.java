package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.specialityDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Speciality;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class specialityDaoImp implements specialityDao {

    private static final String INSERT_Speciality_SQL = "INSERT INTO Speciality (name) VALUES (?);";

    private static final String SELECT_Speciality_BY_ID = "select * from Speciality where id_speciality =?";
    private static final String SELECT_ALL_Speciality = "select * from Speciality";
    private static final String DELETE_Speciality_SQL = "delete from Speciality where id_speciality = ?;";
    private static final String UPDATE_Speciality_SQL = "update Speciality set name = ? where id_speciality = ?;";


    @Override
    public Speciality getSpeciality(long id) throws DAOException  {
        Speciality speciality = null;

        try (Connection connection = ConnectionFactory.getInstance().getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Speciality_BY_ID);) {
            preparedStatement.setLong(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int id_Speciality = rs.getInt("id_speciality");
                String name = rs.getString("name");

                speciality = new Speciality(id_Speciality, name);

            }

        } catch (DAOException | SQLException e) {
            // printSQLException(e);
        }

        return speciality;
    }

    @Override
    public List<Speciality> getAllSpeciality() throws DAOException  {


        List < Speciality > Specialities = new ArrayList<Speciality  >();

        try (Connection connection = ConnectionFactory.getInstance().getConnection();


             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Speciality);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int id = rs.getInt("id_speciality");
                String name = rs.getString("name");

                Specialities.add( new Speciality( id, name));
            }
        } catch (SQLException e) {
            //   printSQLException(e);
        }
        return Specialities;

    }

    @Override
    public void saveSpeciality(Speciality t) throws DAOException {

        try (Connection connection = ConnectionFactory.getInstance().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Speciality_SQL)) {

            preparedStatement.setString(1,t.getName() );


            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }



    @Override
    public void updateSpeciality(Speciality t, String[] params) throws DAOException {
        try (Connection connection = ConnectionFactory.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_Speciality_SQL);) {
            statement.setInt(1, t.getId_speciality());
            statement.setString(2, t.getName());


            statement.executeUpdate() ;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public boolean deleteSpeciality(Speciality t) throws DAOException {

        boolean rowDeleted = false;
        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_Speciality_SQL);) {
            statement.setLong(1, t.getId_speciality());
            if(statement.executeUpdate() > 0){
                rowDeleted = true;
            };
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return rowDeleted;

    }
}
