
package client.resultDetails;


import javax.swing.*;
import java.awt.*;

public class CommentPanel extends JPanel {

    public CommentPanel() {
    }
    public ImageIcon createImageIconResizeable(String path,
                                               String description, int w, int h) {
        java.net.URL imgURL = CommentPanel.class.getResource(path);

        if (imgURL != null) {
            ImageIcon imageIcon = new ImageIcon(imgURL, description);
            Image image=imageIcon.getImage();
            Image newimg = image.getScaledInstance(w, h,  Image.SCALE_SMOOTH);
            imageIcon=new ImageIcon(newimg);
            return imageIcon;
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    public ImageIcon createImageIcon(String path,
                                             String description) {
        java.net.URL imgURL = CommentPanel.class.getResource(path);

        if (imgURL != null) {
            ImageIcon imageIcon = new ImageIcon(imgURL, description);
            Image image=imageIcon.getImage();
            Image newimg = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
            imageIcon=new ImageIcon(newimg);
            return imageIcon;
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    CommentPanel(String username, String bodytext1, int likesNumber)
    {



//        JPanel comment=new JPanel();
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#C5C5C5")));
        this.setLayout(null);
//        this.setBackground(Color.decode("#F6F6F6"));
        JLabel user=new JLabel(username);
        user.setFont(new Font("Verdana", Font.BOLD, 15));
        user.setBounds(30,15,150,20);
        user.setForeground(Color.decode("#3674D0"));
        String template="<html>%s</p><html>";
        String text=String.format(template,bodytext1);
        JLabel body=new JLabel(text);
        body.setFont(new Font("Verdana", Font.PLAIN, 10));
        body.setBounds(30,20,200,100);
        ImageIcon icon = createImageIcon("/client/images/like.png","like");

        JLabel likeIcon = new JLabel(icon);
        likeIcon.setBounds(140,10,40,25);
        JLabel likes=new JLabel("6");
        likes.setFont(new Font("Verdana", Font.BOLD, 12));
        likes.setBounds(175,20,20,10);
        likes.setForeground(Color.decode("#878787"));
        this.add(user);
        this.add(body);
        this.add(likeIcon);
        this.add(likes);
    }

}
