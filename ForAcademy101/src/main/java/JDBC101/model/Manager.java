package JDBC101.model;

public class Manager extends User {
private Event event;
private Teacher teacher;
private Secretary secretary;

    private String entry_date;

    public String getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(String entry_date) {
        this.entry_date = entry_date;
    }

    public Manager(String entry_date) {
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
