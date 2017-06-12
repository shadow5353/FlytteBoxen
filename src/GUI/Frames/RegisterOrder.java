package GUI.Frames;

import Domain.Customer;
import Domain.CustomerController;
import Domain.Order;
import Domain.OrderController;
import Tech.Messages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

/**
 * Created by Jacob on 07-06-2017.
 */
public class RegisterOrder extends JFrame {
    private JTextField addressField, nameField, phoneField, postalCodeField, searchField, emailField;
    private JButton createCustomerAndOrderButton, createOrderButton, searchButton;
    private JLabel searchFieldLabel, addressFieldLabel, customerInfoAddressLabel, customerInfoEmailLabel, customerInfoHeading,
            customerInfoIDLabel, customerInfoNameLabel, customerInfoPhoneLabel, customerInfoPostalCodeLabel, emailFieldLabel,
            nameFieldLabel, phoneFieldLabel, postalCodeFieldLabel;
    private JPanel existingCustomer, newCustomerPanel;
    private JTabbedPane jTabbedPane1;
    private int boxNumber;
    private int customerID;
    private Date date;
    private OrderController orderController;
    private CustomerController customerController;
    private Messages messages;


    /**
     * Creates new form RegisterOrder
     */
    public RegisterOrder(int boxNumber, Date date) {
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                screenSize.width - inset * 2,
                screenSize.height - inset * 2);

        this.boxNumber = boxNumber;
        this.date = date;

        this.customerController = new CustomerController();
        this.orderController = new OrderController();

        messages = new Messages();

