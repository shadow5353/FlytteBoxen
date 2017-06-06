package Domain;

import Tech.DBFacade;
import Tech.Messages;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jacob on 06-06-2017.
 */
public class Hall {
    private DBFacade db;
    private Messages messages;

    public Hall() {
        db = new DBFacade();
        messages = new Messages();
    }

    public void createHall(int hallID, String description, int zip, String address) {
        if(!checkExists(hallID)) {
            try {
                CallableStatement cl = db.callableStatement("{call add_Hall(?, ?, ?, ?)}");

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

    private boolean checkExists(int hallID) {
        try {
            PreparedStatement ps = db.preparedStatement("SELECT * FROM tbl_Hall WHERE fldHallId = ?");

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
