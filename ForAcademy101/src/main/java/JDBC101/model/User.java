package JDBC101.model;

public class User {

    private Long id_user;
    private String first_name;
    private String last_name;
    private String phone;
    private String email;
    private String gender;
    private String password;
    private Address address;
    private boolean status;
    private Role role;

    public User() {

    }

    // get user Address
    public Address getAddress() {

        return address;
    }
    // set user address
    public void setAddress(Address address) {
        this.address = address;
    }

    // Get role
    public Role getRole() {
        return role;
    }
    // Set role
    public void setRole(Role role) {
        this.role = role;
    }

    // get user id
    public Long getId_user() {
        return id_user;
    }

    // set user id
    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }
    
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "users{" +
                "id_user=" + id_user +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
    // address: Address add this
    // role : Role add this

}
