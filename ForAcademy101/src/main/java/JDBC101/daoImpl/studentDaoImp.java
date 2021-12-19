package JDBC101.daoImpl;

import JDBC101.dao.studentDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Student;

import java.util.List;
import java.util.Optional;

public class studentDaoImp implements studentDao {

    @Override
    public Optional<Student> getStudent(long id) throws DAOException {
        return Optional.empty();
    }

    @Override
    public List<Student> getAllStudent() throws DAOException {
        return null;
    }

    @Override
    public void saveStudent(Student t) throws DAOException {

    }

    @Override
    public void updateStudent(Student t, String[] params) throws DAOException {

    }

    @Override
    public void deleteStudent(Student t) throws DAOException {

    }
}
