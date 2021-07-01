package client.Dashboard;

import client.ClientMain.ClientServerConnector;
import client.resultDetails.UserTopNav;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import server.Server.Controllers.ReportController.SpotReportsActions;
import server.Server.Model.RequestBody;
import server.Server.Model.ResponseBody;
import server.Server.Model.SpotsReport;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dashboard {
     JLabel TopRatedLabelTitle;
    JFrame dashBoard;
    JPanel sideBar,users,locations,spots,billing,mostViewedSpots,bestRatedSpot,recentRegisteredSpots,billing2,topNav;
    ChartPanel BarChart;
    JLabel DashboardLabel,UserLabel,BillingsLabel,LocationsLabel,SpotsLLabel,SettingsLabel,LogoutLabel,Users2Label,Locations2Label,spots2Label,billing2Label,RecentRegisterdSpotsLabel,recentRegisterdSpotsLabel,recentTimeLabel,bestRatedSpotLabel,bestRated2SpotLabel,bestRated3SpotLabel, bestRated4SpotLabel,bestRated5SpotLabel,bestRated6SpotLabel,bestRated7SpotLabel,bestRated8SpotLabel,mostViewedSpotsLabel,mostViewedSpotsLabel2;
    JLabel dashboardIconLabel,usersIconLabel,billingsIconLabel,locationsIconLabel,spotsIconLabel,settingsIconLabel,logoutIconLabel,users2IconLabel,locations2IconLabel,spots2IconLabel,billing2IconLabel,RecentRegisterdIconLabel,bestRatedIconSpotLabel,bestRated2IconSpotLabel,progressBar;
    ImageIcon icon1,icon2,icon3,icon4,icon5,icon6,icon7,icon8,icon9,icon10,icon11,icon12,icon13;
    BufferedImage img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13;
    JProgressBar mostViewedSpotPb;
    JScrollBar scrollBar;
    Container container;
    JFreeChart chart;
    public Dashboard() throws Exception {
    dashBoard = new JFrame("Dashboard");
    topNav= new JPanel();
    topNav = new UserTopNav().topnavInit();
    topNav.setLayout(null);
    topNav.setBounds(0,2,2000,80);
    sideBar = new JPanel();
    sideBar.setLayout(null);
    DashboardLabel = new JLabel("Dashboard");
    DashboardLabel.setFont(new Font("Roboto",Font.BOLD,20));
    DashboardLabel.setForeground(Color.white);
    img1 = ImageIO.read(new File("src/client/images/Dashboard.png"));
    icon1 = new ImageIcon(img1.getScaledInstance(20,20,BufferedImage.SCALE_DEFAULT));
    dashboardIconLabel= new JLabel();
    dashboardIconLabel.setBounds(20,70,20,20);
    dashboardIconLabel.setIcon(icon1);
    DashboardLabel.setBounds(50,70,250,20);
    UserLabel = new JLabel("Users");
    UserLabel.setFont(new Font("Roboto",Font.BOLD,20));
    UserLabel.setForeground(Color.white);
    img2 = ImageIO.read(new File("src\\client\\images\\users.png"));
    icon2 = new ImageIcon(img2.getScaledInstance(25,25,BufferedImage.SCALE_DEFAULT));
    usersIconLabel = new JLabel();
    usersIconLabel.setBounds(20,110,40,40);
    usersIconLabel.setIcon(icon2);
    UserLabel.setBounds(50,120,250,20);
    BillingsLabel = new JLabel("Billings");
    BillingsLabel.setFont(new Font("Roboto",Font.BOLD,20));
    BillingsLabel.setForeground(Color.white);
    img3 = ImageIO.read(new File("src\\client\\images\\Billing.png"));
    icon3 = new ImageIcon(img3.getScaledInstance(20,20,BufferedImage.SCALE_DEFAULT));
    billingsIconLabel = new JLabel();
    billingsIconLabel.setBounds(20,200,20,20);
    billingsIconLabel.setIcon(icon3);
    BillingsLabel.setBounds(50,200,250,25);
    LocationsLabel = new JLabel("Locations");
    LocationsLabel.setFont(new Font("Roboto",Font.BOLD,20));
    LocationsLabel.setForeground(Color.white);
    img4 = ImageIO.read(new File("src\\client\\images\\Locations.png"));
    icon4 = new ImageIcon(img4.getScaledInstance(25,30,BufferedImage.SCALE_DEFAULT));
    locationsIconLabel = new JLabel();
    locationsIconLabel.setBounds(20,260,280,40);
    locationsIconLabel.setIcon(icon4);
    LocationsLabel.setBounds(45,270,250,25);
    SpotsLLabel = new JLabel("Spots");
    SpotsLLabel.setFont(new Font("Roboto",Font.BOLD,20));
    SpotsLLabel.setForeground(Color.white);
    img5 = ImageIO.read(new File("src\\client\\images\\icons8_tripadvisor_64px 2.png"));
    icon5 = new ImageIcon(img5.getScaledInstance(30,30,BufferedImage.SCALE_DEFAULT));
    spotsIconLabel = new JLabel();
    spotsIconLabel.setBounds(20,350,250,25);
    spotsIconLabel.setIcon(icon5);
    SpotsLLabel.setBounds(52,350,250,25);

    SettingsLabel = new JLabel("Settings");
    SettingsLabel.setFont(new Font("Roboto",Font.BOLD,20));
    SettingsLabel.setForeground(Color.white);
    img6 = ImageIO.read(new File("src\\client\\images\\settings.png"));
    icon6 = new ImageIcon(img6.getScaledInstance(20,20,BufferedImage.SCALE_DEFAULT));
    settingsIconLabel = new JLabel();
    settingsIconLabel.setBounds(20,420,250,25);
    settingsIconLabel.setIcon(icon6);
    SettingsLabel.setBounds(50,420,250,25);
    LogoutLabel = new JLabel("Logout");
    LogoutLabel.setBounds(50,520,250,25);
    LogoutLabel.setFont(new Font("Roboto",Font.BOLD,20));
    LogoutLabel.setForeground(Color.white);
    img7 = ImageIO.read(new File("src\\client\\images\\logout.jpg"));
    icon7 = new ImageIcon(img7.getScaledInstance(20,20,BufferedImage.SCALE_DEFAULT));
    logoutIconLabel = new JLabel();
    logoutIconLabel.setBounds(20,520,250,25);
    logoutIconLabel.setIcon(icon7);
    sideBar.add(dashboardIconLabel);
    sideBar.add(DashboardLabel);
    sideBar.add(usersIconLabel);
    sideBar.add(UserLabel);
    sideBar.add(billingsIconLabel);
    sideBar.add(BillingsLabel);
    sideBar.add(locationsIconLabel);
    sideBar.add(LocationsLabel);
    sideBar.add(spotsIconLabel);
    sideBar.add(SpotsLLabel);
    sideBar.add(settingsIconLabel);
    sideBar.add(SettingsLabel);
    sideBar.add(logoutIconLabel);
    sideBar.add(LogoutLabel);
    users = new JPanel();
    locations = new JPanel();
    spots = new JPanel();
    billing = new JPanel();
    mostViewedSpots = new JPanel();
    bestRatedSpot = new JPanel();
    bestRatedSpot.setLayout(new BoxLayout(bestRatedSpot, BoxLayout.Y_AXIS));
    bestRatedSpot.setBorder(new EmptyBorder(20, 5, 0, 0));
    recentRegisteredSpots = new JPanel();
    recentRegisteredSpots.setLayout(new BoxLayout(recentRegisteredSpots,BoxLayout.Y_AXIS));
    recentRegisteredSpots.setBorder(new EmptyBorder(30,5,0,0));
    billing2 = new JPanel();
    sideBar.setBounds(0,80,200,700);
    sideBar.setBackground(Color.decode("#3674d0"));
    users.setBounds(300,130,200,100);
    users.setLayout(null);
    users.setBackground(Color.decode("#fe3f3f"));
    img8 = ImageIO.read(new File("src\\client\\images\\users2.png"));
    icon8 = new ImageIcon(img8.getScaledInstance(40,40,BufferedImage.SCALE_DEFAULT));
    users2IconLabel = new JLabel();
    users2IconLabel.setBounds(80,15,400,40);
    users2IconLabel.setIcon(icon8);
    Users2Label = new JLabel("Users");
    Users2Label.setFont(new Font("Roboto",Font.BOLD,20));
    Users2Label.setForeground(Color.white);
    Users2Label.setBounds(80,20,100,100);
    users.add(users2IconLabel);
    users.add(Users2Label);
    locations.setBackground(Color.decode("#cd45d0"));
    locations.setBounds(550,130,200,100);
    locations.setLayout(null);
    img9 = ImageIO.read(new File("src\\client\\images\\locations2.png"));
    icon9 = new ImageIcon(img9.getScaledInstance(40,40,BufferedImage.SCALE_DEFAULT));
    locations2IconLabel = new JLabel();
    locations2IconLabel.setBounds(80,15,400,40);
    locations2IconLabel.setIcon(icon9);
    Locations2Label = new JLabel("Locations");
    Locations2Label.setFont(new Font("Roboto",Font.BOLD,20));
    Locations2Label.setForeground(Color.white);
    Locations2Label.setBounds(80,20,100,100);
    locations.add(locations2IconLabel);
    locations.add(Locations2Label);
    spots.setBackground(Color.decode("#42af60"));
    spots.setBounds(800,130,200,100);
    spots.setLayout(null);
    img10 =  ImageIO.read(new File("src\\client\\images\\icons8_tripadvisor_64px 2.png"));
    icon10 = new ImageIcon(img10.getScaledInstance(40,40,BufferedImage.SCALE_DEFAULT));
    spots2IconLabel = new JLabel();
    spots2IconLabel.setBounds(80,15,400,40);
    spots2IconLabel.setIcon(icon10);
    spots2Label = new JLabel("Spots");
    spots2Label.setFont(new Font("Roboto",Font.BOLD,20));
    spots2Label.setForeground(Color.white);
    spots2Label.setBounds(80,20,100,100);
    spots.add(spots2IconLabel);
    spots.add(spots2Label);
    billing.setBackground(Color.decode("#4e5ef2"));
    billing.setBounds(1050,130,200,100);
    billing.setLayout(null);
    img11 = ImageIO.read(new File("src\\client\\images\\billing2.png"));
    icon11 = new ImageIcon(img11.getScaledInstance(40,40,BufferedImage.SCALE_DEFAULT));
    billing2IconLabel = new JLabel();
    billing2IconLabel.setBounds(80,15,400,40);
    billing2IconLabel.setIcon(icon11);
    billing2Label = new JLabel("Billings");
    billing2Label.setFont(new Font("Roboto",Font.BOLD,20));
    billing2Label.setForeground(Color.white);
    billing2Label.setBounds(80,20,100,100);
    billing.add(billing2IconLabel);
    billing.add(billing2Label);

        bestRatedSpot.setBackground(Color.white);
        bestRatedSpot.setBounds(750, 285, 180, 150);
        TopRatedLabelTitle=new JLabel("Best Rated Spots");
        bestRatedSpot.add(TopRatedLabelTitle);

        RequestBody request=new RequestBody();
        request.setUrl("/report");
        request.setAction("viewHighlyRatedSpots");
        request.setObject(null);

        ResponseBody responseBody=new ClientServerConnector().ConnectToServer(request);

        for(Object Response: responseBody.getResponse()) {
            SpotsReport SpotsReport=(server.Server.Model.SpotsReport) Response;
            displayRatesCardData(SpotsReport.getSpot_name());
//            img8 = ImageIO.read(new File("src\\client\\images\\users2.png"));
//            icon8 = new ImageIcon(img8.getScaledInstance(40,40,BufferedImage.SCALE_DEFAULT));
//            users2IconLabel = new JLabel();
//            users2IconLabel.setBounds(80,15,400,40);
//            users2IconLabel.setIcon(icon8);
//            recentRegisteredSpots.add(usersIconLabel);
        }

        JLabel recentRegisterdSpotsLabelTitle=new JLabel("Recent registered spots");
        recentRegisteredSpots.add(recentRegisterdSpotsLabelTitle);
        recentRegisteredSpots.setBackground(Color.white);
        recentRegisteredSpots.setBounds(950, 285, 300, 380);

        RequestBody recentRequest=new RequestBody();
        recentRequest.setUrl("/report");
        recentRequest.setAction("viewRecentRegisteredSpots");
        recentRequest.setObject(null);

        ResponseBody recentResponseBody=new ClientServerConnector().ConnectToServer(recentRequest);

        for(Object recentResponse: recentResponseBody.getResponse()) {
            SpotsReport SpotsReport=(server.Server.Model.SpotsReport) recentResponse;
            displayRecentsCardData(SpotsReport.getSpot_name());
//                System.out.println(SpotsReport.getSpot_name());

        }
        billing2.setBackground(Color.white);
       billing2.setBounds(1000,800,300,380);
       billing2.setLayout(null);

       DefaultCategoryDataset dataset = usersLineChart();
       chart = ChartFactory.createBarChart("Spots of the system","Year of registration","Number of spots",dataset, PlotOrientation.VERTICAL,true,false,false);
       BarChart = new ChartPanel(chart);
       BarChart.setBounds(200,260,540,400);
        container = new Container();
        container.add(topNav);
        container.add(sideBar);
        container.add(users);
        container.add(locations);
        container.add(spots);
        container.add(billing);
        container.add(bestRatedSpot);
        container.add(recentRegisteredSpots);
        container.add(billing2);
        container.add(BarChart);
        container.setLayout(null);
        scrollBar = new JScrollBar();
        scrollBar.setBounds(100,100, 50,100);
        dashBoard.add(topNav);
        dashBoard.add(container);
        dashBoard.setSize(1400,1700);
        dashBoard.setVisible(true);
 }

  public DefaultCategoryDataset usersLineChart(){
   String uniqueUsers = "Spots";
    DefaultCategoryDataset dataset  = new DefaultCategoryDataset();
      List<List> values = new ArrayList<List>();
      values = SpotReportsActions.printDataOnLineChart();
      List<Integer> spotsData = new ArrayList<>();
      List<Integer> yearsData = new ArrayList<>();
      spotsData = values.get(0);
      yearsData = values.get(1);
      for (int i = 0; i <  spotsData.size() ; i++) {

          dataset.addValue(Double.parseDouble(spotsData.get(i).toString()),uniqueUsers,yearsData.get(i).toString());

      }
      return dataset;
  }

    public void displayRatesCardData(String Label) throws IOException {

        JPanel ratesCardData = new JPanel();
        ratesCardData.setBackground(new Color(0,0,0,0));
        ratesCardData.setBorder(new EmptyBorder(5,0,0,0));
        img12=ImageIO.read(new File("src/client/images/Billing.png"));
        icon1=new ImageIcon(img1.getScaledInstance(20, 20, BufferedImage.SCALE_DEFAULT));

        JLabel ratesList=new JLabel();
        ratesList.setBounds(20, 70, 20, 20);
        ratesList.setIcon(icon1);

        ratesCardData.add(ratesList);
        bestRatedSpotLabel=new JLabel(Label);
        bestRatedSpotLabel.setFont(new Font("Roboto", Font.BOLD, 15));
        bestRatedSpotLabel.setForeground(Color.black);
        bestRatedSpotLabel.setLocation(100, 100);

        bestRatedSpotLabel.setBounds(100, 100, 200, 200);
        ratesCardData.add(bestRatedSpotLabel);

        bestRatedSpot.add(ratesCardData);
    }

    public void displayRecentsCardData(String Label) {

        JPanel recentsCardData = new JPanel();
        recentsCardData.setBorder(new EmptyBorder(5,0,0,0));
        recentsCardData.setBackground(Color.white);
        recentRegisterdSpotsLabel=new JLabel(Label);
        recentRegisterdSpotsLabel.setFont(new Font("Roboto", Font.BOLD, 15));
        recentRegisterdSpotsLabel.setForeground(Color.black);
        recentRegisterdSpotsLabel.setLocation(100,100);
        recentRegisterdSpotsLabel.setBounds(30, -80, 400, 200);
        recentsCardData.add(recentRegisterdSpotsLabel);

        recentRegisteredSpots.add(recentsCardData);


    }

 public static void main(String args[]) throws Exception {
       Dashboard dashboard = new Dashboard();
 }
}
