package JDBC101.models;

public class Promotion {

    private int id_promotion;
    private String name;
    private int year;
    private String start_date;
    private String end_date;

    public Promotion(int id_promotion, String name) {
        this.id_promotion = id_promotion;
        this.name = name;
    }


    public Promotion() {

    }

    public int getId_promotion() {
        return id_promotion;
    }

    public void setId_promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id_promotion=" + id_promotion +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                '}';
    }
}
