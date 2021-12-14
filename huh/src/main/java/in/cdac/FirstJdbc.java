package in.cdac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/kteb-smya-dyal-database";
        String username = "postgres";
        String password = "ktb-password-dyalk";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("connected to postgresql");

            String sql = "INSERT INTO users (name) VALUES ('akram')";
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            if(rows > 0){
                System.out.println("a new user has been added.");
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("error in connecting to postgresql server");
            e.printStackTrace();
        }
    }
}
