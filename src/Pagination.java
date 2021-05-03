import javax.swing.*;
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
            if(actionCommand.equals("Go to first page")){

            }else if(actionCommand.equals("Go to previous page")){

            }else if(actionCommand.equals("Go to page 1")){

            }else if(actionCommand.equals("Go to page 2")){

            }else if(actionCommand.equals("Go to page 3")){

            }else if(actionCommand.equals("Go to page 4")){

            }else if(actionCommand.equals("Go to next page")){

            }else if(actionCommand.equals("Go to last page")){

            }else{

            }
        }
    }

    public void paginationBtn(){

        //Declaring buttons
        JButton first = new JButton("First");
        JButton previous = new JButton("Previous");
        JButton page1 = new JButton("1");
        JButton page2 = new JButton("2");
        JButton page3 = new JButton("3");
        JButton page4 = new JButton("4");
        JButton next = new JButton("Next");
        JButton last = new JButton("Last");

        //Removing background from buttons
        first.setContentAreaFilled(false);
        previous.setContentAreaFilled(false);
        page1.setContentAreaFilled(false);
        page2.setContentAreaFilled(false);
        page3.setContentAreaFilled(false);
        page4.setContentAreaFilled(false);
        next.setContentAreaFilled(false);
        last.setContentAreaFilled(false);

        //Attaching listener to buttons
        //Setting action commands
        first.setActionCommand("Go to first page");
        previous.setActionCommand("Go to previous page");
        page1.setActionCommand("Go to page 1");
        page2.setActionCommand("Go to page 2");
        page3.setActionCommand("Go to page 3");
        page4.setActionCommand("Go to page 4");
        next.setActionCommand("Go to page next page");
        last.setActionCommand("Go to last page");

        //Adding action listener to buttons
        first.addActionListener(new ButtonActionListener());
        previous.addActionListener(new ButtonActionListener());
        page1.addActionListener(new ButtonActionListener());
        page2.addActionListener(new ButtonActionListener());
        page3.addActionListener(new ButtonActionListener());
        page4.addActionListener(new ButtonActionListener());
        next.addActionListener(new ButtonActionListener());
        last.addActionListener(new ButtonActionListener());


        //Add buttons to page
        add(first);
        add(previous);
        add(page1);
        add(page2);
        add(page3);
        add(page4);
        add(next);
        add(last);
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
        frame.setSize(800,500);
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