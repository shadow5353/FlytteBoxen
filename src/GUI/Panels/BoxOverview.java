package GUI.Panels;


import Domain.BoxController;
import GUI.Frames.EditBox;
import Tech.Messages;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

public class BoxOverview extends javax.swing.JPanel {
    private javax.swing.JButton printButton;
    private javax.swing.JButton exportTextFileButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable boksOverviewTable;
    private String[] tableColumnName = {"Box ID", "Størrelse", "Pris", "Nærmeste port", "Hall ID"};
    private String[][] tableData;
    private Messages ms;
    private DefaultTableModel jtModel;

    /**
     * Creates new form BoxOverview
     */
    public BoxOverview() {
        initComponents();
    }

    public void generateRows(){
        BoxController bc = new BoxController();

    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();


        headerLabel = new javax.swing.JLabel();
        printButton = new javax.swing.JButton();
        exportTextFileButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        ms = new Messages();
        scrollPane = new javax.swing.JScrollPane();

        jtModel = new DefaultTableModel(tableData, tableColumnName) {

            Class[] types = new Class[]{
                    Integer.class, Integer.class, Object.class, Integer.class, Integer.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };


        boksOverviewTable = new javax.swing.JTable(jtModel);

        jScrollPane1.setViewportView(boksOverviewTable);

        headerLabel.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        headerLabel.setText("Oversigt af bokse");

        printButton.setText("Print");

        exportTextFileButton.setText("Exporter til tekstfil");

        editButton.setText("Rediger");

        deleteButton.setText("Slet");

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boksOverviewTable.print();
                } catch (PrinterException e1) {
                    e1.printStackTrace();
                }
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
                int row = boksOverviewTable.getSelectedRow();
                int boxId = Integer.parseInt(boksOverviewTable.getValueAt(row,0).toString());
                EditBox eb = new EditBox(boxId);
                eb.setVisible(true);

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BoxController bc = new BoxController();
                Messages ms = new Messages();
                int row = boksOverviewTable.getSelectedRow();
                int boxId = Integer.parseInt(boksOverviewTable.getValueAt(row,0).toString());
                int answer = ms.confirmMessage("Er du sikker på du vil slette boks " + boxId + " ?");
                if(answer == JOptionPane.YES_OPTION){
                    bc.removeBox(boxId);
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

