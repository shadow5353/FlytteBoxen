package GUI.Frames;

import Domain.*;
import Domain.Box;
import Tech.Messages;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * Created by Jacob on 06-06-2017.
 */
public class AvailableBoxes extends JFrame {
    private JLabel headingLabel;
    private JScrollPane scrollPane;
    private JTable boxesTable;
    private DefaultTableModel jtModel;
    private String[] tableColumnName = {"Box Nummer", "Pris", "Hal Nummer", "Port Nummer"};
    private String[][] tableData;
    private int size;
    private Date date;
    private Messages messages;
    private BoxController boxController;

    /**
     * Creates new form AvailableBoxes
     */
    public AvailableBoxes(Date date, int size) {
        boxController = new BoxController();
        messages = new Messages();

        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                screenSize.width - inset * 2,
                screenSize.height - inset * 2);

        this.size = size;
        this.date = date;

        initComponents();
    }

    private void generateRows() {

        List<Box> availableBoxes = boxController.getAvailableBoxes(size, date);

        if (availableBoxes.isEmpty()) {
            messages.errorMessage("Der er ingen ledige bokse!");
        } else {

            for (Box box : availableBoxes) {
                int boxID = box.getBoxID();
                BigDecimal price = box.getPrice();
                int hall = box.getHallID();
                int gate = box.getGate();

                Object[] newLine = {boxID, price, hall, gate};

                jtModel.addRow(newLine);
            }
        }
    }

    private void initComponents() {

        headingLabel = new javax.swing.JLabel();
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

        boxesTable = new JTable(jtModel);

        boxesTable.setAutoCreateRowSorter(true);
        boxesTable.addMouseListener(new DoubleClickListener());

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        ImageIcon img = new ImageIcon("src/Pictures/flytteboxenLogo.png");

        this.setIconImage(img.getImage());

        this.setTitle("Find boks i størrelse " + size);

        headingLabel.setFont(new Font("Dialog", 1, 25));
        headingLabel.setText("Tilgængelige Bokse i størrelse " + size);

        scrollPane.setViewportView(boxesTable);

        generateRows();


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(headingLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(headingLabel)
                                .addGap(18, 18, 18)
                                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

    }

    private class DoubleClickListener implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                JTable target = (JTable) e.getSource();
                int row = target.getSelectedRow();

                int boxID = Integer.parseInt(target.getValueAt(row, 0).toString());

                int dialogResult = messages.confirmMessage("Vil du vælge boks nummer: " + boxID + "?");

                if (dialogResult == JOptionPane.YES_OPTION) {
                    RegisterOrder registerOrder = new RegisterOrder(boxID, date);

                    dispose();

                    registerOrder.setVisible(true);
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}

