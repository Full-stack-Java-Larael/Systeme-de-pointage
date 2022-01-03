package JDBC101.model;

import java.sql.Date;

public class Manager extends User {
private Event event;
private Teacher teacher;
private Secretary secretary;

    private Date entry_date;

    public Date getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }


    public Manager(){

    }


    public Event createEvent(){
        return event;
    }

    public Event approveEvent(){
        return event;
    }

    public Teacher createTeacher(){
        return teacher;
    }

    public Secretary createSecretary(){
        return secretary;
    }


    @Override
    public String toString() {
        return "Manager{" +
                "entry_date='" + entry_date + '\'' +
                '}';
    }
}
