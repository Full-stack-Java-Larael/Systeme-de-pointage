package JDBC101.daoImpl;

import JDBC101.dao.eventDao;
import JDBC101.model.Event;

import java.util.List;
import java.util.Optional;

public class eventDaoImp implements eventDao {
    @Override
    public Optional<Event> getEvent(long id) {
        return Optional.empty();
    }

    @Override
    public List<Event> getAllEvent() {
        return null;
    }

    @Override
    public void saveEvent(Event t) {

    }

    @Override
    public void updateEvent(Event t, String[] params) {

    }

    @Override
    public void deleteEvent(Event t) {

    }
}
