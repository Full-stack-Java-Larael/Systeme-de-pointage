package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.specialityDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Speciality;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class specialityDaoImp implements specialityDao {

    private static final String INSERT_Speciality_SQL = "INSERT INTO Speciality (name) VALUES (?)";

    private static final String SELECT_Speciality_BY_ID = "select * from Speciality where id_speciality =?";
    private static final String SELECT_ALL_Speciality = "select * from Speciality";
    private static final String DELETE_Speciality_SQL = "DELETE from speciality where id_speciality = ?";
    private static final String UPDATE_Speciality_SQL = "update Speciality set name = ? where id_speciality = ?";


    @Override
    public Speciality getSpeciality(long id) throws DAOException  {
        try (
            Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_Speciality_BY_ID);
        ) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            Speciality speciality = new Speciality();
            while (resultSet.next()) {
                speciality.setId_speciality(resultSet.getLong("id_speciality"));
                speciality.setName(resultSet.getString("name"));
            }
            return speciality;
        } catch (DAOException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Speciality> getAllSpeciality() throws DAOException  {


        ArrayList <Speciality> Specialities = new ArrayList<Speciality>();

        try(
            Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Speciality);
        ){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_speciality");
                String name = resultSet.getString("name");
                Specialities.add( new Speciality( id, name));
            }
            return Specialities;
        } catch (SQLException e) {
               e.printStackTrace();
        }
        return Specialities;
    }

    @Override
    public Speciality saveSpeciality(Speciality speciality) throws DAOException {
        try (
            Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_Speciality_SQL,Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1,speciality.getName());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()){
                speciality.setId_speciality((int)resultSet.getLong(1));
            }
            return speciality;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public Speciality updateSpeciality(Speciality speciality) throws DAOException {
        try(
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_Speciality_SQL);
            ){
                statement.setString(1,speciality.getName());
                statement.setLong(2,speciality.getId_speciality());
                statement.executeUpdate() ;
                return speciality;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteSpeciality(Speciality speciality) throws DAOException {
        try (
            Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_Speciality_SQL)
        ) {
            statement.setLong(1, speciality.getId_speciality());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
