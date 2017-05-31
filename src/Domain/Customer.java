package Domain;

import Tech.DBFacade;
import Tech.Messages;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            CallableStatement cl = db.callableStatement("{call add_Customer(?, ?, ?, ?, ?, ?, ?)}");

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

    public void removeCustomer(int customerID) {
        try {
            CallableStatement cl = db.callableStatement("{call delete_Customer(?)}");

            cl.setInt(1, customerID);

            cl.executeUpdate();

            messages.infoMessage("Customer with ID: " + customerID + " have been remove!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(int customerID, String name, String address, int zip, String town, String phone, String email) {
        try {
            CallableStatement cl = db.callableStatement("{call update_Customer(?, ?, ?, ?, ?, ?, ?, ?, ?}");

            cl.setInt(1, customerID);
            cl.setString(2, name);
            cl.setString(3, address);
            cl.setInt(4, zip);
            cl.setString(5, town);
            cl.setString(6, phone);
            cl.setString(7, email);

            cl.executeUpdate();

            messages.infoMessage("Customer " + name + " have been updated!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getName(int customerID) {
        try {
            PreparedStatement ps = db.preparedStatement("SELECT fld_Name FROM tbl_Customer WHERE fld_CustomerId = ?");

            ps.setInt(1, customerID);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("fld_Name");

                return name;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
