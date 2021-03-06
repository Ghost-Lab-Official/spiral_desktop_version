package client.Location;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import server.Server.DbController.CloudStorageConnectionHandler;
//import  server.Server.DbController.PropertyVariables;

public class LocationView {
    private JFrame  window;
    private JPanel  panelHeader;
    private JPanel  mainPanel;
    private JLabel  titleView;
    private JButton levelButton;
    private JButton locationButton;
    private JPanel panel2;
    private JTable locationsTable;


    private Connection con;

    public LocationView() throws Exception {
        LocationsInit();
    }

    public void loadLocationTable(){

        panel2 = new JPanel();
        panel2.setBounds(50, 110, 1175, 500);




        locationsTable = new JTable();
        String[] columns = {"Location","GPS","Description", "Status"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        locationsTable.setModel(model);


        JScrollPane sp = new JScrollPane(locationsTable);
        locationsTable.setRowHeight(50);
        locationsTable.setBorder(new LineBorder(Color.WHITE));
        locationsTable.setShowVerticalLines(false);
        locationsTable.setIntercellSpacing(new Dimension(0,0));
        locationsTable.getTableHeader().setBackground(Color.WHITE);
        locationsTable.getTableHeader().setPreferredSize(new Dimension(sp.getWidth(),40));
        locationsTable.getTableHeader().setFont(new Font("Nunito",Font.BOLD,14));

        String loc_name= "";
        String gps= "";
        String description = "";
        String status = "";

        try
        {
            String sql = "select location_name,location_GPS,description,status from locations";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            int i =0;
            while(rs.next())
            {
                loc_name = rs.getString("location_name");

                gps = rs.getString("location_GPS");
                description = rs.getString("description");
                status = rs.getString("status");
                model.addRow(new Object[]{loc_name , gps, description, status});
                i++;
            }
            if(i <1)
            {
                JOptionPane.showMessageDialog(null, "No Record Found","Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            if(i ==1)
            {
                System.out.println(i+" Record Found");
            }
            else
            {
                System.out.println(i+" Records Found");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        sp.setPreferredSize(new Dimension(1000,400));

        panel2.setBackground(Color.WHITE);
        panel2.add(sp);
    };

    public void LocationsInit() throws Exception {
        CloudStorageConnectionHandler DbHandler = new CloudStorageConnectionHandler();
        con= DbHandler.getConnection();
        window = new JFrame("Location buttons");
        window.setSize(1375, 735);
        window.setLayout(null);
        window.setBackground(Color.decode("#F2F6FF"));

        mainPanel=new JPanel();
        mainPanel.setBounds(0, 10, 1375, 730);
        mainPanel.setBackground(Color.WHITE);

        panelHeader = new JPanel();
        panelHeader.setBounds(0, 10, 1375, 100);
        panelHeader.setBackground(Color.WHITE);


        titleView = new JLabel("View Locations", JLabel.NORTH_EAST);
        titleView.setFont(new Font("Nunito", Font.BOLD, 20));
        titleView.setForeground(Color.decode("#3674D0"));


        levelButton = new JButton(" + Add Level ");
        levelButton.setBorder(null);
        levelButton.setFont(new Font("Verdana", Font.BOLD, 12));
        levelButton.setPreferredSize(new Dimension(150, 55));
        levelButton.setForeground(Color.WHITE);
        levelButton.setBackground(Color.gray);
        levelButton.setFocusPainted(false);
        levelButton.setBorder(BorderFactory.createCompoundBorder(
                new CustomBorder(),
                new EmptyBorder(new Insets(25, 25, 25, 25))
        ));



        locationButton = new JButton(" + Add Location ");
        locationButton.setBackground(Color.decode("#3674D0"));
        locationButton.setBorder(null);
        locationButton.setFont(new Font("Verdana", Font.BOLD, 12));
        locationButton.setPreferredSize(new Dimension(180, 55));
        locationButton.setForeground(Color.WHITE);
        locationButton.setFocusPainted(false);
        locationButton.setBorder(BorderFactory.createCompoundBorder(
                new CustomBorder(),
                new EmptyBorder(new Insets(25, 25, 25, 25))
        ));



        loadLocationTable();
        panelHeader.add(titleView,BorderLayout.EAST);
        panelHeader.add(Box.createHorizontalStrut(700));
        panelHeader.add(levelButton,BorderLayout.CENTER);
        panelHeader.add(locationButton,BorderLayout.WEST);

        mainPanel.add(panelHeader);
        mainPanel.add(panel2);
        window.add(mainPanel);

        window.setVisible(true);
    }

    class CustomBorder extends AbstractBorder {
        public void paintBorder(Component c, Graphics g, int x, int y,
                                int width, int height) {
            super.paintBorder(c, g, x, y, width, height);
            Graphics2D g2d = (Graphics2D)g;
            g2d.setStroke(new BasicStroke(15));
            g2d.drawRoundRect(x, y, width - 0, height - 0, 34, 34);
        }
    }

    public static void main(String[] args) throws Exception {

        new LocationView();
    }
}
