package GUI.Panels;

import Domain.CustomerController;
import Tech.Messages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomer extends javax.swing.JPanel {
    private JButton saveButton;
    private JLabel headerLabel, fullNameLabel, addressLabel;
    private JLabel zipCodeLabel, CityLabel, phoneLabel, emailLabel;
    private JTextField nameTextField, addressTextField, zipTextField, cityTextField, phoneTextField, emailTextField;
    private Messages message;

    /**
     * Creates new form AddCustomer
     */
    public AddCustomer() {
        message = new Messages();

        initComponents();

        createCustomer();
    }

    /**
     * Add a customer and make user validation
     */
    private void createCustomer() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nameTextField.getText().isEmpty()) {
                    message.errorMessage("Du skal indtaste kundens navn!");
                } else if (emailTextField.getText().isEmpty()) {
                    message.errorMessage("Du skal indtaste kundens email!");
                } else if (phoneTextField.getText().isEmpty()) {
                    message.errorMessage("Du skal indtaste kundens telefon nummer!");
                } else if (addressTextField.getText().isEmpty()) {
                    message.errorMessage("Du skal indtaste kundens adresse!");
                } else if (zipTextField.getText().isEmpty()) {
                    message.errorMessage("Du skal indtaste kundens post nummer!");
                } else {
                    try {
                        String name = nameTextField.getText();
                        String email = emailTextField.getText();
                        String phone = phoneTextField.getText();
                        String address = addressTextField.getText();
                        int zip = Integer.parseInt(zipTextField.getText());

                        CustomerController customerController = new CustomerController();

                        customerController.createCustomer(name, address, zip, phone, email);

                        message.infoMessage("Customer: " + name + " have been created!");
                    } catch (NumberFormatException ex) {
                        message.errorMessage("Post nummeret skal være i tal!");
                    }
                }
            }
        });
    }

    private void initComponents() {

        headerLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        zipTextField = new javax.swing.JTextField();
        cityTextField = new javax.swing.JTextField();
        phoneTextField = new javax.swing.JTextField();
        fullNameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        zipCodeLabel = new javax.swing.JLabel();
        CityLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        emailLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();

        headerLabel.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        headerLabel.setText("Registrer Kunde");

        fullNameLabel.setText("Navn:");

        addressLabel.setText("Adresse:");

        zipCodeLabel.setText("Postnummer:");

        CityLabel.setText("By:");

        phoneLabel.setText("Telefonnummer:");

        saveButton.setText("Tilføj");

        emailLabel.setText("E-Mail:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(250, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(zipCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cityTextField)
                                        .addComponent(phoneTextField)
                                        .addComponent(saveButton)
                                        .addComponent(nameTextField)
                                        .addComponent(addressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(fullNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(headerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(zipTextField)
                                        .addComponent(CityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(phoneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addressTextField)
                                        .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(emailTextField))
                                .addContainerGap(250, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(17, Short.MAX_VALUE)
                                .addComponent(headerLabel)
                                .addGap(18, 18, 18)
                                .addComponent(fullNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addressLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(zipCodeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(zipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CityLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(phoneLabel)
                                .addGap(8, 8, 8)
                                .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(emailLabel)
                                .addGap(8, 8, 8)
                                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(saveButton)
                                .addContainerGap(8, Short.MAX_VALUE))
        );
    }
}
