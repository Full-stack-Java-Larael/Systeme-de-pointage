package JDBC101.model;

import java.sql.Date;
import java.sql.Time;

public class Event {

    private int id_event;
    private String name;
    private Date date;
    private String description;
    private int status;
    private Event event;

    public Event(int id_event, String name, Date date, String description, int status) {
        this.id_event = id_event;
        this.name = name;
        this.date = date;
        this.description = description;
        this.status = status;
    }

    public Event() {

    }

    public Event(int id, String name, Time date, String description, int status) {
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = Date.valueOf(date);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public Event createEvent(){
        return event;
    }

    public Event updateEvent(){
        return event;
    }
    public Event deleteEvent(){
        return event;
    }

    public Event getEvent(){
        return event;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id_event=" + id_event +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }


}
