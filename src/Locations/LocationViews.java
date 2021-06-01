package Locations;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LocationViews {
    private JFrame  window;
    private JPanel  panelHeader;
    private JPanel mainPanel;
    private JLabel  titleView;
    private JButton levelButton;
    private JButton locationButton;

    public LocationViews() {
        LocationsInit();
    }

    public void LocationsInit() {
        window = new JFrame("Location buttons");
        window.setSize(1375, 735);
        window.setLayout(null);

        mainPanel=new JPanel();
mainPanel.setBounds(0, 10, 1375, 730);

        mainPanel.setBackground(Color.WHITE);

        panelHeader = new JPanel();
        panelHeader.setBounds(0, 10, 1375, 100);
        panelHeader.setBackground(Color.WHITE);


        titleView = new JLabel("View Locations", JLabel.NORTH_EAST);
        titleView.setFont(new Font("Nunito", Font.BOLD, 20));
        titleView.setForeground(Color.decode("#3674D0"));



        levelButton = new JButton(" + Add Level ");
        levelButton.setBorder(null);
        levelButton.setFont(new Font("Verdana", Font.BOLD, 12));
       levelButton.setPreferredSize(new Dimension(150, 55));
      levelButton.setForeground(Color.WHITE);
      levelButton.setBackground(Color.gray);
        levelButton.setFocusPainted(false);
        levelButton.setBorder(BorderFactory.createCompoundBorder(
                new LocationViews.CustomBorder(),
                new EmptyBorder(new Insets(25, 25, 25, 25))
        ));


        locationButton = new JButton(" + Add Location ");
        locationButton.setBackground(Color.decode("#3674D0"));
        locationButton.setBorder(null);
        locationButton.setFont(new Font("Verdana", Font.BOLD, 12));
        locationButton.setPreferredSize(new Dimension(180, 55));
        locationButton.setForeground(Color.WHITE);
        locationButton.setFocusPainted(false);
        locationButton.setBorder(BorderFactory.createCompoundBorder(
                new LocationViews.CustomBorder(),
                new EmptyBorder(new Insets(25, 25, 25, 25))
        ));




        panelHeader.add(titleView,BorderLayout.EAST);
        panelHeader.add(Box.createHorizontalStrut(700));
        panelHeader.add(levelButton,BorderLayout.CENTER);
        panelHeader.add(locationButton,BorderLayout.WEST);
        mainPanel.add(panelHeader);
                window.add(mainPanel);
        window.setVisible(true);
    }




    class CustomBorder extends AbstractBorder {
        public void paintBorder(Component c, Graphics g, int x, int y,
                                int width, int height) {
            super.paintBorder(c, g, x, y, width, height);
            Graphics2D g2d = (Graphics2D)g;
            g2d.setStroke(new BasicStroke(15));
            g2d.drawRoundRect(x, y, width - 0, height - 0, 34, 34);
        }
    }

    public static void main(String[] args) {

        new LocationViews();
    }


}
