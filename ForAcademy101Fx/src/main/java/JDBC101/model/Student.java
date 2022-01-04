package JDBC101.model;

public class Student extends User{
    private Event event;

    private Promotion promotion = new Promotion();

    public Student(Promotion promotion) {
        this.promotion = promotion;
    }
    public Student(){

    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Event suggestEvent(){
        return event ;
    };



    @Override
    public String toString() {
        return "Student{" +
                "promotion=" + promotion +
                '}';
    }
}
