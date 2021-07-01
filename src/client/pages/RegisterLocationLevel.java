package client.pages;
import client.ClientMain.ClientServerConnector;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.UUID;
import server.Server.Model.RequestBody;
import server.Server.Model.LocationLevels;
import server.Server.Model.ResponseBody;
import server.Server.Model.ResponseStatus;


/**
 *
 * Author :pauline ishimwe
 * this is location views it get all locations from location table and are displayed in a table
 * it allows you navigation to register location page and  add level page
 */
public class RegisterLocationLevel {
    JTextArea levelText;
    JTextArea descriptionText;

    private JFrame registerLocationLevelWindow;
    private JLabel title;
    private JLabel level_name;
    private JLabel description;
    private JLabel text;
    private JLabel spiralHeading;
    private JPanel titlePanel;
    private JPanel formPanel;
    private JButton button;
    public RegisterLocationLevel() throws Exception {
        levelText = new JTextArea();
        descriptionText = new JTextArea();
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
        level_name = new JLabel("Level name");
        level_name.setBounds(510,200,150,40);
        level_name.setForeground(Color.decode("#202020"));
        level_name.setFont(new Font("Verdana", Font.PLAIN, 16));
        levelText = new JTextArea();
        levelText.setBounds(510,250,400,
                40);
        levelText.setBorder(new RoundedBorder(15));
        description = new JLabel("Description");
        description.setBounds(510,300,150,40);
        description.setForeground(Color.decode("#202020"));
        description.setFont(new Font("Verdana", Font.PLAIN, 16));
        descriptionText = new JTextArea();
        descriptionText.setBounds(510,350,400,40);
        descriptionText.setBorder(new RoundedBorder(15));
        button = new JButton("Register");
        button.setBounds(510,450,200,50);
        button.setBackground(Color.decode("#3674D0"));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Verdana", Font.PLAIN, 15));
        button.setBorder(new LineBorder(Color.white,1,true));
        button.setActionCommand("REGISTER");
        button.addActionListener(new ActionListern());
        text = new JLabel("<html>This is where you could register<br/> <p style=\"color:#3674D0;\">location level...</p></html>");
        text.setForeground(Color.decode("#515151"));
        text.setBounds(510,500,300,40);
        registerLocationLevelWindow.add(spiralHeading);
        registerLocationLevelWindow.add(title);
        registerLocationLevelWindow.add(level_name);
        registerLocationLevelWindow.add(levelText);
        registerLocationLevelWindow.add(description);
        registerLocationLevelWindow.add(descriptionText);
        registerLocationLevelWindow.add(button);
        registerLocationLevelWindow.add(text);
        registerLocationLevelWindow.add(titlePanel);
        registerLocationLevelWindow.add(formPanel);
        registerLocationLevelWindow.setVisible(true);
    }

    public void userRegister() throws Exception {
        String level_name = levelText.getText();
        String description = descriptionText.getText();
        String level_id = UUID.randomUUID().toString();

        LocationLevels locationLevels = new LocationLevels();
        locationLevels.setLevel_name(level_name);
        locationLevels.setDescription(description);
        locationLevels.setLevel_id(level_id);

        RequestBody requestBody=new RequestBody();
        requestBody.setUrl("/location-levels");
        requestBody.setAction("register");
        requestBody.setObject(locationLevels);

        ClientServerConnector clientServerConnector = new ClientServerConnector();
        ResponseBody responseBody = clientServerConnector.ConnectToServer(requestBody);

        for(Object response : responseBody.getResponse()){
            ResponseStatus responseStatus = (ResponseStatus) response;
            System.out.println("\t\t -------------------------------------- STATUS: "+responseStatus.getStatus()+" ---------------------------");
            System.out.println("\t\t --------------         Meaning: "+responseStatus.getMessage());
            System.out.println("\t\t --------------         Action: "+responseStatus.getActionToDo());
            System.out.println("\t\t ------------------------------------------------------------------------------");
        }
        showMessageDialog(null, "Registration is done successfully!!!");
    }

    public class ActionListern implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                userRegister();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new RegisterLocationLevel();
    }
}