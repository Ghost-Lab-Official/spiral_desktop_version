package Dashboard;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Dashboard {
    JFrame dashBoard;
    JPanel sideBar;
    JPanel users;
    JPanel locations;
    JPanel spots;
    JPanel billing;
    JPanel mostViewedSpots;
    JPanel bestRatedSpot;
    JPanel topPopularLocation;
    JPanel recentRegisterdSpots;
    // nav bar
    JLabel Dashboard;

    public Dashboard(){
    dashBoard = new JFrame("Dashboard");
    sideBar = new JPanel();
    sideBar.setLayout(null);
    Dashboard = new JLabel("Dashboard");
    Dashboard.setBounds(40,40,200,100);
    Dashboard.setFont(new Font("Roboto",Font.BOLD,20));
    Dashboard.setBackground(Color.WHITE);
    sideBar.add(Dashboard);
    users = new JPanel();
    locations = new JPanel();
    spots = new JPanel();
    billing = new JPanel();
    mostViewedSpots = new JPanel();
    bestRatedSpot = new JPanel();
    topPopularLocation = new JPanel();
    recentRegisterdSpots = new JPanel();
    sideBar.setBounds(0,80,200,700);
    sideBar.setBackground(Color.decode("#3674d0"));
    users.setBounds(300,130,200,100);
    users.setBackground(Color.decode("#fe3f3f"));
    locations.setBackground(Color.decode("#cd45d0"));
    locations.setBounds(550,130,200,100);
    spots.setBackground(Color.decode("#42af60"));
    spots.setBounds(800,130,200,100);
    billing.setBackground(Color.decode("#4e5ef2"));
    billing.setBounds(1050,130,200,100);
    mostViewedSpots.setBackground(Color.white);
    mostViewedSpots.setBounds(300,280,180,150);
    bestRatedSpot.setBackground(Color.white);
    bestRatedSpot.setBounds(300,450,180,150);
    topPopularLocation.setBackground(Color.white);
    topPopularLocation.setBounds(550,285,300,300);
    recentRegisterdSpots.setBackground(Color.white);
    recentRegisterdSpots.setBounds(900,285,300,380);

    dashBoard.add(sideBar);
    dashBoard.add(users);
    dashBoard.add(locations);
    dashBoard.add(spots);
    dashBoard.add(billing);
    dashBoard.add(mostViewedSpots);
    dashBoard.add(bestRatedSpot);
    dashBoard.add(topPopularLocation);
    dashBoard.add(recentRegisterdSpots);
    dashBoard.setLayout(null);
    dashBoard.setSize(1920,900);
    dashBoard.setVisible(true);
 }

 public static void main(String args[]) throws IOException{
        new Dashboard();
 }
}
