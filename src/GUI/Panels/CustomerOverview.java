package GUI.Panels;


import Domain.Customer;
import Domain.CustomerController;
import GUI.Frames.EditCustomer;
import Tech.Messages;
import Tech.ModelMethods;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.List;

public class CustomerOverview extends javax.swing.JPanel {

    private javax.swing.JButton printButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable customerTable;
    private String[] tableColumnName = {"Kundenummer", "Navn", "Adresse", "Postnummer", "By", "Telefon", "E-Mail"};
    private String[][] tableData;
    private DefaultTableModel jtModel;
    private Messages messages;


    public CustomerOverview() {
        messages = new Messages();

        initComponents();
    }

    private void generateRows() {
        CustomerController customerController = new CustomerController();

        List<Customer> customers = customerController.getAllCustomers();

        for(Customer customer : customers) {
            int customerID = customer.getCustomerID();
            String name = customer.getName();
            String address = customer.getAddress();
            int zip = customer.getZip();
            String city = customer.getCity();
            String phone = customer.getPhone();
            String email = customer.getEmail();

            Object[] newLine = {customerID, name, address, zip, city, phone, email};

            jtModel.addRow(newLine);
        }
    }

    private void deleteRow() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerController cc = new CustomerController();
                Messages ms = new Messages();
                int row = customerTable.getSelectedRow();
                int customerId = Integer.parseInt(customerTable.getValueAt(row,0).toString());
                int answer = ms.confirmMessage("Er du sikker på du vil slette kunde med kundenummer: " + customerId + " ?");
                if (answer == JOptionPane.YES_OPTION){
                    cc.removeCustomer(customerId);
                }

            }
        });
    }

    private void editRow() {
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = customerTable.getSelectedRow();
                int customerId = Integer.parseInt(customerTable.getValueAt(row,0).toString());
                EditCustomer eb = new EditCustomer(customerId);
                eb.setVisible(true);
            }
        });
    }

    private void printTable() {
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    customerTable.print();
                } catch (PrinterException e1) {
                    e1.printStackTrace();
                }
            }
        });
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

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        headerLabel = new javax.swing.JLabel();
        printButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();


        jtModel = new DefaultTableModel(tableData, tableColumnName) {

            Class[] types = new Class[]{
                    Integer.class, String.class, String.class, Integer.class, String.class, String.class, String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        customerTable = new javax.swing.JTable(jtModel);

        jScrollPane1.setViewportView(customerTable);

        headerLabel.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        headerLabel.setText("Oversigt over kunder");

        printButton.setText("Print");

        updateButton.setText("Opdater Oversigt");

        editButton.setText("Rediger");

        deleteButton.setText("Slet");

        editRow();
        printTable();
        deleteRow();
        generateRows();
        updateTable();

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
