package GUI.Frames;

import Domain.CustomerController;
import Domain.OrderController;
import Tech.Messages;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class EditOrder extends javax.swing.JFrame {
    private javax.swing.JLabel boxIdLabel;
    private javax.swing.JTextField boxIdTextField;
    private javax.swing.JLabel createdByLabel;
    private javax.swing.JTextField createdByTextField;
    private javax.swing.JLabel customerIdLabel;
    private javax.swing.JTextField customerIdTextField;
    private javax.swing.JLabel endDateLabel;
    private JXDatePicker endDateTextField;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JLabel orderNumberLabel;
    private javax.swing.JTextField orderNumberTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel startDateLabel;
    private JXDatePicker startDateTextField;
    private javax.swing.JComboBox<String> terminatedComboBox;
    private javax.swing.JLabel terminatedLabel;
    private int orderID;
    private Messages messages;

    /**
     * Creates new form EditBox
     */
    public EditOrder(int orderID) {
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                screenSize.width - inset * 2,
                screenSize.height - inset * 2);

        messages = new Messages();
        this.orderID = orderID;
        initComponents();

        insertIntoTextFields();
    }

    private void insertIntoTextFields() {
        OrderController orderController = new OrderController(orderID);

        int customerID = orderController.getCustomerId();
        int boxID = orderController.getBoxId();
        String createdBy = orderController.getCreatedBy();
        Date startDate = orderController.getStartDate();
        Date endDate = orderController.getEndDate();
        boolean terminated = orderController.getTerminated();

        orderNumberTextField.setText("" + orderID);
        orderNumberTextField.setEditable(false);
        customerIdTextField.setText("" + customerID);
        boxIdTextField.setText("" + boxID);
        createdByTextField.setText(createdBy);
        startDateTextField.setDate(startDate);
        endDateTextField.setDate(endDate);

        if (terminated) {
            terminatedComboBox.setSelectedItem(0);
        } else {
            terminatedComboBox.setSelectedItem(1);
        }

    }

    private void saveOrder() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int boxID = Integer.parseInt(boxIdTextField.getText());
                int customerID = Integer.parseInt(customerIdTextField.getText());
                String createdBy = createdByTextField.getText();
                Date startDate = new Date(startDateTextField.getDate().getTime());
                boolean terminated = Boolean.parseBoolean(terminatedComboBox.getSelectedIndex() + "");

                OrderController orderController = new OrderController();

                try {
                    Date endDate = new Date(endDateTextField.getDate().getTime());

                    orderController.updateOrder(orderID, customerID, boxID, createdBy, startDate, endDate, terminated);
                } catch (NullPointerException ex) {
                    orderController.updateOrder(orderID, customerID, boxID, createdBy, startDate, null, terminated);
                }

                CustomerController customerController = new CustomerController(customerID);

                String customerName = customerController.getCustomerName();

                messages.infoMessage("Ordre Nummer: " + customerID + " for kunde: " + customerName + " er blevet opdateret!");

                dispose();
            }
        });
    }

    private void initComponents() {

        saveButton = new javax.swing.JButton();
        headerLabel = new javax.swing.JLabel();
        orderNumberLabel = new javax.swing.JLabel();
        orderNumberTextField = new javax.swing.JTextField();
        customerIdLabel = new javax.swing.JLabel();
        boxIdLabel = new javax.swing.JLabel();
        boxIdTextField = new javax.swing.JTextField();
        createdByLabel = new javax.swing.JLabel();
        createdByTextField = new javax.swing.JTextField();
        startDateLabel = new javax.swing.JLabel();
        startDateTextField = new JXDatePicker();
        endDateLabel = new javax.swing.JLabel();
        endDateTextField = new JXDatePicker();
        customerIdTextField = new javax.swing.JTextField();
        terminatedLabel = new javax.swing.JLabel();
        terminatedComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        saveButton.setText("Gem");

        headerLabel.setText("Rediger ordre:");

        orderNumberLabel.setText("Ordrenummer:");

        customerIdLabel.setText("Kundenummer:");

        boxIdLabel.setText("Boks nummer:");

        createdByLabel.setText("Oprettet af:");

        startDateLabel.setText("Start dato:");

        endDateLabel.setText("Slut dato:");


        terminatedLabel.setText("Opsagt:");

        terminatedComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nej", "Ja" }));

        saveOrder();

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
                                                .addContainerGap(162, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(orderNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(customerIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(boxIdLabel)
                                                        .addComponent(startDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(orderNumberTextField)
                                                        .addComponent(boxIdTextField)
                                                        .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(createdByTextField)
                                                        .addComponent(startDateTextField)
                                                        .addComponent(endDateTextField)
                                                        .addComponent(endDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(customerIdTextField)
                                                        .addComponent(createdByLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(terminatedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(terminatedComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headerLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orderNumberLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orderNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(customerIdLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customerIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boxIdLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(createdByLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createdByTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(startDateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(endDateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(endDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(terminatedLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(terminatedComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(saveButton)
                                .addContainerGap())
        );
    }
}

