package GUI.Frames;

import GUI.Panels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MainFrame extends javax.swing.JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel, mainPanel, createHallPanel, createOrderPanel, addBoxPanel, addCustomerPanel, boxOverviewPanel,
            customerOverviewPanel, hallOverviewPanel, orderOverviewPanel;
    private JMenuBar menu;
    private JMenu orderMenu, customerMenu, boxMenu, hallMenu, homeMenu;
    private JMenuItem boxOverviewItem, customerOverviewItem, orderOverviewItem, addBoxItem,
            addCustomerItem, createOrderItem, createHallItem, hallOverviewItem, homePageItem, exitItem;

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
        cardPanel.add(addBoxPanel, "addBox");
        cardPanel.add(addCustomerPanel, "addCustomer");
        cardPanel.add(boxOverviewPanel, "boxOverview");
        cardPanel.add(customerOverviewPanel, "customerOverview");
        cardPanel.add(hallOverviewPanel, "hallOverview");
        cardPanel.add(orderOverviewPanel, "orderOverview");
    }

    private void setPanels() {
        cardPanel = new JPanel();
        mainPanel = new MainPanel();
        createHallPanel = new CreateHall();
        createOrderPanel = new CreateOrder();
        addBoxPanel = new AddBox();
        addCustomerPanel = new AddCustomer();
        boxOverviewPanel = new BoxOverview();
        customerOverviewPanel = new CustomerOverview();
        hallOverviewPanel = new HallOverview();
        orderOverviewPanel = new OrderOverview();
    }

    private void actionListeners() {
        createOrderItem.addActionListener(new ChangePanel("createOrder"));
        createHallItem.addActionListener(new ChangePanel("createHall"));
        homePageItem.addActionListener(new ChangePanel("main"));
        addBoxItem.addActionListener(new ChangePanel("addBox"));
        addCustomerItem.addActionListener(new ChangePanel("addCustomer"));
        boxOverviewItem.addActionListener(new ChangePanel("boxOverview"));
        customerOverviewItem.addActionListener(new ChangePanel("customerOverview"));
        hallOverviewItem.addActionListener(new ChangePanel("hallOverview"));
        orderOverviewItem.addActionListener(new ChangePanel("orderOverview"));

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
        addCustomerItem = new JMenuItem();
        customerOverviewItem = new JMenuItem();
        boxMenu = new JMenu();
        addBoxItem = new JMenuItem();
        boxOverviewItem = new JMenuItem();
        orderMenu = new JMenu();
        createOrderItem = new JMenuItem();
        orderOverviewItem = new JMenuItem();
        hallMenu = new JMenu();
        createHallItem = new JMenuItem();
        hallOverviewItem = new JMenuItem();
        homeMenu = new JMenu();
        homePageItem = new JMenuItem();
        exitItem = new JMenuItem();

        setPanels();
        setCardLayout();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ImageIcon img = new ImageIcon(getClass().getResource("/Pictures/logo.png"));

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

        addCustomerItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_MASK));
        addCustomerItem.setText("Opret Kunde");

        customerMenu.add(addCustomerItem);

        customerOverviewItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.SHIFT_MASK | InputEvent.CTRL_MASK));
        customerOverviewItem.setText("Vis alle Kunder");
        customerMenu.add(customerOverviewItem);

        menu.add(customerMenu);

        boxMenu.setText("Boks");

        addBoxItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
        addBoxItem.setText("Opret Boks");
        boxMenu.add(addBoxItem);

        boxOverviewItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.SHIFT_MASK | InputEvent.CTRL_MASK));
        boxOverviewItem.setText("Vis alle Bokse");
        boxMenu.add(boxOverviewItem);

        menu.add(boxMenu);

        hallMenu.setText("Hal");

        createHallItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
        createHallItem.setText("Opret Hal");

        hallMenu.add(createHallItem);

        hallOverviewItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.SHIFT_MASK));
        hallOverviewItem.setText("Vis alle Haller");

        hallMenu.add(hallOverviewItem);

        menu.add(hallMenu);

        orderMenu.setText("Bestilling");

        createOrderItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        createOrderItem.setText("Opret Bestilling");

        orderMenu.add(createOrderItem);

        orderOverviewItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.SHIFT_MASK | InputEvent.CTRL_MASK));
        orderOverviewItem.setText("Vis alle Bestillinger");

        orderMenu.add(orderOverviewItem);

        menu.add(orderMenu);

        setJMenuBar(menu);

        add(cardPanel);
        actionListeners();

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