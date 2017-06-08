package Domain;

import Tech.DBFacade;

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

    public CustomerController(String name, String email, String phone, String address, int zip) {
        this.db = new DBFacade();

        this.db.createCustomer(name, email, zip, address, phone);

        this.customerModel = db.getCustomer(email);
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
}
