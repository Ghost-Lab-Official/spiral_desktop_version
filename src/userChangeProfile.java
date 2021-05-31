
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class userChangeProfile {
    JFrame dashBoard;
    JPanel sideBar;
    JPanel users;
    JLabel DashboardLabel,UserLabel,changePasswordLabel,notificationsLLabel,SettingsLabel,LogoutLabel,Users2Label;
    JLabel dashboardIconLabel,usersIconLabel,changePasswordIconLabel,notificationsIconLabel,settingsIconLabel,logoutIconLabel,users2IconLabel;
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
        DashboardLabel = new JLabel("Dashboard");
        DashboardLabel.setFont(new Font("Roboto",Font.BOLD,20));
        DashboardLabel.setForeground(Color.black);
        img1 = ImageIO.read(new File("src\\images\\dashboard1.png"));
        icon1 = new ImageIcon(img1.getScaledInstance(15,15,BufferedImage.SCALE_DEFAULT));
        dashboardIconLabel= new JLabel();
        dashboardIconLabel.setBounds(20,70,20,20);
        dashboardIconLabel.setIcon(icon1);
        DashboardLabel.setBounds(50,70,250,20);
        UserLabel = new JLabel("Users");
        UserLabel.setFont(new Font("Roboto",Font.BOLD,20));
        UserLabel.setForeground(Color.black);
        img2 = ImageIO.read(new File("src\\images\\UserBlack.png"));
        icon2 = new ImageIcon(img2.getScaledInstance(15,15,BufferedImage.SCALE_DEFAULT));
        usersIconLabel = new JLabel();
        usersIconLabel.setBounds(20,130,40,40);
        usersIconLabel.setIcon(icon2);
        UserLabel.setBounds(50,140,250,20);
        changePasswordLabel = new JLabel("change Password");
        changePasswordLabel.setFont(new Font("Roboto",Font.BOLD,20));
        changePasswordLabel.setForeground(Color.black);
        img3 = ImageIO.read(new File("src\\images\\password.png"));
        icon3 = new ImageIcon(img3.getScaledInstance(15,15,BufferedImage.SCALE_DEFAULT));
        changePasswordIconLabel = new JLabel();
        changePasswordIconLabel.setBounds(20,200,20,20);
        changePasswordIconLabel.setIcon(icon3);
        changePasswordLabel.setBounds(50,200,250,25);

        notificationsLLabel = new JLabel("Notifications");
        notificationsLLabel.setFont(new Font("Roboto",Font.BOLD,20));
        notificationsLLabel.setForeground(Color.black);
        img5 = ImageIO.read(new File("src\\images\\notifications.png"));
        icon5 = new ImageIcon(img5.getScaledInstance(15,15,BufferedImage.SCALE_DEFAULT));
        notificationsIconLabel = new JLabel();
        notificationsIconLabel.setBounds(20,420,250,25);
        notificationsIconLabel.setIcon(icon5);
        notificationsLLabel.setBounds(50,420,250,25);
        SettingsLabel = new JLabel("Settings");
        SettingsLabel.setFont(new Font("Roboto",Font.BOLD,20));
        SettingsLabel.setForeground(Color.black);
        img6 = ImageIO.read(new File("src\\images\\settingsBlack.png"));
        icon6 = new ImageIcon(img6.getScaledInstance(15,15,BufferedImage.SCALE_DEFAULT));
        settingsIconLabel = new JLabel();
        settingsIconLabel.setBounds(20,260,250,25);
        settingsIconLabel.setIcon(icon6);
        SettingsLabel.setBounds(52,260,250,25);
        LogoutLabel = new JLabel("Logout");
        LogoutLabel.setBounds(50,520,250,25);
        LogoutLabel.setFont(new Font("Roboto",Font.BOLD,20));
        LogoutLabel.setForeground(Color.black);
        img7 = ImageIO.read(new File("src\\images\\logoutBlack.png"));
        icon7 = new ImageIcon(img7.getScaledInstance(15,15,BufferedImage.SCALE_DEFAULT));
        logoutIconLabel = new JLabel();
        logoutIconLabel.setBounds(20,520,250,25);
        logoutIconLabel.setIcon(icon7);
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

        sideBar.setBounds(0,80,wid,(int)height);
        sideBar.setBackground(Color.decode("#F2F6FF"));
//        users.setBounds(300,130,200,100);
//        users.setLayout(null);
//        users.setBackground(Color.decode("#fe3f3f"));
//        img8 = ImageIO.read(new File("src\\images\\users2.png"));
//        icon8 = new ImageIcon(img8.getScaledInstance(40,40,BufferedImage.SCALE_DEFAULT));
//        users2IconLabel = new JLabel();
//        users2IconLabel.setBounds(80,15,400,40);
//        users2IconLabel.setIcon(icon8);
//        Users2Label = new JLabel("Users");
//        Users2Label.setFont(new Font("Roboto",Font.BOLD,20));
//        Users2Label.setForeground(Color.black);
//        Users2Label.setBounds(80,20,100,100);
//        users.add(users2IconLabel);
//        users.add(Users2Label);


        dashBoard.add(sideBar);
        dashBoard.add(users);
        dashBoard.setLayout(null);
        dashBoard.setSize(1920,900);
        dashBoard.setVisible(true);
    }
//    public void setProgressBarValue(){
//        int i=0;
//        try{
//            while (i<=100){
//                mostViewedSpotPb.setValue(i+10);
//                Thread.sleep(1000);
//                i+=20;
//            }
//        }catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
//    }
    public static void main(String args[]) throws IOException{
        userChangeProfile profile = new userChangeProfile();
//        profile.setProgressBarValue();
    }
}
