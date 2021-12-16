package JDBC101;

import JDBC101.daoImpl.userDaoImp;
import JDBC101.model.User;

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
>>>>>>> a9f136ec0892e4826526e351867f9eb21db3c254

        User user = new User();
        user.setFirst_name("anouar");
        user.setLast_name("iguernait");
        user.setEmail("iguernait.anouar@gmail.com");

        userDaoImp userDao = new userDaoImp(jdbcUrl, username, password);
    }
}
