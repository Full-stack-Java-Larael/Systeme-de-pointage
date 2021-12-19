package JDBC101.daoImpl;

import JDBC101.dao.teacherDao;
import JDBC101.model.Teacher;

import java.util.List;
import java.util.Optional;

public class teacherDaoImp implements teacherDao {
    @Override
    public Optional<Teacher> getTeacher(long id) {
        return Optional.empty();
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return null;
    }

    @Override
    public void saveTeacher(Teacher t) {

    }

    @Override
    public void updateTeacher(Teacher t, String[] params) {

    }

    @Override
    public void deleteTeacher(Teacher t) {

    }
}
