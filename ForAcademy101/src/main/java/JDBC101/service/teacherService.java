package JDBC101.service;

import JDBC101.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface teacherService {
    public void addTeacher(Teacher Teacher);
    public Optional<Teacher> fetchTeacherById(int id_teacher);
    public void deleteTeacherById(Teacher id_teacher);
    public void updateTeacherPasswordById(String newPassword, String[] id_teacher);
    public List<Teacher> getAllTeachers();
}
