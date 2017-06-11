package GUI.Panels;

import Domain.Hall;
import Domain.HallController;
import GUI.Frames.EditHall;
import Tech.Messages;
import Tech.ModelMethods;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.List;

public class HallOverview extends javax.swing.JPanel {
    private javax.swing.JButton printButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable hallOverviewTable;
    private DefaultTableModel jtModel;
    private Messages messages;


    public HallOverview() {
        messages = new Messages();
        initComponents();
    }

    private void deleteRow() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HallController hc = new HallController();
                int row = hallOverviewTable.getSelectedRow();
                int hallID = Integer.parseInt(hallOverviewTable.getValueAt(row,0).toString());
                int answer = messages.confirmMessage("Er du sikker på du vil slette hal nummer " + hallID + " ?");
                if(answer == JOptionPane.YES_OPTION){
                    hc.removeHall(hallID);
                }

            }
        });
    }

    private void editRow() {
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = hallOverviewTable.getSelectedRow();
                int hallID = Integer.parseInt(hallOverviewTable.getValueAt(row,0).toString());
                EditHall eh = new EditHall(hallID);
                eh.setVisible(true);
            }
        });
    }

    private void printTable() {
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    hallOverviewTable.print();
                } catch (PrinterException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void updateOverview() {
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModelMethods.updateOverview(jtModel);

                generateRows();
            }
        });
    }

    private void generateRows() {
        HallController hc = new HallController();

        List<Hall> halls = hc.getHalls();

        if(halls.isEmpty()) {
            messages.errorMessage("Der findes ingen haller!");
        } else {
            for (Hall hall : halls) {
                int hallID = hall.getHallID();
                String description = hall.getDescription();
                String address = hall.getAddress();
                int zip = hall.getZip();
                String city = hall.getCity();

                Object[] newLine = {hallID, description, city, zip, address};

                jtModel.addRow(newLine);
            }
        }
    }


    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        hallOverviewTable = new javax.swing.JTable();
        headerLabel = new javax.swing.JLabel();
        printButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        jtModel = new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "Hal ID", "Beskrivelse", "By", "Postnummer", "Adresse"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };

        hallOverviewTable.setModel(jtModel);
        jScrollPane1.setViewportView(hallOverviewTable);

        headerLabel.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        headerLabel.setText("Oversigt over haller");

        printButton.setText("Print");

        updateButton.setText("Opdater Oversigt");

        editButton.setText("Rediger");

        deleteButton.setText("Slet");

        generateRows();
        editRow();
        deleteRow();
        printTable();
        updateOverview();

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
                                                .addComponent(updateButton)
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
                                        .addComponent(updateButton)
                                        .addComponent(editButton)
                                        .addComponent(deleteButton))
                                .addContainerGap())
        );
    }



}

