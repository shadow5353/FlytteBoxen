package GUI.Frames;

import Domain.BoxController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class EditBox extends javax.swing.JFrame {

    private javax.swing.JTextField boksNumberTextField;
    private javax.swing.JLabel boxNumberLabel;
    private javax.swing.JLabel hallIdLabel;
    private javax.swing.JTextField hallNumberTextField;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JLabel nearestGateLabel;
    private javax.swing.JTextField nearestGateTextField;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox<String> sizeComboBox;
    private javax.swing.JLabel sizeLabel;
    private int boxId;

    /**
     * Creates new form EditBox
     */
    public EditBox(int boxId) {
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                screenSize.width - inset * 2,
                screenSize.height - inset * 2);

        BoxController bc = new BoxController(boxId);

        initComponents();

        BigDecimal price = bc.getBoxPrice();
        int hallNumber = bc.getBoxHall();
        int gate = bc.getBoxGate();

        boksNumberTextField.setText("" + boxId);
        boksNumberTextField.setEditable(false);
        priceTextField.setText("" + price);
        hallNumberTextField.setText("" + hallNumber);
        nearestGateTextField.setText("" + gate);

    }

    private void saveBox() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int size = Integer.parseInt(sizeComboBox.getSelectedItem().toString());
                BigDecimal price = new BigDecimal(priceTextField.getText());
                int hallID = Integer.parseInt(hallNumberTextField.getText());
                int gate = Integer.parseInt(nearestGateTextField.getText());

                BoxController bc = new BoxController();

                bc.updateBox(boxId, size, price, hallID, gate);

            }
        });
    }

    private void initComponents() {

        saveButton = new javax.swing.JButton();
        headerLabel = new javax.swing.JLabel();
        boxNumberLabel = new javax.swing.JLabel();
        boksNumberTextField = new javax.swing.JTextField();
        sizeLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        priceTextField = new javax.swing.JTextField();
        hallIdLabel = new javax.swing.JLabel();
        hallNumberTextField = new javax.swing.JTextField();
        nearestGateLabel = new javax.swing.JLabel();
        nearestGateTextField = new javax.swing.JTextField();
        sizeComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        this.setTitle("Rediger Boks " + boxId);

        saveButton.setText("Gem");

        headerLabel.setText("Rediger boks");

        boxNumberLabel.setText("Boks nummer:");

        sizeLabel.setText("Størrelse:");

        priceLabel.setText("Pris:");

        hallIdLabel.setText("Hall nummer:");

        nearestGateLabel.setText("Nærmeste port:");

        sizeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6"}));

        saveBox();


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(headerLabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(160, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(boxNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(sizeLabel)
                                                        .addComponent(priceLabel)
                                                        .addComponent(hallIdLabel)
                                                        .addComponent(nearestGateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(sizeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(boksNumberTextField)
                                                        .addComponent(priceTextField)
                                                        .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(hallNumberTextField)
                                                        .addComponent(nearestGateTextField))))
                                .addContainerGap(148, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headerLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxNumberLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boksNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sizeLabel)
                                .addGap(4, 4, 4)
                                .addComponent(sizeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(priceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hallIdLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hallNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nearestGateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nearestGateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveButton)
                                .addContainerGap())
        );
    }


}

