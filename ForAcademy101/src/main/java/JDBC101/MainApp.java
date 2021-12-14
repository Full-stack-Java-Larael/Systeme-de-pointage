package JDBC101;

import JDBC101.dao.userDao;
import JDBC101.models.Users;

public class MainApp {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/test101";
        String username = "postgres";
        String password = "5687";

        Users users = new Users();
        users.setEmail("someonesEmail@gmail.com");

        userDao userDao = new userDao(jdbcUrl, username, password);
        userDao.saveUser(users);
    }
}
