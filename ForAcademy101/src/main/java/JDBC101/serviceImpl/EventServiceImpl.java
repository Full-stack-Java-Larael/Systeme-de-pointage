package JDBC101.serviceImpl;

import JDBC101.model.Event;
import JDBC101.service.eventService;

import java.util.List;
import java.util.Optional;

public class EventServiceImpl implements eventService {

    @Override
    public void addEvent(Event Event) {

    }

    @Override
    public Event fetchEventById(long id_event) {
        return null;
    }

    @Override
    public void deleteEventById(Event event) {

    }

    @Override
    public void updateEventPasswordById(String newPassword, long id_event) {

    }

    @Override
    public List<Event> getAllEvents() {
        return null;
    }
}
