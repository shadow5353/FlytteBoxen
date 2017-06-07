package GUI.Frames;

import Domain.Customer;
import Domain.Order;
import Tech.Messages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

/**
 * Created by Jacob on 07-06-2017.
 */
public class RegisterOrder extends javax.swing.JFrame {
    private JTextField addressField, nameField, phoneField, postalCodeField, searchField, emailField;
    private JButton createCustomerAndOrderButton, createOrderButton, searchButton;
    private JLabel searchFieldLabel, addressFieldLabel, customerInfoAddressLabel, customerInfoEmailLabel, customerInfoHeading,
            customerInfoIDLabel, customerInfoNameLabel, customerInfoPhoneLabel, customerInfoPostalCodeLabel, emailFieldLabel,
            nameFieldLabel, phoneFieldLabel, postalCodeFieldLabel;
    private JPanel existingCustomer, newCustomerPanel;
    private JTabbedPane jTabbedPane1;
    private int boxNumber;
    private Date date;
    private int customerID;
    private Customer customer;
    private Order order;
    private Messages messages;


    /**
     * Creates new form RegisterOrder
     */
    public RegisterOrder(int boxNumber, Date date) {
        initComponents();

        customer = new Customer();
        order = new Order();
        messages = new Messages();

        this.boxNumber = boxNumber;
        this.date = date;
    }

    private void createCustomer() {
        createCustomerAndOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameField.getText().isEmpty()) {
                    messages.errorMessage("Du skal indtaste kundens navn!");
                } else if (emailField.getText().isEmpty()) {
                    messages.errorMessage("Du skal indtaste kundens email!");
                } else if (phoneField.getText().isEmpty()){
                    messages.errorMessage("Du skal indtaste kundens telefon nummer!");
                } else if (addressField.getText().isEmpty()){
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

                        customer.createCustomer(name, address, postalCode, phone, email);

                        customerID = customer.getCustomerID(email);

                        messages.infoMessage(name + " er blevet oprettet som kunde!");
                    } catch (NumberFormatException ex) {
                        messages.errorMessage("Du skal indtaste kundens post nummer!");
                    }
                }
            }
        });
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

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        nameFieldLabel.setText("Navn");

        addressFieldLabel.setText("Adresse");

        postalCodeFieldLabel.setText("Post Nummer");

        phoneFieldLabel.setText("Telefon Nummer");

        emailFieldLabel.setText("Email Adresse");

        createCustomerAndOrderButton.setText("Opret Kunde og Bestilling");

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

        searchFieldLabel.setText("Indtast Email eller Telefon Nummer");

        searchButton.setText("Søg Efter Kunde");

        customerInfoNameLabel.setText("Navn: [Name]");

        customerInfoHeading.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        customerInfoHeading.setText("Kunde Informationer");

        customerInfoAddressLabel.setText("Adresse: [Address]");

        customerInfoPostalCodeLabel.setText("Post Nummer: [PostalCode]");

        customerInfoEmailLabel.setText("Email Adresse: [Email]");

        customerInfoPhoneLabel.setText("Telefon Nummer: [Phone]");

        customerInfoIDLabel.setText("Kunde ID: [ID]");

        createOrderButton.setText("Opret Bestilling");

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