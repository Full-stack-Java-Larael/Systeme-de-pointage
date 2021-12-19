package JDBC101.model;

public class Event {

    private int id_event;
    private String name;
    private String date;
    private String description;
    private int status;
    private Event event;

    public Event(int id_event, String name, String date, String description, int status) {
        this.id_event = id_event;
        this.name = name;
        this.date = date;
        this.description = description;
        this.status = status;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
