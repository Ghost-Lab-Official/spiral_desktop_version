// Result details page
import javax.swing.*;
import java.awt.*;

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

        // Declaration of objects of JLabel class.
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

        add(p1, "West");

        // add the p2 object which
        // refer to the Jpanel
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
