package GUI.Panels;

import Domain.OrderController;
import Tech.Messages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderOverview extends javax.swing.JPanel {

    private javax.swing.JButton printButton;
    private javax.swing.JButton exportTextFileButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable orderOverviewTable;

    public OrderOverview() {
        initComponents();
    }


    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        orderOverviewTable = new javax.swing.JTable();
        headerLabel = new javax.swing.JLabel();
        printButton = new javax.swing.JButton();
        exportTextFileButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        orderOverviewTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null}
                },
                new String [] {
                        "Ordrenummer", "Kundenummer", "Boks nummer", "Oprettet af", "Start dato", "Slut dato", "Afsluttet"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(orderOverviewTable);

        headerLabel.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        headerLabel.setText("Oversigt over ordrer");

        printButton.setText("Print");

        exportTextFileButton.setText("Exporter til tekstfil");

        editButton.setText("Rediger");

        deleteButton.setText("Slet");

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });

        exportTextFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderController oc = new OrderController();
                Messages ms = new Messages();
                int row = orderOverviewTable.getSelectedRow();
                int orderId = Integer.parseInt(orderOverviewTable.getValueAt(row,0).toString());
                int answer = ms.confirmMessage("Er du sikker på du vil slette ordren med ordrenummer: " + orderId + " ?");
                if (answer == JOptionPane.YES_OPTION) {
                    oc.deleteOrder(orderId);
                }

            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(headerLabel)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(printButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(exportTextFileButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(editButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(deleteButton)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(headerLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(printButton)
                                        .addComponent(exportTextFileButton)
                                        .addComponent(editButton)
                                        .addComponent(deleteButton))
                                .addContainerGap())
        );
    }

}
