package Domain;

import Tech.DBFacade;
import Tech.Messages;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class Customer {
    private DBFacade db;
    private Messages messages;

    public Customer() {
        db = new DBFacade();
        messages = new Messages();
    }

    public void createCustomer(String name, String address, int zip, String town, String phone, String email) {
        try {
            CallableStatement cl = db.callableStatement("{call createCustomer(?, ?, ?, ?, ?, ?, ?)}");

            cl.setString(1, name);
            cl.setString(2, address);
            cl.setInt(3, zip);
            cl.setString(4, town);
            cl.setString(5, phone);
            cl.setString(6, email);

            cl.executeUpdate();

            messages.infoMessage("Customer: " + name + " have been created!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
