package pages;

import javax.swing.*;
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
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class UpdatePassword extends JFrame {
    private static final long serialVersionUID = 4924551093376342051L;
    private static final Color themeColor = Color.decode("#3674D0");
    public UpdatePassword() {

        super("Update Password");
        setSize(1000, 650);
        initUI();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void initUI() {
        JPanel Container = new JPanel();
        JPanel SmallPanel = new JPanel();
        JLabel UpdateLabel = new JLabel("Update Password");
        JLabel passwordInputLabel = new JLabel("Password");
        JTextField passwordInput = new JTextField();
        JLabel ConformationInputLabel = new JLabel(" Confirm Password");
        JTextField ConformationInput = new JTextField();
        JButton UpdateButton = new JButton("Update");
        UpdateButton.setPreferredSize(new Dimension(150, 50));
        Container.setBackground(themeColor);
        Container.add(SmallPanel);
        UpdateLabel.setForeground(themeColor);
        UpdateLabel.setFont(new Font("Nunito", Font.BOLD, 25));
        passwordInputLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
        ConformationInputLabel.setFont(new Font("Verdana", Font.PLAIN, 16));


        UpdateButton.setForeground(Color.WHITE);
        UpdateButton.setBackground(themeColor);
        UpdateButton.setFont(new Font("Verdana", Font.BOLD, 16));
        UpdateButton.setBounds(10, 10, 120, 50);
        UpdateButton.setBorder(BorderFactory.createCompoundBorder(

                new CustomBorder(),

                new EmptyBorder(new Insets(25, 20, 25, 25))

        ));
        passwordInput.setBorder(new RoundedBorder(15));
        ConformationInput.setBorder(new RoundedBorder(15));

        JPanel PasswordLabelPanel = new JPanel();
        PasswordLabelPanel.setBackground(Color.WHITE);
        PasswordLabelPanel.setLayout(new BorderLayout());
        PasswordLabelPanel.add(passwordInputLabel, BorderLayout.SOUTH);


        JPanel ConfirmLabelPanel = new JPanel();
        ConfirmLabelPanel.setBackground(Color.WHITE);
        ConfirmLabelPanel.setLayout(new BorderLayout());
        ConfirmLabelPanel.add(ConformationInputLabel, BorderLayout.SOUTH);

        JPanel UpdateButtonPanel = new JPanel(new BorderLayout());
        UpdateButtonPanel.setBackground(Color.WHITE);
        UpdateButtonPanel.add(UpdateButton, BorderLayout.WEST);


        SmallPanel.add(UpdateLabel);
        SmallPanel.add(PasswordLabelPanel);
        SmallPanel.add(passwordInput);
        SmallPanel.add(ConfirmLabelPanel);
        SmallPanel.add(ConformationInput);
        SmallPanel.add(UpdateButtonPanel);
        SmallPanel.setLayout(new GridLayout(9, 1, 0, 10));


        SmallPanel.setBackground(Color.WHITE);
        SmallPanel.setBorder(BorderFactory.createEmptyBorder(30, 300, 30, 120));

        add(SmallPanel, BorderLayout.CENTER);
        add(Container, BorderLayout.WEST);
        Container.setLayout(new CardLayout(120, 5));


    }


    public static void main(String[] args) {

        UpdatePassword updatePassword = new UpdatePassword();

    }


}


