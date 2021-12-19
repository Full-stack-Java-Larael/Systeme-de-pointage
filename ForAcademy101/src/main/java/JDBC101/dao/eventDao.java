package JDBC101.dao;

import JDBC101.model.Event;

import java.util.List;
import java.util.Optional;

public interface eventDao {
    Optional<Event> getEvent(long id);

    List<Event> getAllEvent();

    void saveEvent(Event t);

    void updateEvent(Event t, String[] params);

    void deleteEvent(Event t);
}
