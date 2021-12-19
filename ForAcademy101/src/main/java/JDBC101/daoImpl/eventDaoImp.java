package JDBC101.daoImpl;

import JDBC101.dao.eventDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Event;

import java.util.List;
import java.util.Optional;

public class eventDaoImp implements eventDao {

    @Override
    public Optional<Event> getEvent(long id) throws DAOException {
        return Optional.empty();
    }

    @Override
    public List<Event> getAllEvent() throws DAOException {
        return null;
    }

    @Override
    public void saveEvent(Event t) throws DAOException {

    }

    @Override
    public void updateEvent(Event t, String[] params) throws DAOException {

    }

    @Override
    public void deleteEvent(Event t) throws DAOException {

    }
}
