package GUI.Panels;

import javax.swing.*;

/**
 * Created by Jacob on 05-06-2017.
 */
public class MainPanel extends JPanel {
    private JLabel picture;

    /**
     * Creates new form MainPanel
     */
    public MainPanel() {
        initComponents();
    }

    private void initComponents() {

        picture = new javax.swing.JLabel();

        picture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/logo.png")));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(290, Short.MAX_VALUE)
                                .addComponent(picture)
                                .addContainerGap(290, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(94, Short.MAX_VALUE)
                                .addComponent(picture)
                                .addContainerGap(136, Short.MAX_VALUE))
        );
    }
}
