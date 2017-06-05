package GUI.Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MainFrame extends javax.swing.JFrame {
    private GridBagLayout grid;
    private JMenuBar menu;
    private JPanel dynamicPanel, mainPanel;
    private JMenu orderMenu, customerMenu, boxMenu, hallMenu;
    private JMenuItem showBoxesItem, showCustomerItem, showOrdersItem, checkAvailabilityItem, createBoxItem,
            createCustomerItem, createOrderItem, createHallItem, showHallItem;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                screenSize.width - inset * 2,
                screenSize.height - inset * 2);

        initComponents();
    }

    private void setDynamicPanel() {
        dynamicPanel.setLayout(grid);

        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;


    }

    private void initComponents() {
        grid = new GridBagLayout();
        mainPanel = new JPanel();
        dynamicPanel = new JPanel();
        menu = new JMenuBar();
        customerMenu = new JMenu();
        createCustomerItem = new JMenuItem();
        showCustomerItem = new JMenuItem();
        boxMenu = new JMenu();
        createBoxItem = new JMenuItem();
        showBoxesItem = new JMenuItem();
        checkAvailabilityItem = new JMenuItem();
        orderMenu = new JMenu();
        createOrderItem = new JMenuItem();
        showOrdersItem = new JMenuItem();
        hallMenu = new JMenu();
        createHallItem = new JMenuItem();
        showHallItem = new JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ImageIcon img = new ImageIcon("src/Pictures/flytteboxenLogo.png");

        this.setIconImage(img.getImage());

        this.setTitle("Flytteboxen");

        customerMenu.setText("Kunde");

        createCustomerItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        createCustomerItem.setText("Opret Kunde");

        customerMenu.add(createCustomerItem);

        showCustomerItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        showCustomerItem.setText("Vis alle Kunder");
        customerMenu.add(showCustomerItem);

        menu.add(customerMenu);

        boxMenu.setText("Boks");

        createBoxItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        createBoxItem.setText("Opret Boks");
        boxMenu.add(createBoxItem);

        showBoxesItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        showBoxesItem.setText("Vis alle Bokse");
        boxMenu.add(showBoxesItem);

        checkAvailabilityItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        checkAvailabilityItem.setText("Tjek Tilgængelighed");
        boxMenu.add(checkAvailabilityItem);

        menu.add(boxMenu);

        hallMenu.setText("Hal");

        createHallItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
        createHallItem.setText("Opret Hal");

        hallMenu.add(createHallItem);

        showHallItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.SHIFT_MASK));
        showHallItem.setText("Vis alle Haller");

        hallMenu.add(showHallItem);

        menu.add(hallMenu);

        orderMenu.setText("Bestilling");

        createOrderItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        createOrderItem.setText("Opret Bestilling");

        orderMenu.add(createOrderItem);

        showOrdersItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        showOrdersItem.setText("Vis alle Bestillinger");

        orderMenu.add(showOrdersItem);

        menu.add(orderMenu);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
}