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
        p1.setBackground(Color.decode("#ffffff"));
        p1.setPreferredSize(new Dimension(400, 200));
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
        title.setFont(new Font("Verdana", Font.BOLD, 27));
        title.setBounds(100,30,200,30);
        TPanel.add(title);
        p1.add(TPanel);


//        comments = new CommePanel[5];
        for (int i = 0;i<4;i++) {
            CommentPanel comment = new CommentPanel("Izere kerie","That song was on fire We can't wait next track !!",12);
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
        CommentField.setBounds(0,50,300,55);
        CommentField.setBorder(BorderFactory.createCompoundBorder(
                CommentField.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        CommentField.setMargin(new Insets(20, 20, 10, 10));

//        CommentField.setBounds(0,50,300,55);
//        CommentField.setBorder(null);
//        CommentField.setMargin(new Insets(20, 20, 10, 10));

         JButton sendComment=new JButton("SEND");
         sendComment.setBounds(300,50,100,55);
         sendComment.setBackground(Color.decode("#C4C4C4"));
         sendComment.setBorder(null);
         sendComment.setFont(new Font("Verdana", Font.BOLD, 15));
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
        resultDetailsTitle = new JLabel("Amakosi-Ish Kevin");
        resultDetailsTitle.setFont(new Font("Inter", Font.BOLD,25));
        likes = new JLabel("Likes: 38.8k");
        resultDetailsTitle.setBounds(350,30,400,20);
        likes.setBounds(400,60,80,20);
        likes.setForeground(Color.decode("#878787"));
        resultDetailsDescription = new JLabel("<html>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse vehicula\n" +
                "blandit metus eget eleifend. Suspendisse nisl ante, aliquam in nunc at, sagittis\n" +
                "fringilla lorem. Duis pretium arcu et diam convallis, et lacinia lectus fermentum.\n" +
                "Nunc ac mattis ante. Nullam et diam efficitur, pulvinar sem ac, congue ipsum.\n" +
                "Proin lacinia nisi vitae tortor scelerisque fringilla. Fusce in gravida nulla. In quis\n" +
                "orci ut ex condimentum faucibus nec sed odio. Nulla et turpis mollis, aliquet nib\n" +
                "id, pharetra massa. Duis finibus ante quis scelerisque luctus.\n" +
                "\n" +
                "Mauris vehicula ante vel erat accumsan, eu ultrices elit porttitor. Aliquam accum\n" +
                "urna nec condimentum suscipit. Fusce eleifend massa cursus elementum pulvin \n" +
                "Vivamus quis quam luctus, porta metus at, pharetra mi. Quisque diam sapien, p\n" +
                "uere eu suscipit eu, convallis nec magna. \n" +
                "\n" +
                "Cras luctus sagittis feugiat. Vestibului amet dapibus nulla. Integer faucibus id m\n" +
                "id lectus suscipit suscipit in quis turpis. Sed auctor tempor dolor, vitae placerat\n" +
                "rhoncus vel. Mauris tellus nisi, congue vitae fringilla id, condimentum vel tellus.\n" +
                "lentesque ac dui vulputate, ultrices quam sit amet.</html>");
        
        resultDetailsDescription.setBounds(230,90,450,250);
        p2.setLayout(null);
        p2.add(resultDetailsDescription);
        // Adding Jlabel "one" on JFrame.
        p2.add(resultDetailsTitle);
        p2.add(likes);


        p1.setLayout (new GridLayout(7,1));



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