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
    public Optional<Event> fetchEventById(int id_event) {
        return Optional.empty();
    }

    @Override
    public void deleteEventById(Event id_event) {

    }

    @Override
    public void updateEventPasswordById(String newPassword, String[] id_event) {

    }

    @Override
    public List<Event> getAllEvents() {
        return null;
    }
}
