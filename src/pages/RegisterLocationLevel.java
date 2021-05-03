package pages;

import javax.swing.*;
import java.awt.*;

public class RegisterLocationLevel extends JFrame {
    private static final Color themeColor = Color.decode("#3674D0");

    RegisterLocationLevel(){
      super("Create New Location Level");
      setSize(1000,650);
      initUI();
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
    }
    void initUI(){
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JLabel spiralLabel = new JLabel("Spiral");

//        left panel
        leftPanel.setBackground(themeColor);
        leftPanel.add(spiralLabel);
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 120, 10, 120));
        leftPanel.setLayout(new GridBagLayout());


//      right panel

        JLabel levelName = new JLabel("Level name");
        JTextField levelNameInput = new JTextField();
        JLabel levelDescription = new JLabel("Description");
        JTextField levelDescrInput = new JTextField();

//        styling the input labels
        levelName.setFont(new Font("Verdana",Font.PLAIN,16));
        levelDescription.setFont(new Font("Verdana",Font.PLAIN,16));

//      styling the input fields
        levelNameInput.setBorder(new RoundedBorder(15));
        levelDescrInput.setBorder(new RoundedBorder(15));

        rightPanel.setLayout(new GridLayout(9,1, 0, 10));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(30, 120, 30, 120));

//      add panel to window
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        JPanel levelNameLabelPanel = new JPanel();
        levelNameLabelPanel.setBackground(Color.WHITE);
        levelNameLabelPanel.setLayout(new BorderLayout());
        levelNameLabelPanel.add(levelName,BorderLayout.SOUTH);

        JPanel levelDescrLabelPanel = new JPanel();
        levelDescrLabelPanel.setBackground(Color.WHITE);
        levelDescrLabelPanel.setLayout(new BorderLayout());
        levelDescrLabelPanel.add(levelDescription,BorderLayout.SOUTH);

        rightPanel.add(levelNameLabelPanel);
        rightPanel.add(levelNameInput);
        rightPanel.add(levelDescrLabelPanel);
        rightPanel.add(levelDescrInput);
    }

    public static void main(String[] args) {
        new RegisterLocationLevel();
    }
}
