import client.ClientMain.ClientServerConnector;
import client.pages.RegisterLocation;
import client.result_list.ResultDetails;
import client.result_list.ResultList;
import server.Server.Middleware.UserAuthMiddleware;
import server.Server.Model.RequestBody;
import server.Server.Model.ResponseBody;
import server.Server.Model.Spot;
import server.Server.Model.UserLog;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * @author Mutoni Uwingeneye Denyse
 */
public class Landing extends JFrame{
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");
    private JButton registerButton;
    private JButton loginButton;
    IconTextField searchField = new IconTextField();
//    ActionListener callPanels = new ActionListener(){
//        @Override
//        public void actionPerfomed(ActionEvent e){
//
//        }
//    }
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
//        searchInput.setActionCommand("SEARCH");

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

        searchField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    String searchStr = searchField.getText();
                    try {
//                        searchSpot(searchStr);
                        new ResultList(searchStr);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
//                    String sql = "SELECT * from Spot_table WHERE spot_name LIKE '%" + searchStr + "%' OR spot_description LIKE '%" + searchStr + "%' AND status = 1 ORDER BY viewers DESC LIMIT 10";
//                    System.out.   println(searchStr);
//                    ResultList resultList = new ResultList();
//                    resultList.initUI();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        bodyContent.add(new JPanel(new GridBagLayout()).add(searchField));
        bodyContent.setLayout(boxLayout);
        bodyContent.setBackground(bgColor);
        bodyPanel.setBackground(bgColor);
        bodyPanel.add(bodyContent);
        headPanel.add(headLeftPanel, BorderLayout.WEST);
        headPanel.add(headRightPanel, BorderLayout.EAST);
        contentPanel.add(headPanel, BorderLayout.NORTH);
        contentPanel.add(bodyPanel, BorderLayout.CENTER);
//        contentPanel.add(searchButton,BorderLayout.CENTER);
        add(contentPanel);
    }

    public static void main(String[] args) {
        new Landing();
    }
    public static void searchSpot(String searchKey) throws Exception{
        try {
            RequestBody requestBody = new RequestBody();
            requestBody.setUrl("/search");
            requestBody.setAction("getSpots");

            Spot spotToSend = new Spot();
            System.out.print("Search a spot: ");

            spotToSend.setSpotName(searchKey);
            requestBody.setObject(spotToSend);

            ResponseBody responseBody = new ClientServerConnector().ConnectToServer(requestBody);
            System.out.println(responseBody.getResponse());
            boolean found = false;
            Integer index = 0;
            for (Object response : responseBody.getResponse()) {
                index++;
                found = true;
                Spot spot = (Spot) response;
                String showDesc = spot.getSpotDescription().length() > 20 ? spot.getSpotDescription().substring(0,20) + "..." : spot.getSpotDescription();
                System.out.println(index + ". " + spot.getSpotName() + "\n\t\t" +  showDesc);
            }

            if (!found) {
                System.out.println("No spots Found.");
            } else {
//                displaySpot(spotsList);
            }
        }catch (Exception e){
            System.out.println("Error occured" + e.getMessage());
        }
    }

//    public static void searchSpot(String searchKey) throws Exception{
//        try {
//            RequestBody requestBody = new RequestBody();
//            requestBody.setUrl("/search");
//            requestBody.setAction("getSpots");
//
//            Spot spotToSend = new Spot();
//            System.out.print("Search a spot: ");
//            //        create user log
//
//            spotToSend.setSpotName(searchKey);
//            requestBody.setObject(spotToSend);
//
//            ResponseBody responseBody = new ClientServerConnector().ConnectToServer(requestBody);
//            System.out.println(responseBody);
//            boolean found = false;
//            Integer index = 0;
//            for (Object response : responseBody.getResponse()) {
//                index++;
//                found = true;
//                Spot spot = (Spot) response;
//                String showDesc = spot.getSpotDescription().length() > 20 ? spot.getSpotDescription().substring(0,20) + "..." : spot.getSpotDescription();
////                spotsList.add(spot);
//            }
//
//            if (!found) {
//                System.out.println("No spots Found.");
//            } else {
//            }
//        }catch (Exception e){
//            System.out.println("Error occured : " + e.getMessage());
//        }
//    }
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

    @Override
    public void setBorder(Border border) {
        getHelper().onSetBorder(border);
        super.setBorder(getHelper().getBorder());
    }

}

