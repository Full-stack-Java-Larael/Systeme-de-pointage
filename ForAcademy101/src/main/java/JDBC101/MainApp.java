package JDBC101;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.daoImpl.addressDaoImp;
import JDBC101.daoImpl.userDaoImp;
import JDBC101.model.Address;
import JDBC101.model.User;
import JDBC101.serviceImpl.*;

public class MainApp {


    public static void main(String[] args) {




        Address address = new Address(2000,"Casablanca","rue ait baha");
        addressDaoImp addDao = new addressDaoImp();
        addDao.saveAddress(address);

      }

}