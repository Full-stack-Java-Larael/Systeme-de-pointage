package JDBC101.daoImpl;

import JDBC101.model.Attendance;
import JDBC101.model.User;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class attendanceDaoImpTest {

    @Test
    void getAttendance() {
        attendanceDaoImp attendanceDaoImp = new attendanceDaoImp();
        assertInstanceOf(Attendance.class,attendanceDaoImp.getAttendance(1));
    }

    @Test
    void getAllAttendances() {
        attendanceDaoImp attendanceDaoImp = new attendanceDaoImp();
        List<Attendance> attendances= attendanceDaoImp.getAllAttendances();
        ArrayList<Attendance> attendance = new ArrayList<Attendance>();
        assertInstanceOf(attendance.getClass(),attendances);
    }

    @Test
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
    }

    @Test
    void updateAttendance() {
        attendanceDaoImp attendanceDaoImp = new attendanceDaoImp();
        Attendance attendance = new Attendance();
        attendance.setId_attendance(3);
        attendance.setDate(new Date(System.currentTimeMillis()));
        attendance.setDeparture_hour(new Time(System.currentTimeMillis()));
        attendance.setArrival_hour(new Time(System.currentTimeMillis()));
        // User
        User user = new User();
        user.setId_user((long) 1);
        attendance.setUser(user);
        assertTrue(attendanceDaoImp.updateAttendance(attendance));
    }

    @Test
    void deleteAttendance() {
        attendanceDaoImp attendanceDaoImp = new attendanceDaoImp();
        Attendance attendance = new Attendance();
        attendance.setId_attendance(1);
        assertTrue(attendanceDaoImp.deleteAttendance(attendance));
    }
}