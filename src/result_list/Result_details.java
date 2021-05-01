package result_list;

import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class Result_details {
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

    public Result_details() {


    window= new JFrame();
          window.setTitle("Result Details");
          window.setBounds(300, 10, 800, 800);
          window.setDefaultCloseOperation(EXIT_ON_CLOSE);
          window.setResizable(false);
          container = window.getContentPane();
          container.setBackground(Color.white);
          container.setLayout(null);


          title= new JLabel("Amakosi-Ish Kevin (Lyrics) ");
          title.setFont(new Font("Arial", Font.BOLD, 23));
          title.setSize(500, 30);
          title.setLocation(60, 40);
          title.setForeground(Color.blue);
          container.add(title);

        subTitle= new JLabel("http://www.ecosia.org >");
        subTitle.setFont(new Font("Arial", Font.ITALIC, 14));
        subTitle.setSize(500, 30);
        subTitle.setLocation(60, 68);
        subTitle.setForeground(Color.lightGray);
        container.add(subTitle);

        description= new JLabel();
        description.setText(convertToMultiline("Lorem Ipsum is simply dummy text of the printing and typesetting\nindustry. Lorem Ipsum has been the industry's standard dummy \n text ever since the 1500s, when an unknown printer took a galley\nof type and scrambled it to make a type specimen book. It has\nsurvived not only five centuries, but also the leap into electronic\ntypesetting, remaining essentially unchanged."));
        description.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        description.setSize(700, 130);
        description.setLocation(60, 100);
        container.add(description);

        lsubTitle= new JLabel("<html><font color=blue><U>Related</U>: </font> <font color=gray>Lorem Ipsum... Mto mto-Ish Kevin</font></html>");
        lsubTitle.setFont(new Font("Arial", Font.ITALIC, 14));
        lsubTitle.setSize(500, 30);
        lsubTitle.setLocation(60, 220);
        container.add(lsubTitle);


        //Second Div

        title2= new JLabel("Amakosi-Ish Kevin (Lyrics) ");
        title2.setFont(new Font("Arial", Font.BOLD, 23));
        title2.setSize(500, 30);
        title2.setLocation(60, 280);
        title2.setForeground(Color.blue);
        container.add(title2);


        subTitle2= new JLabel("http://www.ecosia.org >");
        subTitle2.setFont(new Font("Arial", Font.ITALIC, 14));
        subTitle2.setSize(500, 30);
        subTitle2.setLocation(60, 308);
        subTitle2.setForeground(Color.lightGray);
        container.add(subTitle2);

        description2= new JLabel();
        description2.setText(convertToMultiline("Lorem Ipsum is simply dummy text of the printing and typesetting\nindustry. Lorem Ipsum has been the industry's standard dummy \n text ever since the 1500s, when an unknown printer took a galley\nof type and scrambled it to make a type specimen book. It has\nsurvived not only five centuries, but also the leap into electronic\ntypesetting, remaining essentially unchanged."));
        description2.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        description2.setSize(700, 130);
        description2.setLocation(60, 340);
        container.add(description2);

        lsubTitle2= new JLabel("<html><font color=blue><U>Related</U>: </font> <font color=gray>Lorem Ipsum... Mto mto-Ish Kevin</font></html>");
        lsubTitle2.setFont(new Font("Arial", Font.ITALIC, 14));
        lsubTitle2.setSize(500, 30);
        lsubTitle2.setLocation(60, 460);
        container.add(lsubTitle2);


        title3= new JLabel("Amakosi-Ish Kevin (Lyrics) ");
        title3.setFont(new Font("Arial", Font.BOLD, 23));
        title3.setSize(500, 30);
        title3.setLocation(60, 520);
        title3.setForeground(Color.blue);
        container.add(title3);


        subTitle3= new JLabel("http://www.ecosia.org >");
        subTitle3.setFont(new Font("Arial", Font.ITALIC, 14));
        subTitle3.setSize(500, 30);
        subTitle3.setLocation(60, 548);
        subTitle3.setForeground(Color.lightGray);
        container.add(subTitle3);

        description3= new JLabel();
        description3.setText(convertToMultiline("Lorem Ipsum is simply dummy text of the printing and typesetting\nindustry. Lorem Ipsum has been the industry's standard dummy \n text ever since the 1500s, when an unknown printer took a galley\nof type and scrambled it to make a type specimen book. It has\nsurvived not only five centuries, but also the leap into electronic\ntypesetting, remaining essentially unchanged."));
        description3.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        description3.setSize(700, 130);
        description3.setLocation(60, 580);
        container.add(description3);





        window.setVisible(true);

}
    public static String convertToMultiline(String orig)
    {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }

    public static void main(String [] args)throws Exception{

        Result_details description= new Result_details();


    }
}

