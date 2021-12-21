package JDBC101.daoImpl;

import JDBC101.JDBCfactory.ConnectionFactory;
import JDBC101.dao.RoleDao;
import JDBC101.handlingExceptions.DAOException;
import JDBC101.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class roleDaoImp implements RoleDao {

    private static final String INSERT_role_SQL = "INSERT INTO Role" + "  (name, privileges) VALUES " +
            " (?, ?);";

    private static final String SELECT_role_BY_ID = "select * from Role where id_role =?";
    private static final String SELECT_ALL_role = "select * from Role";
    private static final String DELETE_role_SQL = "delete from Role where id_role = ?;";
    private static final String UPDATE_role_SQL = "update Role set name = ?,privileges= ? where id_role = ?;";


    @Override
    public Role getRole(long id) throws DAOException  {
        Role role = null;

        try (Connection connection = ConnectionFactory.getInstance().getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_role_BY_ID);) {
            preparedStatement.setLong(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int id_role = rs.getInt("id");
                String name = rs.getString("name");
                String privileges = rs.getString("privileges");
                role = new Role(id_role, name, privileges);


            }

        } catch (DAOException | SQLException e) {
            // printSQLException(e);
        }


        return role;
    }

    @Override
    public List<Role> getAllRole() throws DAOException  {


        List < Role > roles = new ArrayList<Role  >();

        try (Connection connection = ConnectionFactory.getInstance().getConnection();


             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_role);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String privileges = rs.getString("privileges");
                roles.add( new Role( id, name, privileges));
            }
        } catch (SQLException e) {
            //   printSQLException(e);
        }
        return roles;

    }

    @Override
    public void saveRole(Role t) throws DAOException {

        try (Connection connection = ConnectionFactory.getInstance().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_role_SQL)) {
            preparedStatement.setInt(1, t.getId_role());
            preparedStatement.setString(2,t.getName() );
            preparedStatement.setString(3,t.getPrivileges() );
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // printSQLException(e);
        }



    }



    @Override
    public void updateRole(Role t, String[] params) throws DAOException {
        try (Connection connection = ConnectionFactory.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_role_SQL);) {
            statement.setInt(1, t.getId_role());
            statement.setString(2, t.getName());
            statement.setString(3, t.getPrivileges());

            statement.executeUpdate() ;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public boolean deleteRole(Role t) throws DAOException {

        boolean rowDeleted = false;
        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_role_SQL);) {
            statement.setLong(1, t.getId_role());
            if(statement.executeUpdate() > 0){
                rowDeleted = true;
            };
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return rowDeleted;

    }
}
