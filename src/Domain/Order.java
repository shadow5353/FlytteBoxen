package Domain;

import java.sql.Date;

public class Order {
    private int OrderID;
    private int customerID;
    private int boxID;
    private String createdBy;
    private Date startDate;
    private Date endDate;
    private boolean terminated;

    public Order(int customerID, int boxID, String createdBy, Date startDate, Date endDate, boolean terminated) {
        this.customerID = customerID;
        this.boxID = boxID;
        this.createdBy = createdBy;
        this.startDate = startDate;
        this.endDate = endDate;
        this.terminated = terminated;
    }

    public Order(int orderID, int customerID, int boxID, String createdBy, Date startDate, Date endDate, boolean terminated) {
        OrderID = orderID;
        this.customerID = customerID;
        this.boxID = boxID;
        this.createdBy = createdBy;
        this.startDate = startDate;
        this.endDate = endDate;
        this.terminated = terminated;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getBoxID() {
        return boxID;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean isTerminated() {
        return terminated;
    }

    public int getOrderID() {
        return OrderID;
    }
}
