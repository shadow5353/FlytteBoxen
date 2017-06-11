package Domain;

import Tech.DBFacade;
import Tech.Messages;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
    private int customerID;
    private String name;
    private String email;
    private String phone;
    private String address;
    private int zip;
    private String city;

    public Customer(int customerID, String name, String email, String phone, String address, int zip, String city) {
        this.customerID = customerID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.zip = zip;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getZip() {
        return zip;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getCity() {
        return city;
    }
}
