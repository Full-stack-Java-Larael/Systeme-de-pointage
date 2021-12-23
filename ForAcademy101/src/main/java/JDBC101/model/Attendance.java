package JDBC101.model;

import java.sql.Time;
import java.util.Date;

public class Attendance {

    private long id_attendance;
    private Date date;
    private Time arrival_hour;
    private Time departure_hour;
    private User user;

    public Attendance(long id_attendance, Date date, Time arrival_hour, Time departure_hour) {
        this.id_attendance = id_attendance;
        this.date = date;
        this.arrival_hour = arrival_hour;
        this.departure_hour = departure_hour;
    }
    public Attendance(){

    }

    public long getId_attendance() {
        return id_attendance;
    }

    public void setId_attendance(int id_attendance) {
        this.id_attendance = id_attendance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getArrival_hour() {
        return arrival_hour;
    }

    public void setArrival_hour(Time arrival_hour) {
        this.arrival_hour = arrival_hour;
    }

    public Time getDeparture_hour() {
        return departure_hour;
    }

    public void setDeparture_hour(Time departure_hour) {
        this.departure_hour = departure_hour;
    }




    @Override
    public String toString() {
        return "Attendance{" +
                "id_attendance=" + id_attendance +
                ", date='" + date + '\'' +
                ", arrival_hour='" + arrival_hour + '\'' +
                ", departure_hour='" + departure_hour + '\'' +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
