package JDBC101.dao;

import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Event;

import java.util.ArrayList;
import java.util.List;

public interface eventDao {
    Event getEvent(long id) throws DAOException;

    ArrayList<Event> getAllEvent() throws DAOException;

    Event saveEvent(Event event) throws DAOException;

    Event updateEvent(Event event) throws DAOException;

    boolean deleteEvent(long id) throws DAOException;
}
