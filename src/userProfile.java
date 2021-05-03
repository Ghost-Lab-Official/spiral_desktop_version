import javax.swing.*;
import java.awt.*;

public class userProfile extends JFrame {

    private JPanel sideBar;
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel sideMenu;
    private JLabel logo;
    private JLabel menuTitle;
    private JMenuBar sideMenuContents;
    private final Color textColor = Color.decode("#3674D0");
    private final Color bgColor = Color.decode("#F2F6FF");

    public userProfile(){
        setTitle("user profile");
        setSize(1000,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(bgColor);
        boardUI();
    }
    public void  boardUI(){
//        creating contents

        sideBar = new JPanel();
        sideMenu = new JPanel();
        sideMenuContents = new JMenuBar();
        BoxLayout boxLayout = new BoxLayout(sideMenu, BoxLayout.Y_AXIS);
        BoxLayout sideMenuLayout = new BoxLayout(sideMenuContents, BoxLayout.PAGE_AXIS);
        mainPanel=new JPanel(new BorderLayout());
        leftPanel=new JPanel(new BorderLayout());
        logo=new JLabel("<html><strong><font size='8' color='#3674D0'>Sp</font><font size='8' color='black'>iral</font></strong></html>");
        menuTitle = new JLabel("User Profile");
        JMenu dashboard = new JMenu("Dashboard");
        JMenu userInfo = new JMenu("User info");
        JMenu password = new JMenu("Change password");
        JMenu settings = new JMenu("Settings");
        JMenu notification = new JMenu("Notifications");


//    Contents properties
//        sideMenu.setLayout(boxLayout);
        sideMenuContents.setLayout(sideMenuLayout);
        sideMenuContents.setBackground(Color.WHITE);
        sideMenuContents.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        sideMenuContents.setOpaque(true);
        sideMenu.setBackground(Color.WHITE);
        logo.setFont(new Font("Nunito", Font.BOLD, 25));
        menuTitle.setFont(new Font("Nunito", Font.BOLD, 23));
        dashboard.setFont(new Font("Nunito", Font.PLAIN, 20));
        userInfo.setFont(new Font("Nunito", Font.BOLD, 20));
        password.setFont(new Font("Nunito", Font.PLAIN, 20));
        settings.setFont(new Font("Nunito", Font.PLAIN, 20));
        notification.setFont(new Font("Nunito", Font.PLAIN, 20));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        int wid = (int) (Math.round(width * 0.20));
        double height = screenSize.getHeight();
        sideBar.setPreferredSize(new Dimension(wid,(int)height));
        sideBar.setLayout(new BorderLayout());
        sideBar.setBackground(Color.white);
        
        sideBar.add(logo,BorderLayout.PAGE_START);
        sideMenu.add(menuTitle);
        sideMenuContents.add(dashboard);
        sideMenuContents.add(userInfo);
        sideMenuContents.add(password);
        sideMenuContents.add(settings);
        sideMenuContents.add(notification);
        sideMenu.add(sideMenuContents);
        sideBar.add(sideMenu);
        leftPanel.setBackground(bgColor);
        mainPanel.add(sideBar,BorderLayout.WEST);
        mainPanel.add(leftPanel,BorderLayout.EAST);
//
        add(mainPanel);
    }
    public static void main(String[] args) {
        new userProfile();
    }
}
