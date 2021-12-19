package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.userDao;
import JDBC101.model.User;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class userDaoImp implements userDao{


    public userDaoImp() {
    }

    @Override
    public Optional<User> getUser(long id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    public void saveUser(User user){
        try {
         //   Connection connection = DriverManager.getConnection(url, username, password);

            Connection connection =   ConnectionFactory.getInstance().getConnection();

            if(user.getId_user() != null){
                PreparedStatement statement = connection.prepareStatement
                        ("update users set email= ?, first_name= ?, last_name= ? where id_user = ?;");
                statement.setString(1, user.getEmail());
                statement.setLong(4, user.getId_user());
                statement.setString(2, user.getFirst_name());
                statement.setString(3, user.getLast_name());
                statement.execute();

            }else{
                PreparedStatement statement = connection.prepareStatement
                        ("insert into users ( first_name, last_name,address_id,phone,email,password) values (?,?,?,?,?,?);");
                statement.setString(5, user.getEmail());
                statement.setString(1, user.getFirst_name());
                statement.setString(2, user.getLast_name());
                statement.setString(4, user.getPhone());
                statement.setString(6, user.getPassword());
                statement.setLong(3, user.getAddress_id().getId_address());

                statement.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("unable to save the product");
        }
    }

    @Override
    public void updateUser(User t, String[] params) {

    }

    @Override
    public void deleteUser(User t) {

    }


    public User getUserById(Long id_user){
        try {
            Connection connection =   ConnectionFactory.getInstance().getConnection();
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


}

