import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import java.awt.*;
import client.Home.Loader;

public class Landing extends JFrame{
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");
    private JButton registerButton;
    private JButton loginButton;
    private JTextField searchInput;
    IconTextField searchField = new IconTextField();

    public Landing(){
        setTitle("client/Home");
        setSize(1000,600);
        initUI();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initUI(){
        JPanel contentPanel = new JPanel(new BorderLayout());
        JPanel headPanel = new JPanel(new BorderLayout());
        JPanel bodyPanel = new JPanel(new GridBagLayout());

        registerButton = new JButton("Register");
        loginButton = new JButton("Login");
        searchInput = new JTextField("Search whatever you want");

        JLabel appBrand = new JLabel("Spiral");
        JLabel welcomeText = new JLabel("Welcome to Spiral");
        JLabel instructionText = new JLabel("Search whatever you want");

        ImageIcon icon = new ImageIcon("search-icon.png");
        searchField.setIcon(icon);
        searchField.setFont(new Font("Verdana", Font.PLAIN, 16));

        appBrand.setFont(new Font("nunito", Font.BOLD, 25));
        appBrand.setForeground(textColor);
        headPanel.setPreferredSize(new Dimension(0, 80));
        headPanel.setBackground(bgColor);
        bodyPanel.setBackground(bgColor);

        JPanel headRightPanel = new JPanel( new GridLayout(1, 2, 15, 0));
        JPanel headLeftPanel = new JPanel( new GridLayout(1, 1, 10, 3));
        headRightPanel.setBackground(bgColor);
        headLeftPanel.setBackground(bgColor);
        headRightPanel.add(registerButton);
        headRightPanel.add(loginButton);
        headLeftPanel.add(appBrand);
        headRightPanel.setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 50));
        headLeftPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 5));

        registerButton.setBackground(textColor);
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setFont(new Font("nunito", Font.PLAIN,15));
        registerButton.setBorder(new RoundedBorder(40));
        registerButton.setFocusPainted(false);
        registerButton.setBorderPainted(false);
//        registerButton.setContentAreaFilled(false);
//        registerButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
//        registerButton.setBorder(BorderFactory.createCompoundBorder(
//                new CustomBorder(),
//                new EmptyBorder(new Insets(2, 1, 1, 2))
//        ));

//        registerButton.setBorder(new RoundedBorder(5));

        loginButton.setBackground(bgColor);
        loginButton.setFont(new Font("nunito",Font.PLAIN,17));
        loginButton.setForeground(textColor);
        loginButton.setBorder(null);
        loginButton.setFocusPainted(false);

        JPanel bodyContent = new JPanel();
        BoxLayout boxLayout = new BoxLayout(bodyContent, BoxLayout.Y_AXIS);

        welcomeText.setFont(new Font("nunito", Font.BOLD, 30));
        welcomeText.setForeground(textColor);

        instructionText.setForeground(Color.GRAY);
        instructionText.setFont(new Font("nunito", Font.PLAIN, 15));

        searchField.setPreferredSize(new Dimension(400, 50));

        JPanel panel1 = new JPanel(new GridBagLayout());
        panel1.setBorder(BorderFactory.createEmptyBorder(0,0, 3, 0));
        panel1.add(welcomeText);
        panel1.setBackground(bgColor);
        bodyContent.add(panel1);

        JPanel panel2 = new JPanel(new GridBagLayout());
        panel2.setBorder(BorderFactory.createEmptyBorder(0,0, 25, 0));
        panel2.add(instructionText);
        panel2.setBackground(bgColor);
        bodyContent.add(panel2);

        searchField.setBackground(bgColor);
//        searchField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        searchField.setBorder(BorderFactory.createLineBorder(Color.GRAY,1,true));
        searchField.setForeground(Color.BLACK);
        bodyContent.add(new JPanel(new GridBagLayout()).add(searchField));
        bodyContent.setLayout(boxLayout);
        bodyContent.setBackground(bgColor);
        bodyPanel.setBackground(bgColor);
        bodyPanel.add(bodyContent);

        headPanel.add(headLeftPanel, BorderLayout.WEST);
        headPanel.add(headRightPanel, BorderLayout.EAST);
        contentPanel.add(headPanel, BorderLayout.NORTH);
        contentPanel.add(bodyPanel, BorderLayout.CENTER);
        add(contentPanel);
    }

    public static void main(String[] args) {

        new Loader();
//


    }
}
class RoundedBorder implements Border {
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
        g2d.setStroke(new BasicStroke(12));
        g2d.drawRoundRect(x, y, width - 1, height - 1, 25, 25);
    }
}

class IconTextComponentHelper {
    private static final int ICON_SPACING = 4;

    private Border mBorder;
    private Icon mIcon;
    private Border mOrigBorder;
    private JTextComponent mTextComponent;

    IconTextComponentHelper(JTextComponent component) {
        mTextComponent = component;
        mOrigBorder = component.getBorder();
        mBorder = mOrigBorder;
    }

    Border getBorder() {
        return mBorder;
    }

    void onPaintComponent(Graphics g) {
        if (mIcon != null) {
            Insets iconInsets = mOrigBorder.getBorderInsets(mTextComponent);
            mIcon.paintIcon(mTextComponent, g, iconInsets.left, iconInsets.top);
        }
    }

    void onSetBorder(Border border) {
        mOrigBorder = border;

        if (mIcon == null) {
            mBorder = border;
        } else {
            Border margin = BorderFactory.createEmptyBorder(0, mIcon.getIconWidth() + ICON_SPACING, 0, 0);
            mBorder = BorderFactory.createCompoundBorder(border, margin);
        }
    }

    void onSetIcon(Icon icon) {
        mIcon = icon;
        resetBorder();
    }

    private void resetBorder() {
        mTextComponent.setBorder(mOrigBorder);
    }
}

class IconTextField extends JTextField {
    private IconTextComponentHelper mHelper = new IconTextComponentHelper(this);

    public IconTextField() {
        super();
    }

    public IconTextField(int cols) {
        super(cols);
    }

    private IconTextComponentHelper getHelper() {
        if (mHelper == null)
            mHelper = new IconTextComponentHelper(this);

        return mHelper;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        getHelper().onPaintComponent(graphics);
    }

    public void setIcon(Icon icon) {
        getHelper().onSetIcon(icon);
    }

//    public void setIconSpacing(int spacing) {
//        getHelper().onSetIconSpacing(spacing);
//    }

    @Override
    public void setBorder(Border border) {
        getHelper().onSetBorder(border);
        super.setBorder(getHelper().getBorder());
    }
}