package JDBC101.daoImpl;

import JDBC101.dao.Dao;
import JDBC101.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserDaoT implements Dao<User> {

    private List<User> users = new ArrayList<>();

    public UserDaoT() {
       // users.add(new User("test","test2","john@domain.com"));

    }

    @Override
    public Optional<User> get(long id) {
        return Optional.ofNullable(users.get((int) id));
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public void update(User user, String[] params) {
     /*   user.setName(Objects.requireNonNull(
                params[0], "Name cannot be null"));
        user.setEmail(Objects.requireNonNull(
                params[1], "Email cannot be null"));

        users.add(user);


      */
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }
}