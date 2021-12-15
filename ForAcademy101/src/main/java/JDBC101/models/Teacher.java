package JDBC101.models;

public class Teacher {

    private Specialty speciality = new Specialty();

    public Teacher(Specialty speciality) {
        this.speciality = speciality;
    }

    public Specialty getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Specialty speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "speciality=" + speciality +
                '}';
    }
}
