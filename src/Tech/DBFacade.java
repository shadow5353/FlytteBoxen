package Tech;

import Domain.Box;
import Domain.Customer;

import java.math.BigDecimal;
import java.sql.*;

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
            CallableStatement cl = this.callableStatement("{call add_Customer(?, ?, ?, ?, ?, ?)}");

            cl.setString(1, name);
            cl.setString(2, address);
            cl.setInt(3, zip);
            cl.setString(4, phone);
            cl.setString(5, email);

            cl.executeUpdate();

            messages.infoMessage("Customer: " + name + " have been created!");
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

    public void updateCustomer(int customerID, String name, String address, int zip, String town, String phone, String email) {
        try {
            CallableStatement cl = this.callableStatement("{call update_Customer(?, ?, ?, ?, ?, ?, ?, ?, ?}");

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

    public Customer getCustomer(int customerID) {
        try {
            CallableStatement cl = this.callableStatement("{call show_CustomerID(?)");

            cl.setInt(1, customerID);

            ResultSet rs = cl.executeQuery();

            if (rs.next()) {
                String name = rs.getString("fld_Name");
                String email = rs.getString("fld_Email");
                String phone = rs.getString("fld_Phone");
                String address = rs.getString("fld_Address");
                int zip = rs.getInt("fld_Zip");

                Customer customer = new Customer(name, email, phone, address, zip);

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
            CallableStatement cl = this.callableStatement("{call show_CustomerEmail(?)");

            cl.setString(1, customerEmail);

            ResultSet rs = cl.executeQuery();

            if (rs.next()) {
                String name = rs.getString("fld_Name");
                String email = rs.getString("fld_Email");
                String phone = rs.getString("fld_Phone");
                int zip = rs.getInt("fld_Zip");
                String address = rs.getString("fld_Address");

                Customer customer = new Customer(name, email, phone, address, zip);

                return customer;
            } else {
                messages.errorMessage("Der findes ingen kunde med email: " + customerEmail + "!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Box

    public void createBox(int boxID, int size, BigDecimal price, int hallID, int gate) {
        if (size <= 1 && size >= 6) {
            try {
                boolean exists = boxExists(boxID);

                if(exists) {

                    CallableStatement cl = this.callableStatement("{call insertBox(?, ?, ?, ?, ?)}");

                    cl.setInt(1, boxID);
                    cl.setInt(2, size);
                    cl.setBigDecimal(3, price);
                    cl.setInt(4, hallID);
                    cl.setInt(5, gate);

                    cl.executeUpdate();

                    messages.infoMessage("Box: " + boxID + " have been created with size: " + size);

                } else {
                    messages.errorMessage("This box: " + boxID + " already exists!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            messages.errorMessage("The box size have to be between 1 and 6");
        }
    }

    private boolean boxExists(int boxID) {
        try {
            PreparedStatement ps = this.preparedStatement("SELECT * FROM tbl_Box WHERE fld_BoxId = ?");

            ps.setInt(1, boxID);

            ResultSet rs = ps.executeQuery();

            if(!(rs.next())) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void removeBox(int boxID) {
        try {
            CallableStatement cl = this.callableStatement("{call delete_Box(?)");

            cl.setInt(1, boxID);

            cl.executeUpdate();

            messages.infoMessage("Box number: " + boxID + " have been removed!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBox(int boxID, int boxSize, BigDecimal price) {
        try {
            CallableStatement cl = this.callableStatement("{call update_Box(?, ?, ?");

            cl.setInt(1, boxID);
            cl.setInt(2, boxSize);
            cl.setBigDecimal(3, price);

            cl.executeUpdate();

            messages.infoMessage("Box: " + boxID + " have been updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Box getBox(int boxID) {
        try {
            CallableStatement cl = this.callableStatement("{show_Box(?)}");

            cl.setInt(1, boxID);

            ResultSet rs = cl.executeQuery();

            if (rs.next()) {
                int size = rs.getInt("fld_Size");
                BigDecimal price = rs.getBigDecimal("fld_price");
                int hallID = rs.getInt("fld_hallId");
                int gate = rs.getInt("fld_Gate");

                Box box = new Box(size, price, hallID, gate);

                return box;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Hall

    public void createHall(int hallID, String description, int zip, String address) {
        if(!checkExists(hallID)) {
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
        if(checkExists(hallID)) {

        } else {
            messages.errorMessage("Hal " + hallID + " findes ikke!");
        }
    }

    private boolean checkExists(int hallID) {
        try {
            PreparedStatement ps = this.preparedStatement("SELECT * FROM tbl_Hall WHERE fld_HallId = ?");

            ps.setInt(1, hallID);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
