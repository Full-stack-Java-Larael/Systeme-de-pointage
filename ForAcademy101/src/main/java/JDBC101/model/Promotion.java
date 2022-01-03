package JDBC101.model;

import java.sql.Date;

public class Promotion {

    private long id_promotion;
    private String name;
    private int year;
    private java.sql.Date start_date;
    private Date end_date;
    private Promotion promotion;

    public Promotion( String name , int year , Date start_date , Date end_date) {


        this.name = name;
        this.year = year;
        this.start_date = start_date;
        this.end_date = end_date;
    }


    public Promotion() {

    }

    public long getId_promotion() {
        return id_promotion;
    }

    public void setId_promotion(long id_promotion) {
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

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int numberOfStudents(){
        return 0;
    }

    public int numberOfBoys(){
        return 0;
    }

    public int numberOfGirls(){
        return 0;
    }

    public Promotion createPromotion(){
        return promotion;
    }

    public Promotion updatePromotion(){
        return promotion;
    }

    public Promotion deletePromotion(){
        return promotion;
    }

    public Promotion getPromotion(){
        return promotion;
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
