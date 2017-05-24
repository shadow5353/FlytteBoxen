package GUI;

public class MainFrame extends javax.swing.JFrame {
    private javax.swing.JMenu boxMenu;
    private javax.swing.JMenuItem checkAvailabilityItem;
    private javax.swing.JMenuItem createBoxItem;
    private javax.swing.JMenuItem createCustomerItem;
    private javax.swing.JMenuItem createOrderItem;
    private javax.swing.JMenu customerMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu orderMenu;
    private javax.swing.JMenuItem showBoxesItem;
    private javax.swing.JMenuItem showCustomerItem;
    private javax.swing.JMenuItem showOrdersItem;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        customerMenu = new javax.swing.JMenu();
        createCustomerItem = new javax.swing.JMenuItem();
        showCustomerItem = new javax.swing.JMenuItem();
        boxMenu = new javax.swing.JMenu();
        createBoxItem = new javax.swing.JMenuItem();
        showBoxesItem = new javax.swing.JMenuItem();
        checkAvailabilityItem = new javax.swing.JMenuItem();
        orderMenu = new javax.swing.JMenu();
        createOrderItem = new javax.swing.JMenuItem();
        showOrdersItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jLabel1.setText("Statestik");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Antal Bokse: 0");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Antal Optaget: 0");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Antal Frie: 0");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap(111, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(74, 74, 74)
                                .addComponent(jLabel3)
                                .addGap(102, 102, 102)
                                .addComponent(jLabel4)
                                .addContainerGap(111, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(119, 119, 119)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4))
                                .addContainerGap(284, Short.MAX_VALUE))
        );

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