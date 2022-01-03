package JDBC101.daoImpl;

import JDBC101.model.Attendance;
import JDBC101.model.User;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class attendanceDaoImpTest {
    static long id;
    @Test
    @Order(3)
    void getAttendance() {
        attendanceDaoImp attendanceDaoImp = new attendanceDaoImp();
        assertInstanceOf(Attendance.class,attendanceDaoImp.getAttendance(id));
    }

    @Test
    @Order(2)
    void getAllAttendances() {
        attendanceDaoImp attendanceDaoImp = new attendanceDaoImp();
        List<Attendance> attendances= attendanceDaoImp.getAllAttendances();
        ArrayList<Attendance> attendance = new ArrayList<Attendance>();
        assertInstanceOf(attendance.getClass(),attendances);
    }

    @Test
    @Order(1)
    void saveAttendance() {
        attendanceDaoImp attendanceDaoImp = new attendanceDaoImp();
        Attendance attendance = new Attendance();
        attendance.setDate(new Date(System.currentTimeMillis()));
        attendance.setDeparture_hour(new Time(System.currentTimeMillis()));
        attendance.setArrival_hour(new Time(System.currentTimeMillis()));
        // User
        User user = new User();
        user.setId_user((long) 1);
        attendance.setUser(user);
        Attendance attendance1 = attendanceDaoImp.saveAttendance(attendance);
        assertInstanceOf(Attendance.class,attendance1);
        id = attendance1.getId_attendance();
    }

    @Test
    @Order(4)
    void updateAttendance() {
        attendanceDaoImp attendanceDaoImp = new attendanceDaoImp();
        Attendance attendance = new Attendance();
        attendance.setId_attendance(id);
        attendance.setDate(new Date(System.currentTimeMillis()));
        attendance.setDeparture_hour(new Time(System.currentTimeMillis()));
        attendance.setArrival_hour(new Time(System.currentTimeMillis()));
        attendance.setUser(new userDaoImp().getAllUser().get(0));
        assertTrue(attendanceDaoImp.updateAttendance(attendance));
    }

    @Test
    @Order(5)
    void deleteAttendance() {
        attendanceDaoImp attendanceDaoImp = new attendanceDaoImp();
        Attendance attendance = new Attendance();
        attendance.setId_attendance(id);
        assertTrue(attendanceDaoImp.deleteAttendance(attendance));
    }
}