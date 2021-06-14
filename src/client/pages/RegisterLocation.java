package client.pages;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RegisterLocation extends JFrame {
    private static final Color themeColor = Color.decode("#3674D0");

    public RegisterLocation(){
        super("Create New Location");
        setSize(1000,650);
        initUI();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
<<<<<<< HEAD
    void initUI(){
=======
    public void initUI(){
>>>>>>> d3cbee5dde6691de8ab652e5c49bd56983c38f24
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JLabel spiralLabel = new JLabel("Spiral");
        JButton createBtn = new JButton("Register");
        JLabel levelText = new JLabel("<html>This is where you could register your?<br/> <font color='#3674D0'>Location</font></html>");
        JPanel CreateButtonPanel = new JPanel(new BorderLayout());
        JPanel DescriptLabelPanel = new JPanel();

//        company name
        spiralLabel.setFont(new Font("Nunito", Font.BOLD, 40));
        spiralLabel.setForeground(Color.WHITE);
        spiralLabel.setFont(new Font("Nunito", Font.BOLD,40));
        spiralLabel.setForeground(Color.white);

//        left panel
        leftPanel.setBackground(themeColor);
        leftPanel.add(spiralLabel);
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 120, 10, 120));
        leftPanel.setLayout(new GridBagLayout());


        DescriptLabelPanel.setBackground(Color.WHITE);
        DescriptLabelPanel.setLayout(new BorderLayout());
        DescriptLabelPanel.add(levelText, BorderLayout.SOUTH);

//      right panel

        //header
        JLabel registerHeadingLabel = new JLabel("<html>Register Location</html>");
        registerHeadingLabel.setForeground(themeColor);
        registerHeadingLabel.setFont(new Font("Nunito", Font.BOLD,25));
        rightPanel.add(registerHeadingLabel);

        //input fields
        JLabel levelName = new JLabel("Location name");
        JTextField levelNameInput = new JTextField();
        JLabel levelDescription = new JLabel("Description");
        JTextField levelDescrInput = new JTextField();

        JLabel gpsAddress = new JLabel("Location GPS");
        JTextField gpsAddressInput = new JTextField();

//        styling the input labels
        levelName.setFont(new Font("Verdana",Font.PLAIN,16));
        levelDescription.setFont(new Font("Verdana",Font.PLAIN,16));

//      styling the input fields
        levelNameInput.setBorder(new RoundedBorder(15));
        levelDescrInput.setBorder(new RoundedBorder(15));

        rightPanel.setLayout(new GridLayout(9,1, 0, 10));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(30, 120, 30, 120));

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
        rightPanel.add(gpsAddress);
        rightPanel.add(gpsAddressInput);

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

        // panel to window
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        new RegisterLocation();
    }
}
