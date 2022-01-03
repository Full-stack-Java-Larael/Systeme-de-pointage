package JDBC101.service;

import JDBC101.model.Teacher;

import java.util.List;

public interface teacherService {
    public void addTeacher(Teacher Teacher);
    Teacher fetchTeacherById(long id_teacher);
     void deleteTeacherById(Teacher id_teacher);

     List<Teacher> getAllTeachers();

}
