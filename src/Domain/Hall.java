package Domain;

/**
 * Created by Jacob on 06-06-2017.
 */
public class Hall {
    private int hallID;
    private String description;
    private int zip;
    private String address;
    private String city;

    public Hall(int hallID, String description, int zip, String address, String city) {
        this.hallID = hallID;
        this.description = description;
        this.zip = zip;
        this.address = address;
        this.city = city;
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

    public String getCity() {
        return city;
    }
}
