package JDBC101;

import JDBC101.daoImpl.*;
import JDBC101.model.*;

import java.sql.Date;
import java.sql.Time;

public class MainApp {
    public static void main(String[] args) {
        attendanceDaoImp attendanceDaoImp = new attendanceDaoImp();
        Attendance attendance = new Attendance();
        attendance.setArrival_hour(new Time(System.currentTimeMillis()));
        attendance.setDeparture_hour(null);
        attendance.setDate(new Date(System.currentTimeMillis()));

        // User
        User user = new User();
        user.setId_user((long)1);
        attendance.setUser(user);

        System.out.println(attendanceDaoImp.saveAttendance(attendance));

    }

}