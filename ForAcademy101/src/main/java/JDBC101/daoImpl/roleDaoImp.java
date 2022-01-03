package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.RoleDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class roleDaoImp implements RoleDao {

    private static final String INSERT_role_SQL = "INSERT INTO Role (name, privileges) VALUES (?, ?)";

    private static final String SELECT_role_BY_ID = "select * from Role where id_role =?";
    private static final String SELECT_ALL_role = "select * from Role";
    private static final String DELETE_role_SQL = "delete from Role where id_role = ?;";
    private static final String UPDATE_role_SQL = "update Role set name = ? , privileges= ? where id_role = ?";


    @Override
    public Role getRole(long id) throws DAOException  {
        try (
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_role_BY_ID)
        ) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            Role role = new Role();
            while (rs.next()) {
                role.setId_role(rs.getInt("id_role"));
                role.setName(rs.getString("name"));
                role.setPrivileges(rs.getString("privileges"));
            }
            return role;
        } catch (DAOException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Role> getAllRole() throws DAOException  {
        try (
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_role);
        ) {
            ArrayList <Role> roles = new ArrayList<Role>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id_role");
                String name = resultSet.getString("name");
                String privileges = resultSet.getString("privileges");
                roles.add( new Role( id, name, privileges));
            }
            return  roles;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Role saveRole(Role role) throws DAOException {

        try (
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT_role_SQL, Statement.RETURN_GENERATED_KEYS)
        ) {
//            statement.setLong(1, role.getId_role());
            statement.setString(1,role.getName() );
            statement.setString(2,role.getPrivileges());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()){
                role.setId_role(resultSet.getLong(1));
            }
            return role;
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return null;
    }



    @Override
    public Role updateRole(Role role) throws DAOException {
        try (
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_role_SQL)
        ) {
            statement.setString(1, role.getName());
            statement.setString(2, role.getPrivileges());
            statement.setLong(3, role.getId_role());

            statement.executeUpdate() ;
            return role;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteRole(Role role) throws DAOException {
        try (
                Connection connection = ConnectionFactory.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_role_SQL)
        ) {
            statement.setLong(1, role.getId_role());
            if(statement.executeUpdate() > 0){
                return true;
            };
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }
}
