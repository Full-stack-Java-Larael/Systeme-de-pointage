package JDBC101.model;

public class Attendance {

    private int id_attendance;
    private String date;
    private String arrival_hour;
    private String departure_hour;

    public Attendance(int id_attendance, String date, String arrival_hour, String departure_hour) {
        this.id_attendance = id_attendance;
        this.date = date;
        this.arrival_hour = arrival_hour;
        this.departure_hour = departure_hour;
    }

    public int getId_attendance() {
        return id_attendance;
    }

    public void setId_attendance(int id_attendance) {
        this.id_attendance = id_attendance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getArrival_hour() {
        return arrival_hour;
    }

    public void setArrival_hour(String arrival_hour) {
        this.arrival_hour = arrival_hour;
    }

    public String getDeparture_hour() {
        return departure_hour;
    }

    public void setDeparture_hour(String departure_hour) {
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
}
