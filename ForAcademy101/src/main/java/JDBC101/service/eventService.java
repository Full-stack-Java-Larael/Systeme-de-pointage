package JDBC101.service;

import JDBC101.model.Event;

import java.util.List;

public interface eventService {

     void addEvent(Event Event);
     Event fetchEventById(long id_event);
     void deleteEventById(Event event);

     List<Event> getAllEvents();
}
