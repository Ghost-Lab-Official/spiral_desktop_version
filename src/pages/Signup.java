package pages;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Signup {
    private JFrame window;
//    private JLabel welcome;
//    private JLabel title;
//    private JLabel firstName;
//    private JLabel lastName;
//    private JLabel email;
//    private JLabel password;
//    private JLabel location;
//    private JLabel already;
//    private JLabel login;
    private JLabel spiral;
//    private JTextField first;
//    private JTextField last;
//    private JTextField address;
//    private JPasswordField pass;
//    private JTextField place;
    private JPanel titlePanel;
    private JPanel formPanel;



    public Signup()throws IOException{
        formInitiator();
    }
    public void formInitiator()throws IOException {
        window = new JFrame("Signup Form");
        window.setSize(1360,720);
        window.setLayout(null);
        window.setBackground(Color.WHITE);
        window.setVisible(true);
        titlePanel = new JPanel();
        titlePanel.setBounds(0,0,400,720);
        titlePanel.setBackground(Color.cyan);
        spiral = new JLabel("Spiral");
        spiral.setFont(new Font("Verdana", Font.PLAIN, 30));
        spiral.setForeground(Color.white);
        spiral.setBounds(150,300,120,40);
        formPanel = new JPanel();
        formPanel.setBounds(400,0,960,720);
        formPanel.setBackground(Color.white);
        window.add(spiral);
        window.add(titlePanel);
        window.add(formPanel);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("We are in main");
        new Signup();
    }

}
