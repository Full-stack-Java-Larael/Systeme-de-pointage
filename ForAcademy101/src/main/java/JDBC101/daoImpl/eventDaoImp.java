package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.eventDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class eventDaoImp implements eventDao {

    private static final String INSERT_Event_SQL = "INSERT INTO Event (name, date, description, status) VALUES " +
            " (?, ?,?,?);";

    private static final String SELECT_Event_BY_ID = "select * from Event where id_event =?";
    private static final String SELECT_ALL_Event = "select * from Event";
    private static final String DELETE_Event_SQL = "delete from Event where id_event = ?;";
    private static final String UPDATE_Event_SQL = "update Event set name = ?, date= ?, description= ?, status= ? where id_event = ?;";


    @Override
    public Event getEvent(long id) throws DAOException  {
        Event Event = null;

        try (Connection connection = ConnectionFactory.getInstance().getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Event_BY_ID);) {
            preparedStatement.setLong(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int id_event = rs.getInt("id");
                String name = rs.getString("name");
                String date = rs.getString("date");
                String description = rs.getString("description");
                int status = rs.getInt("status");

                Event = new Event(id_event, name, date, description, status);


            }

        } catch (DAOException | SQLException e) {
            // printSQLException(e);
        }


        return Event;
    }

    @Override
    public List<Event> getAllEvent() throws DAOException  {


        List < Event > Events = new ArrayList<Event  >();

        try (Connection connection = ConnectionFactory.getInstance().getConnection();


             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Event);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String date = rs.getString("date");
                String description = rs.getString("description");
                int status = rs.getInt("status");
                Events.add( new Event( id, name, date, description, status));
            }
        } catch (SQLException e) {
            //   printSQLException(e);
        }
        return Events;

    }

    @Override
    public void saveEvent(Event t) throws DAOException {

        try (Connection connection = ConnectionFactory.getInstance().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Event_SQL)) {
            preparedStatement.setInt(1, t.getId_event());
            preparedStatement.setString(2,t.getName() );
            preparedStatement.setString(3,t.getDate() );
            preparedStatement.setString(4,t.getDescription() );
            preparedStatement.setInt(5,t.getStatus() );

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // printSQLException(e);
        }



    }



    @Override
    public void updateEvent(Event t, String[] params) throws DAOException {
        try (Connection connection = ConnectionFactory.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_Event_SQL);) {
            statement.setInt(1, t.getId_event());
            statement.setString(2, t.getName());
            statement.setString(3, t.getDate());
            statement.setString(4, t.getDescription());
            statement.setInt(5, t.getStatus());

            statement.executeUpdate() ;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public boolean deleteEvent(Event t) throws DAOException {

        boolean rowDeleted = false;
        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_Event_SQL);) {
            statement.setLong(1, t.getId_event());
            if(statement.executeUpdate() > 0){
                rowDeleted = true;
            };
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return rowDeleted;

    }
}
