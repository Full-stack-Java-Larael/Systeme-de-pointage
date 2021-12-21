package JDBC101.model;

public class Address {

    private long id_address;
    private int postal_code;
    private String city;
    private String street;
    private Address address;


    public Address( int postal_code, String city, String street) {

        this.id_address = id_address;
        this.postal_code = postal_code;
        this.city = city;
        this.street = street;
    }
    public Address(){

    }

    public long getId_address() {
        return id_address;
    }

    public void setId_address(int id_address) {
        this.id_address = id_address;
    }

    public int getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public Address getAddress(){
        return address;
    }
    public Address createAddress(){
        return address;
    }

    public Address updateAddress(){
        return address;
    }
    public Address deleteAddress(){
        return address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id_address=" + id_address +
                ", postal_code=" + postal_code +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
