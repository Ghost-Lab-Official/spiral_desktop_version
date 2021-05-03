import javax.swing.*;
import java.awt.*;

public class ResultList {
    private JFrame window;

    private JPanel secondPanel;
    private JPanel firstPanel;

    private JLabel text_description;
    private JLabel time_taken;
    private JLabel time_in_seconds;
    private JLabel totalSearches;
    private JLabel numberOfSearches;


    public ResultList(){
        window= new JFrame();
        window.setTitle("Result details");
        window.setBounds(200, 10, 1000, 1000);
        //window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setResizable(false);

        text_description = new JLabel();
        text_description.setText("Kanda kurayo magambo asa Ubururu kugira ngo ubone Ibyo ushaka. Murakoze");
        text_description.setFont(new Font("Nunito",Font.BOLD,16));



        secondPanel = new JPanel();
        secondPanel.setBackground(Color.decode("#C4C4C4"));
        //secondPanel.setSize(200,400);
        secondPanel.setBounds(400,200,250,250);
        secondPanel.add(text_description);

        firstPanel=new JPanel();
        firstPanel.setBackground(Color.green);

        window.add(secondPanel);
        window.add(firstPanel);
        window.setVisible(true);

    }

    public static void main(String[] args) throws Exception{
        ResultList resultList = new ResultList();
    }
}
