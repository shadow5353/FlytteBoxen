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
    private String description;
    private int zip;
    private String address;

    public Hall(String description, int zip, String address) {
        this.description = description;
        this.zip = zip;
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public int getZip() {
        return zip;
    }

    public String getAddress() {
        return address;
    }
}
