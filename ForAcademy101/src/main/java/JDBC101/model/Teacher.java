package JDBC101.model;

public class Teacher {


    private Specialty speciality = new Specialty();

    private Event event ;

    public Teacher(Specialty speciality) {
        this.speciality = speciality;
    }

    public Specialty getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Specialty speciality) {
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
