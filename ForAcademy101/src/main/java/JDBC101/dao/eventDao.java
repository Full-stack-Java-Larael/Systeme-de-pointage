package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Event;

import java.util.List;

public interface eventDao {
    Event getEvent(long id) throws DAOException;

    List<Event> getAllEvent() throws DAOException;

    void saveEvent(Event t) throws DAOException;

    void updateEvent(Event t, String[] params) throws DAOException;

    boolean deleteEvent(Event t) throws DAOException;
}
