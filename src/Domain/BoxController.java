package Domain;

import Tech.DBFacade;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * Created by Jacob on 08-06-2017.
 */
public class BoxController {
    private Box boxModel;
    private DBFacade db;

    public BoxController(int boxID) {
        this.db = new DBFacade();

        this.boxModel = db.getBox(boxID);
    }

    public BoxController() {
        this.db = new DBFacade();
    }

    public int getBoxSize() {
        return this.boxModel.getSize();
    }

    public BigDecimal getBoxPrice() {
        return this.boxModel.getPrice();
    }

    public int getBoxHall() {
        return this.boxModel.getHallID();
    }

    public int getBoxGate() {
        return this.boxModel.getGate();
    }

    public int getBoxID() {
        return this.boxModel.getBoxID();
    }

    public void createBox(int boxID, int size, BigDecimal price, int hallID, int gate) {
        db.createBox(boxID, size, price, hallID, gate);
    }

    public void updateBox(int boxID, int size, BigDecimal price, int hallID, int gate) {
        db.updateBox(boxID, size, price, hallID, gate);
    }

    public void removeBox(int boxID) {
        db.removeBox(boxID);
    }

    public List<Box> getAvailableBoxes(int size, Date startDate) {
        return db.getAvailableBoxes(size, startDate);
    }

    public List<Box> getBoxes() {
        return db.getBoxes();
    }
}
