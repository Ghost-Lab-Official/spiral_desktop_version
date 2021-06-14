package client.pages;

import client.ClientMain.ClientServerConnector;
import client.ClientMain.ClientServerConnector.*;
import client.Dashboard.Dashboard;
import server.Server.DbController.CloudStorageConnectionHandler;
import server.Server.Model.RequestBody;
import server.Server.Model.ResponseBody;
import server.Server.Model.ResponseStatus;
import server.Server.Model.User;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import java.io.IOException;
import java.sql.*;

import server.Server.Model.RequestBody;
import server.Server.Model.ResponseBody;


public class Login extends JFrame {
    private static final long serialVersionUID = 4924551093376342051L;
    private static final Color themeColor = Color.decode("#3674D0");
	private Connection con;
	JTextField emailInput;
	JTextField passwordInput;
	JLabel loginFailed;
    ClientServerConnector clientServerConnector = new ClientServerConnector();
    
    public class ActionLstn implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			switch (e.getActionCommand()) {
			case "LOGIN":
                try {
                    userLogin();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                break;

			default:
				System.out.println("Invalid action");
				break;
			}
		}
    	
    }
    
    public void userLogin() throws Exception {
    	String email = emailInput.getText();
    	String password = passwordInput.getText();
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        RequestBody requestBody = new RequestBody();
        requestBody.setUrl("/users");
        requestBody.setAction("login");
        requestBody.setObject(user);
        if(email.equals("") || password.equals("")) {
    		System.out.println("Enter email and Password");
            loginFailed.setText("Please enter your email and password");
            loginFailed.setBorder(BorderFactory.createLineBorder(Color.RED));
    	}else {
            ClientServerConnector clientServerConnector = new ClientServerConnector();
            ResponseBody responseBody=  clientServerConnector.ConnectToServer(requestBody);
            for (Object response: responseBody.getResponse()) {
                ResponseStatus responseStatus = (ResponseStatus) response;
                if(responseStatus.getStatus()==200){
                    Dashboard dashboard = new Dashboard();
                }
            }
        }
    }

    public Login() throws Exception {
        super("Login To Spiral");
        setSize(1000,650);
        CloudStorageConnectionHandler DbHandler = new CloudStorageConnectionHandler();
        con= DbHandler.getConnection();
        emailInput = new JTextField();
        emailInput.setFont(new Font("SansSerif", Font.PLAIN, 15));
        passwordInput = new JTextField();
        initUI();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initUI() throws Exception {
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JLabel spLabel = new JLabel("Spiral");
        JLabel welcomeLabel = new JLabel("Welcome to Spiral");
        JLabel loginHeadingLabel = new JLabel("Log into your Account");
        //////
        loginFailed = new JLabel("");
        /////
        JLabel emailInputLabel = new JLabel("E-mail or username");
        JLabel passwordInputLabel = new JLabel("Password");
        JButton loginButton = new JButton("Log in");
        JLabel signUpLabel = new JLabel("<html>Don't have account? <font color='blue'>Sign Up.</font></html>");
        JLabel forgotPasswordLabel = new JLabel("Forgot your Password?");
        loginButton.setPreferredSize(new Dimension(150,30));
        loginButton.setSize(new Dimension(150,50));

        spLabel.setFont(new Font("nunito", Font.BOLD, 40));
        spLabel.setForeground(Color.WHITE);
        leftPanel.setBackground(themeColor);
        leftPanel.add(spLabel);
        leftPanel.setBorder(BorderFactory.createEmptyBorder(9, 120, 10, 120));
        leftPanel.setLayout(new GridBagLayout());


        welcomeLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        loginHeadingLabel.setForeground(themeColor);
        loginHeadingLabel.setFont(new Font("Nunito", Font.BOLD, 25));
        emailInputLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        passwordInputLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        forgotPasswordLabel.setForeground(themeColor);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(themeColor);
        loginButton.setFont(new Font("Verdana", Font.BOLD, 16));
        loginButton.setBounds(10, 10, 120, 50);
        loginButton.setBorder(BorderFactory.createCompoundBorder(
                new CustomBorder(),
                new EmptyBorder(new Insets(25, 20, 25, 25))
        ));
        loginButton.setActionCommand("LOGIN");
        loginButton.addActionListener(new ActionLstn());
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

        ////////
//        JPanel loginFailedPanel = new JPanel();
//        loginFailedPanel.setBackground(Color.WHITE);
//        loginFailedPanel.setLayout(new BorderLayout());
//        loginFailedPanel.add(loginFailed, BorderLayout.SOUTH);
        ////////
        rightPanel.add(welcomeLabel);
        rightPanel.add(loginHeadingLabel);
        rightPanel.add(loginFailed);
        rightPanel.add(emailLabelPanel);
        rightPanel.add(emailInput);
        rightPanel.add(passordLabelPanel);
        rightPanel.add(passwordInput);
        rightPanel.add(loginButtonPanel);
        rightPanel.add(signUpLabel);
        rightPanel.add(forgotPasswordLabel);
        rightPanel.setLayout(new GridLayout(10,1, 0, 12));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(30, 120, 30, 120));



        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
					new Login();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
            }
        });
    }

  private static final long serialVersionUID = 4924551093376342051L;
  private static final Color themeColor = Color.decode("#3674D0");
  private int radius;

  public Login() {
    super("Login To Spiral");
    setSize(1000, 650);
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
    JLabel signUpLabel = new JLabel(
      "<html>Don't have account? <font color='blue'>Sign Up.</font></html>"
    );
    JLabel forgotPasswordLabel = new JLabel("Forgot your Password?");
    loginButton.setPreferredSize(new Dimension(150, 50));

    signUpLabel.addMouseListener(
      new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
          try {
            new Signup();
          } catch (IOException ioException) {
            ioException.printStackTrace();
          }
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
      }
    );
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
    loginButton.setBorder(
      BorderFactory.createCompoundBorder(
        new CustomBorder(),
        new EmptyBorder(new Insets(25, 20, 25, 25))
      )
    );
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
    rightPanel.setLayout(new GridLayout(9, 1, 0, 10));
    rightPanel.setBackground(Color.WHITE);
    rightPanel.setBorder(BorderFactory.createEmptyBorder(30, 120, 30, 120));

    add(leftPanel, BorderLayout.WEST);
    add(rightPanel, BorderLayout.CENTER);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(
      new Runnable() {
        @Override
        public void run() {
          new Login();
        }
      }
    );
  }
}

class RoundedBorder implements Border {

  private int radius;

  public RoundedBorder(int radius) {
    this.radius = radius;
  }

  public Insets getBorderInsets(Component c) {
    return new Insets(
      this.radius + 1,
      this.radius + 1,
      this.radius + 2,
      this.radius
    );
  }

  public boolean isBorderOpaque() {
    return true;
  }

  public void paintBorder(
    Component c,
    Graphics g,
    int x,
    int y,
    int width,
    int height
  ) {
    g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
  }
}

class CustomBorder extends AbstractBorder {

  public void paintBorder(
    Component c,
    Graphics g,
    int x,
    int y,
    int width,
    int height
  ) {
    super.paintBorder(c, g, x, y, width, height);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setStroke(new BasicStroke(12));
    g2d.drawRoundRect(x, y, width - 1, height - 1, 25, 25);
  }
}
