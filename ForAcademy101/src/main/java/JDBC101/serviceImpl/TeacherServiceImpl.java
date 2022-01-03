package JDBC101.serviceImpl;

import JDBC101.daoImpl.teacherDaoImp;
import JDBC101.model.Teacher;
import JDBC101.service.teacherService;

import java.util.List;
import java.util.Optional;

public class TeacherServiceImpl implements teacherService {
    private teacherDaoImp teacherDao = new teacherDaoImp();
    @Override
    public void addTeacher(Teacher Teacher) {
teacherDao.saveTeacher(Teacher);
    }

    @Override
    public Teacher fetchTeacherById(long id_teacher) {
        return teacherDao.getTeacher(id_teacher);
    }

    @Override
    public void deleteTeacherById(Teacher id_teacher) {
        teacherDao.deleteTeacher(id_teacher.getId_user());

    }



    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDao.getAllTeacher();
    }
}
