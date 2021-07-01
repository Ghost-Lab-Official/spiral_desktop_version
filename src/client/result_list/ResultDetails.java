package client.result_list;
import client.ClientMain.ClientServerConnector;
import client.resultDetails.SingleResultDetails;
import server.Server.Model.Comment;
import server.Server.Model.RequestBody;
import server.Server.Model.ResponseBody;
import server.Server.Model.Spot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class ResultDetails{
    private JFrame window;
    private Container container;
    private JLabel title;
    private JLabel subTitle;
    private JLabel description;
    private JLabel lsubTitle;
    private JLabel title2;
    private JLabel subTitle2;
    private JLabel description2;
    private JLabel lsubTitle2;
    private JLabel title3;
    private JLabel subTitle3;
    private JLabel description3;
    private JLabel lsubTitle3;


    public JFrame getWindow() {
        return window;
    }
    public void setWindow(JFrame window) {
        this.window = window;
    }
    public Container getContainer() {
        return container;
    }
    public void setContainer(Container container) {
        this.container = container;
    }
    public JLabel getTitle() {
        return title;
    }
    public void setTitle(JLabel title) {
        this.title = title;
    }
    public JLabel getSubTitle() {
        return subTitle;
    }
    public void setSubTitle(JLabel subTitle) {
        this.subTitle = subTitle;
    }
    public JLabel getDescription() {
        return description;
    }
    public void setDescription(JLabel description) {
        this.description = description;
    }
    public JLabel getLsubTitle() {
        return lsubTitle;
    }
    public void setLsubTitle(JLabel lsubTitle) {
        this.lsubTitle = lsubTitle;
    }
    public JLabel getTitle2() {
        return title2;
    }
    public void setTitle2(JLabel title2) {
        this.title2 = title2;
    }
    public JLabel getSubTitle2() {
        return subTitle2;
    }
    public void setSubTitle2(JLabel subTitle2) {
        this.subTitle2 = subTitle2;
    }
    public JLabel getDescription2() {
        return description2;
    }
    public void setDescription2(JLabel description2) {
        this.description2 = description2;
    }
    public JLabel getLsubTitle2() {
        return lsubTitle2;
    }
    public void setLsubTitle2(JLabel lsubTitle2) {
        this.lsubTitle2 = lsubTitle2;
    }
    public JLabel getTitle3() {
        return title3;
    }
    public void setTitle3(JLabel title3) {
        this.title3 = title3;
    }
    public JLabel getSubTitle3() {
        return subTitle3;
    }
    public void setSubTitle3(JLabel subTitle3) {
        this.subTitle3 = subTitle3;
    }
    public JLabel getDescription3() {
        return description3;
    }
    public void setDescription3(JLabel description3) {
        this.description3 = description3;
    }
    public JLabel getLsubTitle3() {
        return lsubTitle3;
    }
    public void setLsubTitle3(JLabel lsubTitle3) {
        this.lsubTitle3 = lsubTitle3;
    }


    private class LabelClickListener extends MouseAdapter {
        private int rates;
        private int id;
        private String name;
        private String desc;


        public LabelClickListener(Integer spotId, String spotName, String spotDescription) {
            this.id=spotId;
            this.name=spotName;
            this.desc=spotDescription;

        }


        public void mouseClicked(MouseEvent e) {

                try {
                    new SingleResultDetails(id,name,desc);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
        }
    }
    public ResultDetails(String searchKeyParam) throws Exception {
        Spot spotToSend = new Spot();

        if(searchKeyParam.equals("")){
            spotToSend.setSpotName("Oops! No results found at the moment");
        }
        RequestBody requestBody = new RequestBody();
        requestBody.setUrl("/search");
        requestBody.setAction("getSpots");

        spotToSend.setSpotName(searchKeyParam);
        requestBody.setObject(spotToSend);

        ResponseBody responseBody = new ClientServerConnector().ConnectToServer(requestBody);
        if(responseBody == null){
            spotToSend.setSpotName("Oops! No results found at the moment");
        }
        Integer index = 0;
        List<Object> spotsList = new ArrayList<>();

        for (Object response : responseBody.getResponse()) {
            index++;
            Spot spot = (Spot) response;
//            System.out.println("The response: "+ ((Spot) response).getSpotDescription());
//            System.out.println(index + ". " + spot.getSpotName() + "\n\t\t" + spot.getSpotDescription());
            spotsList.add(spot);
        }

        window = new JFrame();
        window.setTitle("Result Details");
        int y1=40;int y2=60;
        for (Object response : responseBody.getResponse()) {
            window.setBounds(300, 10, 800, 800);
            window.setDefaultCloseOperation(EXIT_ON_CLOSE);
            window.setResizable(true);
            container = window.getContentPane();
            container.setBackground(Color.white);
            container.setLayout(null);

        Spot spot = (Spot) response;
        title = new JLabel(spot.getSpotName());
       title.addMouseListener(new LabelClickListener(spot.getSpotId(),spot.getSpotName(),spot.getSpotDescription()));
        title.setFont(new Font("Arial", Font.BOLD, 23));
        title.setSize(500, 30);
        title.setLocation(60, y1);

        title.setForeground(Color.decode("#0074DB"));
        container.add(title);

        description = new JLabel();
        description.setText(convertToMultiline(spot.getSpotDescription()));
        description.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        description.setSize(700, 130);
        description.setLocation(60, y2);
        container.add(description);
         y1=+150;
         y2=+170;
    }
      
        window.setVisible(false);
    }
    public static String convertToMultiline(String orig)
    {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }
}
