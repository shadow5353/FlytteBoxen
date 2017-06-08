package Domain;

import java.math.BigDecimal;

public class Box {
    private int boxID;
    private int size;
    private BigDecimal price;
    private int hallID;
    private int gate;

    public Box(int boxID, int size, BigDecimal price, int hallID, int gate) {
        this.boxID = boxID;
        this.size = size;
        this.price = price;
        this.hallID = hallID;
        this.gate = gate;
    }

    public int getSize() {
        return size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getHallID() {
        return hallID;
    }

    public int getGate() {
        return gate;
    }

    public int getBoxID() {
        return boxID;
    }
}
