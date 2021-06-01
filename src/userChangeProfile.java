
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class userChangeProfile {
    JFrame dashBoard;
    JPanel sideBar;
    JPanel users;
    JButton editProfile;
    JTextField firstNameField,lastNameField,emailField,phoneField,locationField,passwordField;
    JLabel firstNameLabel,lastNameLabel,emailLabel,phoneLabel,locationLabel,passwordLabel;
    JLabel DashboardLabel,UserLabel,changePasswordLabel,notificationsLLabel,SettingsLabel,LogoutLabel;
    JLabel dashboardIconLabel,usersIconLabel,changePasswordIconLabel,notificationsIconLabel,settingsIconLabel,logoutIconLabel,logo,menuTitle;
    ImageIcon icon1,icon2,icon3,icon4,icon5,icon6,icon7,icon8,icon9,icon10,icon12;
    BufferedImage img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img12;
    JProgressBar mostViewedSpotPb;
    public final Color textColor = Color.decode("#3674D0");
    public final Color bgColor = Color.decode("#F2F6FF");

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    int wid = (int) (Math.round(width * 0.20));
    double height = screenSize.getHeight();

    public userChangeProfile() throws IOException {

        dashBoard = new JFrame("Dashboard");
        sideBar = new JPanel();
        sideBar.setLayout(null);

        logo=new JLabel("<html><strong><font color='#3674D0'>Sp</font><font color='black'>iral</font></strong></html>");
        logo.setFont(new Font("Roboto",Font.BOLD,40));
        logo.setForeground(Color.black);
        logo.setBounds(20,30,300,60);

        menuTitle = new JLabel("User Profile");
        menuTitle.setFont(new Font("Roboto",Font.BOLD,26));
        menuTitle.setForeground(Color.black);
        menuTitle.setBounds(20,150,300,25);

        DashboardLabel = new JLabel("Dashboard");
        DashboardLabel.setFont(new Font("Roboto",Font.BOLD,20));
        DashboardLabel.setForeground(Color.black);
        img1 = ImageIO.read(new File("src\\images\\dashboard1.png"));
        icon1 = new ImageIcon(img1.getScaledInstance(15,15,BufferedImage.SCALE_DEFAULT));
        dashboardIconLabel= new JLabel();
        dashboardIconLabel.setBounds(30,230,20,20);
        dashboardIconLabel.setIcon(icon1);
        DashboardLabel.setBounds(60,230,250,20);

        UserLabel = new JLabel("Users");
        UserLabel.setFont(new Font("Roboto",Font.BOLD,20));
        UserLabel.setForeground(Color.black);
        img2 = ImageIO.read(new File("src\\images\\UserBlack.png"));
        icon2 = new ImageIcon(img2.getScaledInstance(15,15,BufferedImage.SCALE_DEFAULT));
        usersIconLabel = new JLabel();
        usersIconLabel.setBounds(30,280,40,40);
        usersIconLabel.setIcon(icon2);
        UserLabel.setBounds(60,291,250,20);

        changePasswordLabel = new JLabel("change Password");
        changePasswordLabel.setFont(new Font("Roboto",Font.BOLD,20));
        changePasswordLabel.setForeground(Color.black);
        img3 = ImageIO.read(new File("src\\images\\password.png"));
        icon3 = new ImageIcon(img3.getScaledInstance(15,15,BufferedImage.SCALE_DEFAULT));
        changePasswordIconLabel = new JLabel();
        changePasswordIconLabel.setBounds(30,350,20,20);
        changePasswordIconLabel.setIcon(icon3);
        changePasswordLabel.setBounds(60,350,250,25);

        notificationsLLabel = new JLabel("Notifications");
        notificationsLLabel.setFont(new Font("Roboto",Font.BOLD,20));
        notificationsLLabel.setForeground(Color.black);
        img5 = ImageIO.read(new File("src\\images\\notifications.png"));
        icon5 = new ImageIcon(img5.getScaledInstance(15,15,BufferedImage.SCALE_DEFAULT));
        notificationsIconLabel = new JLabel();
        notificationsIconLabel.setBounds(30,470,250,25);
        notificationsIconLabel.setIcon(icon5);
        notificationsLLabel.setBounds(60,470,250,25);

        SettingsLabel = new JLabel("Settings");
        SettingsLabel.setFont(new Font("Roboto",Font.BOLD,20));
        SettingsLabel.setForeground(Color.black);
        img6 = ImageIO.read(new File("src\\images\\settingsBlack.png"));
        icon6 = new ImageIcon(img6.getScaledInstance(15,15,BufferedImage.SCALE_DEFAULT));
        settingsIconLabel = new JLabel();
        settingsIconLabel.setBounds(30,410,250,25);
        settingsIconLabel.setIcon(icon6);
        SettingsLabel.setBounds(62,410,250,25);

        LogoutLabel = new JLabel("Logout");
        LogoutLabel.setBounds(90,600,250,25);
        LogoutLabel.setFont(new Font("Roboto",Font.BOLD,20));
        LogoutLabel.setForeground(Color.decode("#3674D0"));
        img7 = ImageIO.read(new File("src\\images\\logoutBlue.png"));
        icon7 = new ImageIcon(img7.getScaledInstance(15,15,BufferedImage.SCALE_DEFAULT));
        logoutIconLabel = new JLabel();
        logoutIconLabel.setBounds(50,600,250,25);
        logoutIconLabel.setIcon(icon7);

        sideBar.add(logo);
        sideBar.add(menuTitle);
        sideBar.add(dashboardIconLabel);
        sideBar.add(DashboardLabel);
        sideBar.add(usersIconLabel);
        sideBar.add(UserLabel);
        sideBar.add(changePasswordIconLabel);
        sideBar.add(changePasswordLabel);
        sideBar.add(notificationsIconLabel);
        sideBar.add(notificationsLLabel);
        sideBar.add(settingsIconLabel);
        sideBar.add(SettingsLabel);
        sideBar.add(logoutIconLabel);
        sideBar.add(LogoutLabel);

        users = new JPanel();
        users.setBounds(300,130,200,100);
        users.setLayout(null);
        users.setBackground(Color.decode("#fe3f3f"));

        firstNameLabel = new JLabel("First Name");
        firstNameLabel.setFont(new Font("Roboto",Font.BOLD,16));
        firstNameLabel.setForeground(Color.black);
        firstNameLabel.setBounds(300,250,200,30);
        firstNameField = new JTextField();
        firstNameField.setBounds(300,290,200,40);

        lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setFont(new Font("Roboto",Font.BOLD,16));
        lastNameLabel.setForeground(Color.black);
        lastNameLabel.setBounds(600,250,200,30);
        lastNameField = new JTextField();
        lastNameField.setBounds(600,290,200,40);

        emailLabel = new JLabel("Email Address");
        emailLabel.setFont(new Font("Roboto",Font.BOLD,16));
        emailLabel.setForeground(Color.black);
        emailLabel.setBounds(300,350,200,30);
        emailField = new JTextField();
        emailField.setBounds(300,390,200,40);

        phoneLabel = new JLabel("Phone number");
        phoneLabel.setFont(new Font("Roboto",Font.BOLD,16));
        phoneLabel.setForeground(Color.black);
        phoneLabel.setBounds(600,350,200,30);
        phoneField = new JTextField();
        phoneField.setBounds(600,390,200,40);

        locationLabel = new JLabel("Location");
        locationLabel.setFont(new Font("Roboto",Font.BOLD,16));
        locationLabel.setForeground(Color.black);
        locationLabel.setBounds(300,450,200,30);
        locationField = new JTextField();
        locationField.setBounds(300,490,200,40);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Roboto",Font.BOLD,16));
        passwordLabel.setForeground(Color.black);
        passwordLabel.setBounds(600,450,200,30);
        passwordField = new JTextField();
        passwordField.setBounds(600,490,200,40);

        editProfile = new JButton("Edit Profile");
        editProfile.setFont(new Font("Roboto",Font.BOLD,16));
        editProfile.setForeground(Color.white);
        editProfile.setBackground(Color.decode("#3674D0"));
        editProfile.setBounds(300,600,150,40);


        sideBar.setSize(wid,(int)height);
        sideBar.setBackground(Color.WHITE);

        dashBoard.setBackground(Color.decode("#F2F6FF"));
        dashBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashBoard.add(sideBar);
        dashBoard.add(users);
        dashBoard.add(firstNameLabel);
        dashBoard.add(firstNameField);
        dashBoard.add(lastNameLabel);
        dashBoard.add(lastNameField);
        dashBoard.add(emailLabel);
        dashBoard.add(emailField);
        dashBoard.add(phoneLabel);
        dashBoard.add(phoneField);
        dashBoard.add(locationLabel);
        dashBoard.add(locationField);
        dashBoard.add(passwordLabel);
        dashBoard.add(passwordField);
        dashBoard.add(editProfile);
        dashBoard.setLayout(null);
        dashBoard.setSize(1200,750);
        dashBoard.setVisible(true);
    }

    public static void main(String args[]) throws IOException{
        userChangeProfile profile = new userChangeProfile();
    }
}
