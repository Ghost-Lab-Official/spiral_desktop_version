package pages;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;

public class RegisterLocationLevel {
    private JFrame registerLocationLevelWindow;
    private JLabel title;
    private JLabel levelName;
    private JLabel description;
    private JLabel text;
    private JLabel spiralHeading;
    private JTextField levelText;
    private JTextArea descriptionText;
    private JPanel titlePanel;
    private JPanel formPanel;
    private JButton button;


    public RegisterLocationLevel()throws IOException{
        formGui();
    }
    public void formGui()throws IOException {
        registerLocationLevelWindow = new JFrame("Register Location Level Form");
        registerLocationLevelWindow.setSize(1370,730);
        registerLocationLevelWindow.setLayout(null);
        registerLocationLevelWindow.setBackground(Color.WHITE);

        titlePanel = new JPanel();
        titlePanel.setBounds(0,0,400,720);
        titlePanel.setBackground(Color.decode("#3674D0"));
        spiralHeading = new JLabel("Spiral");
        spiralHeading.setFont(new Font("Nunito", Font.BOLD, 30));
        spiralHeading.setForeground(Color.white);
        spiralHeading.setBounds(150,300,120,40);
        formPanel = new JPanel();
        formPanel.setBounds(400,0,960,720);
        formPanel.setBackground(Color.white);
        title = new JLabel("<html>Register Location<br/> Level</html>");
        title.setBounds(510,15,400,150);
        title.setFont(new Font("verdana", Font.PLAIN, 30));
        title.setForeground(Color.decode("#3674D0"));
        levelName = new JLabel("Level name");
        levelName.setBounds(510,200,150,40);
        levelName.setForeground(Color.decode("#202020"));
        levelName.setFont(new Font("verdana", Font.PLAIN, 14));
        levelText = new JTextField();
        levelText.setBounds(510,250,400,40);
        levelText.setBorder(new LineBorder(Color.BLACK,1,true));
        description = new JLabel("Description");
        description.setBounds(510,300,150,40);
        description.setForeground(Color.decode("#202020"));
        description.setFont(new Font("verdana", Font.PLAIN, 14));
        descriptionText = new JTextArea();
        descriptionText.setBounds(510,350,400,40);
        descriptionText.setBorder(new LineBorder(Color.BLACK,1,true));
        button = new JButton("Register");
        button.setBounds(510,450,200,50);
        button.setBackground(Color.decode("#3674D0"));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("verdana", Font.PLAIN, 15));
        button.setBorder(new LineBorder(Color.white,1,true));
        text = new JLabel("<html>This is where you could register<br/> <p style=\"color:blue;\">location level...</p></html>");
        text.setForeground(Color.decode("#515151"));
        text.setBounds(510,500,300,40);
        registerLocationLevelWindow.add(spiralHeading);
        registerLocationLevelWindow.add(title);
        registerLocationLevelWindow.add(levelName);
        registerLocationLevelWindow.add(levelText);
        registerLocationLevelWindow.add(description);
        registerLocationLevelWindow.add(descriptionText);
        registerLocationLevelWindow.add(button);
        registerLocationLevelWindow.add(text);
        registerLocationLevelWindow.add(titlePanel);
        registerLocationLevelWindow.add(formPanel);
        registerLocationLevelWindow.setVisible(true);
    }



    public static void main(String[] args) throws Exception {
        new RegisterLocationLevel();
    }

}
