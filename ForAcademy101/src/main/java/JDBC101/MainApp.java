package JDBC101;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.daoImpl.userDaoImp;
import JDBC101.model.User;

public class MainApp {


    public static void main(String[] args) {



        User user = new User();
        user.setFirst_name("ZZZZZZ");
        user.setLast_name("zzzzz");
        user.setEmail("abaaa@gmail.com");
        user.setPassword("blabla");
        user.setPhone("+212657761515");

        userDaoImp.saveUser(user);

    }

}