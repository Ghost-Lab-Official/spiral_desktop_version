package result_list;

import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class ResultDetails {
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

    public ResultDetails() {


    window= new JFrame();
          window.setTitle("Result Details");
          window.setBounds(300, 10, 800, 800);
          window.setDefaultCloseOperation(EXIT_ON_CLOSE);
          window.setResizable(true);
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
        window.setVisible(false);

}
    public static String convertToMultiline(String orig)
    {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }
}

