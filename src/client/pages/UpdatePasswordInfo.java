package client.pages;

import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdatePasswordInfo extends JFrame {
    Border borderLabel = BorderFactory.createEmptyBorder(0, 0, 5, 50);
    Border passwordLabel = BorderFactory.createEmptyBorder(5, -50, 0, 0);
    Border borderInput = BorderFactory.createEmptyBorder(0, 0, 20, 0);
    JPanel alignInput = new JPanel(new BorderLayout());
    JPanel alignInput2 = new JPanel(new BorderLayout());
    private JLabel newPasswordLabel, confirmNewPasswordLabel, titleLabel;
    private JPasswordField newPasswordInput;
    private JPasswordField confirmNewPasswordInput;
    private JButton updateButton;

    public UpdatePasswordInfo() throws Exception {

        setTitle("/user/UpdatePassword");
        setSize(1000, 700);
        setMinimumSize(new Dimension(700, 400));
        initUI();
        updateButton.addActionListener(e -> {
            String databaseURL = "jdbc:mysql://localhost:3306/2yq7auowc7";
            String user = "root";
            String password = "123";
            Connection connection = null;

            String passText = newPasswordInput.getText();
            String comfText = confirmNewPasswordInput.getText();
            if (passText.equals("") || comfText.equals("") && passText != comfText) {
                System.out.println("Enter valid Password and it's confirmation");
            } else {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection(databaseURL, user, password);
                    if (connection != null) {
                        System.out.println("Connected to the database");
                        String email = "test@gmail.com";
                        String sql = "Update users_table SET password=? where email=?";
                        PreparedStatement updateSql = connection.prepareStatement(sql);

                        updateSql.setString(1, passText);//hashPassword
                        updateSql.setString(2, email);
                        int PassUpdate = updateSql.executeUpdate();
                        if (PassUpdate == 1) {
                            JOptionPane.showMessageDialog(updateButton, "Password has been successfully changed");
                        }
                    }
                } catch (Exception exception) {
                    System.out.println("Could not find database driver class");
                    exception.printStackTrace();
                }
            }
        });

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            UpdatePasswordInfo ex = null;
            try {
                ex = new UpdatePasswordInfo();
            } catch (Exception e) {
                e.printStackTrace();
            }
            ex.setVisible(true);
        });
    }

    private String hashPassword(String password) {
        System.out.println(BCrypt.gensalt(12));
        return BCrypt.hashpw(password, BCrypt.gensalt(12));

    }

    private void initUI() {
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
        titleLabel = new JLabel("Update Password ");
        titleLabel.setFont(new Font("Nunito", Font.PLAIN, 22));
        titleLabel.setForeground(Color.decode("#3674D0"));

        newPasswordLabel = new JLabel("Password");
        alignInput.add(newPasswordLabel, BorderLayout.EAST);
        alignInput.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 250));
        newPasswordLabel.setFont(new Font("Nunito", Font.PLAIN, 12));
        newPasswordLabel.setForeground(Color.decode("#202020"));
        newPasswordInput = new JPasswordField();
        newPasswordInput.setPreferredSize(new Dimension(370, 40));
        newPasswordInput.setBorder(new RoundedBorder(10));

        confirmNewPasswordLabel = new JLabel("Confirm Password");
        alignInput2.setBackground(null);
        alignInput2.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 210));
        alignInput2.add(confirmNewPasswordLabel, BorderLayout.EAST);
        confirmNewPasswordLabel.setFont(new Font("Nunito", Font.PLAIN, 12));
        confirmNewPasswordLabel.setForeground(Color.decode("#202020"));

        confirmNewPasswordInput = new JPasswordField();
        confirmNewPasswordInput.setPreferredSize(new Dimension(370, 40));
        confirmNewPasswordInput.setBorder(new RoundedBorder(10));


        updateButton = new JButton("Update");
        updateButton.setBorder(null);
        updateButton.setFont(new Font("Verdana", Font.PLAIN, 14));
        updateButton.setPreferredSize(new Dimension(100, 55));
        updateButton.setFocusPainted(false);


        // Align labels and input to the center

        JPanel titleLabelPanel = new JPanel(new GridBagLayout());

        JPanel newPasswordPanel = new JPanel(new GridBagLayout());

        JPanel newPasswordInputPanel = new JPanel(new GridBagLayout());
        JPanel confirmNewPasswordPanel = new JPanel(new GridBagLayout());

        JPanel confirmNewPasswordInputPanel = new JPanel(new GridBagLayout());
        JPanel updatePanel = new JPanel(new GridBagLayout());

        // Add labels and inputs to their panels

        titleLabelPanel.add(titleLabel);
        titleLabelPanel.setBackground(null);
        titleLabelPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        // newPasswordPanel.add(newPasswordLabel);
        newPasswordPanel.add(alignInput);
        newPasswordPanel.setBackground(null);

        newPasswordPanel.setBorder(passwordLabel);

        newPasswordInputPanel.add(newPasswordInput);
        newPasswordInputPanel.setBackground(null);
        newPasswordInputPanel.setBorder(borderInput);

        confirmNewPasswordPanel.add(alignInput2);
        confirmNewPasswordPanel.setBackground(null);
        confirmNewPasswordPanel.setBorder(borderLabel);

        confirmNewPasswordInputPanel.add(confirmNewPasswordInput);
        confirmNewPasswordInputPanel.setBackground(null);
        confirmNewPasswordInputPanel.setBorder(borderInput);

        updatePanel.add(updateButton);
        updatePanel.setBackground(null);
        updateButton.setBorder(BorderFactory.createCompoundBorder(
                new CustomBorder(),
                new EmptyBorder(new Insets(25, 25, 25, 25))
        ));
        updateButton.setForeground(Color.decode("#FFFFFF"));
        updateButton.setBackground(Color.decode("#3674D0"));
        // Add labels and inputs' labels to passwordDataPanel
        passwordDataPanel.add(titleLabelPanel);
        passwordDataPanel.add(newPasswordPanel);
        passwordDataPanel.add(newPasswordInputPanel);
        passwordDataPanel.add(confirmNewPasswordPanel);

        passwordDataPanel.add(confirmNewPasswordInputPanel);
        passwordDataPanel.add(updatePanel);

        // Add passwordDataPanel to allContentPanel
        allContentPanel.setBorder(BorderFactory.createEmptyBorder(60, 0, 0, 0));
        allContentPanel.add(passwordDataPanel);


        var bottomPanel = new JPanel(new BorderLayout());

        var topPanel = new RoundedPanel(new GridBagLayout());
        topPanel.setBounds(220, 0, 560, 100);

        topPanel.setBackground(Color.white);
        topPanel.setPreferredSize(new Dimension(100, 350));
        topPanel.add(allContentPanel);
        topPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        bottomPanel.add(topPanel, BorderLayout.CENTER);
        bottomPanel.setBackground(Color.decode("#3674D0"));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(80, 80, 80, 80));
        add(bottomPanel);

        pack();
    }

    class RoundedBorder implements Border {
        private final int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

    class CustomBorder extends AbstractBorder {
        public void paintBorder(Component c, Graphics g, int x, int y,
                                int width, int height) {
            super.paintBorder(c, g, x, y, width, height);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(10));
            g2d.drawRoundRect(x, y, width - 1, height, 25, 20);
        }
    }

    public class RoundedPanel extends JPanel {
        protected int _strokeSize = 0;
        protected Color _shadowColor = Color.WHITE;
        protected boolean _shadowed = true;
        protected boolean _highQuality = true;
        protected Dimension _arcs = new Dimension(30, 30);
        protected int _shadowGap = 0;
        protected int _shadowOffset = 0;
        protected int _shadowAlpha = 150;

        protected Color _backgroundColor = Color.WHITE;

        public RoundedPanel(GridBagLayout borderLayout) {
            super();
            setOpaque(false);
        }

        @Override
        public void setBackground(Color c) {
            _backgroundColor = c;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int width = getWidth();
            int height = getHeight();
            int shadowGap = this._shadowGap;
            Color shadowColorA = new Color(_shadowColor.getRed(), _shadowColor.getGreen(), _shadowColor.getTransparency(), _shadowAlpha);
            Graphics2D graphics = (Graphics2D) g;

            if (_highQuality) {
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            }

            if (_shadowed) {
                graphics.setColor(shadowColorA);
                graphics.fillRoundRect(_shadowOffset, _shadowOffset, width - _strokeSize - _shadowOffset,
                        height - _strokeSize - _shadowOffset, _arcs.width, _arcs.height);
            } else {
                _shadowGap = 1;
            }

            graphics.setColor(_backgroundColor);
            graphics.fillRoundRect(0, 0, width - shadowGap, height - shadowGap, _arcs.width, _arcs.height);
            graphics.setStroke(new BasicStroke(_strokeSize));
            graphics.setColor(getForeground());
            graphics.drawRoundRect(0, 0, width - shadowGap, height - shadowGap, _arcs.width, _arcs.height);
            graphics.setStroke(new BasicStroke());
        }
    }
}