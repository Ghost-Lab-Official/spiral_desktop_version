package pages;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;

public class Signup {
    private JFrame window;
    private JLabel welcome;
    private JLabel title;
    private JLabel firstName;
    private JLabel lastName;
    private JLabel email;
    private JLabel username;
    private JLabel password;
    private JLabel location;
//    private JLabel already;
//    private JLabel login;
    private JLabel spiral;
    private JTextField first;
    private JTextField last;
    private JTextField address;
    private JTextField name;
    private JPasswordField pass;
    private JTextField place;
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

        titlePanel = new JPanel();
        titlePanel.setBounds(0,0,400,720);
        titlePanel.setBackground(Color.decode("#3674D0"));
        spiral = new JLabel("Spiral");
        spiral.setFont(new Font("Nunito", Font.BOLD, 30));
        spiral.setForeground(Color.white);
        spiral.setBounds(150,300,120,40);
        formPanel = new JPanel();
        formPanel.setBounds(400,0,960,720);
        formPanel.setBackground(Color.white);
        welcome = new JLabel("Welcome to Spiral");
        welcome.setBounds(510,50,120,20);
        welcome.setForeground(Color.decode("#515151"));
        title = new JLabel("Sign Up");
        title.setBounds(510,90,150,40);
        title.setFont(new Font("verdana", Font.PLAIN, 30));
        title.setForeground(Color.decode("#3674D0"));
        firstName = new JLabel("First name");
        firstName.setBounds(510,150,150,40);
        firstName.setFont(new Font("verdana", Font.PLAIN, 14));
        firstName.setForeground(Color.decode("#202020"));
        first = new JTextField();
        first.setBounds(510,190,180,40);
        first.setBorder(new LineBorder(Color.GRAY,1,true));
        lastName = new JLabel("Last name");
        lastName.setBounds(730,150,150,40);
        lastName.setFont(new Font("verdana", Font.PLAIN, 14));
        lastName.setForeground(Color.decode("#202020"));
        last = new JTextField();
        last.setBounds(730,190,180,40);
        last.setBorder(new LineBorder(Color.GRAY,1,true));
        email = new JLabel("Email");
        email.setBounds(510,230,150,40);
        email.setForeground(Color.decode("#202020"));
        email.setFont(new Font("verdana", Font.PLAIN, 14));
        address = new JTextField();
        address.setBounds(510,270,400,40);
        address.setBorder(new LineBorder(Color.GRAY,1,true));
        username = new JLabel("Username");
        username.setBounds(510,310,150,40);
        username.setForeground(Color.decode("#202020"));
        username.setFont(new Font("verdana", Font.PLAIN, 14));
        name = new JTextField();
        name.setBounds(510,350,400,40);
        name.setBorder(new LineBorder(Color.GRAY,1,true));
        password = new JLabel("Password");
        password.setBounds(510,390,150,40);
        password.setForeground(Color.decode("#202020"));
        password.setFont(new Font("verdana", Font.PLAIN, 14));
        pass = new JPasswordField();
        pass.setBounds(510,430,400,40);
        pass.setBorder(new LineBorder(Color.GRAY,1,true));
        location = new JLabel("Location");
        location.setBounds(510,470,150,40);
        location.setForeground(Color.decode("#202020"));
        location.setFont(new Font("verdana", Font.PLAIN, 14));
        place = new JTextField();
        place.setBounds(510,510,400,40);
        place.setBorder(new LineBorder(Color.GRAY,1,true));



        window.add(spiral);
        window.add(welcome);
        window.add(title);
        window.add(firstName);
        window.add(first);
        window.add(lastName);
        window.add(last);
        window.add(email);
        window.add(address);
        window.add(username);
        window.add(name);
        window.add(password);
        window.add(pass);
        window.add(location);
        window.add(place);
        window.add(titlePanel);
        window.add(formPanel);
        window.setVisible(true);

    }

    public static void main(String[] args) throws Exception {
        new Signup();
    }

}
