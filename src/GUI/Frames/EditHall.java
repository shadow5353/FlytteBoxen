package GUI.Frames;

import Domain.HallController;
import Tech.Messages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditHall extends javax.swing.JFrame {
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JLabel hallIdLabel;
    private javax.swing.JTextField hallIdTextField;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel zipLabel;
    private javax.swing.JTextField zipTextField;
    private int hallID;
    private Messages messages;

    /**
     * Creates new form editBox
     */
    public EditHall(int hallID) {
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                screenSize.width - inset * 2,
                screenSize.height - inset * 2);

        messages = new Messages();
        this.hallID = hallID;
        initComponents();

        HallController hc = new HallController(hallID);

        String description = hc.getHallDescription();
        String address = hc.getHallAddress();
        int zip = hc.getHallZip();

        hallIdTextField.setText("" + hallID);
        hallIdTextField.setEditable(false);
        descriptionTextField.setText(description);
        addressTextField.setText(address);
        zipTextField.setText("" + zip);

    }

    private void saveHall() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String description = descriptionTextField.getText();
                    String address = addressTextField.getText();
                    int zip = Integer.parseInt(zipTextField.getText());

                    HallController hc = new HallController();

                    hc.updateHall(hallID, description, zip, address);

                    messages.infoMessage("Hal " + hallID + " er blevet opdateret!");

                    dispose();
                } catch (NumberFormatException ex) {
                    messages.errorMessage("Post Nummer skal indtastet som et tal!");
                }
            }
        });
    }


    private void initComponents() {

        saveButton = new javax.swing.JButton();
        headerLabel = new javax.swing.JLabel();
        hallIdLabel = new javax.swing.JLabel();
        hallIdTextField = new javax.swing.JTextField();
        descriptionLabel = new javax.swing.JLabel();
        zipLabel = new javax.swing.JLabel();
        zipTextField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        descriptionTextField = new javax.swing.JTextField();

        this.setTitle("Rediger Hal " + hallID);

        saveButton.setText("Gem");

        headerLabel.setText("Rediger hall:");

        hallIdLabel.setText("Hall nummer:");

        descriptionLabel.setText("Beskrivelse:");

        zipLabel.setText("Postnummer:");

        addressLabel.setText("Adresse:");

        saveHall();

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
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(hallIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                                        .addComponent(descriptionLabel)
                                                        .addComponent(zipLabel)
                                                        .addComponent(addressLabel)
                                                        .addComponent(hallIdTextField)
                                                        .addComponent(zipTextField)
                                                        .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(addressTextField))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 121, Short.MAX_VALUE)
                                .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headerLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hallIdLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hallIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(descriptionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(zipLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(zipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addressLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(saveButton)
                                .addContainerGap())
        );
    }
}

