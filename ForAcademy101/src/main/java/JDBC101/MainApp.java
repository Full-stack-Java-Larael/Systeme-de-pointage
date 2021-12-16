package JDBC101;

import JDBC101.daoImpl.userDaoImp;
import JDBC101.model.User;

public class MainApp {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/foracademy";
        String username = "postgres";
        String password = "password-dyalk!!!";


        User user = new User();
        user.setFirst_name("a");
        user.setLast_name("b");
        user.setEmail("ab@gmail.com");

        userDaoImp userDao = new userDaoImp(jdbcUrl, username, password);
        userDaoImp.saveUser(user);
    }
}
