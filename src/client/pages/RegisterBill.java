package client.pages;


import client.ClientMain.ClientServerConnector;
import server.Server.Model.Billing;
import server.Server.Model.RequestBody;
import server.Server.Model.ResponseBody;
import server.Server.Model.ResponseStatus;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;


public class RegisterBill extends JFrame {
    JTextField billingNameInput;
    JTextField amountInput;
    JTextField periodInput;
    private static final Color themeColor = Color.decode("#3674D0");

    RegisterBill(){
        super("Create new billing plan");
        setSize(1000,650);
        initUI();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    void initUI(){
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JLabel spiralLabel = new JLabel("Spiral");
        JButton createBtn = new JButton("Register");
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
        JLabel registerHeadingLabel = new JLabel("<html>Register Bill</html>");
        registerHeadingLabel.setForeground(themeColor);
        registerHeadingLabel.setFont(new Font("Nunito", Font.BOLD,25));
        rightPanel.add(registerHeadingLabel);

        //input fields
        JLabel billingName = new JLabel("Billing name");
        billingNameInput = new JTextField();
        JLabel amount = new JLabel("Billing price");
        amountInput = new JTextField();

        
        JLabel period = new JLabel("Billing period (months)");
        periodInput = new JTextField();


//        styling the input labels
        billingName.setFont(new Font("Verdana",Font.PLAIN,16));
        amount.setFont(new Font("Verdana",Font.PLAIN,16));
        period.setFont(new Font("Verdana",Font.PLAIN,16));
//      styling the input fields
        billingNameInput.setBorder(new RoundedBorder(15));
        amountInput.setBorder(new RoundedBorder(15));
        periodInput.setBorder(new RoundedBorder(15));

        rightPanel.setLayout(new GridLayout(9,1, 0, 10));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(30, 120, 30, 120));

        JPanel billingNameLabelPanel = new JPanel();
        billingNameLabelPanel.setBackground(Color.WHITE);
        billingNameLabelPanel.setLayout(new BorderLayout());
        billingNameLabelPanel.add(billingName,BorderLayout.SOUTH);

        JPanel amountPanel = new JPanel();
        amountPanel.setBackground(Color.WHITE);
        amountPanel.setLayout(new BorderLayout());
        amountPanel.add(amount,BorderLayout.SOUTH);

        
        JPanel periodPanel = new JPanel();
        periodPanel.setBackground(Color.WHITE);
        periodPanel.setLayout(new BorderLayout());
        periodPanel.add(period,BorderLayout.SOUTH);



        rightPanel.add(billingNameLabelPanel);
        rightPanel.add(billingNameInput);
        rightPanel.add(amountPanel);
        rightPanel.add(amountInput);

        rightPanel.add(periodPanel);
        rightPanel.add(periodInput);

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
        createBtn.addActionListener(new ActionListen());

        CreateButtonPanel.setBackground(Color.WHITE);
        CreateButtonPanel.add(createBtn, BorderLayout.WEST);

        rightPanel.add(CreateButtonPanel);

        // panel to window
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

    }


    public void registerBill()throws Exception{
        String billName = billingNameInput.getText();
        Integer billPrice = Integer.parseInt(amountInput.getText());
        Integer billPeriod = Integer.parseInt(periodInput.getText());

        Billing billing = new Billing();
        billing.setBilling_name(billName);
        billing.setPrice(billPrice);
        billing.setBilling_period(billPeriod);
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
            setVisible(false);
            try {
                registerBill();
                new BillingTable();
            } catch (Exception exception) {
                setVisible(true);
                exception.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new RegisterBill();
    }
}
     
