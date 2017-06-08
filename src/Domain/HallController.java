package Domain;

import Tech.DBFacade;

/**
 * Created by Jacob on 08-06-2017.
 */
public class HallController {
    private Hall hallModel;
    private DBFacade db;

    public HallController(int hallID) {
        this.db = new DBFacade();

        this.hallModel = this.db.getHall(hallID);
    }

    public HallController(int hallID,String description, int zip, String address) {
        this.db = new DBFacade();

        this.db.createHall(hallID, description, zip, address);

        this.hallModel = this.db.getHall(hallID);
    }

    public int getHallID() {
        return this.hallModel.getHallID();
    }

    public String getHallDescription() {
        return this.hallModel.getDescription();
    }

    public int getHallZip() {
        return this.hallModel.getZip();
    }

    public String getHallAddress() {
        return this.hallModel.getAddress();
    }

}
