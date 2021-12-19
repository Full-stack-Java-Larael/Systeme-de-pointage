package JDBC101.dao;

import JDBC101.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface teacherDao {
    Optional<Teacher> getTeacher(long id);

    List<Teacher> getAllTeacher();

    void saveTeacher(Teacher t);

    void updateTeacher(Teacher t, String[] params);

    void deleteTeacher(Teacher t);
}
