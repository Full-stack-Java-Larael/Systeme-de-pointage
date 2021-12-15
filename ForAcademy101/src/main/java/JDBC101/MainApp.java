package JDBC101;

import JDBC101.dao.jdbcDao;
import JDBC101.models.User;

public class MainApp {

    public static void main(String[] args) {
<<<<<<< HEAD
        String jdbcUrl = "jdbc:postgresql://localhost:5432/FA101";
        String username = "postgres";
        String password = "hello";
=======
        String jdbcUrl = "jdbc:postgresql://localhost:5432/test101";
        String username = "postgres";
        String password = "5687";
>>>>>>> 20991ccc269b00f69763510e9eeb5bb49b2982d3

        User user = new User();
        user.setFirst_name("abdelaziz");
        user.setLast_name("bardich");
        user.setEmail("B.abdelaziz@gmail.com");

        jdbcDao userDao = new jdbcDao(jdbcUrl, username, password);
        jdbcDao.saveUser(user);
    }
}
