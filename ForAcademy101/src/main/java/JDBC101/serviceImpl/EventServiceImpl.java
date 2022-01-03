package JDBC101.serviceImpl;

import JDBC101.daoImpl.eventDaoImp;
import JDBC101.model.Event;
import JDBC101.service.eventService;

import java.util.List;
import java.util.Optional;

public class EventServiceImpl implements eventService {
private eventDaoImp eventDao = new eventDaoImp();
    @Override
    public void addEvent(Event Event) {
eventDao.saveEvent(Event);
    }

    @Override
    public Event fetchEventById(long id_event) {
        return eventDao.getEvent(id_event);
    }

    @Override
    public void deleteEventById(Event event) {
eventDao.deleteEvent(event);
    }



    @Override
    public List<Event> getAllEvents() {
        return eventDao.getAllEvent();
    }
}
