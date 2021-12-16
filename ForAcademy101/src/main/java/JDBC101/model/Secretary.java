package JDBC101.model;

public class Secretary {

    private String entry_date;

    public Secretary(String entry_date) {
        this.entry_date = entry_date;
    }

    public String getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(String entry_date) {
        this.entry_date = entry_date;
    }

    @Override
    public String toString() {
        return "Secretary{" +
                "entry_date='" + entry_date + '\'' +
                '}';
    }
}
