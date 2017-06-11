package GUI.Panels;

import Domain.Order;
import Domain.OrderController;
import GUI.Frames.EditOrder;
import Tech.Messages;
import Tech.ModelMethods;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterAbortException;
import java.awt.print.PrinterException;
import java.sql.Date;
import java.util.List;

public class OrderOverview extends javax.swing.JPanel {
    private javax.swing.JButton printButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable orderOverviewTable;
    private DefaultTableModel jtModel;
    private Messages messages;

    public OrderOverview() {
        messages = new Messages();
        initComponents();
    }

    private void generateRows() {
        OrderController orderController = new OrderController();

        List<Order> orders = orderController.getAllOrders();

        for(Order order : orders) {
            int orderID = order.getOrderID();
            int customerID = order.getCustomerID();
            int boxID = order.getBoxID();
            String createdBy = order.getCreatedBy();
            Date startDate = order.getStartDate();
            Date endDate = order.getEndDate();
            boolean terminated = order.isTerminated();

            Object[] newLine = {orderID, customerID, boxID, createdBy, startDate, endDate, terminated};

            jtModel.addRow(newLine);
        }
    }

    private void updateTable() {
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModelMethods.updateOverview(jtModel);
                generateRows();
            }
        });
    }

    private void printTable() {
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    orderOverviewTable.print();
                } catch (PrinterException ex) {
                    messages.errorMessage("Der opstod en fejl ved at printe en oversigt!");
                }
            }
        });
    }

    private void deleteRow() {
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
    }

    private void editRow() {
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int row = orderOverviewTable.getSelectedRow();
                        int orderID = Integer.parseInt(orderOverviewTable.getValueAt(row, 0).toString());

                        EditOrder editOrder = new EditOrder(orderID);
                        editOrder.setVisible(true);
                    }
                });
            }
        });
    }

    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        orderOverviewTable = new javax.swing.JTable();
        headerLabel = new javax.swing.JLabel();
        printButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jtModel = new javax.swing.table.DefaultTableModel(
                new Object [][] {},
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
        };

        orderOverviewTable.setModel(jtModel);

        jScrollPane1.setViewportView(orderOverviewTable);

        headerLabel.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        headerLabel.setText("Oversigt over ordrer");

        printButton.setText("Print");

        updateButton.setText("Opdater Oversigt");

        editButton.setText("Rediger");

        deleteButton.setText("Slet");

        printTable();
        editRow();
        updateTable();
        generateRows();
        deleteRow();

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
