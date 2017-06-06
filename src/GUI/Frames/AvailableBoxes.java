package GUI.Frames;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Date;

/**
 * Created by Jacob on 06-06-2017.
 */
public class AvailableBoxes extends JFrame {
    private JLabel headingLabel;
    private JScrollPane scrollPane;
    private JTable boxesTable;
    private int size;
    private Date date;

    /**
     * Creates new form AvailableBoxes
     */
    public AvailableBoxes(Date date, int size) {
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

    }

    private void initComponents() {

        headingLabel = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        boxesTable = new javax.swing.JTable();

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        ImageIcon img = new ImageIcon("src/Pictures/flytteboxenLogo.png");

        this.setIconImage(img.getImage());

        this.setTitle("Find boks i størrelse " + size);

        headingLabel.setFont(new Font("Dialog", 1, 25));
        headingLabel.setText("Tilgængelige Bokse i størrelse " + size);

        boxesTable.setAutoCreateRowSorter(true);
        boxesTable.setModel(new DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "Boks Number", "Boks Size", "Pris", "Hal", "Port Nummer", "Vælg"
                }
        ) {
            Class[] types = new Class [] {
                    Integer.class, Integer.class, Object.class, Integer.class, Integer.class, Object.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPane.setViewportView(boxesTable);
        if (boxesTable.getColumnModel().getColumnCount() > 0) {
            boxesTable.getColumnModel().getColumn(0).setResizable(false);
            boxesTable.getColumnModel().getColumn(1).setResizable(false);
            boxesTable.getColumnModel().getColumn(2).setResizable(false);
            boxesTable.getColumnModel().getColumn(3).setResizable(false);
            boxesTable.getColumnModel().getColumn(4).setResizable(false);
            boxesTable.getColumnModel().getColumn(5).setResizable(false);
        }

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
}

