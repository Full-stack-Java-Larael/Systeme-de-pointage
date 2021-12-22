package JDBC101.serviceImpl;

import JDBC101.model.Teacher;
import JDBC101.service.teacherService;

import java.util.List;
import java.util.Optional;

public class TeacherServiceImpl implements teacherService {
    @Override
    public void addTeacher(Teacher Teacher) {

    }

    @Override
    public Optional<Teacher> fetchTeacherById(int id_teacher) {
        return Optional.empty();
    }

    @Override
    public void deleteTeacherById(Teacher id_teacher) {

    }

    @Override
    public void updateTeacherPasswordById(String newPassword, String[] id_teacher) {

    }

    @Override
    public List<Teacher> getAllTeachers() {
        return null;
    }
}
