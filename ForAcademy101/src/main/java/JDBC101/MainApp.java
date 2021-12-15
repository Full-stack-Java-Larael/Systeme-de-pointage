package JDBC101;

import JDBC101.dao.jdbcDao;
import JDBC101.models.User;

public class MainApp {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/FA101";
        String username = "postgres";
        String password = "hello";

        User user = new User();
        user.setFirst_name("abdelaziz");
        user.setLast_name("bardich");
        user.setEmail("B.abdelaziz@gmail.com");

        jdbcDao userDao = new jdbcDao(jdbcUrl, username, password);
        jdbcDao.saveUser(user);
    }
}
