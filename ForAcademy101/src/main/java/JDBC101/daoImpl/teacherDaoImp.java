package JDBC101.daoImpl;

import JDBC101.dao.teacherDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Teacher;

import java.util.List;
import java.util.Optional;

public class teacherDaoImp implements teacherDao {

    @Override
    public Optional<Teacher> getTeacher(long id) throws DAOException {
        return Optional.empty();
    }

    @Override
    public List<Teacher> getAllTeacher() throws DAOException {
        return null;
    }

    @Override
    public void saveTeacher(Teacher t) throws DAOException {

    }

    @Override
    public void updateTeacher(Teacher t, String[] params) throws DAOException {

    }

    @Override
    public void deleteTeacher(Teacher t) throws DAOException {

    }
}
