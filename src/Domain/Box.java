package Domain;

import java.math.BigDecimal;

public class Box {
    private int size;
    private BigDecimal price;
    private int hallID;
    private int gate;

    public Box(int size, BigDecimal price, int hallID, int gate) {
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
}
