package Tech;

import Domain.Box;
import Domain.Customer;
import Domain.Hall;
import Domain.Order;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBFacade {
    private String userName, password, port, databaseName;
    private Messages messages;
    private Connection connection;
    private PreparedStatement ps;
    private CallableStatement cl;

    public DBFacade() {
        userName = "sa";
        password = "987654321";
        port = "1433";
        databaseName = "DB_FlytteBoxen";

        messages = new Messages();

        openConnection();
    }

    /**
     * Open the connection for the database
     */
    private void openConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:" + port + ";databaseName=" + databaseName, userName, password);
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Makes a prepared Statement
     *
     * @param sql the sql code
     * @return the prepared statement
     * @throws SQLException
     */
    private PreparedStatement preparedStatement(String sql) throws SQLException {
        ps = connection.prepareStatement(sql);

        return ps;
    }

    /**
     * Makes a callable statement
     *
     * @param sql the sql code
     * @return the callable statement
     * @throws SQLException
     */
    private CallableStatement callableStatement(String sql) throws SQLException {
        cl = connection.prepareCall(sql);

        return cl;
    }

    // Customer

    public void createCustomer(String name, String address, int zip, String phone, String email) {
        try {
            CallableStatement cl = this.callableStatement("{call add_Customer(?, ?, ?, ?, ?)}");

            cl.setString(1, name);
            cl.setString(2, address);
            cl.setInt(3, zip);
            cl.setString(4, phone);
            cl.setString(5, email);

            cl.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeCustomer(int customerID) {
        try {
            CallableStatement cl = this.callableStatement("{call delete_Customer(?)}");

            cl.setInt(1, customerID);

            cl.executeUpdate();

            messages.infoMessage("Customer with ID: " + customerID + " have been remove!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(int customerID, String name, String address, int zip, String phone, String email) {
        try {
            CallableStatement cl = this.callableStatement("{call update_Customer(?, ?, ?, ?, ?, ?, ?, ?)}");

            cl.setInt(1, customerID);
            cl.setString(2, name);
            cl.setString(3, address);
            cl.setInt(4, zip);
            cl.setString(5, phone);
            cl.setString(6, email);

            cl.executeUpdate();

            messages.infoMessage("Customer " + name + " have been updated!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomer(int customerID) {
        try {
            CallableStatement cl = this.callableStatement("{call show_CustomerID(?)}");

            cl.setInt(1, customerID);

            ResultSet rs = cl.executeQuery();

            if (rs.next()) {
                String name = rs.getString("fld_Name");
                String email = rs.getString("fld_Email");
                String phone = rs.getString("fld_Phone");
                String address = rs.getString("fld_Address");
                int zip = rs.getInt("fld_Zip");

                Customer customer = new Customer(customerID, name, email, phone, address, zip);

                return customer;
            } else {
                messages.errorMessage("Denne kunde findes ikke!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Customer getCustomer(String customerEmail) {
        try {
            CallableStatement cl = this.callableStatement("{call show_CustomerEmail(?)}");

            cl.setString(1, customerEmail);

            ResultSet rs = cl.executeQuery();

            if (rs.next()) {
                int customerID = rs.getInt("fld_CustomerId");
                String name = rs.getString("fld_Name");
                String email = rs.getString("fld_Email");
                String phone = rs.getString("fld_Phone");
                int zip = rs.getInt("fld_Zip");
                String address = rs.getString("fld_Address");

                Customer customer = new Customer(customerID, name, email, phone, address, zip);

                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean customerExists(String email) {
        try {
            PreparedStatement ps = this.preparedStatement("SELECT * FROM tbl_Customer WHERE fld_Email = ?");

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Box

    public void createBox(int boxID, int size, BigDecimal price, int hallID, int gate) {
        try {
            boolean exists = boxExists(boxID);

            if (!(exists)) {

                CallableStatement cl = this.callableStatement("{call add_Box(?, ?, ?, ?, ?)}");

                cl.setInt(1, boxID);
                cl.setInt(2, size);
                cl.setBigDecimal(3, price);
                cl.setInt(4, hallID);
                cl.setInt(5, gate);

                cl.executeUpdate();

                messages.infoMessage("Boks: " + boxID + " er blevet oprettet med størrelse: " + size);

            } else {
                messages.errorMessage("Boks: " + boxID + " eksistere allerede!");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    private boolean boxExists(int boxID) {
        try {
            PreparedStatement ps = this.preparedStatement("SELECT * FROM tbl_Box WHERE fld_BoxId = ?");

            ps.setInt(1, boxID);

            ResultSet rs = ps.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void removeBox(int boxID) {
        try {
            CallableStatement cl = this.callableStatement("{call delete_Box(?)}");

            cl.setInt(1, boxID);

            cl.executeUpdate();

            messages.infoMessage("Box number: " + boxID + " have been removed!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBox(int boxID, int boxSize, BigDecimal price, int hallID, int gate) {
        try {
            CallableStatement cl = this.callableStatement("{call update_Box(?, ?, ?, ?, ?)}");

            cl.setInt(1, boxID);
            cl.setInt(2, boxSize);
            cl.setBigDecimal(3, price);
            cl.setInt(4, hallID);
            cl.setInt(5, gate);

            cl.executeUpdate();

            messages.infoMessage("Boks: " + boxID + " er blevet opdateret!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Box getBox(int boxID) {
        try {
            CallableStatement cl = this.callableStatement("{call show_Box(?)}");

            cl.setInt(1, boxID);

            ResultSet rs = cl.executeQuery();

            if (rs.next()) {
                int size = rs.getInt("fld_Size");
                BigDecimal price = rs.getBigDecimal("fld_price");
                int hallID = rs.getInt("fld_hallId");
                int gate = rs.getInt("fld_Gate");

                Box box = new Box(boxID, size, price, hallID, gate);

                return box;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Box> getAvailableBoxes(int size, Date startDate) {
        try {
            List<Box> boxes = new ArrayList<>();
            CallableStatement cl = this.callableStatement("{call availableBoxes(?, ?)}");

            cl.setDate(1, startDate);
            cl.setInt(2, size);

            ResultSet rs = cl.executeQuery();

            while (rs.next()) {
                int boxNumber = rs.getInt("fld_BoxId");
                int hallID = rs.getInt("fld_HallId");
                BigDecimal price = rs.getBigDecimal("fld_Price");
                int gate = rs.getInt("fld_Gate");

                boxes.add(new Box(boxNumber, size, price, hallID, gate));
            }

            return boxes;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Box> getBoxes() {
        try {
            List<Box> boxes = new ArrayList<>();
            CallableStatement cl = this.callableStatement("{call showAll_Box()}");

            ResultSet rs = cl.executeQuery();

            while (rs.next()) {
                int boxNumber = rs.getInt("fld_BoxId");
                int size = rs.getInt("fld_Size");
                BigDecimal price = rs.getBigDecimal("fld_Price");
                int gate = rs.getInt("fld_Gate");
                int hallID = rs.getInt("fld_HallId");


                boxes.add(new Box(boxNumber, size, price, hallID, gate));
            }

            return boxes;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Hall

    public void createHall(int hallID, String description, int zip, String address) {
        if (!checkExists(hallID)) {
            try {
                CallableStatement cl = this.callableStatement("{call add_Hall(?, ?, ?, ?)}");

                cl.setInt(1, hallID);
                cl.setString(2, description);
                cl.setInt(3, zip);
                cl.setString(4, address);

                int rows = cl.executeUpdate();

                if (rows == 1) {
                    messages.infoMessage("Hal Nummer: " + hallID + " er blevet oprettet!");

                } else {
                    messages.errorMessage("Der skete en fejl med oprettelsen af hal nummer: " + hallID + "!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            messages.errorMessage("Hal " + hallID + " findes allerede!");
        }
    }

    public void deleteHall(int hallID) {
        if (checkExists(hallID)) {
            try {
                CallableStatement cl = this.callableStatement("{call delete_Hall(?)}");

                cl.setInt(1, hallID);

                cl.executeUpdate();

                messages.infoMessage("Hal " + hallID + " er blevet fjernet!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            messages.errorMessage("Hal " + hallID + " findes ikke!");
        }
    }

    public Hall getHall(int hallID) {
        try {
            CallableStatement cl = this.callableStatement("{show_Hall(?)}");

            cl.setInt(1, hallID);

            ResultSet rs = cl.executeQuery();

            if (rs.next()) {
                String description = rs.getString("fld_Description");
                int zip = rs.getInt("fld_Zip");
                String address = rs.getString("fld_Address");

                Hall hall = new Hall(hallID, description, zip, address);

                return hall;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void updateHall(int hallID, String description, int zip, String address) {
        try {
            if (checkExists(hallID)) {
                CallableStatement cl = this.callableStatement("{update_Hall(?, ?, ?, ?)}");

                cl.setInt(1, hallID);
                cl.setString(2, description);
                cl.setInt(3, zip);
                cl.setString(4, address);

                cl.executeUpdate();

                messages.infoMessage("Hal " + hallID + " er blevet opdateret!");
            } else {
                messages.errorMessage("Hal " + hallID + " findes ikke!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean checkExists(int hallID) {
        try {
            PreparedStatement ps = this.preparedStatement("SELECT * FROM tbl_Hall WHERE fld_HallId = ?");

            ps.setInt(1, hallID);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Order

    public void createOrder(int customerID, int boxID, Date startDate, Date endDate) {
        try {
            CallableStatement cl = this.callableStatement("{call add_Order(?, ?, ?, ?, ?, ?)}");

            String createdBy = System.getProperty("user.name");
            boolean terminated = false;

            cl.setInt(1, customerID);
            cl.setInt(2, boxID);
            cl.setString(3, createdBy);
            cl.setDate(4, startDate);
            cl.setDate(5, endDate);
            cl.setBoolean(6, terminated);

            cl.executeUpdate();

            Customer customer = this.getCustomer(customerID);

            String customerName = customer.getName();

            messages.infoMessage(customerName + " have ordered box: " + boxID);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOrder(int orderID, int customerID, int boxID, String createdBy, Date startDate, Date endDate, boolean terminated) {
        try {
            CallableStatement cl = this.callableStatement("{call update_Order(?, ?, ?, ?, ?, ?, ?)}");

            cl.setInt(1, orderID);
            cl.setInt(2, customerID);
            cl.setInt(3, boxID);
            cl.setString(4, createdBy);
            cl.setDate(5, startDate);
            cl.setDate(6, endDate);
            cl.setBoolean(7, terminated);

            cl.executeUpdate();

            Customer customer = this.getCustomer(customerID);

            String customerName = customer.getName();

            messages.infoMessage("Order number: " + customerID + " for customer: " + customerName + " have been updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder(int orderID) {
        try {
            CallableStatement cl = this.callableStatement("{call delete_Order(?)}");

            cl.setInt(1, orderID);

            cl.executeUpdate();

            messages.infoMessage("Customer number: " + orderID + " have been deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Order getOrder(int orderID) {
        try {
            CallableStatement cl = this.callableStatement("{call show_Order(?)}");

            cl.setInt(1, orderID);

            ResultSet rs = cl.executeQuery();

            if (rs.next()) {
                int customerID = rs.getInt("fld_CustomerId");
                int boxID = rs.getInt("fld_BoxId");
                String createdBy = rs.getString("fld_CreatedBy");
                Date startedDate = rs.getDate("fld_StartDate");
                Date endDate = rs.getDate("fld_EndDate");
                boolean terminated = rs.getBoolean("fld_Terminated");

                Order order = new Order(customerID, boxID, createdBy, startedDate, endDate, terminated);

                return order;
            } else {
                messages.errorMessage("Denne ordre findes ikke!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
