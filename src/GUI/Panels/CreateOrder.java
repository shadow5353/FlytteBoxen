package GUI.Panels;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;

/**
 * Created by Jacob on 05-06-2017.
 */
public class CreateOrder extends JPanel {
    private JXDatePicker date;
    private JLabel dateLabel;
    private JLabel headingLabel;
    private JButton searchButton;
    private JComboBox<String> sizesBox;
    private JLabel sizesLabel;

    /**
     * Creates new form MainPanel
     */
    public CreateOrder() {
        initComponents();
    }

    private void initComponents() {

        headingLabel = new javax.swing.JLabel();
        date = new org.jdesktop.swingx.JXDatePicker();
        dateLabel = new javax.swing.JLabel();
        sizesBox = new javax.swing.JComboBox<>();
        sizesLabel = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();

        headingLabel.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        headingLabel.setText("Opret Bestilling");


        dateLabel.setText("Lejeperiode Start");

        sizesBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));

        sizesLabel.setText("Størrelse");

        searchButton.setText("Søg Efter Boks");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(270, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(sizesLabel)
                                        .addComponent(dateLabel)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(searchButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(sizesBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(headingLabel)))
                                .addContainerGap(257, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(headingLabel)
                                .addGap(69, 69, 69)
                                .addComponent(dateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sizesLabel)
                                .addGap(3, 3, 3)
                                .addComponent(sizesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(searchButton)
                                .addContainerGap(166, Short.MAX_VALUE))
        );
    }
}
