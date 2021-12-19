package JDBC101.service;

import JDBC101.model.Event;

import java.util.List;
import java.util.Optional;

public interface eventService {

    public void addEvent(Event Event);
    public Optional<Event> fetchEventById(int id_event);
    public void deleteEventById(Event id_event);
    public void updateEventPasswordById(String newPassword, String[] id_event);
    public List<Event> getAllEvents();
}
