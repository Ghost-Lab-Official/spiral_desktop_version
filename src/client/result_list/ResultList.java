package client.result_list;

<<<<<<< HEAD
import javax.swing.*;
import java.awt.*;

public class ResultList extends JFrame{

    public ResultList(){
        setTitle("Search Results");
        setSize(1200, 700);
        setMinimumSize(new Dimension(1000, 500));
        initUI();
=======

import java.awt.*;
import javax.swing.*;

public class ResultList extends JFrame{

    public ResultList(String searchKey) throws Exception {
        setTitle("Search Results");
        setSize(1200, 700);
        setMinimumSize(new Dimension(1000, 500));
        initUI(searchKey);
>>>>>>> d3cbee5dde6691de8ab652e5c49bd56983c38f24
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

<<<<<<< HEAD
    public void initUI(){
=======
    public void initUI(String searchKey) throws Exception {
>>>>>>> d3cbee5dde6691de8ab652e5c49bd56983c38f24
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JLabel compName = new JLabel("#Ouagadougu");
        JLabel instructionText = new JLabel(convertToMultiline("Kanda kurayo magambo asa\n" +
                "Ubururu kugira ngo ubone\n" +
                "Ibyo ushaka. Murakoze"));
        String[][] results = {
                {"Title", "url", "description","Relation"},
                {"Title", "url", "description","Relation"},
                {"Title", "url", "description","Relation"}
        };




        JLabel timeTaken = new JLabel("Time Taken:");
        JLabel timeInSeconds = new JLabel("14 secs");
        JLabel totalSearches = new JLabel("Total Searches:");
        JLabel numberOfSearches = new JLabel("30.5k");


        BoxLayout leftPanelLayout = new BoxLayout(leftPanel, BoxLayout.Y_AXIS);
        leftPanel.setLayout(leftPanelLayout);


        rightPanel.setPreferredSize(new Dimension(350, 0));
        JPanel grayPanel = new JPanel(new GridLayout(2,1));
        grayPanel.setBackground(Color.decode("#C4C4C4"));
        rightPanel.setLayout(new BorderLayout());

        JPanel instructionsPanel = new JPanel(new GridBagLayout());
        instructionsPanel.add(instructionText);
        instructionsPanel.setBackground(null);
        instructionsPanel.setBorder(BorderFactory.createEmptyBorder(60, 0,0,0));
        instructionText.setFont(new Font("Nunito", Font.BOLD, 16));

        JPanel compNamePanel = new JPanel(new GridBagLayout());
        compNamePanel.add(compName);
        compNamePanel.setBackground(null);
        compName.setFont(new Font("Nunito", Font.BOLD, 16));

        grayPanel.add(instructionsPanel);
        grayPanel.add(compNamePanel);

        JPanel counterPanel = new JPanel(new GridLayout(2,2));
        counterPanel.add(timeTaken);
        counterPanel.setBorder(BorderFactory.createEmptyBorder(30, 40,0,0));
        counterPanel.setPreferredSize(new Dimension(300,100));
        timeTaken.setFont(new Font("Nunito",Font.BOLD,14));
        timeTaken.setForeground(Color.decode("#3674D0"));
        counterPanel.add(timeInSeconds);
        timeInSeconds.setFont(new Font("Nunito",Font.BOLD,14));
        counterPanel.add(totalSearches);
        totalSearches.setFont(new Font("Nunito",Font.BOLD,14));
        totalSearches.setForeground(Color.decode("#3674D0"));
        counterPanel.add(numberOfSearches);
        numberOfSearches.setFont(new Font("Nunito",Font.BOLD,14));

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(grayPanel, BorderLayout.NORTH);
        topPanel.add(counterPanel, BorderLayout.CENTER);

        rightPanel.add(topPanel, BorderLayout.NORTH);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(120, 60, 0, 40));

        mainPanel.add(leftPanel, BorderLayout.CENTER);
        mainPanel.add(rightPanel, BorderLayout.EAST);
        mainPanel.setBackground(Color.WHITE);
<<<<<<< HEAD
        leftPanel.add(new ResultDetails().getContainer());


=======

        try {
            leftPanel.add(new ResultDetails(searchKey).getContainer());
        }
        catch (Exception e) {
            leftPanel.add(new ResultDetails("").getContainer());
        }
>>>>>>> d3cbee5dde6691de8ab652e5c49bd56983c38f24
        add(mainPanel);
    }

    public static String convertToMultiline(String text){
        return "<html>" + text.replaceAll("\n", "<br>");
    }

<<<<<<< HEAD
    public static void main(String[] args){
        new ResultList();
    }
=======
//    public static void main(String[] args) throws Exception {
//        new ResultList();
//    }
>>>>>>> d3cbee5dde6691de8ab652e5c49bd56983c38f24
}