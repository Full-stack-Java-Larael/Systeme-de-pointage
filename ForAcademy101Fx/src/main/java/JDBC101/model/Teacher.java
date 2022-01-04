package JDBC101.model;

public class Teacher extends User {


    private Speciality speciality = new Speciality();

    private Event event ;

    public Teacher() {
        this.speciality = null;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Event suggestEvent(){
        return event ;
    };

    @Override
    public String toString() {
        return "Teacher{" +
                "speciality=" + speciality +
                '}';
    }
}
