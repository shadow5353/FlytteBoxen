package GUI.Frames;

import Domain.CustomerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditCustomer extends javax.swing.JFrame {

    private javax.swing.JLabel adressLabel;
    private javax.swing.JTextField adressTextField;
    private javax.swing.JLabel customerIdLabel;
    private javax.swing.JTextField customerIdTextField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel telephonenNumberLabel;
    private javax.swing.JTextField telephonenumberTextField;
    private javax.swing.JLabel zipLabel;
    private javax.swing.JTextField zipTextField;
    private int customerId;

    /**
     * Creates new form EditBox
     */
    public EditCustomer(int customerId) {
        CustomerController cc = new CustomerController();
        this.customerId = customerId;
        initComponents();

        customerIdTextField.setText("" + customerId);
        adressTextField.setText(""+ cc.getCustomerAddress());
        zipTextField.setText(""+ cc.getCustomerZip());
        telephonenumberTextField.setText(""+cc.getCustomerPhone());
        emailTextField.setText(""+cc.getCustomerEmail());
        nameTextField.setText(""+cc.getCustomerName());

    }



    private void initComponents() {

        saveButton = new javax.swing.JButton();
        headerLabel = new javax.swing.JLabel();
        customerIdLabel = new javax.swing.JLabel();
        customerIdTextField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        adressLabel = new javax.swing.JLabel();
        adressTextField = new javax.swing.JTextField();
        zipLabel = new javax.swing.JLabel();
        zipTextField = new javax.swing.JTextField();
        telephonenNumberLabel = new javax.swing.JLabel();
        telephonenumberTextField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        saveButton.setText("Gem");

        headerLabel.setText("Rediger kunde:");

        customerIdLabel.setText("Kunde nummer:");

        nameLabel.setText("Navn:");

        adressLabel.setText("Adresse:");

        zipLabel.setText("Postnummer:");

        telephonenNumberLabel.setText("Telefonnummer:");

        emailLabel.setText("E-mail:");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerController cc = new CustomerController();
                cc.updateCustomer(
                            Integer.parseInt(customerIdTextField.getText()),
                            nameTextField.getText(),
                            adressTextField.getText(),
                            Integer.parseInt(zipTextField.getText()),
                            telephonenumberTextField.getText(),
                            emailTextField.getText()
                );
            }
        });


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(headerLabel))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(159, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(customerIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(nameLabel)
                                                        .addComponent(adressLabel)
                                                        .addComponent(zipLabel)
                                                        .addComponent(telephonenNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(customerIdTextField)
                                                        .addComponent(adressTextField)
                                                        .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(zipTextField)
                                                        .addComponent(telephonenumberTextField)
                                                        .addComponent(emailTextField)
                                                        .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(nameTextField))))
                                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headerLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customerIdLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customerIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(adressLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(adressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(zipLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(zipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(telephonenNumberLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(telephonenumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(emailLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(saveButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
}

