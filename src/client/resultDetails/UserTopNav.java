package client.resultDetails;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class UserTopNav extends JFrame {
 public UserTopNav(){

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

    public JPanel topnavInit() throws IOException {
        JFrame window = new JFrame();
        JPanel navigationPanel = new JPanel();
        navigationPanel.setLayout(new BorderLayout());

        navigationPanel.setPreferredSize(new Dimension(600,140));
        navigationPanel.setBackground(Color.decode("#FFFFFF"));

        JPanel logoPanel = new JPanel();
        logoPanel.setBorder(BorderFactory.createEmptyBorder(30,5,0,5));
        logoPanel.setBackground(Color.decode("#FFFFFF"));
        ImageIcon logoImage = new ImageIcon("src/client/images/spirallogo.png");
        JLabel logoImg = new JLabel(logoImage);
        logoPanel.add(logoImg);
        logoPanel.setBounds(-10,-15,300,100);
        navigationPanel.add(logoPanel, BorderLayout.WEST);

        JPanel searchPanel = new JPanel();
//        searchPanel.setSize(600,300);
        searchPanel.setBounds(250,-10,600,300);
        JTextField searchInput=new JTextField("Search",30);
        searchInput.setBorder(new RoundedBoarder(10));
        searchInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.setBorder(BorderFactory.createEmptyBorder(35, 5, 0, 5));
        searchPanel.setBackground(Color.decode("#FFFFFF"));
        searchPanel.add(searchInput);
        navigationPanel.add(searchPanel, BorderLayout.CENTER);


        JPanel profilePanel = new JPanel();
        profilePanel.setBackground(Color.decode("#FFFFFF"));
        profilePanel.setSize(100,40);
        profilePanel.setBorder(BorderFactory.createEmptyBorder(10,2,0,45));
        BufferedImage img = null;

        img = ImageIO.read(new File("src/client/images/profile.png"));
        Image dimg = img.getScaledInstance(80,80,
                Image.SCALE_DEFAULT);


        ImageIcon profileImage = new ImageIcon(dimg);
        JLabel profileImg = new JLabel(profileImage);

        JLabel username = new JLabel("Nyirakamana");
        profilePanel.add(username);
        profilePanel.add(profileImg);
//        navigationPanel.setLayout(null);
//        navigationPanel.setBounds(400,0,200,200);
        navigationPanel.add(profilePanel, BorderLayout.EAST);

        navigationPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

        return navigationPanel;

    }
}
