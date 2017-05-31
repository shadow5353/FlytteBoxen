package Domain;

import Tech.DBFacade;
import Tech.Messages;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Box {
    private DBFacade db;
    private Messages messages;

    public Box() {
        db = new DBFacade();
        messages = new Messages();
    }

    public void createBox(int boxID, int size, BigDecimal price) {
        if (size <= 1 && size >= 6) {
            try {
                boolean exists = boxExists(boxID);

                if(exists) {

                    CallableStatement cl = db.callableStatement("{call insertBox(?, ?, ?)}");

                    cl.setInt(1, boxID);
                    cl.setInt(2, size);
                    cl.setBigDecimal(3, price);

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

    public void removeBox(int boxID) {
        try {
            CallableStatement cl = db.callableStatement("{call delete_Box(?)");

            cl.setInt(1, boxID);

            cl.executeUpdate();

            messages.infoMessage("Box number: " + boxID + " have been removed!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBox(int boxID, int boxSize, BigDecimal price) {
        try {
            CallableStatement cl = db.callableStatement("{call update_Box(?, ?, ?");

            cl.setInt(1, boxID);
            cl.setInt(2, boxSize);
            cl.setBigDecimal(3, price);

            cl.executeUpdate();

            messages.infoMessage("Box: " + boxID + " have been updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean boxExists(int boxID) {
        try {
            PreparedStatement ps = db.preparedStatement("SELECT * FROM tbl_Box WHERE fld_BoxId = ?");

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
}
