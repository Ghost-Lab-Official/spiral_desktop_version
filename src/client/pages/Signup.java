package client.pages;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;

import server.Server.DbController.CloudStorageConnectionHandler;
import server.Server.Controllers.UserModuleControllers.Register;

/**
 * @Author: MANZI Mike
 * @Author: MUKUNDWA Ange Nicole
 * @Description: This is a class for user registration
 *
 *  */

public class Signup{
    private JFrame window;
    private JLabel welcome;
    private JLabel title;
    private JLabel firstName;
    private JLabel lastName;
    private JLabel email;
    private JLabel username;
    private JLabel password;
    private JLabel location;
    private JLabel already;
    private JLabel login;
    private JLabel spiral;
    private JTextField first;
    private JTextField last;
    private JTextField address;
    private JTextField name;
    private JPasswordField pass;
    private JTextField place;
    private JButton signin;
    private JPanel titlePanel;
    private JPanel formPanel;
    private JButton btn;
    private Connection conn;


    public Signup() throws Exception {
        conn= new CloudStorageConnectionHandler().getConnection();
        formInitiator();
    }
    public void formInitiator()throws IOException {
        window = new JFrame("Signup Form");
        window.setSize(1000,730);
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
        welcome.setBounds(510,20,120,20);
        welcome.setForeground(Color.decode("#515151"));
        welcome.setFont(new Font("Nunito", Font.BOLD,13));
        title = new JLabel("Sign Up");
        title.setBounds(510,40,150,40);
        title.setFont(new Font("verdana", Font.PLAIN, 30));
        title.setForeground(Color.decode("#3674D0"));
        firstName = new JLabel("First name");
        firstName.setBounds(510,100,150,40);
        firstName.setFont(new Font("verdana", Font.PLAIN, 14));
        firstName.setForeground(Color.decode("#202020"));
        first = new JTextField();
        first.setBounds(510,150,180,40);
        first.setBorder(new LineBorder(Color.BLACK,1,true));
        lastName = new JLabel("Last name");
        lastName.setBounds(730,100,150,40);
        lastName.setFont(new Font("verdana", Font.PLAIN, 14));
        lastName.setForeground(Color.decode("#202020"));
        last = new JTextField();
        last.setBounds(730,150,180,40);
        last.setBorder(new LineBorder(Color.BLACK,1,true));
        email = new JLabel("Email");
        email.setBounds(510,200,150,40);
        email.setForeground(Color.decode("#202020"));
        email.setFont(new Font("Nunito", Font.PLAIN, 14));
        address = new JTextField();
        address.setBounds(510,250,400,40);
        address.setBorder(new LineBorder(Color.BLACK,1,true));
        username = new JLabel("Username");
        username.setBounds(510,300,150,40);
        username.setForeground(Color.decode("#202020"));
        username.setFont(new Font("Nunito", Font.PLAIN, 14));
        name = new JTextField();
        name.setBounds(510,350,400,40);
        name.setBorder(new LineBorder(Color.BLACK,1,true));
        password = new JLabel("Password");
        password.setBounds(510,400,150,40);
        password.setForeground(Color.decode("#202020"));
        password.setFont(new Font("Nunito", Font.PLAIN, 14));
        pass = new JPasswordField();
        pass.setBounds(510,450,400,40);
        pass.setBorder(new LineBorder(Color.BLACK,1,true));
        location = new JLabel("Location");
        location.setBounds(510,500,150,40);
        location.setForeground(Color.decode("#202020"));
        location.setFont(new Font("Nunito", Font.PLAIN, 14));
        place = new JTextField();
        place.setBounds(510,550,400,40);
        place.setBorder(new LineBorder(Color.BLACK,1,true));
        btn = new JButton("Sign Up");
        btn.setBounds(510,600,90,40);
        btn.setBackground(Color.decode("#3674D0"));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("verdana", Font.PLAIN, 15));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setActionCommand("SIGNUP");
        btn.addActionListener(new ActListener());
        already = new JLabel("Already have an account?");
        already.setForeground(Color.decode("#515151"));
        already.setBounds(510,650,150,40);
        login = new JLabel("Login");
        login.setForeground(Color.decode("#3674D0"));
        login.setBounds(660,650,50,40);
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                window.dispose();
                new Login();
            }
        });
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
        window.add(btn);
        window.add(already);
        window.add(login);
        window.add(titlePanel);
        window.add(formPanel);
        window.setVisible(true);
    }



    public static void main(String[] args) throws Exception {
        new Signup();
    }

    public class ActListener extends  Register implements java.awt.event.ActionListener{

        public ActListener(){}

        @Override
        public void actionPerformed(ActionEvent e) {
            if("SIGNUP".equals(e.getActionCommand())){
                try {
                    if(first.getText().equals("") || last.getText().equals("") || name.getText().equals("") || address.getText().equals("") || pass.getPassword().toString().equals("") || place.getText().equals("")) {
                        JOptionPane.showMessageDialog(window, "All Fields Are Required.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return;
                    }else{
                        boolean registered = this.registerUser(
                                conn,
                                first.getText(),
                                last.getText(),
                                name.getText(),
                                address.getText(),
                                "Male",
                                "2021/06/06",
                                pass.getPassword().toString(),
                                place.getText()
                        );
                        if(registered==true){
                            JOptionPane.showMessageDialog(window,"User Registered", "SUCCESSFUL.", JOptionPane.INFORMATION_MESSAGE);
                           first.setText("");
                           last.setText("");
                           name.setText("");
                           address.setText("");
                           pass.setText("");
                           place.setText("");
                           window.dispose();
                           new Login();
                        }else{
                            JOptionPane.showMessageDialog(window,"Registration Failed", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(window,ex.getMessage(), "SOMETHING WENT WRONG", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        }
    }
}
