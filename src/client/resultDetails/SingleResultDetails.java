package client.resultDetails;// Java program to illustrate the GridLayout

import client.ClientMain.ClientServerConnector;
import client.result_list.ResultDetails;
import server.Server.Model.Comment;
import server.Server.Model.RequestBody;
import server.Server.Model.ResponseBody;
import server.Server.Model.ResponseStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.*;

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

    public void setSearchId(int searchId) {
        this.searchId = searchId;
    }

    private class ButtonClickListener implements ActionListener {

        private String commentContent;

        public ButtonClickListener(String commentText) {
            this.commentContent = commentText;
        }


        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if( command.equals( "sendComment" ))  {
                try {
//                    new SingleResultDetails(id,name,desc);
                    System.out.println("Here we are guys: " + this.commentContent);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public SingleResultDetails(int id, String name, String desc) throws Exception {
        // Creating Object P1 of JPanel class
        this.spotName = name;
        this.descSpot = desc;
        this.searchId = id;

        setSearchId(searchId);
        RequestBody requestBody = new RequestBody();
        requestBody.setUrl("/spot-comment");
        requestBody.setAction("getComments");
        requestBody.setObject((Object) this.searchId);
        ClientServerConnector clientServerConnector = new ClientServerConnector();
        ResponseBody responseBody = null;
        try {
            responseBody = clientServerConnector.ConnectToServer(requestBody);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        boolean found = false;
//        Integer index = 0;
//        List<Object> commentsList = new ArrayList<>();
//
//        if(!found){
//            System.out.println("No comments Found.");
//        }
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
        JPanel TPanel = new JPanel();
        TPanel.setLayout(null);
        JLabel title = new JLabel("Comments");
        title.setFont(new Font("Montserrat", Font.BOLD, 20));
        title.setBounds(100, 40, 200, 30);
        TPanel.add(title);
        p1.add(TPanel);
//        comments = new CommePanel[5];
        int n = 0;

        for (Object response : responseBody.getResponse()) {

            if (n < 4) {
                Comment comment = (Comment) response;
                CommentPanel commentP = new CommentPanel(String.valueOf(comment.getUserId()), comment.getContent(), 12);
                commentP.setFont(new Font("Nunito", Font.PLAIN, 13));
                p1.add(commentP);
            } else {
                break;
            }

            n++;

        }
//        for (int i = 0;i<4;i++) {
//
//            CommentPanel comment = new CommentPanel("Izere kerie","That song was on fire We can't wait next track !!",12);
//            comment.setFont(new Font("Nunito", Font.PLAIN,13));
//            p1.add(comment);
//        }
        JPanel lastPanel = new JPanel();
        lastPanel.setLayout(null);
        JLabel more = new JLabel("Load more");
        more.setBounds(150, 10, 100, 30);
        more.setForeground(Color.decode("#3674D0"));
        Font font = more.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        more.setFont(font.deriveFont(attributes));
        lastPanel.add(more);

//        ResponseBody response;
//        Comment comment = (Comment) response;
        final PlaceholderTextField CommentField = new PlaceholderTextField("");
        CommentField.setColumns(20);
        CommentField.setPlaceholder("Add a comment!");
        CommentField.setBounds(0, 50, 300, 55);
        CommentField.setBorder(BorderFactory.createCompoundBorder(CommentField.getBorder(),
                BorderFactory.createEmptyBorder(3, 3, 3, 3)));
        CommentField.setMargin(new Insets(15, 15, 10, 15));
        final Font f = CommentField.getFont();
        CommentField.setFont(new Font(f.getName(), f.getStyle(), 12));

        System.out.println("Here's our " + CommentField.getText());
        JButton sendComment = new JButton("SEND");
//        sendComment.setActionCommand("sendComment");

        sendComment.setActionCommand("sendComment");
//        sendComment.addActionListener(new ResultDetails.ButtonClickListener(spot.getSpotId(),spot.getSpotName(),spot.getSpotDescription()));
        sendComment.addActionListener(new ButtonClickListener(CommentField.getText()));

        //sendComment.addActionListener(new ButtonClickListener(comm., spot.getSpotName(), spot.getSpotDescription()));
        sendComment.setBounds(300, 50, 100, 55);
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
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 20, 40));
        p2.setBackground(Color.WHITE);
        // Initialization of object
        // "one" of JLabel class.
        resultDetailsTitle = new JLabel(spotName);
        resultDetailsTitle.setFont(new Font("Montserrat", Font.BOLD, 25));
        likes = new JLabel("Likes: 38.8k");
        likes.setFont(new Font("Nunito", Font.PLAIN, 12));
        resultDetailsTitle.setBounds(350, 100, 400, 20);
        likes.setBounds(380, 135, 80, 20);
        likes.setForeground(Color.decode("#878787"));
        int x = 430;
        for (int i = 0; i < 4; i++) {
            CommentPanel ratingStars = new CommentPanel();
            ImageIcon image = ratingStars.createImageIconResizeable("/client/images/star.png", "ratings", 15, 15);
            JLabel rates = new JLabel(image);
            rates.setBounds(x, 135, 80, 20);
            p2.add(rates);
            x += 20;
        }
        resultDetailsDescription = new JLabel("<html>" + descSpot + "</html>");
        resultDetailsDescription.setBounds(230, 0, 450, 400);
        resultDetailsDescription.setFont(new Font("Nunito", Font.PLAIN, 13));
        p2.setLayout(null);
        p2.add(resultDetailsDescription);
        // Adding Jlabel "one" on JFrame.
        p2.add(resultDetailsTitle);
        p2.add(likes);
        p1.setLayout(new GridLayout(6, 1));
        add(p1, "West");
        add(p2, "East");
        // Function to set visible
        // status of JFrame.
        setVisible(true);
        // this Keyword refers to current
        // object. Function to set size of JFrame.
        this.setSize(1920, 670);
    }

//    private class ButtonClickListener implements ActionListener {
//        private int id;
//        private String content;
//
//
//        public ButtonClickListener(Integer spotId, String content) {
//            System.out.println(content);
//            this.id = spotId;
//            this.content = content;
//
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public String getContent() {
//            return content;
//        }
//
//        public void setContent(String content) {
//            this.content = content;
//        }
//
//        public void actionPerformed(ActionEvent e) {
//            String command = e.getActionCommand();
//            if (command.equals("details")) {
//                try {
//                    System.out.println("harahiye" + " , " + getId() + " , " + getContent());
//                } catch (Exception exception) {
//                    exception.printStackTrace();
//                }
//            }
//        }
//    }

    private void saveComment(String spotId, String content) throws Exception {
        Comment comment = new Comment();
        comment.setComment_id(UUID.randomUUID().toString());
        comment.setContent("Updated my comment is registered now");
        comment.setSpotId(1);
        comment.setCreated_at(new Date());
        comment.setStatus("active");
        comment.setUserId(3);
        comment.setUpdatedAt(new Date());

        RequestBody requestBody = new RequestBody();
        requestBody.setUrl("/spot-comment");
        requestBody.setAction("update");
        requestBody.setObject(comment);

        ClientServerConnector clientServerConnector = new ClientServerConnector();
        ResponseBody responseBody = clientServerConnector.ConnectToServer(requestBody);

        for (Object response: responseBody.getResponse()){
            ResponseStatus responseStatus = (ResponseStatus) response;
            System.out.println("\t\t -------------------------------------- STATUS: "+responseStatus.getStatus()+" ---------------------------");
            System.out.println("\t\t --------------         Meaning: "+responseStatus.getMessage());
            System.out.println("\t\t --------------         Action: "+responseStatus.getActionToDo());
            System.out.println("\t\t ------------------------------------------------------------------------------");

//            UserLog userLogToInsertOnSearch = new UserLog();
//            userLogToInsertOnSearch.setUser_id(new UserAuthMiddleware().checkForUserExistence());
//            String logAction= "Updated spot comment " ;
//            userLogToInsertOnSearch.setAction(logAction);

        }
    }
}