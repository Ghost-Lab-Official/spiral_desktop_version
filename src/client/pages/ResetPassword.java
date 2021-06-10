package client.pages;

import org.mindrot.jbcrypt.BCrypt;
import server.Server.Controllers.UserModuleControllers.SendEmail;
import server.Server.DbController.CloudStorageConnectionHandler;
import server.Server.Model.User;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class ResetPassword extends JFrame {
    private JLabel emailLabel, titleLabel;
    private JTextField emailInput;
    private JButton resetButton;
    Border passwordLabel = BorderFactory.createEmptyBorder(5,-50,0,0);
    Border borderInput = BorderFactory.createEmptyBorder(0, 0, 40, 0);
    JPanel alignInput = new JPanel(new BorderLayout());
    public ResetPassword(User user) throws Exception {
        setTitle("/user/RestPassword");
        setSize(1000, 700);
        setMinimumSize(new Dimension(700, 400));
        initUI();
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String emailText = emailInput.getText();
                if (emailText.equals("")) {
                    System.out.println("Enter valid Password and it's confirmation");
                } else {
                    try {
                        Connection conn = new CloudStorageConnectionHandler().getConnection();
                        Statement CheckEmail = conn.createStatement();
                        ResultSet check =CheckEmail.executeQuery("SELECT * from users_table WHERE email='" + emailText + "'");
                        if(check.next()) {
                            System.out.println("code sent to "+check.getString("email"));
                        }else {
                            System.out.println("No email found!");
                            return;
                        }
                        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                        StringBuilder sb = new StringBuilder();
                        Random random = new Random();
                        int length = 7;

                        for(int i = 0; i < length; i++) {
                            int index = random.nextInt(alphabet.length());
                            char randomChar = alphabet.charAt(index);
                            sb.append(randomChar);
                        }

                        String randomString = sb.toString();

                        new SendEmail().send("tzyelissa90@gmail.com","doordie16",emailText,
                                "Verification Code","verification code:"+randomString);

                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

<<<<<<< HEAD
    public ResetPassword() {

    }

=======
>>>>>>> main
    private String hashPassword(String password) {
        System.out.println(BCrypt.gensalt(12));
        return BCrypt.hashpw(password, BCrypt.gensalt(12));

    }

<<<<<<< HEAD
    public void initUI() {
=======
    private void initUI() {
>>>>>>> main
        JPanel allContentPanel = new JPanel(new GridBagLayout());
        allContentPanel.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 60));
        allContentPanel.setBackground(Color.WHITE);

        // Border layout to align label east

        // Align all items in vertical line
        JPanel passwordDataPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(passwordDataPanel, BoxLayout.Y_AXIS);
        passwordDataPanel.setLayout(boxLayout);
        passwordDataPanel.setBackground(null);

        alignInput.setBackground(null);
        titleLabel = new JLabel("Reset Password ");
        titleLabel.setFont(new Font("Nunito", Font.PLAIN, 22));
        titleLabel.setForeground(Color.decode("#3674D0"));

        emailLabel = new JLabel("E-mail");
        alignInput.add(emailLabel, BorderLayout.EAST);
        alignInput.setBorder(BorderFactory.createEmptyBorder(0,0,10,280));
        emailLabel.setFont(new Font("Nunito", Font.PLAIN, 12));
        emailLabel.setForeground(Color.decode("#202020"));
        emailInput = new JTextField();
        emailInput.setPreferredSize(new Dimension(370, 40));
        emailInput.setBorder(new RoundedBorder(10));


        resetButton = new JButton("Send");
        resetButton.setBorder(null);
        resetButton.setFont(new Font("Verdana", Font.PLAIN, 14));
        resetButton.setPreferredSize(new Dimension(100, 55));
        resetButton.setFocusPainted(false);


        // Align labels and input to the center

        JPanel titleLabelPanel = new JPanel(new GridBagLayout());

        JPanel newPasswordPanel = new JPanel(new GridBagLayout());

        JPanel newPasswordInputPanel = new JPanel(new GridBagLayout());
        JPanel updatePanel = new JPanel(new GridBagLayout());

        // Add labels and inputs to their panels

        titleLabelPanel.add(titleLabel);
        titleLabelPanel.setBackground(null);
        titleLabelPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        // newPasswordPanel.add(newPasswordLabel);
        newPasswordPanel.add(alignInput);
        newPasswordPanel.setBackground(null);

        newPasswordPanel.setBorder(passwordLabel);

        newPasswordInputPanel.add(emailInput);
        newPasswordInputPanel.setBackground(null);
        newPasswordInputPanel.setBorder(borderInput);

        updatePanel.add(resetButton);
        updatePanel.setBackground(null);
        resetButton.setBorder(BorderFactory.createCompoundBorder(
                new CustomBorder(),
                new EmptyBorder(new Insets(45, 25, 45, 25))
        ));
        resetButton.setForeground(Color.decode("#FFFFFF"));
        resetButton.setBackground(Color.decode("#3674D0"));

        // Add labels and inputs' labels to passwordDataPanel
        passwordDataPanel.add(titleLabelPanel);
        passwordDataPanel.add(newPasswordPanel);
        passwordDataPanel.add(newPasswordInputPanel);
        passwordDataPanel.add(updatePanel);

        // Add passwordDataPanel to allContentPanel
        allContentPanel.setBorder(BorderFactory.createEmptyBorder(60,0,0,0));
        allContentPanel.add(passwordDataPanel);


        var bottomPanel = new JPanel(new BorderLayout());

        var topPanel = new RoundedPanel(new GridBagLayout());
        topPanel.setBounds(220, 0, 560, 100);

        topPanel.setBackground(Color.white);
        topPanel.setPreferredSize(new Dimension(100, 350));
        topPanel.add(allContentPanel);
        topPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        bottomPanel.add(topPanel, BorderLayout.CENTER);
        bottomPanel.setBackground(Color.decode("#3674D0"));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(80,80,80,80));
        add(bottomPanel);

        pack();
    }

    class RoundedBorder implements Border{
        private int radius;
        RoundedBorder(int radius) {
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
    class CustomBorder extends AbstractBorder {
        public void paintBorder(Component c, Graphics g, int x, int y,
                                int width, int height) {
            super.paintBorder(c, g, x, y, width, height);
            Graphics2D g2d = (Graphics2D)g;
            g2d.setStroke(new BasicStroke(10));
            g2d.drawRoundRect(x, y, width - 1, height, 25, 20);
        }
    }

    public class RoundedPanel extends JPanel
    {
        protected int _strokeSize = 0;
        protected Color _shadowColor = Color.WHITE;
        protected boolean _shadowed = true;
        protected boolean _highQuality = true;
        protected Dimension _arcs = new Dimension(30, 30);
        protected int _shadowGap = 0;
        protected int _shadowOffset = 0;
        protected int _shadowAlpha = 150;

        protected Color _backgroundColor = Color.WHITE;

        public RoundedPanel(GridBagLayout borderLayout)
        {
            super();
            setOpaque(false);
        }

        @Override
        public void setBackground(Color c)
        {
            _backgroundColor = c;
        }

        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            int width = getWidth();
            int height = getHeight();
            int shadowGap = this._shadowGap;
            Color shadowColorA = new Color(_shadowColor.getRed(), _shadowColor.getGreen(), _shadowColor.getTransparency(), _shadowAlpha);
            Graphics2D graphics = (Graphics2D) g;

            if(_highQuality)
            {
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            }

            if(_shadowed)
            {
                graphics.setColor(shadowColorA);
                graphics.fillRoundRect(_shadowOffset, _shadowOffset, width - _strokeSize - _shadowOffset,
                        height - _strokeSize - _shadowOffset, _arcs.width, _arcs.height);
            }
            else
            {
                _shadowGap = 1;
            }

            graphics.setColor(_backgroundColor);
            graphics.fillRoundRect(0,  0, width - shadowGap, height - shadowGap, _arcs.width, _arcs.height);
            graphics.setStroke(new BasicStroke(_strokeSize));
            graphics.setColor(getForeground());
            graphics.drawRoundRect(0,  0, width - shadowGap, height - shadowGap, _arcs.width, _arcs.height);
            graphics.setStroke(new BasicStroke());
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ResetPassword ex = null;
            User user = new User();
            try {
                ex = new ResetPassword(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ex.setVisible(true);
        });
    }
}
