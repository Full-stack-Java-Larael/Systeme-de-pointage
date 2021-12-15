package JDBC101.models;

public class Specialty {

    private int id_speciality;
    private String name;

    public Specialty(int id_speciality, String name) {
        this.id_speciality = id_speciality;
        this.name = name;
    }

    public Specialty() {

    }

    public int getId_speciality() {
        return id_speciality;
    }

    public void setId_speciality(int id_speciality) {
        this.id_speciality = id_speciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "id_speciality=" + id_speciality +
                ", name='" + name + '\'' +
                '}';
    }
}
