package Domain;

import Tech.DBFacade;
import java.sql.Date;
import java.util.List;

/**
 * Created by Andersen on 08/06/2017.
 */
public class OrderController {

    private Order orderModel;
    private DBFacade db;

    public OrderController(int orderId){
        this.db = new DBFacade();

        this.orderModel = db.getOrder(orderId);
    }

    public OrderController(){
        this.db = new DBFacade();
    }

    public void createOrder(int customerID, int boxID, Date startDate, Date endDate){

        db.createOrder(customerID,boxID,startDate,endDate);
    }

    public void updateOrder (int orderID, int customerID, int boxID, String createdBy, Date startDate, Date endDate, boolean terminated){

        db.updateOrder(orderID, customerID, boxID,  createdBy, startDate,  endDate, terminated);
    }

    public void deleteOrder (int orderID){

        db.deleteOrder(orderID);
    }

    public int getCustomerId(){
        return orderModel.getCustomerID();
    }

    public int getBoxId(){
        return orderModel.getCustomerID();
    }

    public String getCreatedBy(){
        return orderModel.getCreatedBy();
    }

    public Date getStartDate(){
        return orderModel.getStartDate();
    }

    public Date getEndDate(){
        return orderModel.getEndDate();
    }

    public boolean getTerminated(){
        return orderModel.isTerminated();
    }

    public List<Order> getAllOrders() {
        return db.getAllOrders();
    }
}

