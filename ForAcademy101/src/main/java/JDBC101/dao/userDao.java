package JDBC101.dao;

<<<<<<< HEAD
public interface userDao {
=======
import JDBC101.models.Users;

import java.sql.*;

public class userDao {

    private String url;
    private String username;
    private String password;

    public userDao(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }


    public void saveUser(Users users){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            if(users.getId_user() != null){
                PreparedStatement statement = connection.prepareStatement
                        ("update users set email= ? where id_user = ?;");
                statement.setString(1,users.getEmail());
                statement.setLong(2,users.getId_user());
                statement.execute();

            }else{
                PreparedStatement statement = connection.prepareStatement
                        ("insert into users (email) values (?);");
                statement.setString(1,users.getEmail());
                statement.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("unable to save the product");
        }
    }


    public Users getUserById(Long id_user){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement
                    ("select * from users where id_user = ?;");
            statement.setLong(1,id_user);
            ResultSet resultSet = statement.executeQuery();

            Users users = new Users();
            while(resultSet.next()){
                users.setId_user(resultSet.getLong("id_user"));
                users.setEmail(resultSet.getString("email"));
            }
            return users;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
>>>>>>> 20991ccc269b00f69763510e9eeb5bb49b2982d3
}
