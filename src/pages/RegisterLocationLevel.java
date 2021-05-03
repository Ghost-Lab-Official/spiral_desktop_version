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
        spiralLabel.setFont(new Font("Nunito", Font.BOLD,40));
        spiralLabel.setForeground(Color.white);

//        left panel
        leftPanel.setBackground(themeColor);
        leftPanel.add(spiralLabel);
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 120, 10, 120));
        leftPanel.setLayout(new GridBagLayout());


//      right panel
        rightPanel.setLayout(new GridLayout(9,1, 0, 10));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(30, 120, 30, 120));

//      add panel to window
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);


        //header
        JLabel registerHeadingLabel = new JLabel("<html>Register Location <br/> Level </html>");
        registerHeadingLabel.setForeground(themeColor);
        registerHeadingLabel.setFont(new Font("Nunito", Font.BOLD,25));
        rightPanel.add(registerHeadingLabel);
    }

    public static void main(String[] args) {
        new RegisterLocationLevel();
    }
}
