package GUI.Frames;

import GUI.Panels.CreateHall;
import GUI.Panels.CreateOrder;
import GUI.Panels.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MainFrame extends javax.swing.JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel, mainPanel, createHallPanel, createOrderPanel;
    private JMenuBar menu;
    private JMenu orderMenu, customerMenu, boxMenu, hallMenu, homeMenu;
    private JMenuItem showBoxesItem, showCustomerItem, showOrdersItem, checkAvailabilityItem, createBoxItem,
            createCustomerItem, createOrderItem, createHallItem, showHallItem, homePageItem, exitItem;

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

    private void setCardLayout() {
        cardPanel.setLayout(cardLayout);

        cardPanel.add(mainPanel, "main");
        cardPanel.add(createHallPanel, "createHall");
        cardPanel.add(createOrderPanel, "createOrder");
    }

    private void setPanels() {
        cardPanel = new JPanel();
        mainPanel = new MainPanel();
        createHallPanel = new CreateHall();
        createOrderPanel = new CreateOrder();
    }

    private void actionListeners() {
        createOrderItem.addActionListener(new ChangePanel("createOrder"));
        createHallItem.addActionListener(new ChangePanel("createHall"));
        homePageItem.addActionListener(new ChangePanel("main"));

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    private void initComponents() {
        cardLayout = new CardLayout();
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
        homeMenu = new JMenu();
        homePageItem = new JMenuItem();
        exitItem = new JMenuItem();

        setPanels();
        setCardLayout();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ImageIcon img = new ImageIcon("src/Pictures/flytteboxenLogo.png");

        this.setIconImage(img.getImage());

        this.setTitle("Flytteboxen");

        homeMenu.setText("Hjem");

        homePageItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
        homePageItem.setText("Hjem");

        homeMenu.add(homePageItem);

        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
        exitItem.setText("Luk Program");

        homeMenu.add(exitItem);

        menu.add(homeMenu);

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

        checkAvailabilityItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.SHIFT_MASK | InputEvent.CTRL_MASK));
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

        add(cardPanel);
        actionListeners();

        pack();
    }

    class ChangePanel implements ActionListener {
        String panelShow;

        public ChangePanel(String panelShow) {
            this.panelShow = panelShow;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(cardPanel, this.panelShow);
        }
    }
}