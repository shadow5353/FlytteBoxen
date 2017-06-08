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
}
