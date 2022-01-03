package JDBC101.daoImpl;

import JDBC101.model.Event;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.sql.Date;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class eventDaoImpTest {
    static long id;
    @Test
    @Order(3)
    void getEvent() {
        eventDaoImp eventDaoImp = new eventDaoImp();
        assertInstanceOf(Event.class,eventDaoImp.getEvent(id));
    }

    @Test
    @Order(2)
    void getAllEvent() {
        eventDaoImp eventDaoImp = new eventDaoImp();
        ArrayList<Event> events = new ArrayList<Event>();
        assertInstanceOf(events.getClass(),eventDaoImp.getAllEvent());
    }

    @Test
    @Order(1)
    void saveEvent() {
        eventDaoImp eventDaoImp = new eventDaoImp();
        Event event = new Event();
        event.setName("event name");
        event.setDate(new Date(2022,01,15));
        event.setDescription("lorem ipsum");
        event.setStatus(0);
        Event newEvent = eventDaoImp.saveEvent(event);
        assertInstanceOf(Event.class,event);
        id = newEvent.getId_event();
    }

    @Test
    @Order(4)
    void updateEvent() {
        eventDaoImp eventDaoImp = new eventDaoImp();
        Event event = new Event();
        event.setId_event(id);
        event.setName("new event name");
        event.setDate(new Date(2023,01,15));
        event.setDescription("new lorem ipsum");
        event.setStatus(0);
        assertInstanceOf(Event.class,eventDaoImp.saveEvent(event));
    }

    @Test
    @Order(5)
    void deleteEvent() {
        eventDaoImp eventDaoImp = new eventDaoImp();
        assertTrue(eventDaoImp.deleteEvent(id));
    }
}