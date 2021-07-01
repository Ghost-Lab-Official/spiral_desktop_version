package client.pages;

import client.ClientMain.ClientServerConnector;
import server.Server.Model.Billing;
import server.Server.Model.RequestBody;
import server.Server.Model.ResponseBody;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static javax.swing.JOptionPane.showMessageDialog;


public class PurchasePlan extends JFrame {
//    JTextField billingNameInput;
    JComboBox billingNameInput;
    private static final Color themeColor = Color.decode("#3674D0");

    PurchasePlan() throws Exception {
        super("Purchase bill plan");
        setSize(1000,650);
        initUI();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }



    public ResponseBody billingPlans() throws Exception{
        RequestBody requestBody = new RequestBody();
        requestBody.setUrl("/billing");
        requestBody.setAction("selectAllBillingPlans");
        requestBody.setObject(null);


        ClientServerConnector clientServerConnector = new ClientServerConnector();
        return clientServerConnector.ConnectToServer(requestBody);
    }


    void initUI() throws Exception {
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JLabel spiralLabel = new JLabel("Spiral");
        JButton createBtn = new JButton("Purchase");
        JPanel CreateButtonPanel = new JPanel(new BorderLayout());
        JPanel DescriptLabelPanel = new JPanel();

//        company name
        spiralLabel.setFont(new Font("Nunito", Font.BOLD, 40));
        spiralLabel.setForeground(Color.WHITE);
        spiralLabel.setFont(new Font("Nunito", Font.BOLD,40));
        spiralLabel.setForeground(Color.white);

//        left panel
        leftPanel.setBackground(themeColor);
        leftPanel.add(spiralLabel);
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 120, 10, 120));
        leftPanel.setLayout(new GridBagLayout());

//      right panel

        //header
        JLabel registerHeadingLabel = new JLabel("<html>Purchase plan</html>");
        registerHeadingLabel.setForeground(themeColor);
        registerHeadingLabel.setFont(new Font("Nunito", Font.BOLD,25));
        rightPanel.add(registerHeadingLabel);

        //input fields
        JLabel billingName = new JLabel("Billing plan");
//        billingNameInput = new JTextField();
        ResponseBody responseBody = billingPlans();

        Integer index = 1;
        List <String> billing_plans = new ArrayList<>();
        for(Object response : responseBody.getResponse()){
            Billing response1 = (Billing) response;
            billing_plans.add(response1.getBilling_name());
            index++;
        }
//        billingNameInput = new JComboBox((String) billing_plans);
//        styling the input labels
        billingName.setFont(new Font("Verdana",Font.PLAIN,16));
//      styling the input fields
        billingNameInput.setBorder(new RoundedBorder(15));

        rightPanel.setLayout(new GridLayout(9,1, 0, 10));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(30, 120, 30, 120));

        JPanel billingNameLabelPanel = new JPanel();
        billingNameLabelPanel.setBackground(Color.WHITE);
        billingNameLabelPanel.setLayout(new BorderLayout());
        billingNameLabelPanel.add(billingName,BorderLayout.SOUTH);




        rightPanel.add(billingNameLabelPanel);
        rightPanel.add(billingNameInput);

        createBtn.setPreferredSize(new Dimension(150,50));
        createBtn.setForeground(Color.WHITE);
        createBtn.setBackground(themeColor);
        createBtn.setFont(new Font("Nunito",Font.BOLD,16));
        createBtn.setBounds(10, 10, 120, 50);
        createBtn.setBorder(BorderFactory.createCompoundBorder(
                new CustomBorder(),
                new EmptyBorder(new Insets(25, 20, 25, 25))
        ));

        createBtn.setActionCommand("REGISTER");
        createBtn.addActionListener(new PurchasePlan.ActionListen());

        CreateButtonPanel.setBackground(Color.WHITE);
        CreateButtonPanel.add(createBtn, BorderLayout.WEST);

        rightPanel.add(CreateButtonPanel);

        // panel to window
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

    }


    public void purchasePlan()throws Exception{
//        String billName = billingNameInput.;

        Billing billing = new Billing();
//        billing.setBilling_name(billName);
//        System.out.println(billName+" "+billPrice+" "+billPeriod);

//        send request to backend

        RequestBody requestBody = new RequestBody();
        requestBody.setUrl("/billing");
        requestBody.setAction("register");
        requestBody.setObject(billing);





        ClientServerConnector clientServerConnector = new ClientServerConnector();

        ResponseBody responseBody = clientServerConnector.ConnectToServer(requestBody);

        showMessageDialog(null,"Bill is registered successfully");


    }

    public class ActionListen implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try {
//                registerBill();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws Exception {
        new PurchasePlan();
    }

}
