package Locations;

import javax.swing.*;
import java.awt.*;

public class LocationButtons {

    private JFrame window;
    private JButton button1;
    private JButton levelButton;
    private JButton locationButton;
    private JPanel panel1;
    private JLabel titleView;


    public LocationButtons() {
        LocationsInit();
    }

    public void LocationsInit() {
        window = new JFrame("Location buttons");
        window.setSize(1375, 735);
        window.setLayout(null);
        window.setBackground(Color.decode("#E8F0FE"));

        panel1 = new JPanel();
        panel1.setBounds(0, 50, 1375, 32);

        titleView = new JLabel("View Locations", JLabel.NORTH_EAST);
        titleView.setFont(new Font("Nunito", Font.BOLD, 20));
        titleView.setForeground(Color.decode("#3674D0"));
        titleView.setBounds(0, 25, 15, 3);


        levelButton = new JButton("+ Add Level");
        levelButton.setBounds(10, 25, 55, 52);
        levelButton.setBackground(Color.decode("#CCCCCD"));
        levelButton.setFont(new Font("Nunito",Font.PLAIN,17));
        levelButton.setForeground(Color.decode("#323232"));
        levelButton.setBorder(null);
        levelButton.setFocusPainted(false);



        locationButton = new JButton("+ Add Location");
        locationButton.setBounds(15, 25, 0, 0);
        locationButton.setSize(new Dimension(40,90));
        locationButton.setBackground(Color.decode("#3674D0"));
        locationButton.setForeground(Color.WHITE);


        panel1.add(titleView);
        panel1.add(Box.createHorizontalStrut(700));
        panel1.add(levelButton);
        panel1.add(locationButton);
        window.add(panel1);

        window.setVisible(true);
    }


    public static void main(String[] args) {
        new LocationButtons();
    }
}
