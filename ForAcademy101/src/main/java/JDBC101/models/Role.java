package JDBC101.models;

import java.util.Arrays;

public class Role {

    private int id_role;
    private String name;
    private String[] privileges;

    public Role(int id_role, String name, String[] privileges) {
        this.id_role = id_role;
        this.name = name;
        this.privileges = privileges;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String[] privileges) {
        this.privileges = privileges;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id_role=" + id_role +
                ", name='" + name + '\'' +
                ", privileges=" + Arrays.toString(privileges) +
                '}';
    }
}
