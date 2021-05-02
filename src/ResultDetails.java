// Java program to illustrate the GridLayout
import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Map;

// class GridLayout extends JFrame
public class ResultDetails extends JFrame {
    ResultDetails() {
        // Creating Object P1 of JPanel class
        JPanel p1 = new JPanel();
        // set the layout
        p1.setLayout(new GridLayout(4, 2));
        p1.setBackground(Color.decode("#F6F6F6"));
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

        JLabel  title= new JLabel("comments");
        title.setFont(new Font("Verdana", Font.BOLD, 27));
        title.setBounds(100,30,200,30);
        TPanel.add(title);
        p1.add(TPanel);


//        comments = new CommePanel[5];
        for (int i = 0;i<3;i++) {
            CommentPanel  comment = new CommentPanel("Izere kerie","That song was on fire We can't wait next track !!",12);
            p1.add(comment);
        }
               JPanel lastPanel=new JPanel();
          lastPanel.setLayout(null);
       JLabel more=new JLabel("loadmore");
        more.setBounds(150,0,100,30);
        more.setForeground(Color.decode("#3674D0"));
        Font font = more.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        more.setFont(font.deriveFont(attributes));
        lastPanel.add(more);
        JTextArea CommentField=new JTextArea("Add Comment");
        CommentField.setBounds(0,74,300,55);
        CommentField.setBorder(null);
        CommentField.setMargin(new Insets(20, 20, 10, 10));

         JButton sendComment=new JButton("SEND");
         sendComment.setBounds(300,74,100,55);
         sendComment.setBackground(Color.decode("#C4C4C4"));
         sendComment.setBorder(null);
         sendComment.setFont(new Font("Verdana", Font.BOLD, 15));
         lastPanel.add(CommentField);
         lastPanel.add(sendComment);

        p1.add(lastPanel);

        p1.setLayout (new GridLayout(5,1));
        add(p1, "West");
        add(p2, "East");
        // Function to set visible
        // status of JFrame.
        setVisible(true);
        // this Keyword refers to current
        // object. Function to set size of JFrame.
        this.setSize(1920, 768);
    }
    // Main Method
    public static void main(String args[])
    {
        // calling the constructor
        new ResultDetails();
    }
}