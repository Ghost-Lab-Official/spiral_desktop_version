    package Locations;
    import javax.swing.*;
    import java.awt.*;

    public class LocationButtons {
        private JFrame window;
        private JPanel panel1;

        private JLabel titleView;
        private JButton levelButton;
        private JButton locationButton;

        public LocationButtons() {
            LocationsInit();
        }

        public void LocationsInit() {
            window = new JFrame("Location buttons");
            window.setSize(1375, 735);
            window.setLayout(null);
            window.setBackground(Color.decode("#E8F0FE"));

            panel1 = new JPanel();
            panel1.setBounds(0, 10, 1375, 100);
    //      panel1.setBackground(Color.blue);


            titleView = new JLabel("View Locations", JLabel.NORTH_EAST);
            titleView.setFont(new Font("Nunito", Font.BOLD, 20));
            titleView.setForeground(Color.decode("#3674D0"));
            panel1.add(titleView);
            panel1.add(Box.createHorizontalStrut(700));

            levelButton = new JButton(" + Add Level ");
            levelButton.setBackground(Color.decode("#CCCCCD"));
            levelButton.setBorder(null);
            levelButton.setFont(new Font("Nunito", Font.BOLD, 15));
            levelButton.setForeground(Color.decode("#323232"));
//            levelButton.setBorder(new RoundedBorder(10));
            levelButton.setFocusPainted(false);
            panel1.add(levelButton);
            panel1.add(Box.createHorizontalStrut(7));


            locationButton = new JButton(" + Add Location ");
            locationButton.setBackground(Color.decode("#3674D0"));
            locationButton.setBorder(null);
            locationButton.setFont(new Font("Nunito", Font.BOLD, 15));
            locationButton.setForeground(Color.WHITE);
//            locationButton.setBorder(new RoundedBorder(10));
            locationButton.setFocusPainted(false);
            panel1.add(locationButton);

            window.add(panel1, BorderLayout.NORTH);
            window.setVisible(true);
        }


        public static void main(String[] args) {

            new LocationButtons();
        }
    }
