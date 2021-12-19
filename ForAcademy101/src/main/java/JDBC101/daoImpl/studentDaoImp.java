package JDBC101.daoImpl;

import JDBC101.dao.studentDao;
import JDBC101.model.Student;

import java.util.List;
import java.util.Optional;

public class studentDaoImp implements studentDao {
    @Override
    public Optional<Student> getStudent(long id) {
        return Optional.empty();
    }

    @Override
    public List<Student> getAllStudent() {
        return null;
    }

    @Override
    public void saveStudent(Student t) {

    }

    @Override
    public void updateStudent(Student t, String[] params) {

    }

    @Override
    public void deleteStudent(Student t) {

    }
}
