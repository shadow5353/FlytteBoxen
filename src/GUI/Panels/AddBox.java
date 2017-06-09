package GUI.Panels;

import Domain.BoxController;
import Tech.Messages;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class AddBox extends javax.swing.JPanel {
    private JButton saveButton;
    private JComboBox<String> sizeComboBox;
    private JLabel headerLabel, boxIdLabel, sizeLabel, priceLabel, hallLabel, nearestGateLabel;
    private JTextField boxTextField, priceTextField, hallTextField, nearestGateTextField;
    private Messages messages;

    /**
     * Creates new form AddBox
     */
    public AddBox() {
        messages = new Messages();
        initComponents();

        createBox();
    }

    private void createBox() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(boxTextField.getText().isEmpty()) {
                    messages.errorMessage("Du skal indtaste et nummer til boksen!");
                } else if (priceTextField.getText().isEmpty()) {
                    messages.errorMessage("Du skal indtaste en pris til boksen!");
                } else if (hallTextField.getText().isEmpty()) {
                    messages.errorMessage("Du skal indtaste hvilken hal boksen er i!");
                } else if (nearestGateTextField.getText().isEmpty()) {
                    messages.errorMessage("Du skal indtaste den nærmeste port!");
                } else {

                    int boxID = Integer.parseInt(boxTextField.getText());
                    int size = Integer.parseInt(sizeComboBox.getSelectedItem().toString());
                    BigDecimal price = new BigDecimal(priceTextField.getText());
                    int hallID = Integer.parseInt(hallTextField.getText());
                    int gate = Integer.parseInt(nearestGateTextField.getText());

                    BoxController boxController = new BoxController();

                    boxController.createBox(boxID, size, price, hallID, gate);

                    messages.infoMessage("Box: " + boxID + " have been created with size: " + size);
                }
            }
        });
    }

    private void initComponents() {

        headerLabel = new javax.swing.JLabel();
        boxTextField = new javax.swing.JTextField();
        priceTextField = new javax.swing.JTextField();
        hallTextField = new javax.swing.JTextField();
        nearestGateTextField = new javax.swing.JTextField();
        sizeComboBox = new javax.swing.JComboBox<>();
        boxIdLabel = new javax.swing.JLabel();
        sizeLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        hallLabel = new javax.swing.JLabel();
        nearestGateLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();

        headerLabel.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        headerLabel.setText("Tilføj boks");

        sizeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));
        sizeComboBox.setToolTipText("Størrelse");

        boxIdLabel.setText("Boks nummer:");

        sizeLabel.setText("Størrelse:");

        priceLabel.setText("Pris:");

        hallLabel.setText("Hall:");

        nearestGateLabel.setText("Nærmeste port:");

        saveButton.setText("Tilføj");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(272, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(hallTextField)
                                        .addComponent(nearestGateTextField)
                                        .addComponent(saveButton)
                                        .addComponent(boxTextField)
                                        .addComponent(sizeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sizeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(boxIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(headerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(priceTextField)
                                        .addComponent(hallLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nearestGateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(309, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(21, Short.MAX_VALUE)
                                .addComponent(headerLabel)
                                .addGap(18, 18, 18)
                                .addComponent(boxIdLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sizeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sizeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(priceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hallLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hallTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nearestGateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nearestGateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(saveButton)
                                .addContainerGap(55, Short.MAX_VALUE))
        );
    }
}
