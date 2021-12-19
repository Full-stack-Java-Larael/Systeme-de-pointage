package JDBC101.model;

public class Teacher {


    private Speciality speciality = new Speciality();

    private Event event ;

    public Teacher(Speciality speciality) {
        this.speciality = speciality;
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
