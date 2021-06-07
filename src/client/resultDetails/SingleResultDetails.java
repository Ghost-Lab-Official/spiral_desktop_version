package client.resultDetails;// Java program to illustrate the GridLayout
import client.ClientMain.ClientServerConnector;
import client.result_list.ResultDetails;
import server.Server.Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
// class GridLayout extends JFrame
public class SingleResultDetails extends JFrame {
    private int searchId;
    private String spotName;
    private String descSpot;

    public SingleResultDetails() {

    }



    public int getSearchId() {
        return searchId;
    }

    private class LabelClickListener extends MouseAdapter {
        private int rates;



LabelClickListener(int ratings){
    this.rates=ratings;
}


        public void mouseClicked(MouseEvent e) {

            try {
                rateSpot(rates);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
    }
    /// rate spot
    public void  rateSpot(int rates) throws Exception {

        SpotRatings spotRating = new SpotRatings();
        spotRating.setSpot_id(this.searchId);
        spotRating.setUser_id(25);
        spotRating.setRating(rates);

        RequestBody requestBody = new RequestBody();
        requestBody.setUrl("/spot-rating");
        requestBody.setAction("register");
        requestBody.setObject(spotRating);
        ClientServerConnector clientServerConnector = new ClientServerConnector();
        ResponseBody responseBody = clientServerConnector.ConnectToServer(requestBody);
        try {
            responseBody = clientServerConnector.ConnectToServer(requestBody);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
//    new SingleResultDetails(searchId,spotName,descSpot);

    }
    public void setSearchId(int searchId) {
        this.searchId = searchId;
    }
    public int  getRates(Integer id) throws Exception {
        RequestBody requestBody = new RequestBody();
        requestBody.setUrl("/spot-rating");
        requestBody.setAction("getRatings");
        requestBody.setObject((Object) 5);

        ResponseBody responseBody = new ClientServerConnector().ConnectToServer(requestBody);
        boolean found = false;
        Integer  rates = 0;

        for (Object response: responseBody.getResponse()){
            found = true;
            SpotRatings spotRating = (SpotRatings) response;
            rates=rates+spotRating.getRating();
            System.out.println("rates spots :"+spotRating.getSpot_id());
        }

        if(!found){
            return 0;
        }
        System.out.println("number of rates :"+rates);
        return  rates;
    }
    public  SingleResultDetails (int id,String name,String desc)throws Exception {
        // Creating Object P1 of JPanel class
        this.spotName=name;
        this.descSpot=desc;
        this.searchId=id;

        setSearchId(searchId);
        getRates(searchId);
        RequestBody requestBody = new RequestBody();
        requestBody.setUrl("/spot-comment");
        requestBody.setAction("getComments");
        requestBody.setObject((Object) this.searchId);
        ClientServerConnector clientServerConnector = new ClientServerConnector();
        ResponseBody responseBody = null;
        try {
            responseBody = clientServerConnector.ConnectToServer(requestBody);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        boolean found = false;
        Integer index = 0;
        List<Object> commentsList = new ArrayList<>();
        for (Object response: responseBody.getResponse()){
            index++;
            found = true;
            Comment comment = (Comment) response;
            System.out.println(index + ". " + comment.getContent());
            commentsList.add(comment);
        }
        if(!found){
            System.out.println("No comments Found.");
        }




        JPanel p1 = new JPanel();
        // set the layout
        p1.setLayout(new GridLayout(4, 2));
        p1.setBackground(Color.decode("#ffffff"));
        p1.setPreferredSize(new Dimension(400, 480));
        // Creating Object of "FlowLayout" class
        FlowLayout layout = new FlowLayout();
        // Creating Object P2 of JPanel class
        JPanel p2 = new JPanel();
        p2.setBackground(Color.WHITE);
        p2.setPreferredSize(new Dimension(900, 480));
        // set the layout
        p2.setLayout(layout);
        JPanel TPanel=new JPanel();
        TPanel.setLayout(null);
        JLabel  title= new JLabel("Comments");
        title.setFont(new Font("Montserrat", Font.BOLD,20));
        title.setBounds(100,40,200,30);
        TPanel.add(title);
        p1.add(TPanel);
//        comments = new CommePanel[5];
        for (int i = 0;i<4;i++) {
            CommentPanel comment = new CommentPanel("Izere kerie","That song was on fire We can't wait next track !!",12);
            comment.setFont(new Font("Nunito", Font.PLAIN,13));
            p1.add(comment);
        }
        JPanel lastPanel=new JPanel();
        lastPanel.setLayout(null);
        JLabel more=new JLabel("Load more");
        more.setBounds(150,10,100,30);
        more.setForeground(Color.decode("#3674D0"));
        Font font = more.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        more.setFont(font.deriveFont(attributes));
        lastPanel.add(more);
        final PlaceholderTextField CommentField = new PlaceholderTextField("");
        CommentField.setColumns(20);
        CommentField.setPlaceholder("Add a comment!");
        CommentField.setBounds(0,50,300,55);
        CommentField.setBorder(BorderFactory.createCompoundBorder(CommentField.getBorder(),
                BorderFactory.createEmptyBorder(3, 3, 3, 3)));
        CommentField.setMargin(new Insets(15, 15, 10, 15));
        final Font f = CommentField.getFont();
        CommentField.setFont(new Font(f.getName(), f.getStyle(), 12));
        JButton sendComment=new JButton("SEND");
        sendComment.setBounds(300,50,100,55);
        sendComment.setBackground(Color.decode("#C4C4C4"));
        sendComment.setBorder(null);
        sendComment.setFont(new Font("Nunito", Font.BOLD, 15));
        lastPanel.add(CommentField);
        lastPanel.add(sendComment);
        p1.add(lastPanel);
        JLabel resultDetailsTitle, likes, resultDetailsDescription;
        JPanel descriptionPanel = new JPanel(new GridLayout(4, 4));
        descriptionPanel.setPreferredSize(new Dimension(400, 480));
        descriptionPanel.setBackground(Color.BLUE);
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(40,40,20,40));
        p2.setBackground(Color.WHITE);
        // Initialization of object
        // "one" of JLabel class.
        resultDetailsTitle = new JLabel(spotName);
        JLabel ratesn =new JLabel(String.valueOf(getRates(searchId)));
        resultDetailsTitle.setFont(new Font("Montserrat", Font.BOLD,25));
        likes = new JLabel("Likes: 38.8k");
        likes.setFont(new Font("Nunito", Font.PLAIN,12));
        resultDetailsTitle.setBounds(350,100,400,20);
        ratesn.setBounds(500,100,40,20);
        likes.setBounds(380,135,80,20);
        likes.setForeground(Color.decode("#878787"));
        int x=430;
            CommentPanel ratingStars = new CommentPanel();
            ImageIcon imageY =ratingStars.createImageIconResizeable("/client/images/star.png", "ratings", 20, 20);
            ImageIcon imageB =ratingStars.createImageIconResizeable("/client/images/black_star.png", "ratings", 20, 20);
            JLabel star1 = new JLabel((getRates(searchId)>=5)?imageY:imageB);
            star1.setBounds(x, 135, 80, 20);
            star1.addMouseListener(new LabelClickListener(5));
            p2.add(star1);
            x+=20;
            JLabel star2 = new JLabel((getRates(searchId)>=10)?imageY:imageB);
            star2.setBounds(x, 135, 80, 20);
            p2.add(star2);
            x+=20;
            JLabel star3 = new JLabel((getRates(searchId)>=15)?imageY:imageB);
            star3.setBounds(x, 135, 80, 20);
            p2.add(star3);
            x+=20;
            JLabel star4 = new JLabel((getRates(searchId)>=20)?imageY:imageB);
            star4.setBounds(x, 135, 80, 20);
            p2.add(star4);

//        for (int i = 0;i<4;i++) {
//            CommentPanel ratingStars = new CommentPanel();
//            ImageIcon imageY =ratingStars.createImageIconResizeable("/client/images/star.png", "ratings", 20, 20);
//            ImageIcon imageB =ratingStars.createImageIconResizeable("/client/images/black_star.png", "ratings", 20, 20);
//            JLabel rates = new JLabel((getRates(searchId)>5)?imageY:imageB);
//            rates.setBounds(x, 135, 80, 20);
//            p2.add(rates);
//            x+=20;
//        }

        resultDetailsDescription = new JLabel("<html>"+descSpot+"</html>");
        resultDetailsDescription.setBounds(230,0,450,400);
        resultDetailsDescription.setFont(new Font("Nunito", Font.PLAIN,13));
        p2.setLayout(null);
        p2.add(resultDetailsDescription);

        p2.add(resultDetailsTitle);
        p2.add(ratesn);
        p2.add(likes);
        p1.setLayout (new GridLayout(6,1));
        add(p1, "West");
        add(p2, "East");
        // Function to set visible
        // status of JFrame.
        this.setSize(1920, 670);
        setVisible(true);

        // this Keyword refers to current
        // object. Function to set size of JFrame.

    }

}