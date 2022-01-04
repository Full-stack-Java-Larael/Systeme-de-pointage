package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.eventDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class eventDaoImp implements eventDao {

    private static final String INSERT_Event_SQL = "INSERT INTO Event (name, date, description, status) VALUES (?, ?,?,?);";

    private static final String SELECT_Event_BY_ID = "select * from Event where id_event =?";
    private static final String SELECT_ALL_Event = "select * from Event";
    private static final String DELETE_Event_SQL = "delete from Event where id_event = ?;";
    private static final String UPDATE_Event_SQL = "update Event set name = ?, date= ?, description= ?, status= ? where id_event = ?;";


    @Override
    public Event getEvent(long id) throws DAOException  {
        try (
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Event_BY_ID)
        ) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Event event = new Event();
            while (resultSet.next()) {
                event.setId_event(resultSet.getLong("id_event"));
                event.setName(resultSet.getString("name"));
                event.setDate(resultSet.getDate("date"));
                event.setDescription(resultSet.getString("description"));
                event.setStatus(resultSet.getInt("status"));
            }
            return event;
        } catch (DAOException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Event> getAllEvent() throws DAOException  {


        ArrayList < Event > Events = new ArrayList<Event  >();

        try (Connection connection = ConnectionFactory.getInstance().getConnection();


             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Event);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date date = rs.getDate("date");
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
    public Event saveEvent(Event event) throws DAOException {

        try (
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT_Event_SQL,Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, event.getName() );
            statement.setDate(2, event.getDate() );
            statement.setString(3, event.getDescription() );
            statement.setInt(4, event.getStatus() );
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()){
                event.setId_event(resultSet.getInt(1));
            }
            return event;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public Event updateEvent(Event event) throws DAOException {
        try (Connection connection = ConnectionFactory.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_Event_SQL);) {
            statement.setString(1, event.getName());
            statement.setDate(2, event.getDate());
            statement.setString(3, event.getDescription());
            statement.setInt(4, event.getStatus());

            statement.executeUpdate() ;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteEvent(long id) throws DAOException {

        boolean rowDeleted = false;

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_Event_SQL);) {
            statement.setLong(1, id);
            if(statement.executeUpdate() > 0){
                rowDeleted = true;
            };
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return rowDeleted;

    }
}
