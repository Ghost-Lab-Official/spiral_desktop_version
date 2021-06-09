package client.resultDetails;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class userTopNav extends JFrame {

    userTopNav() throws IOException {
        topnavInit();
    }

    public static BufferedImage makeRoundedCorner(BufferedImage image, int cornerRadius) {
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage output = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = output.createGraphics();
        g2.setComposite(AlphaComposite.Src);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fill(new RoundRectangle2D.Float(0, 0, w, h, cornerRadius, cornerRadius));
        
        g2.setComposite(AlphaComposite.SrcAtop);
        g2.drawImage(image, 0, 0, null);

        g2.dispose();

        return output;
    }

    public void topnavInit() throws IOException {
        JFrame window = new JFrame();
        JPanel navigationPanel = new JPanel();
        navigationPanel.setLayout(new BorderLayout());

        navigationPanel.setPreferredSize(new Dimension(600,140));
        navigationPanel.setBackground(Color.decode("#FFFFFF"));

        JPanel logoPanel = new JPanel();
        logoPanel.setBorder(BorderFactory.createEmptyBorder(30,5,0,5));
        logoPanel.setBackground(Color.decode("#FFFFFF"));
        ImageIcon logoImage = new ImageIcon("C:\\Users\\DELL\\OneDrive\\Desktop\\spirallogo.png");
        JLabel logoImg = new JLabel(logoImage);
        logoPanel.add(logoImg);
        navigationPanel.add(logoPanel, BorderLayout.WEST);

        JPanel searchPanel = new JPanel();
        searchPanel.setSize(600,300);
        JTextField searchInput=new JTextField("Search",30);
        searchInput.setBorder(new RoundedBoarder(10));
        searchInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.setBorder(BorderFactory.createEmptyBorder(35, 5, 0, 5));
        searchPanel.setBackground(Color.decode("#FFFFFF"));
        searchPanel.add(searchInput);
        navigationPanel.add(searchPanel, BorderLayout.CENTER);


        JPanel profilePanel = new JPanel();
        profilePanel.setBackground(Color.decode("#FFFFFF"));
        profilePanel.setBorder(BorderFactory.createEmptyBorder(30,5,0,35));
        ImageIcon profileImage = new ImageIcon("C:\\Users\\DELL\\OneDrive\\Desktop\\logo.jpg");
        JButton profileImg = new JButton(profileImage);
        profileImg.setPreferredSize(new Dimension(120,40));
        profileImg.setBorder(BorderFactory.createEmptyBorder(1,3,5,10));
        profileImg.setBorder(new LineBorder(Color.gray,1,true));
        profileImg.setBorder(new RoundedBoarder(50));

        profilePanel.add(profileImg);
        navigationPanel.add(profilePanel, BorderLayout.EAST);

        navigationPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

        window.add(navigationPanel, BorderLayout.PAGE_START);

        window.setSize(1800,700);
        window.setVisible(true);

    }

    public static void main(String[] args) throws IOException {
        userTopNav userTopNav = new userTopNav();
    }

}
