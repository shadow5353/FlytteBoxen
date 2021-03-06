package GUI.Panels;

import Domain.Hall;
import Domain.HallController;
import Tech.Messages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateHall extends JPanel {
    private JLabel addressLabel, postalCodeLabel, hallNumberLabel, headingLabel, infoHeadingLabel, infoLabel, descriptionLabel, extraInfoHeadingLabel;
    private JButton createHallButton;
    private JTextField hallNumberField, postalCodeField, addressField;
    private JTextArea descriptionField;
    private JScrollPane scrollPanelTextField;
    private Messages messages;

    /**
     * Creates new form CreateHall
     */
    public CreateHall() {
        initComponents();
        createHall();
    }

    private void createHall() {
        createHallButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hallNumberField.getText().isEmpty()) {
                    messages.errorMessage("Du skal indtaste et hal nummer!");
                } else {
                    try {
                        int hallNumber = Integer.parseInt(hallNumberField.getText());
                        String description = getDescription();
                        String address = getAddress();
                        int postalCode = getPostalCode();

                        HallController hallController = new HallController();

                        hallController.createHall(hallNumber, description, postalCode, address);

                        hallNumberField.setText("");
                        descriptionField.setText("");
                        postalCodeField.setText("");
                        addressField.setText("");

                    } catch (NumberFormatException ex) {
                        messages.errorMessage("Hal nummer skal være et tal!");
                        hallNumberField.setText("");
                    }
                }
            }
        });
    }

    private String getDescription() {
        if(!(descriptionField.getText().isEmpty())) {
            return descriptionField.getText();
        } else {
            return null;
        }
    }

    private int getPostalCode() {
        try {
            if(!(postalCodeField.getText().isEmpty())) {
                int postalCode = Integer.parseInt(postalCodeField.getText());

                return postalCode;
            }
            else {
                return 0;
            }
        } catch (NumberFormatException e) {
            messages.errorMessage("Post Nummer skal være et tal!");
        }

        return 0;
    }

    private String getAddress() {
        if (!(addressField.getText().isEmpty())) {
            return addressField.getText();
        } else {
            return null;
        }
    }



    private void initComponents() {
        headingLabel = new JLabel();
        hallNumberField = new JTextField();
        hallNumberLabel = new JLabel();
        extraInfoHeadingLabel = new JLabel();
        scrollPanelTextField = new JScrollPane();
        descriptionField = new JTextArea();
        infoHeadingLabel = new JLabel();
        descriptionLabel = new JLabel();
        addressLabel = new JLabel();
        addressField = new JTextField();
        postalCodeLabel = new JLabel();
        postalCodeField = new JTextField();
        createHallButton = new JButton();
        infoLabel = new JLabel();
        messages = new Messages();

        headingLabel.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        headingLabel.setText("Opret Hal");

        hallNumberLabel.setText("Hal Nummer*");

        extraInfoHeadingLabel.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        extraInfoHeadingLabel.setText("Ekstra Information");

        descriptionField.setColumns(20);
        descriptionField.setRows(5);
        scrollPanelTextField.setViewportView(descriptionField);

        infoHeadingLabel.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        infoHeadingLabel.setText("Nødvendig Information");

        descriptionLabel.setText("Beskrivelse");

        addressLabel.setText("Adresse");

        postalCodeLabel.setText("Post Nummer");

        createHallButton.setText("Opret Hal");

        infoLabel.setText("Alle felter med * skal udfyldes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(infoHeadingLabel)
                                        .addComponent(hallNumberLabel)
                                        .addComponent(hallNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(infoLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(postalCodeLabel)
                                        .addComponent(addressLabel)
                                        .addComponent(scrollPanelTextField)
                                        .addComponent(extraInfoHeadingLabel)
                                        .addComponent(descriptionLabel)
                                        .addComponent(addressField)
                                        .addComponent(postalCodeField))
                                .addGap(42, 42, 42))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(headingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(createHallButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(headingLabel)
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(infoHeadingLabel)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(hallNumberLabel)
                                                        .addComponent(descriptionLabel)))
                                        .addComponent(extraInfoHeadingLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(scrollPanelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(hallNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(infoLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addressLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(postalCodeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(postalCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addComponent(createHallButton)
                                .addGap(22, 22, 22))
        );
    }
}
