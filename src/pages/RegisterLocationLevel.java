package pages;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
        JButton createBtn = new JButton("Register");
        JLabel levelText = new JLabel("<html>This is where you could register your?<br/> <font color='#3674D0'>Sign Up.</font></html>");
        JPanel CreateButtonPanel = new JPanel(new BorderLayout());
        JPanel DescriptLabelPanel = new JPanel();

//        company name
        spiralLabel.setFont(new Font("Nunito", Font.BOLD, 40));
        spiralLabel.setForeground(Color.WHITE);

//        left panel
        leftPanel.setBackground(themeColor);
        leftPanel.add(spiralLabel);
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 120, 10, 120));
        leftPanel.setLayout(new GridBagLayout());


        DescriptLabelPanel.setBackground(Color.WHITE);
        DescriptLabelPanel.setLayout(new BorderLayout());
        DescriptLabelPanel.add(levelText, BorderLayout.SOUTH);

//      right panel
        createBtn.setPreferredSize(new Dimension(150,50));
        createBtn.setForeground(Color.WHITE);
        createBtn.setBackground(themeColor);
        createBtn.setFont(new Font("Nunito",Font.BOLD,16));
        createBtn.setBounds(10, 10, 120, 50);
        createBtn.setBorder(BorderFactory.createCompoundBorder(
                new CustomBorder(),
                new EmptyBorder(new Insets(25, 20, 25, 25))
        ));

        CreateButtonPanel.setBackground(Color.WHITE);
        CreateButtonPanel.add(createBtn, BorderLayout.WEST);

        rightPanel.add(CreateButtonPanel);
        rightPanel.add(DescriptLabelPanel);
        rightPanel.setLayout(new GridLayout(9,1, 0, 10));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(30, 120, 30, 120));

//      add panel to window
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new RegisterLocationLevel();
    }
}
