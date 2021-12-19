package JDBC101.model;

public class ClassRoom {

    private int id_class_room;
    private String name;
    private String day_start_hour;
    private String day_end_hour;
    private Specialty specialty = new Specialty();
    private ClassRoom classRoom;

    public ClassRoom(int id_class_room, String name, Specialty specialty) {
        this.id_class_room = id_class_room;
        this.name = name;
        this.specialty = specialty;
    }

    public int getId_class_room() {
        return id_class_room;
    }

    public void setId_class_room(int id_class_room) {
        this.id_class_room = id_class_room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay_start_hour() {
        return day_start_hour;
    }

    public void setDay_start_hour(String day_start_hour) {
        this.day_start_hour = day_start_hour;
    }

    public String getDay_end_hour() {
        return day_end_hour;
    }

    public void setDay_end_hour(String day_end_hour) {
        this.day_end_hour = day_end_hour;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public ClassRoom createClassRoom(){
        return classRoom;
    }
    public ClassRoom updateClassRoom(){
        return classRoom;
    }

    public ClassRoom deleteClassRoom(){
        return classRoom;
    }

    public ClassRoom getClassRoom(){
        return classRoom;
    }

    public int getNumberOfStudents(ClassRoom classRoom){
        return 0;
    }





    @Override
    public String toString() {
        return "ClassRoom{" +
                "id_class_room=" + id_class_room +
                ", name='" + name + '\'' +
                ", day_start_hour='" + day_start_hour + '\'' +
                ", day_end_hour='" + day_end_hour + '\'' +
                ", specialty=" + specialty +
                '}';
    }
}