        initComponents();
    }

    private void createCustomer() {
        createCustomerAndOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameField.getText().isEmpty()) {
                    messages.errorMessage("Du skal indtaste kundens navn!");
                } else if (emailField.getText().isEmpty()) {
                    messages.errorMessage("Du skal indtaste kundens email!");
                } else if (phoneField.getText().isEmpty()) {
                    messages.errorMessage("Du skal indtaste kundens telefon nummer!");
                } else if (addressField.getText().isEmpty()) {
                    messages.errorMessage("Du skal indtaste kundens adresse!");
                } else if (postalCodeField.getText().isEmpty()) {
                    messages.errorMessage("Du skal indtaste kundens post nummer!");
                } else {
                    try {
                        String name = nameField.getText();
                        String address = addressField.getText();
                        int postalCode = Integer.parseInt(postalCodeField.getText());
                        String phone = phoneField.getText();
                        String email = emailField.getText();

                        customerController.createCustomer(name, address, postalCode, phone, email);

                        customerID = new CustomerController(email).getCustomerID();

                        orderBox();

                        messages.infoMessage(name + " er blevet oprettet som kunde!");
                    } catch (NumberFormatException ex) {
                        messages.errorMessage("Du skal indtaste kundens post nummer!");
                    }
                }
            }
        });
    }

    private void createOrderFromExisting() {
        createOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderBox();
            }
        });
    }

    private void searchForCustomer() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(searchField.getText().isEmpty())) {
                    String email = searchField.getText();

                    CustomerController oldCustomer = new CustomerController();

                    if(oldCustomer.customerExists(email)) {

                        oldCustomer = new CustomerController(email);

                        customerID = oldCustomer.getCustomerID();
                        String name = oldCustomer.getCustomerName();
                        String phone = oldCustomer.getCustomerPhone();
                        String address = oldCustomer.getCustomerAddress();
                        int zip = oldCustomer.getCustomerZip();

                        customerInfoHeading.setText("Kunde Informationer");

                        customerInfoIDLabel.setText("Kunde ID: " + customerID);
                        customerInfoNameLabel.setText("Navn: " + name);
                        customerInfoEmailLabel.setText("Email: " + email);
                        customerInfoPhoneLabel.setText("Telefon: " + phone);
                        customerInfoAddressLabel.setText("Adresse: " + address);
                        customerInfoPostalCodeLabel.setText("Post nummer: " + zip);

                        customerInfoIDLabel.setVisible(true);
                        customerInfoHeading.setVisible(true);
                        customerInfoNameLabel.setVisible(true);
                        customerInfoEmailLabel.setVisible(true);
                        customerInfoPhoneLabel.setVisible(true);
                        customerInfoAddressLabel.setVisible(true);
                        customerInfoPostalCodeLabel.setVisible(true);
                    } else {
                        messages.errorMessage("Der findes ingen kunde med denne email: " + email);
                    }
                } else {
                    messages.errorMessage("Du skal indtaste en email, for kunden du leder efter!");
                }
            }
        });
    }

    private void orderBox() {
        orderController.createOrder(customerID, boxNumber, date, null);

        dispose();
    }

    private void initComponents() {

        jTabbedPane1 = new JTabbedPane();
        newCustomerPanel = new JPanel();
        nameField = new JTextField();
        nameFieldLabel = new JLabel();
        addressField = new JTextField();
        addressFieldLabel = new JLabel();
        postalCodeFieldLabel = new JLabel();
        postalCodeField = new JTextField();
        phoneField = new JTextField();
        phoneFieldLabel = new JLabel();
        emailFieldLabel = new JLabel();
        emailField = new JTextField();
        createCustomerAndOrderButton = new JButton();
        existingCustomer = new JPanel();
        searchField = new JTextField();
        searchFieldLabel = new JLabel();
        searchButton = new JButton();
        customerInfoNameLabel = new JLabel();
        customerInfoHeading = new JLabel();
        customerInfoAddressLabel = new JLabel();
        customerInfoPostalCodeLabel = new JLabel();
        customerInfoEmailLabel = new JLabel();
        customerInfoPhoneLabel = new JLabel();
        customerInfoIDLabel = new JLabel();
        createOrderButton = new JButton();

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        ImageIcon img = new ImageIcon(getClass().getResource("/Pictures/logo.png"));

        this.setIconImage(img.getImage());

        this.setTitle("Opret bestilling for box " + boxNumber);

        nameFieldLabel.setText("Navn");

        addressFieldLabel.setText("Adresse");

        postalCodeFieldLabel.setText("Post Nummer");

        phoneFieldLabel.setText("Telefon Nummer");

        emailFieldLabel.setText("Email Adresse");

        createCustomerAndOrderButton.setText("Opret Kunde og Bestilling");

        createCustomer();
        searchForCustomer();
        createOrderFromExisting();

        javax.swing.GroupLayout newCustomerPanelLayout = new javax.swing.GroupLayout(newCustomerPanel);
        newCustomerPanel.setLayout(newCustomerPanelLayout);
        newCustomerPanelLayout.setHorizontalGroup(
                newCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(newCustomerPanelLayout.createSequentialGroup()
                                .addContainerGap(270, Short.MAX_VALUE)
                                .addGroup(newCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(emailFieldLabel)
                                        .addComponent(phoneFieldLabel)
                                        .addComponent(postalCodeFieldLabel)
                                        .addComponent(addressFieldLabel)
                                        .addComponent(nameFieldLabel)
                                        .addComponent(nameField)
                                        .addComponent(addressField)
                                        .addComponent(postalCodeField)
                                        .addComponent(phoneField)
                                        .addComponent(emailField)
                                        .addComponent(createCustomerAndOrderButton, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                                .addContainerGap(271, Short.MAX_VALUE))
        );
        newCustomerPanelLayout.setVerticalGroup(
                newCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(newCustomerPanelLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(nameFieldLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addressFieldLabel)
                                .addGap(5, 5, 5)
                                .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(postalCodeFieldLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(postalCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(phoneFieldLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(emailFieldLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(createCustomerAndOrderButton)
                                .addGap(38, 38, 38))
        );

        jTabbedPane1.addTab("Ny Kunde", newCustomerPanel);

        searchFieldLabel.setText("Indtast Email");

        searchButton.setText("Søg Efter Kunde");

        createOrderButton.setText("Opret Bestilling");

        customerInfoHeading.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N


        javax.swing.GroupLayout existingCustomerLayout = new javax.swing.GroupLayout(existingCustomer);
        existingCustomer.setLayout(existingCustomerLayout);
        existingCustomerLayout.setHorizontalGroup(
                existingCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, existingCustomerLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(existingCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(searchFieldLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(existingCustomerLayout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addGroup(existingCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(createOrderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(existingCustomerLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(existingCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(customerInfoIDLabel)
                                        .addComponent(customerInfoPhoneLabel)
                                        .addComponent(customerInfoEmailLabel)
                                        .addComponent(customerInfoPostalCodeLabel)
                                        .addComponent(customerInfoAddressLabel)
                                        .addComponent(customerInfoHeading)
                                        .addComponent(customerInfoNameLabel))
                                .addContainerGap(523, Short.MAX_VALUE))
        );
        existingCustomerLayout.setVerticalGroup(
                existingCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(existingCustomerLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(searchFieldLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchButton)
                                .addGap(29, 29, 29)
                                .addComponent(customerInfoHeading)
                                .addGap(18, 18, 18)
                                .addComponent(customerInfoIDLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(customerInfoNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(customerInfoAddressLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(customerInfoPostalCodeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(customerInfoEmailLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(customerInfoPhoneLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(createOrderButton)
                                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Eksisterende Kunde", existingCustomer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );

    }

}