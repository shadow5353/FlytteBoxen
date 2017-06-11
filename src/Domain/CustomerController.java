package Domain;

import Tech.DBFacade;

import javax.print.attribute.standard.Chromaticity;
import java.util.List;

/**
 * Created by Jacob on 08-06-2017.
 */
public class CustomerController {
    private Customer customerModel;
    private DBFacade db;

    public CustomerController(int customerID) {
        this.db = new DBFacade();

        this.customerModel = db.getCustomer(customerID);
    }

    public CustomerController(String email) {
        this.db = new DBFacade();

        this.customerModel = db.getCustomer(email);
    }

    public CustomerController() {
        this.db = new DBFacade();
    }

    public void createCustomer(String name, String address, int zip, String phone, String email) {
        this.db.createCustomer(name, address, zip, phone, email);
    }

    public void updateCustomer(int customerID, String name, String address, int zip, String phone, String email) {
        this.db.updateCustomer(customerID ,name, address, zip, phone, email);
    }

    public void removeCustomer(int customerID) {
        this.db.removeCustomer(customerID);
    }

    public boolean customerExists(String email) {
        return db.customerExists(email);
    }

    public int getCustomerID() {
        return this.customerModel.getCustomerID();
    }

    public String getCustomerName() {
        return this.customerModel.getName();
    }

    public String getCustomerEmail() {
        return this.customerModel.getEmail();
    }

    public String getCustomerPhone() {
        return this.customerModel.getPhone();
    }

    public String getCustomerAddress() {
        return this.customerModel.getAddress();
    }

    public int getCustomerZip() {
        return this.customerModel.getZip();
    }

    public String getCustomerCity() {
        return this.customerModel.getCity();
    }

    public List<Customer> getAllCustomers(){
        return db.getAllCustomers();
    }
}
