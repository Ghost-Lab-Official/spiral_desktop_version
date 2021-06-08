package client.pages;

//author: DUSENGIMANA Felix


import client.ClientMain.ClientServerConnector;
import server.Server.Model.Billing;
import server.Server.Model.RequestBody;
import server.Server.Model.ResponseBody;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class BillingTable {
    private JFrame window;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;

    private JLabel titleView;

    private JButton levelButton;
    private JButton button,edit,delete;

    private JTable table;

    public BillingTable() throws Exception {
        CategoriesInit();
    }

    String data[][] = new String[100][6];

    public void loadBillingTable() throws Exception {

        RequestBody requestBody = new RequestBody();
        requestBody.setUrl("/billing");
        requestBody.setAction("selectAllBillingPlans");
        requestBody.setObject(null);
        ClientServerConnector clientServerConnector = new ClientServerConnector();
        ResponseBody responseBody = clientServerConnector.ConnectToServer(requestBody);

        Integer index = 0;
        String[] holder = null;

        for(Object response : responseBody.getResponse()){
            Billing response1 = (Billing) response;
            System.out.println(response1.getBilling_id());
            data[index][0] = String.valueOf(response1.getBilling_id());
            data[index][1] = response1.getBilling_name();
            data[index][2] = String.valueOf(response1.getPrice());
            data[index][3] = String.valueOf(response1.getBilling_period());
            data[index][4] = response1.getBilling_status();
            data[index][5] = response1.getBilling_name();
            index++;
    }
        String[] columns = {"Billing id","Billing name", "Billing Price","Billing Period","Status","Action"};

        panel2 = new JPanel();

        panel2.setBounds(50, 160, 1175, 500);

        table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        table.setModel(model);

        for (int i = 0; i < data.length; i++) {
            String[] currentRow = data[i];
            model.addRow(new Object[]{currentRow[0],currentRow[1],currentRow[2],currentRow[3],currentRow[4],currentRow[5]});
        }

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(new Color(53,32,88));

        JScrollPane sp = new JScrollPane(table);

        table.setRowHeight(50);
        tableHeader.setBorder(new LineBorder(Color.WHITE));
        table.setShowVerticalLines(false);
        table.setIntercellSpacing(new Dimension(0,0));
        table.getTableHeader().setBackground(Color.WHITE);
        table.getTableHeader().setPreferredSize(new Dimension(sp.getWidth(),40));
        table.getTableHeader().setFont(new Font("Nunito",Font.BOLD,14));

        for(int i = 0; i < table.getColumnCount(); i++) {
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                tableHeader.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        sp.setPreferredSize(new Dimension(1175,500));

        panel2.setBackground(Color.WHITE);
        panel2.add(sp);
    };

    public void CategoriesInit() throws Exception {
        window = new JFrame("Billing Table");
        window.setSize(1300, 735);
        window.setLayout(null);
        window.setBackground(Color.decode("#E5E5E5"));

        panel1 = new JPanel();
        panel1.setBounds(0, 10, 1300, 100);


        titleView = new JLabel("Billing");
        titleView.setFont(new Font("Nunito", Font.BOLD, 20));
        titleView.setForeground(Color.decode("#3674D0"));
        panel1.add(titleView);
        panel1.add(Box.createHorizontalStrut(970));


        button = new JButton(" + Add Billing");
        button.setBackground(Color.decode("#3674D0"));
        button.setBorder(null);
        button.setFont(new Font("Nunito", Font.BOLD, 15));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#3674D0"), 1),
                BorderFactory.createLineBorder(Color.decode("#3674D0"), 10)));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        panel1.add(button);

        loadBillingTable();

        //panel three
        panel3 = new JPanel();
        panel3.add(new JLabel("dadada"));
        window.add(panel1, BorderLayout.NORTH);
        window.add(panel3,BorderLayout.NORTH);
        window.add(panel2, BorderLayout.NORTH);
        window.setVisible(true);
    }



    public static void main(String[] args) throws Exception {

        new BillingTable();
    }
}
