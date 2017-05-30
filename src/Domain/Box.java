package Domain;

import Tech.DBFacade;
import Tech.Messages;

import java.math.BigDecimal;
import java.sql.CallableStatement;
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
                CallableStatement cl = db.callableStatement("{call insertBox(?, ?, ?)}");

                cl.setInt(1, boxID);
                cl.setInt(2, size);
                cl.setBigDecimal(3, price);

                cl.executeUpdate();

                messages.infoMessage("Box: " + boxID + " have been created with size: " + size);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            messages.errorMessage("The box size have to be between 1 and 6");
        }
    }
}
