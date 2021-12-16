package JDBC101;

import JDBC101.daoImpl.userDaoImp;
import JDBC101.model.User;

public class MainApp {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/FA101";
        String username = "postgres";
        String password = "hello";


        User user = new User();
        user.setFirst_name("anouar");
        user.setLast_name("iguernait");
        user.setEmail("iguernait.anouar@gmail.com");

        userDaoImp userDao = new userDaoImp(jdbcUrl, username, password);
    }
}
