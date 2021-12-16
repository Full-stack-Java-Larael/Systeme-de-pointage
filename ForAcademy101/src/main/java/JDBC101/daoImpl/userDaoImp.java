package JDBC101.daoImpl;

import JDBC101.dao.userDao;
import JDBC101.model.User;

import java.sql.*;
import java.util.List;

public class userDaoImp implements userDao {
    private static String url;
    private static String username;
    private static String password;

    public userDaoImp(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }


    public void saveUser(User user){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            if(user.getId_user() != null){
                PreparedStatement statement = connection.prepareStatement
                        ("update users set email= ?, first_name= ?, last_name= ? where id_user = ?;");
                statement.setString(1, user.getEmail());
                statement.setLong(2, user.getId_user());
                statement.execute();

            }else{
                PreparedStatement statement = connection.prepareStatement
                        ("insert into users (email, first_name, last_name) values (?,?,?);");
                statement.setString(1, user.getEmail());
                statement.setString(2, user.getFirst_name());
                statement.setString(3, user.getLast_name());

                statement.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("unable to save the product");
        }
    }


    public User getUserById(Long id_user){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement
                    ("select * from users where id_user = ?;");
            statement.setLong(1,id_user);
            ResultSet resultSet = statement.executeQuery();

            User user = new User();
            while(resultSet.next()){
                user.setId_user(resultSet.getLong("id_user"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setLast_name(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
            }
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<User> getAllUsersDetails() {
        return null;
    }
}

