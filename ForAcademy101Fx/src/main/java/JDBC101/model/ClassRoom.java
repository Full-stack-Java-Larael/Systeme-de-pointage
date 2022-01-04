package JDBC101.model;

import java.sql.Date;
import java.sql.Time;

public class ClassRoom {

    private long id_class_room;
    private String name;
    private String day_start_hour;
    private String day_end_hour;
    private Speciality speciality = new Speciality();
    private ClassRoom classRoom;

    public ClassRoom(){

    }
    public ClassRoom(long id_class_room, String name,String startDate,String endDate, Speciality speciality) {
        this.id_class_room = id_class_room;
        this.setName(name);
        this.setDay_end_hour(endDate);
        this.setDay_start_hour(startDate);
        this.speciality = speciality;
    }


    public long getId_class_room() {
        return id_class_room;
    }

    public void setId_class_room(long id_class_room) {
        this.id_class_room = id_class_room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getDay_start_hour() {
        return new Time(345678);
    }

    public void setDay_start_hour(String day_start_hour) {
        this.day_start_hour = day_start_hour;
    }

    public Time getDay_end_hour() {
        return new Time(3245678);
    }

    public void setDay_end_hour(String day_end_hour) {
        this.day_end_hour = day_end_hour;
    }

    public Speciality getSpecialty() {
        return speciality;
    }

    public void setSpecialty(Speciality speciality) {
        this.speciality = speciality;
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
                ", specialty=" + speciality +
                '}';
    }
}
