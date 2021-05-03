import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.xml.stream.events.Comment;
import java.awt.*;

public class TopNav{
    private JFrame window;
    private JPanel navPanel;
    private JPanel panel2;
    private JLabel status;
    JTextField FirstName;
    JTextField LastName;


    public TopNav() {
        layoutInit();
    }

    private static ImageIcon createImageIcon(String path,
                                             String description) {
        java.net.URL imgURL = Comment.class.getResource(path);

        if (imgURL != null) {
            ImageIcon imageIcon = new ImageIcon(imgURL, description);
            Image image=imageIcon.getImage();
            Image newimg = image.getScaledInstance(20, 20,  Image.SCALE_SMOOTH);
            imageIcon=new ImageIcon(newimg);
            return imageIcon;
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }


    public void layoutInit(){
        JFrame window = new JFrame();
        JPanel navPanel = new JPanel(new FlowLayout(SwingConstants.LEADING,130,10));

        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(Color.decode("#F8F8F8"));
        JLabel logoLabel=new JLabel("Spiral");
        logoLabel.setFont(new Font("Nunito", Font.BOLD, 20));
        logoLabel.setForeground(Color.decode("#3674D0"));
        logoPanel.add(logoLabel);
        logoPanel.setPreferredSize(new Dimension(200,50));
        navPanel.add(logoPanel,BorderLayout.LINE_START);



        JPanel searchPanel = new JPanel();
        searchPanel.setSize(600,300);
        searchPanel.setBackground(Color.decode("#F8F8F8"));
        JTextField searchInput=new JTextField("Search",30);
        searchInput.setBorder(new EmptyBorder(0,30,0,0));

        searchInput.setPreferredSize(new Dimension(1,25));
        searchInput.setBorder(new LineBorder(Color.gray,1,true));
        searchPanel.add(searchInput);
        searchPanel.setPreferredSize(new Dimension(800,50));
        navPanel.add(searchPanel,BorderLayout.CENTER);



        JPanel profilePanel = new JPanel(new GridLayout(2,1));
        profilePanel.setBackground(Color.decode("#F8F8F8"));
        ImageIcon profileImage = new ImageIcon("C:\\Users\\DELL\\OneDrive\\Desktop\\logo2.jfif");
        JLabel profileImg = new JLabel(profileImage);

        profileImg.setBounds(140,10,80,15);

        JLabel username = new JLabel("Nyirakamana");
        profilePanel.add(profileImg);
        profilePanel.add(username);

        profilePanel.setPreferredSize(new Dimension(120,50));
        navPanel.add(profilePanel,BorderLayout.LINE_END);



        navPanel.setBackground(Color.decode("#F8F8F8"));
        JPanel navItems = new JPanel(new FlowLayout(SwingConstants.HORIZONTAL));
        navItems.setPreferredSize(new Dimension(1700,300));
        navItems.setBackground(new Color(0,0,0,0));
        navItems.add(navPanel);
        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(1700,750));
        mainPanel.setBackground(Color.decode("#F8F8F8"));
        mainPanel.add(navItems);
        Container container = new Container();
        container = window.getContentPane();
        container.add(mainPanel);

        window.setSize(1800,700);
        window.setVisible(true);


    }
    public static void main(String[] args){
        TopNav topNav = new TopNav();
    }

}
