package Domain;

import Tech.DBFacade;
import java.sql.Date;

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


}

