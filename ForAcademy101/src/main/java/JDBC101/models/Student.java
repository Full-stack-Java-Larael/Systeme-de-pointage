package JDBC101.models;

public class Student {

    private Promotion promotion = new Promotion();

    public Student(Promotion promotion) {
        this.promotion = promotion;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        return "Student{" +
                "promotion=" + promotion +
                '}';
    }
}
