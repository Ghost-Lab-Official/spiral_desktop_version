package client.pages;

import javax.swing.*;
<<<<<<< HEAD
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
=======
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
>>>>>>> d3cbee5dde6691de8ab652e5c49bd56983c38f24


public class Login extends JFrame {
    private static final long serialVersionUID = 4924551093376342051L;
    private static final Color themeColor = Color.decode("#3674D0");
    private int radius;

    public Login() {
        super("Login To Spiral");
        setSize(1000,650);
        initUI();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initUI() {
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JLabel spLabel = new JLabel("Spiral");
        JLabel welcomeLabel = new JLabel("Welcome to Spiral");
        JLabel loginHeadingLabel = new JLabel("Log into your Account");
        JLabel emailInputLabel = new JLabel("E-mail or username");
        JTextField emailInput = new JTextField();
        JLabel passwordInputLabel = new JLabel("Password");
        JTextField passwordInput = new JTextField();
        JButton loginButton = new JButton("Log in");
        JLabel signUpLabel = new JLabel("<html>Don't have account? <font color='blue'>Sign Up.</font></html>");
        JLabel forgotPasswordLabel = new JLabel("Forgot your Password?");
        loginButton.setPreferredSize(new Dimension(150,50));

<<<<<<< HEAD
        signUpLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                try {

                    new Signup();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
=======
>>>>>>> d3cbee5dde6691de8ab652e5c49bd56983c38f24
        spLabel.setFont(new Font("nunito", Font.BOLD, 40));
        spLabel.setForeground(Color.WHITE);
        leftPanel.setBackground(themeColor);
        leftPanel.add(spLabel);
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 120, 10, 120));
        leftPanel.setLayout(new GridBagLayout());


        welcomeLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        loginHeadingLabel.setForeground(themeColor);
        loginHeadingLabel.setFont(new Font("Nunito", Font.BOLD, 25));
        emailInputLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
        passwordInputLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
        forgotPasswordLabel.setForeground(themeColor);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(themeColor);
        loginButton.setFont(new Font("Verdana", Font.BOLD, 16));
        loginButton.setBounds(10, 10, 120, 50);
        loginButton.setBorder(BorderFactory.createCompoundBorder(
                new CustomBorder(),
                new EmptyBorder(new Insets(25, 20, 25, 25))
        ));
        emailInput.setBorder(new RoundedBorder(15));
        passwordInput.setBorder(new RoundedBorder(15));

        JPanel emailLabelPanel = new JPanel();
        emailLabelPanel.setBackground(Color.WHITE);
        emailLabelPanel.setLayout(new BorderLayout());
        emailLabelPanel.add(emailInputLabel, BorderLayout.SOUTH);

        JPanel passordLabelPanel = new JPanel();
        passordLabelPanel.setBackground(Color.WHITE);
        passordLabelPanel.setLayout(new BorderLayout());
        passordLabelPanel.add(passwordInputLabel, BorderLayout.SOUTH);

        JPanel signUpLabelPanel = new JPanel();

        signUpLabelPanel.setBackground(Color.WHITE);
        signUpLabelPanel.setLayout(new BorderLayout());
        signUpLabelPanel.add(signUpLabel, BorderLayout.SOUTH);

        JPanel forgotPasswordLabelPanel = new JPanel();
        forgotPasswordLabelPanel.setBackground(Color.WHITE);
        forgotPasswordLabelPanel.setLayout(new BorderLayout());
        forgotPasswordLabelPanel.add(forgotPasswordLabel, BorderLayout.NORTH);

        JPanel loginButtonPanel = new JPanel(new BorderLayout());

        loginButtonPanel.setBackground(Color.WHITE);
        loginButtonPanel.add(loginButton, BorderLayout.WEST);

        rightPanel.add(welcomeLabel);
        rightPanel.add(loginHeadingLabel);
        rightPanel.add(emailLabelPanel);
        rightPanel.add(emailInput);
        rightPanel.add(passordLabelPanel);
        rightPanel.add(passwordInput);
        rightPanel.add(loginButtonPanel);
        rightPanel.add(signUpLabel);
        rightPanel.add(forgotPasswordLabel);
        rightPanel.setLayout(new GridLayout(9,1, 0, 10));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(30, 120, 30, 120));



        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Login();
            }
        });
    }

}
class RoundedBorder implements Border{
    private int radius;


    public RoundedBorder(int radius) {
        this.radius = radius;
    }


    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }


    public boolean isBorderOpaque() {
        return true;
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}

class CustomBorder extends  AbstractBorder {
    public void paintBorder(Component c, Graphics g, int x, int y,
                            int width, int height) {
        super.paintBorder(c, g, x, y, width, height);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(12));
        g2d.drawRoundRect(x, y, width - 1, height - 1, 25, 25);
    }
}
