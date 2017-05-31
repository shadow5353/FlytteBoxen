package Domain;

import Tech.DBFacade;
import Tech.Messages;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

public class Order {
    private DBFacade db;
    private Messages messages;

    public Order() {
        db = new DBFacade();
        messages = new Messages();
    }

    public void createOrder(int customerID, int boxID, Date startDate, Date endDate) {
        try {
            CallableStatement cl = db.callableStatement("{call add_Order(?, ?, ?, ?)}");

            String createdBy = System.getProperty("user.name");
            boolean terminated = false;

            cl.setInt(1, customerID);
            cl.setInt(2, boxID);
            cl.setString(3, createdBy);
            cl.setDate(4, startDate);
            cl.setDate(5, endDate);
            cl.setBoolean(6, terminated);

            cl.executeUpdate();

            Customer customer = new Customer();
            String customerName = customer.getName(customerID);

            messages.infoMessage(customerName + " have ordered box: " + boxID);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOrder(int orderID, int customerID, int boxID, String createdBy, Date startDate, Date endDate, boolean terminated) {
        try {
            CallableStatement cl = db.callableStatement("{call update_Order(?, ?, ?, ?, ?, ?, ?)}");

            cl.setInt(1, orderID);
            cl.setInt(2, customerID);
            cl.setInt(3, boxID);
            cl.setString(4, createdBy);
            cl.setDate(5, startDate);
            cl.setDate(6, endDate);
            cl.setBoolean(7, terminated);

            cl.executeUpdate();

            Customer customer = new Customer();
            String customerName = customer.getName(customerID);

            messages.infoMessage("Order number: " + customerID + " for customer: " + customerName + " have been updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder(int orderID) {
        try {
            CallableStatement cl = db.callableStatement("{call delete_Order(?)}");

            cl.setInt(1, orderID);

            cl.executeUpdate();

            messages.infoMessage("Customer number: " + orderID + " have been deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
