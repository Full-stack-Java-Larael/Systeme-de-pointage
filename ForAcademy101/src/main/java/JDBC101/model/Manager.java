package JDBC101.model;

public class Manager {

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

    @Override
    public String toString() {
        return "Manager{" +
                "entry_date='" + entry_date + '\'' +
                '}';
    }
}
