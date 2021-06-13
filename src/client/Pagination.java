package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Pagination extends JPanel {
    public Pagination(){paginationBtn();}

    public class ButtonActionListener implements ActionListener {
        public void actionPerformed (ActionEvent e){
            String actionCommand = e.getActionCommand();
            System.out.println("Action Command: "+ actionCommand);
            if(actionCommand.equals("Go to page 1")){

            }else if(actionCommand.equals("Go to page 2")){

            }else if(actionCommand.equals("Go to page 3")){

            }else if(actionCommand.equals("Go to page 4")){

            }else if(actionCommand.equals("More pages")){

            }else{

            }
        }
    }

    public void paginationBtn(){

        //Declaring buttons
        CircleButton page1 = new CircleButton("1");
        CircleButton page2 = new CircleButton("2");
        CircleButton page3 = new CircleButton("3");
        CircleButton page4 = new CircleButton("4");
        JButton etc = new JButton("...");

        //Removing background from buttons and other styles
        page1.setContentAreaFilled(false);
        page2.setContentAreaFilled(false);
        page3.setContentAreaFilled(false);
        page4.setContentAreaFilled(false);
        etc.setContentAreaFilled(false);
        etc.setBorderPainted(false);//Removing border
        etc.setMargin(new Insets(0,0,15,0));//Set margin
        etc.setFont(new Font("Arial", Font.PLAIN, 30));//Set font size
        etc.setForeground(Color.blue);

        //Removing focus painted
        page1.setFocusPainted(false);
        page2.setFocusPainted(false);
        page3.setFocusPainted(false);
        page4.setFocusPainted(false);
        etc.setFocusPainted(false);

        //Attaching listener to buttons
        //Setting action commands
        page1.setActionCommand("Go to page 1");
        page2.setActionCommand("Go to page 2");
        page3.setActionCommand("Go to page 3");
        page4.setActionCommand("Go to page 4");
        etc.setActionCommand("More pages");

        //Adding action listener to buttons
        page1.addActionListener(new ButtonActionListener());
        page2.addActionListener(new ButtonActionListener());
        page3.addActionListener(new ButtonActionListener());
        page4.addActionListener(new ButtonActionListener());
        etc.addActionListener(new ButtonActionListener());

        //Add buttons to page
        add(page1);
        add(page2);
        add(page3);
        add(page4);
        add(etc);
    }

    private static void ShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("PaginationTesting");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        Pagination newContentPane = new Pagination();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //adding window listener
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //Display the window.
        frame.pack();
        frame.setSize(400,200);
        frame.setVisible(true);
    }



    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ShowGUI();
            }
        });
    }
}