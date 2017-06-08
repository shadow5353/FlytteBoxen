package Domain;

/**
 * Created by Jacob on 06-06-2017.
 */
public class Hall {
    private int hallID;
    private String description;
    private int zip;
    private String address;

    public Hall(int hallID, String description, int zip, String address) {
        this.hallID = hallID;
        this.description = description;
        this.zip = zip;
        this.address = address;
    }

    public int getHallID() {
        return hallID;
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
